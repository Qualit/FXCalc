package model.state;

import model.Calculator;
import model.operations.binary.BinaryOperation;
import model.operations.unary.UnaryOperation;

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
		calculator.setCurrentState(AccumulateState.getInstance());
		calculator.appendToDisplay(String.valueOf(digit));
		calculator.appendToAccumulateStr(String.valueOf(digit));
		return calculator.getDisplay();
	}

	@Override
	public String enterBinaryOperation(final Calculator calculator, final BinaryOperation binaryOperation) 
			throws NumberFormatException, ArithmeticException, IllegalArgumentException{
		calculator.setCurrentState(ComputeState.getInstance());
		calculator.executePendingOperation();
		calculator.appendToDisplay(binaryOperation.getOperationType().getOperationTypeSign());
		calculator.setPendingOperation(binaryOperation);
		return calculator.getDisplay();
		
	}

	@Override
	public String enterUnaryOperation(final Calculator calculator, final UnaryOperation unaryOperation) 
			throws NumberFormatException, ArithmeticException, IllegalArgumentException{
		calculator.setCurrentState(EvaluatedState.getInstance());
		calculator.executePendingOperation();
		calculator.appendToDisplay(unaryOperation.getOperationType().getOperationTypeSign());
		calculator.setPendingOperation(unaryOperation);
		return calculator.getDisplay();
	}

	@Override
	public String enterEquals(final Calculator calculator) 
			throws NumberFormatException, ArithmeticException, IllegalArgumentException{
		calculator.executePendingOperation();
		calculator.setCurrentState(ReadyState.getInstance());
		return calculator.getDisplay();
	}

	@Override
	public String enterPoint(final Calculator calculator) {
		calculator.setCurrentState(PointState.getInstance());
		calculator.appendToDisplay(Calculator.DECIMAL_SEPARATOR);
		calculator.appendToAccumulateStr(Calculator.DECIMAL_SEPARATOR);
		return calculator.getDisplay();
		
	}
	
	

}
