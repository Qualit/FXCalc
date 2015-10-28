package model.operations;

public abstract class UnaryOperation extends Operation {
	
	
	protected boolean isEvaluated;
	//abstract double evaluate();
	
	
	public boolean isEvaluated() {
		return isEvaluated;
	}

	public void setEvaluated(boolean isEvaluated) {
		this.isEvaluated = isEvaluated;
	}
	
	
	
	

}
