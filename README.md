# Compilador_Gerenciador_Financas
 Compilador que gerencia as finanças é um sistema que interpreta e executa comandos relacionados a investimentos, previsões financeiras e análises de risco, permitindo o gerenciamento eficiente de carteiras, previsões de rentabilidade e controle de ativos. Ele pode processar informações sobre tipos de investimento, como renda fixa e variável, realizar previsões de retorno e emitir alertas de risco com base em regras pré-definidas.

# Visualização em vídeo:

https://www.youtube.com/watch?v=F_JpcYZdG4g

# Características da entrada.txt:

```
algoritmo

[TIPO: pessoa, empresa]

[VARIAVEL: 'AAPL' | 'MSFT' | 'GOOGL' | 'JPM' | 'AMAZN' | 'TSLA' | 'NVDA' | 'BTC-USD'; ]

[FIXA: 'TESOURO' | 'DEPOSITO';]

[periodicidade: 'DIARIO' | 'MENSAL' | 'ANUAL';]

Clientes(
    TIPO{
        Nome: "NOME",
        ValorInvestido: NUMERO,
        TempoInvestido: NUMERO,
        LucroAlmejado: NUMERO
    }
)

[COMANDOS: Mostrar() | Passado("NOME"), VARIAVEL, PERIODO | Previsao(VARIAVEL, [NUMERO]) | Previsao("NOME", FIXA) | Alerta(VARIAVEL)]

COMANDOS*

fimAlgoritmo

```

# Execução após compilação:

```
java -jar ARQUVO.jar local/do/arquivo/entrada.txt local/do/arquivo/saida.py
```

# Exemplos de saída após rodar a saída.py:

## Comando Visualização
```
 Nome     Tipo  Valor Investido  Tempo Investido (meses)  \
0  Fernando   PESSOA          10000.0                       36   
1  PoliTech  EMPRESA         100000.0                       12   

   Lucro Almejado (%)  
0                15.0  
1                25.0  
```

## Comando Passado VARIAVEL
```
Você chamou por uma função de passado para Fernando do tipo PESSOA
Total investido USD 10000.00 durante o período de 36 meses.
Investindo por período USD 277.78
Ao final do período, teria acumulado 0.3088 ações da BTC-USD
Valor total das ações no último fechamento: USD 18009.66
Porcentagem de lucro: 80.10%
Porcentagem de lucro esperado: 15.00%
```

## Comando Previsao VARIAVEL
```
Preço atual de BTC-USD: 58329.85
Previsão de BTC-USD para 7 dias à frente: 73562.88
Previsão de BTC-USD para 30 dias à frente: 76127.12
Previsão de BTC-USD para 60 dias à frente: 79471.77
```

## Comando Previsao FIXA
```
Você chamou por uma função de previsão (Renda Fixa)
Total a ser investido: R$ 10000.00 durante o período de 1 ano.
Taxa de juros anual: 10.95%
Valor total acumulado ao final do período: R$ 11095.00
Porcentagem de lucro: 10.95%, sem contar os impostos
Porcentagem de lucro esperado: 15.00%
```

## Comando Alerta VARIAVEL
```
A volatilidade da JPM é de:
Variação 1d: -0.53%
Variação 7d: -5.29%
Variação 30d: -0.87%
Variação 6m: 9.55%
Variação 1y: 44.32%
```
