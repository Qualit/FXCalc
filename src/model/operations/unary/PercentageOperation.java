package model.operations.unary;

import enums.OperationType;

public class PercentageOperation extends UnaryOperation {
	
	public PercentageOperation() {
		this.operationType = OperationType.PERCENTAGE;
	}

	@Override
	public double evaluate(double operand)throws ArithmeticException {
		double result = operand *(0.01);
		if(Double.isNaN(result)){
			throw new ArithmeticException();
		}
		else{
			return result;
		}
	}

}
