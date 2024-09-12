package grupo.compiladores.t6;

import grupo.compiladores.t6.GramaParser.*;
import static grupo.compiladores.t6.GramaUtils.*;
import grupo.compiladores.t6.Tabela.*;

//A ideia original era conseguir realizar o fetching aqui mesmo em java, o problema é que as APIs em java são muito limitadas
//Portanto iremos portar o código para R ou Python


public class VisitorCustom extends GramaBaseVisitor<Void> {
    
    private int index = 0;
    
    private final Tabela tabela;
    
    public VisitorCustom(Tabela tabela){
        this.tabela = tabela;
    }
    
//programa: 'algoritmo' 'Clientes' '(' lista_pessoas ')' cmd*? 'fimAlgoritmo';

    @Override
    public Void visitPrograma(ProgramaContext ctx){
        
        super.visitPrograma(ctx);
        
        return null;
    }

    //lista_pessoas -> pessoa | pessoa lista_pessoas

    @Override
    public Void visitLista_clientes(Lista_clientesContext ctx){
        return super.visitLista_clientes(ctx);
    }

    //pessoa -> 'Pessoa' '{' lista_atributos '}'

    @Override
    public Void visitCliente(ClienteContext ctx){
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
        for (AtributoContext atributo : ctx.lista_atributos().atributo()){
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
            index = index + 1;
            tabela.adicionar(nome, tipo, valorInvestido, tempoInvestido, lucroAlmejado, index);
            System.out.println("Cliente " + nome + " adicionado à tabela.");
        }
            
        
        return super.visitCliente(ctx);

    }

    //lista_atributos -> atributo | atributo lista_atributos

    @Override
    public Void visitLista_atributos(Lista_atributosContext ctx){
        return super.visitLista_atributos(ctx);
    }

    @Override
    public Void visitCmd(CmdContext ctx){
        //Caso seja optado por visualizar
        if (ctx.cmdVisualizar() != null){
            tabela.mostrarTabela();
        }
        
        return super.visitCmd(ctx);
    }

    //cmdPassado: 'Passado' '(' nome ',' tipoInvestimento ')';
    @Override
    public Void visitCmdPassado(CmdPassadoContext ctx){
        
        if(ctx.tipoInvestimento().Fixa() != null){
            adicionaErroSemantico(ctx.getStart(), "Erro semântico, pois não há dados para taxas passadas em renda fixa");
            return null;
        }
        
        //Coletar o nome
        String nome = ctx.nome().STRING().getText().replace("\"", "");
        //Verificar se a pessoa está contida na tabela
        if(!tabela.existe(nome)){
            adicionaErroSemantico(ctx.getStart(), "cliente não declarado");
            return null;
        }
        
        //Verificar a periodicidade com a tempo da pessoa
        if(ctx.periodicidade().getText().contains("ANUAL")){
            if(!tabela.possibilidadeAnual(nome)){
                adicionaErroSemantico(ctx.getStart(), "impossível de ser calculado");
                return null;
            }
        }

        //Aqui seria a função propriamente dita em java para coletar as informações do yahoo finance, mas faremos na geração
        tabela.divisaoDinheiro(nome, ctx.periodicidade().getText());
        
        return null;
    }
    
    @Override
    public Void visitCmdPrevisao(CmdPrevisaoContext ctx){   
        if (ctx.nome() != null){
            if (ctx.tipoInvestimento().Variavel() != null){
                adicionaErroSemantico(ctx.getStart(), "Erro semântico, pois deveria ser investimento fixo");
            }
        }
        return null;
    }
    
    
    @Override
    public Void visitCmdAlertaRisco(CmdAlertaRiscoContext ctx){
        if (ctx.tipoInvestimento().Fixa() != null){
            //Adicionar erro que não há risco em renda fixa
            adicionaErroSemantico(ctx.getStart(), "Erro semântico, pois não há risco aqui!");
            return null;
        }
        return null;
    }
        
}
