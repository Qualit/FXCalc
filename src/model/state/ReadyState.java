package model.state;

import model.Calculator;
import model.operations.BinaryOperation;
import model.operations.UnaryOperation;

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
		// TODO Auto-generated method stub
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String enterEquals(final Calculator calculator) {
		// TODO Auto-generated method stub
		return calculator.getDisplay();
	}

	@Override
	public String enterPoint(final Calculator calculator) {
		// TODO Auto-generated method stub
		return null;
	}

}
