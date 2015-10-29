package model.state;

import model.Calculator;
import model.operations.binary.BinaryOperation;
import model.operations.unary.UnaryOperation;

public abstract class CalculatorState {
	
	public abstract String enterDigit(final Calculator calculator, final char digit)throws ArithmeticException;
	public abstract String enterBinaryOperation(final Calculator calculator, final BinaryOperation binaryOperation)throws NumberFormatException, ArithmeticException, IllegalArgumentException;
	public abstract String enterUnaryOperation(final Calculator calculator, final UnaryOperation unaryOperation)throws NumberFormatException, ArithmeticException, IllegalArgumentException;
	public abstract String enterEquals(final Calculator calculator)throws NumberFormatException, ArithmeticException, IllegalArgumentException;
	public abstract String enterPoint(final Calculator calculator)throws NumberFormatException, ArithmeticException, IllegalArgumentException;
}
