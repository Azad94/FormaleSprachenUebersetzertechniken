package ast;

import lexer_parser.Token;
import visitor.Visitor;

public class UMinusNode extends UnaryNode {

	public UMinusNode(ExprNode left, Token token) {
		super(left, token);
	}

	public <T> T accept(Visitor<T> Visitor) {
		return Visitor.visit(this);
	}
}