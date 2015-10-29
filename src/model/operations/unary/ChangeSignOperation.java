package model.operations.unary;

import enums.OperationType;

public class ChangeSignOperation extends UnaryOperation {
	
	public ChangeSignOperation() {
		this.operationType = OperationType.CHANGE_SIGN;
	}

	@Override
	public double evaluate(final double operand)throws ArithmeticException {
		double result = operand*(-1);
		
		if(Double.isNaN(result)){
			throw new ArithmeticException();
		}
		else{
			return result;
		}
	}
}
