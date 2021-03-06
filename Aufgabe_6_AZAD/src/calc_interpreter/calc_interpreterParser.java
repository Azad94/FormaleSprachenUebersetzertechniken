// Generated from calc_interpreter.g4 by ANTLR 4.4
package calc_interpreter;

import java.util.*;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class calc_interpreterParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.4", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__1=1, T__0=2, SMA=3, GRE=4, EXP=5, MUL=6, DIV=7, ADD=8, SUB=9, LBRACK=10, 
		RBRACK=11, ID=12, INT=13, NEWLINE=14, WS=15;
	public static final String[] tokenNames = {
		"<INVALID>", "'#'", "'='", "'<'", "'>'", "'^'", "'*'", "'/'", "'+'", "'-'", 
		"'('", "')'", "ID", "INT", "NEWLINE", "WS"
	};
	public static final int
		RULE_prog = 0, RULE_stat = 1, RULE_clear = 2, RULE_e = 3;
	public static final String[] ruleNames = {
		"prog", "stat", "clear", "e"
	};

	@Override
	public String getGrammarFileName() { return "calc_interpreter.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }


	    /** "memory" for our calculator; variable/value pairs go here */
	    Map<String, Integer> memory = new HashMap<String, Integer>();
	    int eval(int left, int op, int right) {
	        switch ( op ) {
	            case MUL : return (left * right);
	            case DIV : return left / right;
	            case ADD : return (left + right);
	            case SUB : return left - right;
	            case GRE : if (left > right){return 1; } else {return 0;}
	            case SMA : if (right > left){return 1; } else {return 0;}
	            case EXP : return (int)Math.pow(left,right);
	        }
	        return 0;
	    }
	    
	    int evalUnaer(int left, int op) {
	        switch ( op ) {
	            case SUB : return - left;
	        }
	        return 0;
	    }
	    
	    int visitClear(){
			memory.clear();
			return 0;
		}

	public calc_interpreterParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgContext extends ParserRuleContext {
		public StatContext stat(int i) {
			return getRuleContext(StatContext.class,i);
		}
		public List<StatContext> stat() {
			return getRuleContexts(StatContext.class);
		}
		public ProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prog; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof calc_interpreterListener ) ((calc_interpreterListener)listener).enterProg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof calc_interpreterListener ) ((calc_interpreterListener)listener).exitProg(this);
		}
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_prog);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(9); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(8); stat();
				}
				}
				setState(11); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << SUB) | (1L << LBRACK) | (1L << ID) | (1L << INT) | (1L << NEWLINE))) != 0) );
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

	public static class StatContext extends ParserRuleContext {
		public EContext e;
		public Token ID;
		public TerminalNode ID() { return getToken(calc_interpreterParser.ID, 0); }
		public EContext e() {
			return getRuleContext(EContext.class,0);
		}
		public TerminalNode NEWLINE() { return getToken(calc_interpreterParser.NEWLINE, 0); }
		public ClearContext clear() {
			return getRuleContext(ClearContext.class,0);
		}
		public StatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stat; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof calc_interpreterListener ) ((calc_interpreterListener)listener).enterStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof calc_interpreterListener ) ((calc_interpreterListener)listener).exitStat(this);
		}
	}

	public final StatContext stat() throws RecognitionException {
		StatContext _localctx = new StatContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_stat);
		try {
			setState(25);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(13); ((StatContext)_localctx).e = e(0);
				setState(14); match(NEWLINE);
				System.out.println(((StatContext)_localctx).e.v);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(17); ((StatContext)_localctx).ID = match(ID);
				setState(18); match(T__0);
				setState(19); ((StatContext)_localctx).e = e(0);
				setState(20); match(NEWLINE);
				memory.put((((StatContext)_localctx).ID!=null?((StatContext)_localctx).ID.getText():null), ((StatContext)_localctx).e.v);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(23); match(NEWLINE);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(24); clear();
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

	public static class ClearContext extends ParserRuleContext {
		public ClearContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_clear; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof calc_interpreterListener ) ((calc_interpreterListener)listener).enterClear(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof calc_interpreterListener ) ((calc_interpreterListener)listener).exitClear(this);
		}
	}

	public final ClearContext clear() throws RecognitionException {
		ClearContext _localctx = new ClearContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_clear);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(27); match(T__1);
			visitClear();
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

	public static class EContext extends ParserRuleContext {
		public int v;
		public EContext a;
		public Token op;
		public Token INT;
		public Token ID;
		public EContext b;
		public TerminalNode ID() { return getToken(calc_interpreterParser.ID, 0); }
		public List<EContext> e() {
			return getRuleContexts(EContext.class);
		}
		public TerminalNode RBRACK() { return getToken(calc_interpreterParser.RBRACK, 0); }
		public TerminalNode INT() { return getToken(calc_interpreterParser.INT, 0); }
		public EContext e(int i) {
			return getRuleContext(EContext.class,i);
		}
		public TerminalNode LBRACK() { return getToken(calc_interpreterParser.LBRACK, 0); }
		public EContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_e; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof calc_interpreterListener ) ((calc_interpreterListener)listener).enterE(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof calc_interpreterListener ) ((calc_interpreterListener)listener).exitE(this);
		}
	}

	public final EContext e() throws RecognitionException {
		return e(0);
	}

	private EContext e(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		EContext _localctx = new EContext(_ctx, _parentState);
		EContext _prevctx = _localctx;
		int _startState = 6;
		enterRecursionRule(_localctx, 6, RULE_e, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(44);
			switch (_input.LA(1)) {
			case SUB:
				{
				setState(31); ((EContext)_localctx).op = match(SUB);
				setState(32); ((EContext)_localctx).a = e(4);
				((EContext)_localctx).v =  evalUnaer(((EContext)_localctx).a.v, (((EContext)_localctx).op!=null?((EContext)_localctx).op.getType():0));
				}
				break;
			case INT:
				{
				setState(35); ((EContext)_localctx).INT = match(INT);
				((EContext)_localctx).v =  (((EContext)_localctx).INT!=null?Integer.valueOf(((EContext)_localctx).INT.getText()):0);
				}
				break;
			case ID:
				{
				setState(37); ((EContext)_localctx).ID = match(ID);

				      String id = (((EContext)_localctx).ID!=null?((EContext)_localctx).ID.getText():null);
				      ((EContext)_localctx).v =  memory.containsKey(id) ? memory.get(id) : 0;
				      
				}
				break;
			case LBRACK:
				{
				setState(39); match(LBRACK);
				setState(40); ((EContext)_localctx).a = e(0);
				setState(41); match(RBRACK);
				((EContext)_localctx).v =  ((EContext)_localctx).a.v;
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(68);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(66);
					switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
					case 1:
						{
						_localctx = new EContext(_parentctx, _parentState);
						_localctx.a = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_e);
						setState(46);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(47); ((EContext)_localctx).op = match(EXP);
						setState(48); ((EContext)_localctx).b = e(8);
						((EContext)_localctx).v =  eval(((EContext)_localctx).a.v, (((EContext)_localctx).op!=null?((EContext)_localctx).op.getType():0), ((EContext)_localctx).b.v);
						}
						break;
					case 2:
						{
						_localctx = new EContext(_parentctx, _parentState);
						_localctx.a = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_e);
						setState(51);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(52);
						((EContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==SMA || _la==GRE) ) {
							((EContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						consume();
						setState(53); ((EContext)_localctx).b = e(8);
						((EContext)_localctx).v =  eval(((EContext)_localctx).a.v, (((EContext)_localctx).op!=null?((EContext)_localctx).op.getType():0), ((EContext)_localctx).b.v);
						}
						break;
					case 3:
						{
						_localctx = new EContext(_parentctx, _parentState);
						_localctx.a = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_e);
						setState(56);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(57);
						((EContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==MUL || _la==DIV) ) {
							((EContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						consume();
						setState(58); ((EContext)_localctx).b = e(7);
						((EContext)_localctx).v =  eval(((EContext)_localctx).a.v, (((EContext)_localctx).op!=null?((EContext)_localctx).op.getType():0), ((EContext)_localctx).b.v);
						}
						break;
					case 4:
						{
						_localctx = new EContext(_parentctx, _parentState);
						_localctx.a = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_e);
						setState(61);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(62);
						((EContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==ADD || _la==SUB) ) {
							((EContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						consume();
						setState(63); ((EContext)_localctx).b = e(6);
						((EContext)_localctx).v =  eval(((EContext)_localctx).a.v, (((EContext)_localctx).op!=null?((EContext)_localctx).op.getType():0), ((EContext)_localctx).b.v);
						}
						break;
					}
					} 
				}
				setState(70);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 3: return e_sempred((EContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean e_sempred(EContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0: return precpred(_ctx, 8);
		case 1: return precpred(_ctx, 7);
		case 2: return precpred(_ctx, 6);
		case 3: return precpred(_ctx, 5);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\21J\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\3\2\6\2\f\n\2\r\2\16\2\r\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\5\3\34\n\3\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5/\n\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\7\5E\n\5\f\5\16\5"+
		"H\13\5\3\5\2\3\b\6\2\4\6\b\2\5\3\2\5\6\3\2\b\t\3\2\n\13P\2\13\3\2\2\2"+
		"\4\33\3\2\2\2\6\35\3\2\2\2\b.\3\2\2\2\n\f\5\4\3\2\13\n\3\2\2\2\f\r\3\2"+
		"\2\2\r\13\3\2\2\2\r\16\3\2\2\2\16\3\3\2\2\2\17\20\5\b\5\2\20\21\7\20\2"+
		"\2\21\22\b\3\1\2\22\34\3\2\2\2\23\24\7\16\2\2\24\25\7\4\2\2\25\26\5\b"+
		"\5\2\26\27\7\20\2\2\27\30\b\3\1\2\30\34\3\2\2\2\31\34\7\20\2\2\32\34\5"+
		"\6\4\2\33\17\3\2\2\2\33\23\3\2\2\2\33\31\3\2\2\2\33\32\3\2\2\2\34\5\3"+
		"\2\2\2\35\36\7\3\2\2\36\37\b\4\1\2\37\7\3\2\2\2 !\b\5\1\2!\"\7\13\2\2"+
		"\"#\5\b\5\6#$\b\5\1\2$/\3\2\2\2%&\7\17\2\2&/\b\5\1\2\'(\7\16\2\2(/\b\5"+
		"\1\2)*\7\f\2\2*+\5\b\5\2+,\7\r\2\2,-\b\5\1\2-/\3\2\2\2. \3\2\2\2.%\3\2"+
		"\2\2.\'\3\2\2\2.)\3\2\2\2/F\3\2\2\2\60\61\f\n\2\2\61\62\7\7\2\2\62\63"+
		"\5\b\5\n\63\64\b\5\1\2\64E\3\2\2\2\65\66\f\t\2\2\66\67\t\2\2\2\678\5\b"+
		"\5\n89\b\5\1\29E\3\2\2\2:;\f\b\2\2;<\t\3\2\2<=\5\b\5\t=>\b\5\1\2>E\3\2"+
		"\2\2?@\f\7\2\2@A\t\4\2\2AB\5\b\5\bBC\b\5\1\2CE\3\2\2\2D\60\3\2\2\2D\65"+
		"\3\2\2\2D:\3\2\2\2D?\3\2\2\2EH\3\2\2\2FD\3\2\2\2FG\3\2\2\2G\t\3\2\2\2"+
		"HF\3\2\2\2\7\r\33.DF";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}