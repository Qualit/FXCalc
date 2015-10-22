package model.state;

public class ComputeState {
	
	private static final ComputeState INSTANCE = new ComputeState();
	
	private ComputeState(){
		if(INSTANCE!=null){
			throw new IllegalStateException("Already instantiated !");
		}
	}
	
	public static ComputeState getInstance(){
		return INSTANCE;
	}
	
}
