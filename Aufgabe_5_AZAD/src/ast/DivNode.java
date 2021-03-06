package ast;

import lexer_parser.Token;
import visitor.Visitor;

public class DivNode extends BinaryNode {

	public DivNode(ExprNode left, Token addToken, ExprNode right) {
		super(left, addToken, right);
	}
	
	public <T> T accept(Visitor<T> Visitor) {
		return Visitor.visit(this);
	}

}
