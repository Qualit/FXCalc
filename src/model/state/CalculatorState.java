package model.state;

import model.Calculator;
import model.operations.BinaryOperation;
import model.operations.UnaryOperation;

public abstract class CalculatorState {
	
	public abstract void enterDigit(final Calculator calculator, final char digit);
	public abstract void enterBinaryOperation(final Calculator calculator, final BinaryOperation binaryOperation);
	public abstract void enterUnaryOperation(final Calculator calculator, final UnaryOperation unaryOperation);
	public abstract void enterEquals(final Calculator calculator);
	public abstract void enterPoint(final Calculator calculator);

}
