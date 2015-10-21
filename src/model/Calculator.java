package model;

import model.operations.BinaryOperation;
import model.operations.UnaryOperation;
import model.state.CalculatorState;

public class Calculator {
	
	private double accumulate;
	private String display;
	private BinaryOperation binaryOperation;
	private UnaryOperation unaryOperation;
	private CalculatorState currentState;

}
