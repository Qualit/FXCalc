package model.operations.binary;

import enums.OperationType;

public class DivisionOperation extends BinaryOperation{
	
	public DivisionOperation() {
		this.operationType = OperationType.DIVIDE;
	}

	@Override
	public double compute(final double operand1, final double operand2)throws ArithmeticException,IllegalArgumentException {
		
//		if(Double.isNaN(operand1)){
//			throw new IllegalArgumentException("Division operand1 is incorrect");
//		}
//		if(Double.isNaN(operand2)){
//			throw new IllegalArgumentException("Division operand2 is incorrect");
//		}
		
		double result = operand1 / operand2;
		
		if(Double.isNaN(result)){
			throw new ArithmeticException("Incorrect Division result");
		}
		
		if(Double.isInfinite(result)){
			throw new ArithmeticException("Division by 0 !!!");
		}
		
		return result;
	}
	

}
