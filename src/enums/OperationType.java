package enums;

import model.Calculator;

public enum OperationType {
	
	ADD("+"),
	SUBTRACT("-"),
	MULTIPLY("*"),
	DIVIDE("/"),
	EQUAL("="),
	CLEAR("C"),
	SQUARE_ROOT("sqrt"),
	CHANGE_SIGN("=/-"),
	POINT(Calculator.DECIMAL_SEPARATOR),
	NO_OP("no_op");
	private String operationTypeSign;

	private OperationType(String operationTypeSign) {
		this.operationTypeSign = operationTypeSign;
	}

	public String getOperationTypeSign() {
		return operationTypeSign;
	}
	

}
