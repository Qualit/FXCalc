package model.operations;

import enums.OperationType;

public abstract class BinaryOperation extends Operation {
	
	
	protected boolean isComputed;
	
	abstract double compute(final double operand1, final double operand2);

	public boolean isComputed() {
		return isComputed;
	}

	public void setComputed(boolean isComputed) {
		this.isComputed = isComputed;
	}

}