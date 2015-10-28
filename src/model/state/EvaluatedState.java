package model.state;

import model.Calculator;
import model.operations.BinaryOperation;
import model.operations.UnaryOperation;

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
	public String enterBinaryOperation(Calculator calculator, BinaryOperation binaryOperation) {
		calculator.setCurrentState(ComputeState.getInstance());
		calculator.executePendingOperation();
		calculator.appendToDisplay(binaryOperation.getOperationType().getOperationTypeSign());
		calculator.setPendingOperation(binaryOperation);
		return calculator.getDisplay();
	}

	@Override
	public String enterUnaryOperation(Calculator calculator, UnaryOperation unaryOperation) {
		return null;
	}

	@Override
	public String enterEquals(Calculator calculator) {
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