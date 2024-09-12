// Generated from grupo/compiladores/t6/Grama.g4 by ANTLR 4.13.1
package grupo.compiladores.t6;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link GramaParser}.
 */
public interface GramaListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link GramaParser#programa}.
	 * @param ctx the parse tree
	 */
	void enterPrograma(GramaParser.ProgramaContext ctx);
	/**
	 * Exit a parse tree produced by {@link GramaParser#programa}.
	 * @param ctx the parse tree
	 */
	void exitPrograma(GramaParser.ProgramaContext ctx);
	/**
	 * Enter a parse tree produced by {@link GramaParser#lista_clientes}.
	 * @param ctx the parse tree
	 */
	void enterLista_clientes(GramaParser.Lista_clientesContext ctx);
	/**
	 * Exit a parse tree produced by {@link GramaParser#lista_clientes}.
	 * @param ctx the parse tree
	 */
	void exitLista_clientes(GramaParser.Lista_clientesContext ctx);
	/**
	 * Enter a parse tree produced by {@link GramaParser#cliente}.
	 * @param ctx the parse tree
	 */
	void enterCliente(GramaParser.ClienteContext ctx);
	/**
	 * Exit a parse tree produced by {@link GramaParser#cliente}.
	 * @param ctx the parse tree
	 */
	void exitCliente(GramaParser.ClienteContext ctx);
	/**
	 * Enter a parse tree produced by {@link GramaParser#lista_atributos}.
	 * @param ctx the parse tree
	 */
	void enterLista_atributos(GramaParser.Lista_atributosContext ctx);
	/**
	 * Exit a parse tree produced by {@link GramaParser#lista_atributos}.
	 * @param ctx the parse tree
	 */
	void exitLista_atributos(GramaParser.Lista_atributosContext ctx);
	/**
	 * Enter a parse tree produced by {@link GramaParser#atributo}.
	 * @param ctx the parse tree
	 */
	void enterAtributo(GramaParser.AtributoContext ctx);
	/**
	 * Exit a parse tree produced by {@link GramaParser#atributo}.
	 * @param ctx the parse tree
	 */
	void exitAtributo(GramaParser.AtributoContext ctx);
	/**
	 * Enter a parse tree produced by {@link GramaParser#cmd}.
	 * @param ctx the parse tree
	 */
	void enterCmd(GramaParser.CmdContext ctx);
	/**
	 * Exit a parse tree produced by {@link GramaParser#cmd}.
	 * @param ctx the parse tree
	 */
	void exitCmd(GramaParser.CmdContext ctx);
	/**
	 * Enter a parse tree produced by {@link GramaParser#cmdPrevisao}.
	 * @param ctx the parse tree
	 */
	void enterCmdPrevisao(GramaParser.CmdPrevisaoContext ctx);
	/**
	 * Exit a parse tree produced by {@link GramaParser#cmdPrevisao}.
	 * @param ctx the parse tree
	 */
	void exitCmdPrevisao(GramaParser.CmdPrevisaoContext ctx);
	/**
	 * Enter a parse tree produced by {@link GramaParser#cmdPassado}.
	 * @param ctx the parse tree
	 */
	void enterCmdPassado(GramaParser.CmdPassadoContext ctx);
	/**
	 * Exit a parse tree produced by {@link GramaParser#cmdPassado}.
	 * @param ctx the parse tree
	 */
	void exitCmdPassado(GramaParser.CmdPassadoContext ctx);
	/**
	 * Enter a parse tree produced by {@link GramaParser#cmdAlertaRisco}.
	 * @param ctx the parse tree
	 */
	void enterCmdAlertaRisco(GramaParser.CmdAlertaRiscoContext ctx);
	/**
	 * Exit a parse tree produced by {@link GramaParser#cmdAlertaRisco}.
	 * @param ctx the parse tree
	 */
	void exitCmdAlertaRisco(GramaParser.CmdAlertaRiscoContext ctx);
	/**
	 * Enter a parse tree produced by {@link GramaParser#cmdVisualizar}.
	 * @param ctx the parse tree
	 */
	void enterCmdVisualizar(GramaParser.CmdVisualizarContext ctx);
	/**
	 * Exit a parse tree produced by {@link GramaParser#cmdVisualizar}.
	 * @param ctx the parse tree
	 */
	void exitCmdVisualizar(GramaParser.CmdVisualizarContext ctx);
	/**
	 * Enter a parse tree produced by {@link GramaParser#nome}.
	 * @param ctx the parse tree
	 */
	void enterNome(GramaParser.NomeContext ctx);
	/**
	 * Exit a parse tree produced by {@link GramaParser#nome}.
	 * @param ctx the parse tree
	 */
	void exitNome(GramaParser.NomeContext ctx);
	/**
	 * Enter a parse tree produced by {@link GramaParser#tipoInvestimento}.
	 * @param ctx the parse tree
	 */
	void enterTipoInvestimento(GramaParser.TipoInvestimentoContext ctx);
	/**
	 * Exit a parse tree produced by {@link GramaParser#tipoInvestimento}.
	 * @param ctx the parse tree
	 */
	void exitTipoInvestimento(GramaParser.TipoInvestimentoContext ctx);
	/**
	 * Enter a parse tree produced by {@link GramaParser#periodicidade}.
	 * @param ctx the parse tree
	 */
	void enterPeriodicidade(GramaParser.PeriodicidadeContext ctx);
	/**
	 * Exit a parse tree produced by {@link GramaParser#periodicidade}.
	 * @param ctx the parse tree
	 */
	void exitPeriodicidade(GramaParser.PeriodicidadeContext ctx);
}