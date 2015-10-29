package model.state;

import model.Calculator;
import model.operations.binary.BinaryOperation;
import model.operations.unary.UnaryOperation;

public class EvaluatedState extends CalculatorState {
	
	private static final EvaluatedState INSTANCE = new EvaluatedState();
	
	private EvaluatedState() {
		if(INSTANCE!=null){
			throw new IllegalStateException("Already instantiated !");
		}
	}
	
	public static EvaluatedState getInstance() {
		return INSTANCE;
	}

	@Override
	public String enterDigit(Calculator calculator, char digit) {
		return calculator.getDisplay();
	}

	@Override
	public String enterBinaryOperation(Calculator calculator, BinaryOperation binaryOperation) 
			throws NumberFormatException, ArithmeticException, IllegalArgumentException{
		calculator.setCurrentState(ComputeState.getInstance());
		calculator.executePendingOperation();
		calculator.appendToDisplay(binaryOperation.getOperationType().getOperationTypeSign());
		calculator.setPendingOperation(binaryOperation);
		return calculator.getDisplay();
	}

	@Override
	public String enterUnaryOperation(Calculator calculator, UnaryOperation unaryOperation) 
			throws NumberFormatException, ArithmeticException, IllegalArgumentException{
		calculator.setCurrentState(EvaluatedState.getInstance());
		calculator.executePendingOperation();
		calculator.appendToDisplay(unaryOperation.getOperationType().getOperationTypeSign());
		calculator.setPendingOperation(unaryOperation);
		return calculator.getDisplay();
	}

	@Override
	public String enterEquals(Calculator calculator) 
			throws NumberFormatException, ArithmeticException, IllegalArgumentException{
		calculator.executePendingOperation();
		calculator.setCurrentState(ReadyState.getInstance());
		return calculator.getDisplay();
	}

	@Override
	public String enterPoint(Calculator calculator) {
		// TODO Auto-generated method stub
		return null;
	}
}
