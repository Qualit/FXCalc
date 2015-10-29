package controller;

import java.util.List;

import enums.OperationType;
import model.Calculator;
import model.operations.NoOperation;
import model.operations.binary.AdditionOperation;
import model.operations.binary.BinaryOperation;
import model.operations.binary.DivisionOperation;
import model.operations.binary.MultiplicationOperation;
import model.operations.binary.SubtractionOperation;
import model.operations.unary.ChangeSignOperation;
import model.operations.unary.PercentageOperation;
import model.operations.unary.SquareRootOperation;
import model.operations.unary.UnaryOperation;
import model.state.CalculatorState;
import model.state.ComputeState;

public class Controller {
	
	private Calculator calculator;
	
	
	public String handleDigitEvent(final String digit) throws NullPointerException{
		if(digit==null){
			throw new NullPointerException();
		}
		char d = digit.charAt(0);
		return calculator.enterDigit(d);
	}
	
	public String handleBinaryOperationEvent(final String operationSymbol)throws 
						NullPointerException,
						ArithmeticException,
						IllegalArgumentException{
		
		if(operationSymbol==null){
			throw new NullPointerException();
		}
		char op = operationSymbol.charAt(0);
		BinaryOperation binaryOperation;
		switch (String.valueOf(operationSymbol)) {
			case "+":{
				binaryOperation = new AdditionOperation();
				return calculator.enterBinaryOperation(binaryOperation);
			}
			case "-":{
				binaryOperation = new SubtractionOperation();
				return calculator.enterBinaryOperation(binaryOperation);
			}
			case "*":{
				binaryOperation = new MultiplicationOperation();
				return calculator.enterBinaryOperation(binaryOperation);
			}
			case "/":{
				binaryOperation = new DivisionOperation();
				return calculator.enterBinaryOperation(binaryOperation);
			}
			default:
				return "ERR";
			}
	}
	
	public String handleClearOperation(){
		return calculator.clear();
	}
	
	public String handleEqualOperator(){
		return calculator.enterEqual();
	}
	
	public String handleUnaryOperation(final String operationSymbol){
		
		if(operationSymbol==null){
			return "ERR";
		}
		
		UnaryOperation unaryOperation;
		switch (operationSymbol) {
			case "sqrt":{
				unaryOperation = new SquareRootOperation();
				return calculator.enterUnaryOperation(unaryOperation);
			}
			case "+/-":{
				unaryOperation = new ChangeSignOperation();
				return calculator.enterUnaryOperation(unaryOperation);
			}
			case "%":{
				unaryOperation = new PercentageOperation();
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
		calculator = new Calculator();
	}
	
	public CalculatorState getCurrentCalcState(){
		return calculator.getCurrentState();
	}
	
	public void setCurrentCalculatorState(CalculatorState calculatorState){
		this.calculator.setCurrentState(calculatorState);
	}
}
