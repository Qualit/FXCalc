package model.operations.binary;

import enums.OperationType;

public class SubtractionOperation extends BinaryOperation {
	
	public SubtractionOperation() {
		operationType = OperationType.SUBTRACT;
	}
	

	@Override
	public double compute(final double operand1, final double operand2)throws ArithmeticException,IllegalArgumentException {
		
		if(Double.isNaN(operand1)){
			throw new IllegalArgumentException("Subtraction operand1 is incorrect");
		}
		if(Double.isNaN(operand2)){
			throw new IllegalArgumentException("Subtraction operand2 is incorrect");
		}
		
		double result = operand1 - operand2;
		
		if(Double.isNaN(result)){
			throw new ArithmeticException("Incorrect Subtraction result");
		}
		
		return result;
	}
	

}
