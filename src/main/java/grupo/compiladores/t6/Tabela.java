package grupo.compiladores.t6;

import java.util.HashMap;
import java.util.Map;

//Ficará armazenado o nome da pessoa/empresa
public class Tabela {
    
    //Criará uma tabela com todas as pessoas e suas respectivas informações
    private final Map<String, Info> tabela;
    
    public Tabela() {
        this.tabela = new HashMap<>();
    }
    
    //No momento estaremos lidando com dois tipos de clientes
    public enum Tipo{
        PESSOA,
        EMPRESA
    }
    
    //Classe que armazenará as informações da pessoa
    class Info{
        String nome;
        Tipo tipo;
        float valor_investido;
        int tempo_investido;
        float lucro_almejado;
        int index;
        
        private Info(String nome, Tipo tipo, float valor_investido, int tempo_investido, float lucro_almejado, int index){
            this.nome = nome;
            this.tipo = tipo;
            this.valor_investido = valor_investido;
            this.tempo_investido = tempo_investido;
            this.lucro_almejado = lucro_almejado;
            this.index = index;
        }
    }
    
    //Guardar para cada pessoa suas respectivas informações
    public void adicionar(String nome, Tipo tipo, float valor_invest, int tempo_invest, float lucro_alvo, int index){
        tabela.put(nome, new Info(nome, tipo, valor_invest, tempo_invest, lucro_alvo, index));
    }
    
    //Método para verificar a existência da pessoa
    public boolean existe(String nome) {
        return tabela.containsKey(nome);
    }
    
    public boolean possibilidadeAnual(String nome){
        Info info = tabela.get(nome);
        if (info == null){
            System.out.println("Cliente não encontrado");
            return false;
        }        
        return (info.tempo_investido / 12) >= 1;
        
    }
    
    public void divisaoDinheiro(String nome, String periodo){
        Info info = tabela.get(nome);
        int tempo; 
        float vezes = 0;
        switch(periodo){
            case "ANUAL":
                tempo = info.tempo_investido /12;
                vezes = info.valor_investido / tempo;
                System.out.println("O dinheiro será repartido por " + tempo + " vezes para " + vezes + " reais");
                break;
            case "MENSAL":
                vezes = info.valor_investido / info.tempo_investido;
                System.out.println("O dinheiro será repartido por " + info.tempo_investido + " vezes para " + vezes + " reais");
                break;
            case "DIARIO":
                tempo = 30 * info.tempo_investido;
                vezes = info.valor_investido / tempo;
                System.out.println("O dinheiro será repartido por " + tempo + " vezes para " + vezes + " reais");
                break;
        }
    }
   
    public int coletarIndex(String nome){
        Info info = tabela.get(nome);
        return info.index;
    }
    
    public void mostrarTabela() {
        if (tabela.isEmpty()) {
            System.out.println("A tabela está vazia.");
        } else {
            for (Map.Entry<String, Info> entry : tabela.entrySet()) {
                Info info = entry.getValue();
                System.out.println("Nome: " + info.nome);
                System.out.println("Tipo: " + info.tipo);
                System.out.println("Valor Investido: " + info.valor_investido);
                System.out.println("Tempo Investido: " + info.tempo_investido + " meses");
                System.out.println("Lucro Almejado: " + info.lucro_almejado);
                System.out.println("-------------------------");
            }
        }
    }
    
}
