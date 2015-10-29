package model.state;

import model.Calculator;
import model.operations.binary.BinaryOperation;
import model.operations.unary.UnaryOperation;

public class ReadyState extends CalculatorState {
	
	private static final ReadyState INSTANCE = new ReadyState();
	
	private ReadyState() {
		if(INSTANCE!=null){
			throw new IllegalStateException("Already instantiated !");
		}
	}
	
	public static ReadyState getInstance() {
		return INSTANCE;
	}

	@Override
	public String enterDigit(Calculator calculator, char digit) {
		//calculator.clear();
		return calculator.getDisplay();
	}

	@Override
	public String enterBinaryOperation(final Calculator calculator, final BinaryOperation binaryOperation) {
		calculator.setCurrentState(ComputeState.getInstance());
		calculator.appendToDisplay(binaryOperation.getOperationType().getOperationTypeSign());
		calculator.setPendingOperation(binaryOperation);
		return calculator.getDisplay();
	}

	@Override
	public String enterUnaryOperation(final Calculator calculator, final UnaryOperation unaryOperation) {
		calculator.setCurrentState(EvaluatedState.getInstance());
		calculator.appendToDisplay(unaryOperation.getOperationType().getOperationTypeSign());
		calculator.setPendingOperation(unaryOperation);
		return calculator.getDisplay();
	}

	@Override
	public String enterEquals(final Calculator calculator) {
		return calculator.getDisplay();
	}

	@Override
	public String enterPoint(final Calculator calculator) {
		return calculator.getDisplay();
	}

}
