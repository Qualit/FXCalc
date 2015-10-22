package model.state;

public class AccumulateState {
	
	private static final AccumulateState INSTANCE = new AccumulateState();
	
	private AccumulateState(){
		if(INSTANCE!=null){
			throw new IllegalStateException("Already instantiated !");
		}
	}
	
	public static AccumulateState getInstance(){
		return INSTANCE;
	}

}
