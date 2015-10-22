package model.state;

public class StartState {

	private static final StartState INSTANCE = new StartState();
	
	private StartState(){
		if(INSTANCE!=null){
			throw new IllegalStateException("Already instantiated !");
		}
	}
	
	public static StartState getInstance(){
		return INSTANCE;
	}
}
