package model.operations;

import enums.OperationType;

public class NoOperation extends Operation{
	
	public NoOperation() {
		operationType = OperationType.NO_OP;
	}
}
