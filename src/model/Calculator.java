package model;

import model.operations.BinaryOperation;
import model.operations.UnaryOperation;
import model.state.CalculatorState;

public class Calculator {
	
	public static final char DECIMAL_SEPARATOR = '.';
	
	private double accumulate;
	private String display;
	private StringBuilder sb;
	private BinaryOperation pendingOperation;
	private UnaryOperation unaryOperation;
	private CalculatorState currentState;
	
	
	public Calculator() {
		// TODO Auto-generated constructor stub
		this.sb = new StringBuilder();
	}
	
	public String enterDigit(final char c){
		
		// TO DO: check current state, determine next state and check logic conditions
		
		sb.append(String.valueOf(c));
		display = new String(sb.toString());
		return display;
	}
	
	public String enterPoint(){
		
		// TO DO: check current state, determine next state and check logic conditions
		
		sb.append(String.valueOf(DECIMAL_SEPARATOR));
		display = new String(sb.toString());
		return display;
		
	}
	
	public String enterOperation(BinaryOperation binaryOperation){
		// TO DO: check current state, determine next state and check logic conditions
		return "binary op";
	}
	
	public String enterEqual(){
		// TO DO: check current state, determine next state and check logic conditions
		return "=";
	}
	
	public String clear(){
		// TO DO: check current state, determine next state and check logic conditions
		sb = new StringBuilder();
		display = "";
		return display;
	}

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

	public BinaryOperation getPendingOperation() {
		return pendingOperation;
	}

	public void setPendingOperation(BinaryOperation pendingOperation) {
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
