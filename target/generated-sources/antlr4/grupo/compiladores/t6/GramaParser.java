// Generated from grupo/compiladores/t6/Grama.g4 by ANTLR 4.13.1
package grupo.compiladores.t6;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class GramaParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, Fixa=21, Variavel=22, STRING=23, TIPO=24, 
		NUMERO=25, WS=26, ERRO=27, COMMENT=28, LINE_COMMENT=29;
	public static final int
		RULE_programa = 0, RULE_lista_clientes = 1, RULE_cliente = 2, RULE_lista_atributos = 3, 
		RULE_atributo = 4, RULE_cmd = 5, RULE_cmdPrevisao = 6, RULE_cmdPassado = 7, 
		RULE_cmdAlertaRisco = 8, RULE_cmdVisualizar = 9, RULE_nome = 10, RULE_tipoInvestimento = 11, 
		RULE_periodicidade = 12;
	private static String[] makeRuleNames() {
		return new String[] {
			"programa", "lista_clientes", "cliente", "lista_atributos", "atributo", 
			"cmd", "cmdPrevisao", "cmdPassado", "cmdAlertaRisco", "cmdVisualizar", 
			"nome", "tipoInvestimento", "periodicidade"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'algoritmo'", "'Clientes'", "'('", "')'", "'fimAlgoritmo'", "'{'", 
			"'}'", "','", "'Nome:'", "'ValorInvestido:'", "'TempoInvestido:'", "'LucroAlmejado:'", 
			"'Previsao'", "'Passado'", "'Alerta'", "'Mostrar'", "'()'", "'DIARIO'", 
			"'MENSAL'", "'ANUAL'", "'TESOURO'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, "Fixa", "Variavel", 
			"STRING", "TIPO", "NUMERO", "WS", "ERRO", "COMMENT", "LINE_COMMENT"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "Grama.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public GramaParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramaContext extends ParserRuleContext {
		public Lista_clientesContext lista_clientes() {
			return getRuleContext(Lista_clientesContext.class,0);
		}
		public List<CmdContext> cmd() {
			return getRuleContexts(CmdContext.class);
		}
		public CmdContext cmd(int i) {
			return getRuleContext(CmdContext.class,i);
		}
		public ProgramaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_programa; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramaListener ) ((GramaListener)listener).enterPrograma(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramaListener ) ((GramaListener)listener).exitPrograma(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaVisitor ) return ((GramaVisitor<? extends T>)visitor).visitPrograma(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramaContext programa() throws RecognitionException {
		ProgramaContext _localctx = new ProgramaContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_programa);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(26);
			match(T__0);
			setState(27);
			match(T__1);
			setState(28);
			match(T__2);
			setState(29);
			lista_clientes();
			setState(30);
			match(T__3);
			setState(34);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1+1 ) {
					{
					{
					setState(31);
					cmd();
					}
					} 
				}
				setState(36);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			}
			setState(37);
			match(T__4);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Lista_clientesContext extends ParserRuleContext {
		public List<ClienteContext> cliente() {
			return getRuleContexts(ClienteContext.class);
		}
		public ClienteContext cliente(int i) {
			return getRuleContext(ClienteContext.class,i);
		}
		public Lista_clientesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lista_clientes; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramaListener ) ((GramaListener)listener).enterLista_clientes(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramaListener ) ((GramaListener)listener).exitLista_clientes(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaVisitor ) return ((GramaVisitor<? extends T>)visitor).visitLista_clientes(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Lista_clientesContext lista_clientes() throws RecognitionException {
		Lista_clientesContext _localctx = new Lista_clientesContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_lista_clientes);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(40); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(39);
				cliente();
				}
				}
				setState(42); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==TIPO );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ClienteContext extends ParserRuleContext {
		public TerminalNode TIPO() { return getToken(GramaParser.TIPO, 0); }
		public Lista_atributosContext lista_atributos() {
			return getRuleContext(Lista_atributosContext.class,0);
		}
		public ClienteContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cliente; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramaListener ) ((GramaListener)listener).enterCliente(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramaListener ) ((GramaListener)listener).exitCliente(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaVisitor ) return ((GramaVisitor<? extends T>)visitor).visitCliente(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClienteContext cliente() throws RecognitionException {
		ClienteContext _localctx = new ClienteContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_cliente);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(44);
			match(TIPO);
			setState(45);
			match(T__5);
			setState(46);
			lista_atributos();
			setState(47);
			match(T__6);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Lista_atributosContext extends ParserRuleContext {
		public List<AtributoContext> atributo() {
			return getRuleContexts(AtributoContext.class);
		}
		public AtributoContext atributo(int i) {
			return getRuleContext(AtributoContext.class,i);
		}
		public Lista_atributosContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lista_atributos; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramaListener ) ((GramaListener)listener).enterLista_atributos(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramaListener ) ((GramaListener)listener).exitLista_atributos(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaVisitor ) return ((GramaVisitor<? extends T>)visitor).visitLista_atributos(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Lista_atributosContext lista_atributos() throws RecognitionException {
		Lista_atributosContext _localctx = new Lista_atributosContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_lista_atributos);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(49);
			atributo();
			setState(54);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__7) {
				{
				{
				setState(50);
				match(T__7);
				setState(51);
				atributo();
				}
				}
				setState(56);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AtributoContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(GramaParser.STRING, 0); }
		public TerminalNode NUMERO() { return getToken(GramaParser.NUMERO, 0); }
		public AtributoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atributo; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramaListener ) ((GramaListener)listener).enterAtributo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramaListener ) ((GramaListener)listener).exitAtributo(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaVisitor ) return ((GramaVisitor<? extends T>)visitor).visitAtributo(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AtributoContext atributo() throws RecognitionException {
		AtributoContext _localctx = new AtributoContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_atributo);
		try {
			setState(65);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__8:
				enterOuterAlt(_localctx, 1);
				{
				setState(57);
				match(T__8);
				setState(58);
				match(STRING);
				}
				break;
			case T__9:
				enterOuterAlt(_localctx, 2);
				{
				setState(59);
				match(T__9);
				setState(60);
				match(NUMERO);
				}
				break;
			case T__10:
				enterOuterAlt(_localctx, 3);
				{
				setState(61);
				match(T__10);
				setState(62);
				match(NUMERO);
				}
				break;
			case T__11:
				enterOuterAlt(_localctx, 4);
				{
				setState(63);
				match(T__11);
				setState(64);
				match(NUMERO);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CmdContext extends ParserRuleContext {
		public CmdPrevisaoContext cmdPrevisao() {
			return getRuleContext(CmdPrevisaoContext.class,0);
		}
		public CmdPassadoContext cmdPassado() {
			return getRuleContext(CmdPassadoContext.class,0);
		}
		public CmdVisualizarContext cmdVisualizar() {
			return getRuleContext(CmdVisualizarContext.class,0);
		}
		public CmdAlertaRiscoContext cmdAlertaRisco() {
			return getRuleContext(CmdAlertaRiscoContext.class,0);
		}
		public CmdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmd; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramaListener ) ((GramaListener)listener).enterCmd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramaListener ) ((GramaListener)listener).exitCmd(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaVisitor ) return ((GramaVisitor<? extends T>)visitor).visitCmd(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CmdContext cmd() throws RecognitionException {
		CmdContext _localctx = new CmdContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_cmd);
		try {
			setState(71);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__12:
				enterOuterAlt(_localctx, 1);
				{
				setState(67);
				cmdPrevisao();
				}
				break;
			case T__13:
				enterOuterAlt(_localctx, 2);
				{
				setState(68);
				cmdPassado();
				}
				break;
			case T__15:
				enterOuterAlt(_localctx, 3);
				{
				setState(69);
				cmdVisualizar();
				}
				break;
			case T__14:
				enterOuterAlt(_localctx, 4);
				{
				setState(70);
				cmdAlertaRisco();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CmdPrevisaoContext extends ParserRuleContext {
		public TipoInvestimentoContext tipoInvestimento() {
			return getRuleContext(TipoInvestimentoContext.class,0);
		}
		public List<TerminalNode> NUMERO() { return getTokens(GramaParser.NUMERO); }
		public TerminalNode NUMERO(int i) {
			return getToken(GramaParser.NUMERO, i);
		}
		public NomeContext nome() {
			return getRuleContext(NomeContext.class,0);
		}
		public CmdPrevisaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdPrevisao; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramaListener ) ((GramaListener)listener).enterCmdPrevisao(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramaListener ) ((GramaListener)listener).exitCmdPrevisao(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaVisitor ) return ((GramaVisitor<? extends T>)visitor).visitCmdPrevisao(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CmdPrevisaoContext cmdPrevisao() throws RecognitionException {
		CmdPrevisaoContext _localctx = new CmdPrevisaoContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_cmdPrevisao);
		int _la;
		try {
			setState(96);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(73);
				match(T__12);
				setState(74);
				match(T__2);
				setState(75);
				tipoInvestimento();
				setState(76);
				match(T__7);
				setState(77);
				match(T__5);
				setState(78);
				match(NUMERO);
				setState(83);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__7) {
					{
					{
					setState(79);
					match(T__7);
					setState(80);
					match(NUMERO);
					}
					}
					setState(85);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(86);
				match(T__6);
				setState(87);
				match(T__3);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(89);
				match(T__12);
				setState(90);
				match(T__2);
				setState(91);
				nome();
				setState(92);
				match(T__7);
				setState(93);
				tipoInvestimento();
				setState(94);
				match(T__3);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CmdPassadoContext extends ParserRuleContext {
		public NomeContext nome() {
			return getRuleContext(NomeContext.class,0);
		}
		public TipoInvestimentoContext tipoInvestimento() {
			return getRuleContext(TipoInvestimentoContext.class,0);
		}
		public PeriodicidadeContext periodicidade() {
			return getRuleContext(PeriodicidadeContext.class,0);
		}
		public CmdPassadoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdPassado; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramaListener ) ((GramaListener)listener).enterCmdPassado(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramaListener ) ((GramaListener)listener).exitCmdPassado(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaVisitor ) return ((GramaVisitor<? extends T>)visitor).visitCmdPassado(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CmdPassadoContext cmdPassado() throws RecognitionException {
		CmdPassadoContext _localctx = new CmdPassadoContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_cmdPassado);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(98);
			match(T__13);
			setState(99);
			match(T__2);
			setState(100);
			nome();
			setState(101);
			match(T__7);
			setState(102);
			tipoInvestimento();
			setState(103);
			match(T__7);
			setState(104);
			periodicidade();
			setState(105);
			match(T__3);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CmdAlertaRiscoContext extends ParserRuleContext {
		public TipoInvestimentoContext tipoInvestimento() {
			return getRuleContext(TipoInvestimentoContext.class,0);
		}
		public CmdAlertaRiscoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdAlertaRisco; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramaListener ) ((GramaListener)listener).enterCmdAlertaRisco(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramaListener ) ((GramaListener)listener).exitCmdAlertaRisco(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaVisitor ) return ((GramaVisitor<? extends T>)visitor).visitCmdAlertaRisco(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CmdAlertaRiscoContext cmdAlertaRisco() throws RecognitionException {
		CmdAlertaRiscoContext _localctx = new CmdAlertaRiscoContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_cmdAlertaRisco);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(107);
			match(T__14);
			setState(108);
			match(T__2);
			setState(109);
			tipoInvestimento();
			setState(110);
			match(T__3);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CmdVisualizarContext extends ParserRuleContext {
		public CmdVisualizarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdVisualizar; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramaListener ) ((GramaListener)listener).enterCmdVisualizar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramaListener ) ((GramaListener)listener).exitCmdVisualizar(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaVisitor ) return ((GramaVisitor<? extends T>)visitor).visitCmdVisualizar(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CmdVisualizarContext cmdVisualizar() throws RecognitionException {
		CmdVisualizarContext _localctx = new CmdVisualizarContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_cmdVisualizar);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(112);
			match(T__15);
			setState(113);
			match(T__16);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class NomeContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(GramaParser.STRING, 0); }
		public NomeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nome; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramaListener ) ((GramaListener)listener).enterNome(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramaListener ) ((GramaListener)listener).exitNome(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaVisitor ) return ((GramaVisitor<? extends T>)visitor).visitNome(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NomeContext nome() throws RecognitionException {
		NomeContext _localctx = new NomeContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_nome);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(115);
			match(STRING);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TipoInvestimentoContext extends ParserRuleContext {
		public TerminalNode Fixa() { return getToken(GramaParser.Fixa, 0); }
		public TerminalNode Variavel() { return getToken(GramaParser.Variavel, 0); }
		public TipoInvestimentoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tipoInvestimento; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramaListener ) ((GramaListener)listener).enterTipoInvestimento(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramaListener ) ((GramaListener)listener).exitTipoInvestimento(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaVisitor ) return ((GramaVisitor<? extends T>)visitor).visitTipoInvestimento(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TipoInvestimentoContext tipoInvestimento() throws RecognitionException {
		TipoInvestimentoContext _localctx = new TipoInvestimentoContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_tipoInvestimento);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(117);
			_la = _input.LA(1);
			if ( !(_la==Fixa || _la==Variavel) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PeriodicidadeContext extends ParserRuleContext {
		public PeriodicidadeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_periodicidade; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramaListener ) ((GramaListener)listener).enterPeriodicidade(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramaListener ) ((GramaListener)listener).exitPeriodicidade(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaVisitor ) return ((GramaVisitor<? extends T>)visitor).visitPeriodicidade(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PeriodicidadeContext periodicidade() throws RecognitionException {
		PeriodicidadeContext _localctx = new PeriodicidadeContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_periodicidade);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(119);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 1835008L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\u0004\u0001\u001dz\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0005\u0000!\b\u0000\n\u0000\f\u0000$\t\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0001\u0004\u0001)\b\u0001\u000b\u0001\f\u0001*\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0005\u00035\b\u0003\n\u0003\f\u00038\t\u0003\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0003\u0004B\b\u0004\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0003\u0005H\b\u0005\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0005"+
		"\u0006R\b\u0006\n\u0006\f\u0006U\t\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0003\u0006a\b\u0006\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\t\u0001\t\u0001\t"+
		"\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0001\f\u0001"+
		"\"\u0000\r\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016"+
		"\u0018\u0000\u0002\u0001\u0000\u0015\u0016\u0001\u0000\u0012\u0014w\u0000"+
		"\u001a\u0001\u0000\u0000\u0000\u0002(\u0001\u0000\u0000\u0000\u0004,\u0001"+
		"\u0000\u0000\u0000\u00061\u0001\u0000\u0000\u0000\bA\u0001\u0000\u0000"+
		"\u0000\nG\u0001\u0000\u0000\u0000\f`\u0001\u0000\u0000\u0000\u000eb\u0001"+
		"\u0000\u0000\u0000\u0010k\u0001\u0000\u0000\u0000\u0012p\u0001\u0000\u0000"+
		"\u0000\u0014s\u0001\u0000\u0000\u0000\u0016u\u0001\u0000\u0000\u0000\u0018"+
		"w\u0001\u0000\u0000\u0000\u001a\u001b\u0005\u0001\u0000\u0000\u001b\u001c"+
		"\u0005\u0002\u0000\u0000\u001c\u001d\u0005\u0003\u0000\u0000\u001d\u001e"+
		"\u0003\u0002\u0001\u0000\u001e\"\u0005\u0004\u0000\u0000\u001f!\u0003"+
		"\n\u0005\u0000 \u001f\u0001\u0000\u0000\u0000!$\u0001\u0000\u0000\u0000"+
		"\"#\u0001\u0000\u0000\u0000\" \u0001\u0000\u0000\u0000#%\u0001\u0000\u0000"+
		"\u0000$\"\u0001\u0000\u0000\u0000%&\u0005\u0005\u0000\u0000&\u0001\u0001"+
		"\u0000\u0000\u0000\')\u0003\u0004\u0002\u0000(\'\u0001\u0000\u0000\u0000"+
		")*\u0001\u0000\u0000\u0000*(\u0001\u0000\u0000\u0000*+\u0001\u0000\u0000"+
		"\u0000+\u0003\u0001\u0000\u0000\u0000,-\u0005\u0018\u0000\u0000-.\u0005"+
		"\u0006\u0000\u0000./\u0003\u0006\u0003\u0000/0\u0005\u0007\u0000\u0000"+
		"0\u0005\u0001\u0000\u0000\u000016\u0003\b\u0004\u000023\u0005\b\u0000"+
		"\u000035\u0003\b\u0004\u000042\u0001\u0000\u0000\u000058\u0001\u0000\u0000"+
		"\u000064\u0001\u0000\u0000\u000067\u0001\u0000\u0000\u00007\u0007\u0001"+
		"\u0000\u0000\u000086\u0001\u0000\u0000\u00009:\u0005\t\u0000\u0000:B\u0005"+
		"\u0017\u0000\u0000;<\u0005\n\u0000\u0000<B\u0005\u0019\u0000\u0000=>\u0005"+
		"\u000b\u0000\u0000>B\u0005\u0019\u0000\u0000?@\u0005\f\u0000\u0000@B\u0005"+
		"\u0019\u0000\u0000A9\u0001\u0000\u0000\u0000A;\u0001\u0000\u0000\u0000"+
		"A=\u0001\u0000\u0000\u0000A?\u0001\u0000\u0000\u0000B\t\u0001\u0000\u0000"+
		"\u0000CH\u0003\f\u0006\u0000DH\u0003\u000e\u0007\u0000EH\u0003\u0012\t"+
		"\u0000FH\u0003\u0010\b\u0000GC\u0001\u0000\u0000\u0000GD\u0001\u0000\u0000"+
		"\u0000GE\u0001\u0000\u0000\u0000GF\u0001\u0000\u0000\u0000H\u000b\u0001"+
		"\u0000\u0000\u0000IJ\u0005\r\u0000\u0000JK\u0005\u0003\u0000\u0000KL\u0003"+
		"\u0016\u000b\u0000LM\u0005\b\u0000\u0000MN\u0005\u0006\u0000\u0000NS\u0005"+
		"\u0019\u0000\u0000OP\u0005\b\u0000\u0000PR\u0005\u0019\u0000\u0000QO\u0001"+
		"\u0000\u0000\u0000RU\u0001\u0000\u0000\u0000SQ\u0001\u0000\u0000\u0000"+
		"ST\u0001\u0000\u0000\u0000TV\u0001\u0000\u0000\u0000US\u0001\u0000\u0000"+
		"\u0000VW\u0005\u0007\u0000\u0000WX\u0005\u0004\u0000\u0000Xa\u0001\u0000"+
		"\u0000\u0000YZ\u0005\r\u0000\u0000Z[\u0005\u0003\u0000\u0000[\\\u0003"+
		"\u0014\n\u0000\\]\u0005\b\u0000\u0000]^\u0003\u0016\u000b\u0000^_\u0005"+
		"\u0004\u0000\u0000_a\u0001\u0000\u0000\u0000`I\u0001\u0000\u0000\u0000"+
		"`Y\u0001\u0000\u0000\u0000a\r\u0001\u0000\u0000\u0000bc\u0005\u000e\u0000"+
		"\u0000cd\u0005\u0003\u0000\u0000de\u0003\u0014\n\u0000ef\u0005\b\u0000"+
		"\u0000fg\u0003\u0016\u000b\u0000gh\u0005\b\u0000\u0000hi\u0003\u0018\f"+
		"\u0000ij\u0005\u0004\u0000\u0000j\u000f\u0001\u0000\u0000\u0000kl\u0005"+
		"\u000f\u0000\u0000lm\u0005\u0003\u0000\u0000mn\u0003\u0016\u000b\u0000"+
		"no\u0005\u0004\u0000\u0000o\u0011\u0001\u0000\u0000\u0000pq\u0005\u0010"+
		"\u0000\u0000qr\u0005\u0011\u0000\u0000r\u0013\u0001\u0000\u0000\u0000"+
		"st\u0005\u0017\u0000\u0000t\u0015\u0001\u0000\u0000\u0000uv\u0007\u0000"+
		"\u0000\u0000v\u0017\u0001\u0000\u0000\u0000wx\u0007\u0001\u0000\u0000"+
		"x\u0019\u0001\u0000\u0000\u0000\u0007\"*6AGS`";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}