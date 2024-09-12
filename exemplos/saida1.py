#Necessario instalar as libs a seguir:
#pip install pandas
#pip install yfinance

#Importar as libs:
import yfinance as yf
import pandas as pd
import numpy as np
from datetime import datetime, timedelta
pd.set_option('display.max_columns', None)# Classe Cliente representando uma pessoa com atributos de investimento
class Cliente:
    def __init__(self, nome, tipo, valor_investido, tempo_investido, lucro_almejado):
        self.nome = nome
        self.tipo = tipo
        self.valor_investido = valor_investido
        self.tempo_investido = tempo_investido
        self.lucro_almejado = lucro_almejado

# Função para captar informações das ações usando Yahoo Finance
def passado(cliente, nome_acao, periodo):
  
  if periodo == "DIARIO":
    tempo = cliente.tempo_investido * 30
    dinheiro_investido = cliente.valor_investido / tempo
    periodo_string = 'D'
    string = 'dias'
  elif periodo == "MENSAL":
    tempo = cliente.tempo_investido
    dinheiro_investido = cliente.valor_investido / cliente.tempo_investido
    periodo_string = 'ME'
    string = 'meses'
  elif periodo == "ANUAL":
    if cliente.tempo_investido < 12:
      raise ValueError("Impossível calcular, minimo de 12 meses")
    tempo = cliente.tempo_investido / 12
    dinheiro_investido = cliente.valor_investido / tempo
    periodo_string = 'YE'
    string = 'anos'
  else:
    raise ValueError("Periodo inválido, use apenas DIARIO, MENSAL, ANUAL")

  acao = yf.Ticker(nome_acao)
  #Periodo escolhido
  historico = acao.history(period="10y")
  precos = historico['Close']

# Resample o preço de acordo com o período escolhido (diário, mensal ou anual)
  precos_resampled = precos.resample(periodo_string).last()

    # Remover NaN
  precos_resampled = precos_resampled.iloc[::-1]
  precos_resampled = precos_resampled.dropna()

  total_acoes_compradas = 0
  total_investido = 0

  # Ajustar para calcular com base na variável "tempo"
  for i in range(int(tempo)):
      if i < len(precos_resampled):
          preco = precos_resampled.iloc[i]
          acoes_compradas = dinheiro_investido / preco  # Quantas ações poderia comprar
          total_acoes_compradas += acoes_compradas
          total_investido += dinheiro_investido

    # Calcula o valor final das ações com base no último preço
  valor_final_acoes = total_acoes_compradas * precos.iloc[-1]

  # Calcula a porcentagem de lucro
  percentual_lucro = ((valor_final_acoes - total_investido) / total_investido) * 100


  print(f"Você chamou por uma função de passado para {cliente.nome} do tipo {cliente.tipo}")
  print(f"Total investido USD {total_investido:.2f} durante o período de {tempo} {string}.")
  print(f"Investindo por período USD {dinheiro_investido:.2f}")
  print(f"Ao final do período, teria acumulado {total_acoes_compradas:.4f} ações da {nome_acao}")
  print(f"Valor total das ações no último fechamento: USD {total_acoes_compradas * precos.iloc[-1]:.2f}")
  print(f"Porcentagem de lucro: {percentual_lucro:.2f}%")
  print(f"Porcentagem de lucro esperado: {cliente.lucro_almejado:.2f}%\n\n")


def calcular_variacao(preco_atual, preco_passado):
    """Calcula a variação percentual entre dois preços."""
    return (preco_atual - preco_passado) / preco_passado * 100

def risco(acao):
    """Calcula a variação da ação para 1 dia, 7 dias, 30 dias, 6 meses e 1 ano e imprime as variações."""
    # Obter os dados da ação
    ticker = yf.Ticker(acao)
    
    # Obter os dados históricos de 10 anos (ou o período máximo disponível)
    historico = ticker.history(period="10y")
    
    if historico.empty:
        print(f"Não foi possível obter dados para {acao}.")
        return

    # Preço atual (último fechamento)
    preco_atual = historico['Close'].iloc[-1]

    # Obter a data de hoje
    hoje = datetime.today()

    # Definir os intervalos de tempo
    periodos = {
        '1d': hoje - timedelta(days=1),
        '7d': hoje - timedelta(days=7),
        '30d': hoje - timedelta(days=30),
        '6m': hoje - timedelta(days=180),
        '1y': hoje - timedelta(days=365),
    }
    
    variacoes = {}
    print(f"A volatilidade da {acao} é de:")

    for periodo, data in periodos.items():
        # Filtrar o histórico para encontrar a data mais próxima do período desejado
        historico_filtrado = historico.loc[historico.index <= data.strftime('%Y-%m-%d')]

        if historico_filtrado.empty:
            print(f"Variação {periodo}: Dados insuficientes")
            variacoes[periodo] = None
        else:
            preco_passado = historico_filtrado['Close'].iloc[-1]
            variacao = calcular_variacao(preco_atual, preco_passado)
            variacoes[periodo] = variacao
            print(f"Variação {periodo}: {variacao:.2f}%\n\n")
def previsao(acao, dias_prever=[]):
    """Faz uma previsão simples usando regressão linear para estimar o preço futuro em vários períodos."""
    # Obter os dados da ação
    ticker = yf.Ticker(acao)
    
    # Obter os dados históricos de 6 meses
    historico = ticker.history(period="1y")
    
    if historico.empty:
        print(f"Não foi possível obter dados para {acao}.")
        return
    
    # Extrair os preços de fechamento
    historico_fechamento = historico['Close']
    
    # Converter o índice de datas em números de dias
    x = np.arange(len(historico_fechamento))
    
    # Preços de fechamento
    y = historico_fechamento.values
    
    # Ajustar a regressão linear (y = a*x + b)
    coeficientes = np.polyfit(x, y, 1)  # Coeficientes da linha de tendência
    tendencia = np.poly1d(coeficientes)  # Função de tendência linear

    # Preço atual
    preco_atual = y[-1]

    print(f"Preço atual de {acao}: {preco_atual:.2f}")

    # Previsões para os dias solicitados
    previsoes = {}
    for dias in dias_prever:
        previsao = tendencia(len(x) + dias)
        previsoes[dias] = previsao
        print(f"Previsão de {acao} para {dias} dias à frente: {previsao:.2f}")
    print("\n\n")
def previsao_renda_fixa(cliente, taxa_juros_anual):
    """
    Função para simular o rendimento de um investimento de renda fixa por 1 ano.
    :param cliente: Objeto Cliente contendo informações do investidor.
    :param taxa_juros_anual: Taxa de juros anual da renda fixa (em %).
    """

    # Calculando o rendimento usando a fórmula de juros compostos para 1 ano
    valor_final = cliente.valor_investido * (1 + taxa_juros_anual / 100)

    # Calcula a porcentagem de lucro
    percentual_lucro = ((valor_final - cliente.valor_investido) / cliente.valor_investido) * 100

    # Exibir os resultados
    print(f"Você chamou por uma função de previsão (Renda Fixa)")
    print(f"Total a ser investido: R$ {cliente.valor_investido:.2f} durante o período de 1 ano.")
    print(f"Taxa de juros anual: {taxa_juros_anual:.2f}%")
    print(f"Valor total acumulado ao final do período: R$ {valor_final:.2f}")
    print(f"Porcentagem de lucro: {percentual_lucro:.2f}%, sem contar os impostos")
    print(f"Porcentagem de lucro esperado: {cliente.lucro_almejado:.2f}%\n\n")


clientes = [] 


cliente1 = Cliente(
nome='Fernando',
tipo='PESSOA',
valor_investido=10000.0,
tempo_investido=36,
lucro_almejado=15.0)

clientes.append({
    "Nome": cliente1.nome,
    "Tipo": cliente1.tipo,
    "Valor Investido": cliente1.valor_investido,
    "Tempo Investido (meses)": cliente1.tempo_investido,
    "Lucro Almejado (%)": cliente1.lucro_almejado
})

cliente2 = Cliente(
nome='PoliTech',
tipo='EMPRESA',
valor_investido=100000.0,
tempo_investido=12,
lucro_almejado=25.0)

clientes.append({
    "Nome": cliente2.nome,
    "Tipo": cliente2.tipo,
    "Valor Investido": cliente2.valor_investido,
    "Tempo Investido (meses)": cliente2.tempo_investido,
    "Lucro Almejado (%)": cliente2.lucro_almejado
})

df_clientes = pd.DataFrame(clientes)
print(df_clientes)

passado(cliente1, 'BTC-USD', 'MENSAL')

previsao('BTC-USD', [7, 30, 60])
previsao_renda_fixa(cliente1, taxa_juros_anual=10.95)

risco('JPM')
