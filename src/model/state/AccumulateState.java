package model.state;

import model.Calculator;
import model.operations.BinaryOperation;
import model.operations.PointOperation;
import model.operations.UnaryOperation;

public class AccumulateState extends CalculatorState{
	
	private static final AccumulateState INSTANCE = new AccumulateState();
	
	private AccumulateState(){
		if(INSTANCE!=null){
			throw new IllegalStateException("Already instantiated !");
		}
	}
	
	public static AccumulateState getInstance(){
		return INSTANCE;
	}

	@Override
	public String enterDigit(final Calculator calculator, char digit) {
		System.out.println("current state: "+this.getClass()+"digit:"+digit);
		calculator.setCurrentState(AccumulateState.getInstance());
		calculator.appendToDisplay(String.valueOf(digit));
		calculator.appendToAccumulateStr(String.valueOf(digit));
		return calculator.getDisplay();
		
	}

	@Override
	public String enterBinaryOperation(final Calculator calculator, final BinaryOperation binaryOperation) {
	
		calculator.setCurrentState(ComputeState.getInstance());
		calculator.executePendingOperation();
		calculator.appendToDisplay(binaryOperation.getOperationType().getOperationTypeSign());
		//String tmp = calculator.getDisplay();
		//calculator.clearDisplay();
		calculator.setPendingOperation(binaryOperation);
		return calculator.getDisplay();
		
	}

	@Override
	public String enterUnaryOperation(final Calculator calculator, final UnaryOperation unaryOperation) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String enterEquals(final Calculator calculator) {
		calculator.executePendingOperation();
		calculator.setCurrentState(ReadyState.getInstance());
		return calculator.getDisplay();
	}

	@Override
	public String enterPoint(final Calculator calculator) {
		calculator.setCurrentState(PointState.getInstance());
		calculator.setPendingOperation(new PointOperation());
		calculator.appendToDisplay(Calculator.DECIMAL_SEPARATOR);
		calculator.appendToAccumulateStr(Calculator.DECIMAL_SEPARATOR);
		return calculator.getDisplay();
		
	}
	
	

}
