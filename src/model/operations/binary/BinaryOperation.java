package model.operations.binary;

import enums.OperationType;
import model.operations.Operation;

public abstract class BinaryOperation extends Operation {
	
	
	protected boolean isComputed;
	
	abstract double compute(final double operand1, final double operand2)throws ArithmeticException, IllegalArgumentException;

	public boolean isComputed() {
		return isComputed;
	}

	public void setComputed(boolean isComputed) {
		this.isComputed = isComputed;
	}

}