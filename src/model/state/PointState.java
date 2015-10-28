package model.state;

import model.Calculator;
import model.operations.BinaryOperation;
import model.operations.UnaryOperation;

public class PointState extends CalculatorState{
	
	private static final PointState INSTANCE = new PointState();
	
	private PointState(){
		if(INSTANCE!=null){
			throw new IllegalStateException("Already instantiated !");
		}
	}
	
	public static PointState getInstance(){
		return INSTANCE;
	}

	@Override
	public String enterDigit(final Calculator calculator, char digit) {
		calculator.setCurrentState(PointState.getInstance());
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
		calculator.setCurrentState(EvaluatedState.getInstance());
		calculator.executePendingOperation();
		calculator.appendToDisplay(unaryOperation.getOperationType().getOperationTypeSign());
		calculator.setPendingOperation(unaryOperation);
		return calculator.getDisplay();
		
	}

	@Override
	public String enterEquals(final Calculator calculator) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String enterPoint(final Calculator calculator) {
		// TODO Auto-generated method stub
		
	}
	
	
}
