package model;

import enums.OperationType;
import model.operations.AdditionOperation;
import model.operations.BinaryOperation;
import model.operations.DivisionOperation;
import model.operations.MultiplicationOperation;
import model.operations.NoOperation;
import model.operations.Operation;
import model.operations.SubtractionOperation;
import model.operations.UnaryOperation;
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
		System.out.println("append to display, display: "+display);
	}
	
	public void appendToAccumulateStr(final String digit){
		accumulateStr = accumulateStr + digit;
		System.out.println("append to accumulate Str, accum str: "+accumulateStr);
	}
	
	public void updateAccumulate(){
		try{
			accumulate = Double.parseDouble(accumulateStr);
		}
		catch(NumberFormatException  | NullPointerException ex ){
			System.out.println("update accumulate failed, accumStr: "+accumulateStr);
			setCurrentState(ErrorState.getInstance());
		}
	}
	
	private void clearAccumulateStr(){
		accumulateStr = "0";
	}
	public void clearDisplay(){
		display = "";
	}
	
	
	
	public void executePendingOperation(){
		
		updateAccumulate();
		clearAccumulateStr();
		switch (pendingOperation.getOperationType()) {
		case ADD:{
			System.out.println("execute pending op, ADD result: "+result+" accumulate: "+accumulate);
			result = ((AdditionOperation)pendingOperation).compute(result, accumulate);
			display = String.valueOf(result);
			System.out.println("after ADD, result: "+result+"display: "+display);
			pendingOperation = new NoOperation();
			break;
			
		}
		case SUBTRACT:{
			System.out.println("execute pending op,SUBTRACT result: "+result+" accumulate: "+accumulate);
			result = ((SubtractionOperation)pendingOperation).compute(result, accumulate);
			display = String.valueOf(result);
			System.out.println("after SUB, result: "+result+"display: "+display);
			pendingOperation = new NoOperation();
			break;
		}
		case MULTIPLY:{
			System.out.println("execute pending op,MULTIPLY result: "+result+" accumulate: "+accumulate);
			result = ((MultiplicationOperation)pendingOperation).compute(result, accumulate);
			display = String.valueOf(result);
			pendingOperation = new NoOperation();
			break;
		}
		case DIVIDE:{
			System.out.println("execute pending op DIVIDE, result: "+result+" accumulate: "+accumulate);
			try{
				result = ((DivisionOperation)pendingOperation).compute(result, accumulate);
				display = String.valueOf(result);
			}catch(ArithmeticException | IllegalArgumentException ex){
				System.out.println("Arith exception");
				clear();
			}
			
			pendingOperation = new NoOperation();
			break;
		}
		case POINT:{
			result = accumulate;
			//if(accumulate)
			display = String.valueOf(result);
			System.out.println("NO_OP result: "+result+"accumulate: "+accumulate+" display: "+display);
			pendingOperation = new NoOperation();
			break;
		}

		case NO_OP:{
			result = accumulate;
			//if(accumulate)
			display = String.valueOf(result);
			System.out.println("NO_OP result: "+result+"accumulate: "+accumulate+" display: "+display);
			break;
		}

		default:
			//display = String.valueOf(result);
			pendingOperation = new NoOperation();
			return;
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
