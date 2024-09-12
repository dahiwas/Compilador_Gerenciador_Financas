package grupo.compiladores.t6;

import org.antlr.v4.runtime.ANTLRErrorListener; // cuidado para importar a versão 4
import org.antlr.v4.runtime.Token; // Vamos também precisar de Token
import org.antlr.v4.runtime.Recognizer;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.atn.ATNConfigSet;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

import java.io.PrintWriter;
import java.util.BitSet;
// Outros imports vão ser necessários aqui. O NetBeans ou IntelliJ fazem isso automaticamente

public class SaidaCustom implements ANTLRErrorListener {
    private PrintWriter writer;

    public SaidaCustom(PrintWriter writer) {
        this.writer = writer;
    }

    @Override
    public void	reportAmbiguity(Parser recognizer, DFA dfa, int startIndex, int stopIndex, boolean exact, BitSet ambigAlts, ATNConfigSet configs) {
        // Não será necessário para o T2, pode deixar vazio
    }
    
    @Override
    public void reportAttemptingFullContext(Parser recognizer, DFA dfa, int startIndex, int stopIndex, BitSet conflictingAlts, ATNConfigSet configs) {
        // Não será necessário para o T2, pode deixar vazio
    }

    @Override
    public void reportContextSensitivity(Parser recognizer, DFA dfa, int startIndex, int stopIndex, int prediction, ATNConfigSet configs) {
        // Não será necessário para o T2, pode deixar vazio
    }

    @Override
    public void	syntaxError(Recognizer<?,?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException e) {
        // Aqui vamos colocar o tratamento de erro customizado
        // Caso encontre o erro será no formato de Token
        Token t = (Token) offendingSymbol;
        // Transformar em string
        String tokenText = t.getText();
        String extractedText = tokenText;
       // Basicamente retira os caracteres < >, principalmente pra tratar o erro de EOF (end of file)
        if (tokenText.startsWith("<") && tokenText.endsWith(">")) {
            extractedText = tokenText.substring(1, tokenText.length() - 1);
        }
        
        // Encontra o erro sintático e escreve no arquivo de saída, no T2 (Main) ele termina a execução
        writer.println("Linha " + line + ": erro sintatico proximo a " + extractedText);
        writer.println("Fim da compilacao");
        throw new RuntimeException("Erro de compilação encontrado. Terminando a execução.");

        

    }
}