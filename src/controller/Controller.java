package controller;

import java.util.List;

import enums.OperationType;
import model.Calculator;
import model.Model;
import model.operations.AdditionOperation;
import model.operations.BinaryOperation;
import model.operations.ChangeSignOperation;
import model.operations.DivisionOperation;
import model.operations.MultiplicationOperation;
import model.operations.NoOperation;
import model.operations.SquareRootOperation;
import model.operations.SubtractionOperation;
import model.operations.UnaryOperation;
import model.state.ComputeState;

public class Controller {
	
	private Model model;
	private Calculator calculator;
	
	
	public String handleDigitEvent(final String digit){
		char d = digit.charAt(0);
		System.out.println("handle Digit Event!");
		return calculator.enterDigit(d);
	}
	
	public String handleBinaryOperationEvent(final String operationSymbol){
		if(operationSymbol==null){
			return "ERR in handleBInaryOP";
		}
		char op = operationSymbol.charAt(0);
		BinaryOperation binaryOperation;
		System.out.println("handleOperationEvent, operation: "+op);
		switch (String.valueOf(operationSymbol)) {
			case "+":{
			
				binaryOperation = new AdditionOperation();
				System.out.println("CASE ADD");
				return calculator.enterBinaryOperation(binaryOperation);
			}
			case "-":{
				binaryOperation = new SubtractionOperation();
				System.out.println("CASE SUB");
				return calculator.enterBinaryOperation(binaryOperation);
			}
			case "*":{
				binaryOperation = new MultiplicationOperation();
				System.out.println("CASE MUL");
				return calculator.enterBinaryOperation(binaryOperation);
			}
			case "/":{
				binaryOperation = new DivisionOperation();
				System.out.println("CASE DIV");
				return calculator.enterBinaryOperation(binaryOperation);
			}
			default:
				return "ERR";
			}
		
		//return calculator.enterBinaryOperation(binaryOperation);
	}
	
	public String handleClearOperation(){
		return calculator.clear();
	}
	
	public String handleEqualOperator(){
		return calculator.enterEqual();
	}
	
	public String handleUnaryOperation(final String operationSymbol){
		
		if(operationSymbol==null){
			return "ERR in handleBInaryOP";
		}
		
		UnaryOperation unaryOperation;
		switch (operationSymbol) {
			case "sqrt":{
				unaryOperation = new SquareRootOperation();
				System.out.println("SQ_ROOT");
				return calculator.enterUnaryOperation(unaryOperation);
			}
			case "+/-":{
				unaryOperation = new ChangeSignOperation();
				System.out.println("CASE SUB");
				return calculator.enterUnaryOperation(unaryOperation);
			}
			default:
				return "ERR";
			}
	}

	public String handlePointOperation() {
		return calculator.enterPoint();
	}
	
	
	public Controller() {
		System.out.println("Controller ctor");
		calculator = new Calculator();
	}
	
	public String getCurrentCalcState(){
		return calculator.getCurrentState().toString();
	}

	

}
