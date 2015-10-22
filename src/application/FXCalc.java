package application;
	
import javafx.application.Application;
import controller.Controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;


public class FXCalc extends Application {
	
	private Controller controller;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("fxcalc.fxml"));
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("fxscene.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("FXCalc");
			primaryStage.setMinWidth(150);
			primaryStage.setMinHeight(100);
			primaryStage.setMaxWidth(600);
			primaryStage.setMaxHeight(400);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	Double currentResult;
	
	@FXML
	public void Click(ActionEvent event) {
		String eventText = ((Button)event.getSource()).getText();
		System.out.println(eventText);
		display.appendText(eventText);
		if(eventText.equals("=")){
			display.getScene().getRoot().getStyleClass().add("error");
		}
		
	}
	@FXML
	private TextField display;
	
	private Double addTwoNumbers(final Double firstNumber, final Double secondNumber) throws RuntimeException{
		Double result = firstNumber +secondNumber;
		if(result.isNaN()){
			throw new RuntimeException("Overflow during addition");
		}
		else{
			return result;
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}

