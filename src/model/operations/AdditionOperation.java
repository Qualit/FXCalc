package model.operations;

import enums.OperationType;

public class AdditionOperation extends  BinaryOperation{
	
	
	public AdditionOperation() {
		operationType = OperationType.ADD;
	}
	
	@Override
	public double compute(final double operand1, final double operand2) throws ArithmeticException,IllegalArgumentException{
		
		if(Double.isNaN(operand1)){
			throw new IllegalArgumentException("Additon operand1 is incorrect");
		}
		if(Double.isNaN(operand2)){
			throw new IllegalArgumentException("Additon operand2 is incorrect");
		}
		
		double result = operand1 + operand2;
		System.out.println("compute ADD, operand1: "+operand1+", operand2: "+operand2+"result: "+result);
		
		if(Double.isNaN(result)){
			throw new ArithmeticException("Incorrect addition result");
		}
		
		return result;
	}
	

}
