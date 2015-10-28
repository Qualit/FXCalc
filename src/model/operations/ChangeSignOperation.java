package model.operations;

import enums.OperationType;

public class ChangeSignOperation extends UnaryOperation {
	
	public ChangeSignOperation() {
		this.operationType = OperationType.CHANGE_SIGN;
	}

	@Override
	public double evaluate(final double operand) {
		double result = -operand;
		
		if(Double.isNaN(result)){
			throw new ArithmeticException();
		}
		else{
			return result;
		}
	}
	
	

}
