package visitor;

import ast.*;

public class EvaluationVisitor implements Visitor<Double> {

	private Double result;

	public EvaluationVisitor() {
		this.result = 0.0;
	}

	public Double getRes() {
		return this.result;
	}

	@Override
	public Double visit(AddNode n) {
		return result += n.getLeft().accept(this) + n.getRight().accept(this);
	}

	@Override
	public Double visit(MinusNode n) {
		return result += n.getLeft().accept(this) - n.getRight().accept(this);
	}

	@Override
	public Double visit(MultiNode n) {
		return result += (n.getLeft().accept(this) * n.getRight().accept(this));
	}

	@Override
	public Double visit(DivNode n) {
		return result += (n.getLeft().accept(this) / n.getRight().accept(this));
	}

	@Override
	public Double visit(IntNode n) {
		return Double.parseDouble(n.toString());
	}

	@Override
	public Double visit(UMinusNode n) {
		// TODO Auto-generated method stub
		return null;
	}

}

