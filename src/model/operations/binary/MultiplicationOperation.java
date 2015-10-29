package model.operations.binary;

import enums.OperationType;

public class MultiplicationOperation extends BinaryOperation{
	
	public MultiplicationOperation() {
		this.operationType = OperationType.MULTIPLY;
	}

	@Override
	public double compute(final double operand1, final double operand2) throws ArithmeticException,IllegalArgumentException{
		System.out.println("MultiplicationOperation, operand1:"+operand1);
		if(Double.isNaN(operand1)){
			throw new IllegalArgumentException("Multiplication operand1 is incorrect");
		}
		if(Double.isNaN(operand2)){
			throw new IllegalArgumentException("Multiplication operand2 is incorrect");
		}
		
		double result = operand1 * operand2;
		
		if(Double.isNaN(result)){
			throw new ArithmeticException("Incorrect Multiplication result");
		}
		System.out.println("MultiplicationOperation, result:"+result);
		return result;
	}
	

}
