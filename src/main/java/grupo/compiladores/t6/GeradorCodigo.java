package grupo.compiladores.t6;

import static grupo.compiladores.t6.GramaUtils.adicionaErroSemantico;
import grupo.compiladores.t6.GramaParser.*;
import static grupo.compiladores.t6.GramaUtils.*;
import java.util.List;

import org.antlr.v4.runtime.tree.TerminalNode;

public class GeradorCodigo extends GramaBaseVisitor<Void>{
    
    StringBuilder saida;
    Tabela tabela;
    int contadorCliente = 0;
    
    public GeradorCodigo() {
        saida = new StringBuilder();
        this.tabela = new Tabela();
    }
    
    public void criar_funcoes(){
        //Criar a função que encapsulará os clientes
        saida.append("# Classe Cliente representando uma pessoa com atributos de investimento\n" +
            "class Cliente:\n" +
            "    def __init__(self, nome, tipo, valor_investido, tempo_investido, lucro_almejado):\n" +
            "        self.nome = nome\n" +
            "        self.tipo = tipo\n" +
            "        self.valor_investido = valor_investido\n" +
            "        self.tempo_investido = tempo_investido\n" +
            "        self.lucro_almejado = lucro_almejado\n\n");
        
        
        saida.append("# Função para captar informações das ações usando Yahoo Finance\n" +
            "def passado(cliente, nome_acao, periodo):\n" +
            "  \n" +
            "  if periodo == \"DIARIO\":\n" +
            "    tempo = cliente.tempo_investido * 30\n" +
            "    dinheiro_investido = cliente.valor_investido / tempo\n" +
            "    periodo_string = 'D'\n" +
            "    string = 'dias'\n" +
            "  elif periodo == \"MENSAL\":\n" +
            "    tempo = cliente.tempo_investido\n" +
            "    dinheiro_investido = cliente.valor_investido / cliente.tempo_investido\n" +
            "    periodo_string = 'ME'\n" +
            "    string = 'meses'\n" +
            "  elif periodo == \"ANUAL\":\n" +
            "    if cliente.tempo_investido < 12:\n" +
            "      raise ValueError(\"Impossível calcular, minimo de 12 meses\")\n" +
            "    tempo = cliente.tempo_investido / 12\n" +
            "    dinheiro_investido = cliente.valor_investido / tempo\n" +
            "    periodo_string = 'YE'\n" +
            "    string = 'anos'\n" +
            "  else:\n" +
            "    raise ValueError(\"Periodo inválido, use apenas DIARIO, MENSAL, ANUAL\")\n" +
            "\n" +
            "  acao = yf.Ticker(nome_acao)\n" +
            "  #Periodo escolhido\n" +
            "  historico = acao.history(period=\"10y\")\n" +
            "  precos = historico['Close']\n" +
            "\n" +
            "# Resample o preço de acordo com o período escolhido (diário, mensal ou anual)\n" +
            "  precos_resampled = precos.resample(periodo_string).last()\n" +
            "\n" +
            "    # Remover NaN\n" +
            "  precos_resampled = precos_resampled.iloc[::-1]\n" +
            "  precos_resampled = precos_resampled.dropna()\n" +
            "\n" +
            "  total_acoes_compradas = 0\n" +
            "  total_investido = 0\n" +
            "\n" +
            "  # Ajustar para calcular com base na variável \"tempo\"\n" +
            "  for i in range(int(tempo)):\n" +
            "      if i < len(precos_resampled):\n" +
            "          preco = precos_resampled.iloc[i]\n" +
            "          acoes_compradas = dinheiro_investido / preco  # Quantas ações poderia comprar\n" +
            "          total_acoes_compradas += acoes_compradas\n" +
            "          total_investido += dinheiro_investido\n" +
            "\n" +
            "    # Calcula o valor final das ações com base no último preço\n" +
            "  valor_final_acoes = total_acoes_compradas * precos.iloc[-1]\n" +
            "\n" +
            "  # Calcula a porcentagem de lucro\n" +
            "  percentual_lucro = ((valor_final_acoes - total_investido) / total_investido) * 100\n" +
            "\n" +
            "\n" +
            "  print(f\"Você chamou por uma função de passado para {cliente.nome} do tipo {cliente.tipo}\")\n" +
            "  print(f\"Total investido USD {total_investido:.2f} durante o período de {tempo} {string}.\")\n" +
            "  print(f\"Investindo por período USD {dinheiro_investido:.2f}\")\n" +
            "  print(f\"Ao final do período, teria acumulado {total_acoes_compradas:.4f} ações da {nome_acao}\")\n" +
            "  print(f\"Valor total das ações no último fechamento: USD {total_acoes_compradas * precos.iloc[-1]:.2f}\")\n" +
            "  print(f\"Porcentagem de lucro: {percentual_lucro:.2f}%\")\n" +
            "  print(f\"Porcentagem de lucro esperado: {cliente.lucro_almejado:.2f}%\\n\\n\")\n\n");
        
        saida.append("\ndef calcular_variacao(preco_atual, preco_passado):\n" +
            "    \"\"\"Calcula a variação percentual entre dois preços.\"\"\"\n" +
            "    return (preco_atual - preco_passado) / preco_passado * 100\n" +
            "\n" +
            "def risco(acao):\n" +
            "    \"\"\"Calcula a variação da ação para 1 dia, 7 dias, 30 dias, 6 meses e 1 ano e imprime as variações.\"\"\"\n" +
            "    # Obter os dados da ação\n" +
            "    ticker = yf.Ticker(acao)\n" +
            "    \n" +
            "    # Obter os dados históricos de 10 anos (ou o período máximo disponível)\n" +
            "    historico = ticker.history(period=\"10y\")\n" +
            "    \n" +
            "    if historico.empty:\n" +
            "        print(f\"Não foi possível obter dados para {acao}.\")\n" +
            "        return\n" +
            "\n" +
            "    # Preço atual (último fechamento)\n" +
            "    preco_atual = historico['Close'].iloc[-1]\n" +
            "\n" +
            "    # Obter a data de hoje\n" +
            "    hoje = datetime.today()\n" +
            "\n" +
            "    # Definir os intervalos de tempo\n" +
            "    periodos = {\n" +
            "        '1d': hoje - timedelta(days=1),\n" +
            "        '7d': hoje - timedelta(days=7),\n" +
            "        '30d': hoje - timedelta(days=30),\n" +
            "        '6m': hoje - timedelta(days=180),\n" +
            "        '1y': hoje - timedelta(days=365),\n" +
            "    }\n" +
            "    \n" +
            "    variacoes = {}\n" +
            "    print(f\"A volatilidade da {acao} é de:\")\n" +
            "\n" +
            "    for periodo, data in periodos.items():\n" +
            "        # Filtrar o histórico para encontrar a data mais próxima do período desejado\n" +
            "        historico_filtrado = historico.loc[historico.index <= data.strftime('%Y-%m-%d')]\n" +
            "\n" +
            "        if historico_filtrado.empty:\n" +
            "            print(f\"Variação {periodo}: Dados insuficientes\")\n" +
            "            variacoes[periodo] = None\n" +
            "        else:\n" +
            "            preco_passado = historico_filtrado['Close'].iloc[-1]\n" +
            "            variacao = calcular_variacao(preco_atual, preco_passado)\n" +
            "            variacoes[periodo] = variacao\n" +
            "            print(f\"Variação {periodo}: {variacao:.2f}%\\n\\n\")\n");
        
        saida.append("def previsao(acao, dias_prever=[]):\n" +
            "    \"\"\"Faz uma previsão simples usando regressão linear para estimar o preço futuro em vários períodos.\"\"\"\n" +
            "    # Obter os dados da ação\n" +
            "    ticker = yf.Ticker(acao)\n" +
            "    \n" +
            "    # Obter os dados históricos de 6 meses\n" +
            "    historico = ticker.history(period=\"1y\")\n" +
            "    \n" +
            "    if historico.empty:\n" +
            "        print(f\"Não foi possível obter dados para {acao}.\")\n" +
            "        return\n" +
            "    \n" +
            "    # Extrair os preços de fechamento\n" +
            "    historico_fechamento = historico['Close']\n" +
            "    \n" +
            "    # Converter o índice de datas em números de dias\n" +
            "    x = np.arange(len(historico_fechamento))\n" +
            "    \n" +
            "    # Preços de fechamento\n" +
            "    y = historico_fechamento.values\n" +
            "    \n" +
            "    # Ajustar a regressão linear (y = a*x + b)\n" +
            "    coeficientes = np.polyfit(x, y, 1)  # Coeficientes da linha de tendência\n" +
            "    tendencia = np.poly1d(coeficientes)  # Função de tendência linear\n" +
            "\n" +
            "    # Preço atual\n" +
            "    preco_atual = y[-1]\n" +
            "\n" +
            "    print(f\"Preço atual de {acao}: {preco_atual:.2f}\")\n" +
            "\n" +
            "    # Previsões para os dias solicitados\n" +
            "    previsoes = {}\n" +
            "    for dias in dias_prever:\n" +
            "        previsao = tendencia(len(x) + dias)\n" +
            "        previsoes[dias] = previsao\n" +
            "        print(f\"Previsão de {acao} para {dias} dias à frente: {previsao:.2f}\")\n" +
            "    print(\"\\n\\n\")");
        saida.append("\ndef previsao_renda_fixa(cliente, taxa_juros_anual):\n" +
            "    \"\"\"\n" +
            "    Função para simular o rendimento de um investimento de renda fixa por 1 ano.\n" +
            "    :param cliente: Objeto Cliente contendo informações do investidor.\n" +
            "    :param taxa_juros_anual: Taxa de juros anual da renda fixa (em %).\n" +
            "    \"\"\"\n" +
            "\n" +
            "    # Calculando o rendimento usando a fórmula de juros compostos para 1 ano\n" +
            "    valor_final = cliente.valor_investido * (1 + taxa_juros_anual / 100)\n" +
            "\n" +
            "    # Calcula a porcentagem de lucro\n" +
            "    percentual_lucro = ((valor_final - cliente.valor_investido) / cliente.valor_investido) * 100\n" +
            "\n" +
            "    # Exibir os resultados\n" +
            "    print(f\"Você chamou por uma função de previsão (Renda Fixa)\")\n" +
            "    print(f\"Total a ser investido: R$ {cliente.valor_investido:.2f} durante o período de 1 ano.\")\n" +
            "    print(f\"Taxa de juros anual: {taxa_juros_anual:.2f}%\")\n" +
            "    print(f\"Valor total acumulado ao final do período: R$ {valor_final:.2f}\")\n" +
            "    print(f\"Porcentagem de lucro: {percentual_lucro:.2f}%, sem contar os impostos\")\n" +
            "    print(f\"Porcentagem de lucro esperado: {cliente.lucro_almejado:.2f}%\\n\\n\")\n\n");
        
    }
    
    public void adicionarClienteCodigo(int contador, String nome, Tabela.Tipo tipo, float valorInvestido, int tempoInvestido, float lucroAlmejado){
        saida.append("\ncliente").append(contador).append(" = Cliente(\n");
        saida.append("nome='").append(nome).append("',\n");
        saida.append("tipo='").append(tipo.name()).append("',\n");
        saida.append("valor_investido=").append(valorInvestido).append(",\n");
        saida.append("tempo_investido=").append(tempoInvestido).append(",\n");
        saida.append("lucro_almejado=").append(lucroAlmejado).append(")\n");
    }
    
    public void addClientePanda(int contador){
        saida.append("\nclientes.append({\n" +
            "    \"Nome\": cliente").append(contador).append(".nome,\n" +
            "    \"Tipo\": cliente").append(contador).append(".tipo,\n" +
            "    \"Valor Investido\": cliente").append(contador).append(".valor_investido,\n" +
            "    \"Tempo Investido (meses)\": cliente").append(contador).append(".tempo_investido,\n" +
            "    \"Lucro Almejado (%)\": cliente").append(contador).append(".lucro_almejado\n" +
                "})\n");
    }
    
    @Override
    public Void visitLista_clientes(Lista_clientesContext ctx){
        saida.append("\nclientes = [] \n\n");
        
        return super.visitLista_clientes(ctx);
    }
    
    public void comandoPassado(int index, String acao, String periodo){
        saida.append("\npassado(cliente" + index + ", '" + acao + "', '" + periodo + "')\n");
    }
    
    
    @Override
    public Void visitPrograma(GramaParser.ProgramaContext ctx) {
        // Adiciona diretivas de inclusão e uma linha em branco para separar a seção de declarações
        saida.append("#Necessario instalar as libs a seguir:\n");
        saida.append("#pip install pandas\n");
        saida.append("#pip install yfinance\n\n");
        
        saida.append("#Importar as libs:\n");
        saida.append("import yfinance as yf\n");
        saida.append("import pandas as pd\n");
        saida.append("import numpy as np\n");
        saida.append("from datetime import datetime, timedelta\n");
        saida.append("pd.set_option('display.max_columns', None)");
        
        criar_funcoes();
        
        super.visitPrograma(ctx);
        return null;
    }
   
    
    @Override
    public Void visitCliente(GramaParser.ClienteContext ctx){
        String nome = "";
        Tabela.Tipo tipo = null;
        float valorInvestido = 0;
        int tempoInvestido = 0;
        float lucroAlmejado = 0;
        
        //Verificação se é pessoa ou empresa ou então não existe esse tipo
        if (ctx.TIPO().getText().contains("Pessoa")){
            tipo = Tabela.Tipo.PESSOA;
        }else if (ctx.TIPO().getText().contains("Empresa")){
            tipo = Tabela.Tipo.EMPRESA;
        }else{
            adicionaErroSemantico(ctx.getStart(), "tipo nao declarado");
        }
            
        //Vai passar por cada atributo para capturar suas respectivas informações
        for (GramaParser.AtributoContext atributo : ctx.lista_atributos().atributo()){
            if (atributo.STRING() != null){
                //Remover as aspas do nome
                nome = atributo.STRING().getText().replace("\"", "");
                if (tabela.existe(nome)){
                    System.out.println("Nome já declarado");
                    adicionaErroSemantico(atributo.getStart(), "nome ja declarado");
                }
            }
            else if (atributo.NUMERO() != null){
                String[] partes = atributo.getText().split(":");
                String atributoNome = partes[0].trim();
                float valor = Float.parseFloat(partes[1].trim());
                
                switch (atributoNome){
                    case "ValorInvestido":
                        valorInvestido = valor;
                        break;
                    case "TempoInvestido":
                        tempoInvestido = (int)valor;
                        break;
                    case "LucroAlmejado":
                        lucroAlmejado = valor;
                        break;
                }
            }
        }
        
        //Verificar se o cliente ja existe na tabela
        if(!tabela.existe(nome)){
            contadorCliente = contadorCliente + 1;
            tabela.adicionar(nome, tipo, valorInvestido, tempoInvestido, lucroAlmejado, contadorCliente);
            
            adicionarClienteCodigo(contadorCliente, nome, tipo, valorInvestido, tempoInvestido, lucroAlmejado);
            addClientePanda(contadorCliente);
            System.out.println("Cliente " + nome + " adicionado à tabela.");
            
        }else{
            System.out.println("Cliente ja add");
        }
        return super.visitCliente(ctx);
    }
    
        //cmdPassado: 'Passado' '(' nome ',' tipoInvestimento ')';
    @Override
    public Void visitCmdPassado(CmdPassadoContext ctx){
        //Coletar o nome
        String nome = ctx.nome().STRING().getText().replace("\"", "");
        //Verificar se a pessoa está contida na tabela
        if(!tabela.existe(nome)){
            adicionaErroSemantico(ctx.getStart(), "cliente não declarado");
            return null;
        }
        int index = tabela.coletarIndex(nome);
        //Verificar a periodicidade com a tempo da pessoa
        if(ctx.periodicidade().getText().contains("ANUAL")){
            if(!tabela.possibilidadeAnual(nome)){
                adicionaErroSemantico(ctx.getStart(), "impossível de ser calculado");
                return null;
            }
        }
        
        if (ctx.tipoInvestimento().Variavel() != null){
            comandoPassado(index, ctx.tipoInvestimento().Variavel().getText(), ctx.periodicidade().getText());
        }
        return null;
    }
    
    @Override
    public Void visitCmdVisualizar(CmdVisualizarContext ctx){
        saida.append("\ndf_clientes = pd.DataFrame(clientes)\nprint(df_clientes)\n");
        return null;
    }
    
    @Override
    public Void visitCmdAlertaRisco(CmdAlertaRiscoContext ctx){
        saida.append("\nrisco('").append(ctx.tipoInvestimento().getText()).append("')\n");
        return null;
    }
    
    @Override
    public Void visitCmdPrevisao(CmdPrevisaoContext ctx){
        //A taxa é fixa e é sempre anual, dados coletados https://www.tesourodireto.com.br/titulos/precos-e-taxas.htm#0
        if(ctx.nome() != null){
            String nome = ctx.nome().STRING().getText().replace("\"", "");
            int index = tabela.coletarIndex(nome);
            double taxa = 10.95;
            saida.append("previsao_renda_fixa(cliente").append(index).append(", taxa_juros_anual=").append(taxa).append(")\n");
            return null;
        }
        
        saida.append("\nprevisao('").append(ctx.tipoInvestimento().getText()).append("', ");
        saida.append("[");
        // Iterar sobre todos os números fornecidos no contexto
        List<TerminalNode> numeros = ctx.NUMERO();
        for (int i = 0; i < numeros.size(); i++) {
            saida.append(numeros.get(i).getText());

            // Adicionar uma vírgula entre os números, mas não após o último número
            if (i < numeros.size() - 1) {
                saida.append(", ");
            }
        }
        
        saida.append("])\n");

        
        return null;
    }
    
}
