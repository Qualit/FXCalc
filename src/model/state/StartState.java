package model.state;

import model.Calculator;
import model.operations.binary.BinaryOperation;
import model.operations.unary.UnaryOperation;

public class StartState extends CalculatorState{

	private static final StartState INSTANCE = new StartState();
	
	private StartState(){
		if(INSTANCE!=null){
			throw new IllegalStateException("Already instantiated !");
		}
	}
	
	public static StartState getInstance(){
		return INSTANCE;
	}

	@Override
	public String enterDigit(final Calculator calculator, char digit) {
		calculator.setCurrentState(AccumulateState.getInstance());
		calculator.clearDisplay();
		calculator.appendToDisplay(String.valueOf(digit));
		calculator.appendToAccumulateStr(String.valueOf(digit));
		return calculator.getDisplay();
	}

	@Override
	public String enterBinaryOperation(final Calculator calculator, final BinaryOperation binaryOperation) {
		calculator.setCurrentState(ComputeState.getInstance());
		calculator.executePendingOperation();
		calculator.appendToDisplay(binaryOperation.getOperationType().getOperationTypeSign());
		calculator.setPendingOperation(binaryOperation);
		return calculator.getDisplay();
	}

	@Override
	public String enterUnaryOperation(final Calculator calculator, final UnaryOperation unaryOperation) {
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
