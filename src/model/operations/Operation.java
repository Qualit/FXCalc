package model.operations;

import enums.OperationType;

public abstract class Operation {
	protected OperationType operationType;
	
	public OperationType getOperationType() {
		return operationType;
	}

}
