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
