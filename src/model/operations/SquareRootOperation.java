package model.operations;

import enums.OperationType;

public class SquareRootOperation extends UnaryOperation{
	
	public SquareRootOperation() {
		this.operationType = OperationType.SQUARE_ROOT;
	}
	
	public double evaluate(final double operand){
		
		double result = Math.sqrt(operand);
		if(Double.isNaN(result)){
			throw new ArithmeticException();
		}
		else{
			return result;
		}
	}

}
