package model.operations.unary;

import model.operations.Operation;

public abstract class UnaryOperation extends Operation {
	
	
	protected boolean isEvaluated;
	//abstract double evaluate();
	
	
	public boolean isEvaluated() {
		return isEvaluated;
	}

	public void setEvaluated(boolean isEvaluated) {
		this.isEvaluated = isEvaluated;
	}
	
	abstract public double evaluate(final double operand)throws ArithmeticException;
	
	
	

}
