package model.state;

import model.Calculator;
import model.operations.BinaryOperation;
import model.operations.UnaryOperation;

public class ErrorState extends CalculatorState {
	
	private static final ErrorState INSTANCE = new ErrorState();
	
	private ErrorState(){
		if(INSTANCE!=null){
			throw new IllegalStateException("Already instantiated !");
		}
	}
	
	public static ErrorState getInstance(){
		return INSTANCE;
	}
	
	@Override
	public String enterDigit(Calculator calculator, char digit) {
		return "ERR";
	}

	@Override
	public String enterBinaryOperation(Calculator calculator, BinaryOperation binaryOperation) {
		return "ERR";
	}

	@Override
	public String enterUnaryOperation(Calculator calculator, UnaryOperation unaryOperation) {
		return "ERR";
	}

	@Override
	public String enterEquals(Calculator calculator) {
		return "ERR";
	}

	@Override
	public String enterPoint(Calculator calculator) {
		return "ERR";
	}

}
