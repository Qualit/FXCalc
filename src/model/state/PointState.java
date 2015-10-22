package model.state;

public class PointState {
	
	private static final PointState INSTANCE = new PointState();
	
	private PointState(){
		if(INSTANCE!=null){
			throw new IllegalStateException("Already instantiated !");
		}
	}
	
	public static PointState getInstance(){
		return INSTANCE;
	}
}
