package model.state;

import model.Calculator;
import model.operations.binary.BinaryOperation;
import model.operations.unary.UnaryOperation;

public abstract class CalculatorState {
	
	public abstract String enterDigit(final Calculator calculator, final char digit);
	public abstract String enterBinaryOperation(final Calculator calculator, final BinaryOperation binaryOperation);
	public abstract String enterUnaryOperation(final Calculator calculator, final UnaryOperation unaryOperation);
	public abstract String enterEquals(final Calculator calculator);
	public abstract String enterPoint(final Calculator calculator);
}
