// Generated from grupo/compiladores/t6/Grama.g4 by ANTLR 4.13.1
package grupo.compiladores.t6;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link GramaParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface GramaVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link GramaParser#programa}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrograma(GramaParser.ProgramaContext ctx);
	/**
	 * Visit a parse tree produced by {@link GramaParser#lista_clientes}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLista_clientes(GramaParser.Lista_clientesContext ctx);
	/**
	 * Visit a parse tree produced by {@link GramaParser#cliente}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCliente(GramaParser.ClienteContext ctx);
	/**
	 * Visit a parse tree produced by {@link GramaParser#lista_atributos}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLista_atributos(GramaParser.Lista_atributosContext ctx);
	/**
	 * Visit a parse tree produced by {@link GramaParser#atributo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtributo(GramaParser.AtributoContext ctx);
	/**
	 * Visit a parse tree produced by {@link GramaParser#cmd}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCmd(GramaParser.CmdContext ctx);
	/**
	 * Visit a parse tree produced by {@link GramaParser#cmdPrevisao}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCmdPrevisao(GramaParser.CmdPrevisaoContext ctx);
	/**
	 * Visit a parse tree produced by {@link GramaParser#cmdPassado}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCmdPassado(GramaParser.CmdPassadoContext ctx);
	/**
	 * Visit a parse tree produced by {@link GramaParser#cmdAlertaRisco}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCmdAlertaRisco(GramaParser.CmdAlertaRiscoContext ctx);
	/**
	 * Visit a parse tree produced by {@link GramaParser#cmdVisualizar}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCmdVisualizar(GramaParser.CmdVisualizarContext ctx);
	/**
	 * Visit a parse tree produced by {@link GramaParser#nome}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNome(GramaParser.NomeContext ctx);
	/**
	 * Visit a parse tree produced by {@link GramaParser#tipoInvestimento}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTipoInvestimento(GramaParser.TipoInvestimentoContext ctx);
	/**
	 * Visit a parse tree produced by {@link GramaParser#periodicidade}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPeriodicidade(GramaParser.PeriodicidadeContext ctx);
}