package model.state;

import model.Calculator;
import model.operations.binary.BinaryOperation;
import model.operations.unary.UnaryOperation;

public class ComputeState extends CalculatorState{
	
	private static final ComputeState INSTANCE = new ComputeState();
	
	private ComputeState(){
		if(INSTANCE!=null){
			throw new IllegalStateException("Already instantiated !");
		}
	}
	
	public static ComputeState getInstance(){
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
