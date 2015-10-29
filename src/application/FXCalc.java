package application;
	
import javafx.application.Application;

import controller.Controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import model.Calculator;
import model.state.ErrorState;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;


public class FXCalc extends Application {
	
	private Controller controller = new Controller();
	
	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("fxcalc.fxml"));
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("fxscene.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("FXCalc");
			primaryStage.setMinWidth(350);
			primaryStage.setMinHeight(250);
			primaryStage.setMaxWidth(1000);
			primaryStage.setMaxHeight(600);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@FXML
	public void Click(ActionEvent event) {
		String eventText = ((Button)event.getSource()).getText();
		
		if(eventText.matches("[0-9]")){
			try{
				String output = controller.handleDigitEvent(eventText);
				display.setText(output);
				
			}catch(NullPointerException npe){
				enableErrorMode();
			}
			return;
		}
		else if(eventText.matches("[\\+\\-\\*\\/]")){
			try{
				String output = controller.handleBinaryOperationEvent(eventText);
				display.setText(output);
			}catch( ArithmeticException| IllegalArgumentException ex){
				enableErrorMode();
			}
			
			return;
		}
		else if(eventText.equals("=")){
			try{
				String output = controller.handleEqualOperator();
				display.setText(output);
			}catch( ArithmeticException| IllegalArgumentException ex){
				enableErrorMode();
			}
			
			return;
		}
		else if(eventText.equals("C")){
			if(controller.getCurrentCalcState().equals(ErrorState.getInstance())){
				disableErrorMode();
				System.out.println("error mode disabled");
			}
			String output = controller.handleClearOperation();
			display.setText(output);
			
			return;
		}
		else if(eventText.equals("sqrt") || eventText.equals("+/-") || eventText.equals("%")){
			try{
				String output = controller.handleUnaryOperation(eventText);
				display.setText(output);
			}catch( ArithmeticException| IllegalArgumentException ex){
				enableErrorMode();
			}
			return;
		}
		else if (eventText.equals(Calculator.DECIMAL_SEPARATOR)){
			String output = controller.handlePointOperation();
			display.setText(output);
			return;
		}
		return;
		
	}
	@FXML
	private TextField display;
	
	public static void main(String[] args) {
		//controller = new Controller();
		launch(args);

	}
	
	private void enableErrorMode(){
		controller.setCurrentCalculatorState(ErrorState.getInstance());
		display.getScene().getRoot().getStyleClass().add("error");
		
	}
	private void disableErrorMode(){
		display.getScene().getRoot().getStyleClass().removeAll("error");
	}
}

