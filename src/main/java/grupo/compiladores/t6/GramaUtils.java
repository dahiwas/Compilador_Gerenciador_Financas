
package grupo.compiladores.t6;

import java.util.ArrayList;
import java.util.List;
import org.antlr.v4.runtime.Token;


public class GramaUtils {
    
    //Armazenar os erros semanticos
    public static List<String> listaErrosSemanticos = new ArrayList<>();

    // Adiciona um erro semântico à lista de erros, incluindo a linha e a mensagem do erro
    public static void adicionaErroSemantico(Token token, String mensagem) {
        int linhaErro = token.getLine();
        String erroFormatado = String.format("Linha %d: %s", linhaErro, mensagem);

        if (!listaErrosSemanticos.contains(erroFormatado)) {
            listaErrosSemanticos.add(erroFormatado);
        }
    } 
    
    //Verificar a existencia do nome daquela pessoa na tabela
    public boolean verificaExistePessoa(Tabela tabela, String nome){
        return tabela.existe(nome);        
    }
    
}
