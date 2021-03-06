package model;

import enums.OperationType;
import model.operations.NoOperation;
import model.operations.Operation;
import model.operations.binary.AdditionOperation;
import model.operations.binary.BinaryOperation;
import model.operations.binary.DivisionOperation;
import model.operations.binary.MultiplicationOperation;
import model.operations.binary.SubtractionOperation;
import model.operations.unary.ChangeSignOperation;
import model.operations.unary.PercentageOperation;
import model.operations.unary.SquareRootOperation;
import model.operations.unary.UnaryOperation;
import model.state.AccumulateState;
import model.state.CalculatorState;
import model.state.ComputeState;
import model.state.ErrorState;
import model.state.StartState;

public class Calculator {
	
	public static final String DECIMAL_SEPARATOR = ".";
	
	private double accumulate;
	private String accumulateStr;
	private double result;
	private String display;
	private Operation pendingOperation;
	private UnaryOperation unaryOperation;
	private CalculatorState currentState;
	
	
	public Calculator() {
		display = new String("0");
		accumulateStr = new String("0");
		result=0.0;
		accumulate=0.0;
		currentState = StartState.getInstance();
		pendingOperation = new NoOperation();
	}
	
	public String enterDigit(final char c){
		return currentState.enterDigit(this, c);
	}
	
	public String enterPoint(){
		return currentState.enterPoint(this);
	}
	
	public String enterBinaryOperation(final BinaryOperation binaryOperation){
		return currentState.enterBinaryOperation(this, binaryOperation);
	}
	
	public String enterUnaryOperation(final UnaryOperation unaryOperation){
		return currentState.enterUnaryOperation(this, unaryOperation);
	}
	
	public String enterEqual(){
		return currentState.enterEquals(this);
	}
	
	public String clear(){
		display = "0";
		result=0.0;
		accumulate=0.0;
		accumulateStr="0";
		pendingOperation = new NoOperation();
		currentState = StartState.getInstance();
		return display;
	}
	
	public void appendToDisplay(final String text){
		display = display + text;
	}
	
	public void appendToAccumulateStr(final String digit){
		accumulateStr = accumulateStr + digit;
	}
	
	public void updateAccumulate()throws NumberFormatException, NullPointerException{
			accumulate = Double.parseDouble(accumulateStr);
	}
	
	private void clearAccumulateStr(){
		accumulateStr = "0";
	}
	public void clearDisplay(){
		display = "";
	}
	
	public void executePendingOperation()throws ArithmeticException, IllegalArgumentException{
		updateAccumulate();
		clearAccumulateStr();
		switch (pendingOperation.getOperationType()) {
		case ADD:{
			result = ((AdditionOperation)pendingOperation).compute(result, accumulate);
			display = String.valueOf(result);
			pendingOperation = new NoOperation();
			break;	
		}
		case SUBTRACT:{
			result = ((SubtractionOperation)pendingOperation).compute(result, accumulate);
			display = String.valueOf(result);
			pendingOperation = new NoOperation();
			break;
		}
		case MULTIPLY:{
			result = ((MultiplicationOperation)pendingOperation).compute(result, accumulate);
			display = String.valueOf(result);
			pendingOperation = new NoOperation();
			break;
		}
		case DIVIDE:{
			result = ((DivisionOperation)pendingOperation).compute(result, accumulate);
			display = String.valueOf(result);
			pendingOperation = new NoOperation();
			break;
		}
		case POINT:{
			result = accumulate;
			display = String.valueOf(result);
			pendingOperation = new NoOperation();
			break;
		}
		case SQUARE_ROOT:{
			result = ((SquareRootOperation)pendingOperation).evaluate((result));
			display = String.valueOf(result);
			pendingOperation = new NoOperation();
			break;
		}
		case CHANGE_SIGN:{
			result = ((ChangeSignOperation)pendingOperation).evaluate((result));
			display = String.valueOf(result);
			pendingOperation = new NoOperation();
			break;
		}
		case PERCENTAGE:{
			result = ((PercentageOperation)pendingOperation).evaluate((result));
			display = String.valueOf(result);
			pendingOperation = new NoOperation();
			break;
		}
		case NO_OP:{
			result = accumulate;
			display = String.valueOf(result);
			break;
		}

		default:{
			pendingOperation = new NoOperation();
			return;
		}
			
		}
		return;
		
	}

	
	// getters and setters
	
	public double getAccumulate() {
		return accumulate;
	}

	public void setAccumulate(double accumulate) {
		this.accumulate = accumulate;
	}

	public String getDisplay() {
		return display;
	}

	public void setDisplay(String display) {
		this.display = display;
	}

	public Operation getPendingOperation() {
		return pendingOperation;
	}

	public void setPendingOperation(Operation pendingOperation) {
		this.pendingOperation = pendingOperation;
	}

	public UnaryOperation getUnaryOperation() {
		return unaryOperation;
	}

	public void setUnaryOperation(UnaryOperation unaryOperation) {
		this.unaryOperation = unaryOperation;
	}

	public CalculatorState getCurrentState() {
		return currentState;
	}

	public void setCurrentState(CalculatorState currentState) {
		this.currentState = currentState;
	}
}
