package model.state;

import model.Calculator;
import model.operations.BinaryOperation;
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
	public void enterDigit(final Calculator calculator, char digit) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void enterBinaryOperation(final Calculator calculator, final BinaryOperation binaryOperation) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void enterUnaryOperation(final Calculator calculator, final UnaryOperation unaryOperation) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void enterEquals(final Calculator calculator) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void enterPoint(final Calculator calculator) {
		// TODO Auto-generated method stub
		
	}
	
	

}
