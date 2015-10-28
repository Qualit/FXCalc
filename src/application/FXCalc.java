package application;
	
import javafx.application.Application;

import controller.Controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import model.Calculator;
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
			//controller = new Controller();
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
	
	//Double currentResult;
	
	@FXML
	public void Click(ActionEvent event) {
		String eventText = ((Button)event.getSource()).getText();
		System.out.println("Click:"+eventText);
		
		if(eventText.matches("[0-9]")){
			System.out.println("eventText: "+eventText+"calculator state: "+controller.getCurrentCalcState());
			String output = controller.handleDigitEvent(eventText);
			display.setText(output);
			System.out.println(output);
			return;
		}
		else if(eventText.matches("[\\+\\-\\*\\/]")){
			System.out.println("eventText: "+eventText+"calculator state: "+controller.getCurrentCalcState());
			String output = controller.handleBinaryOperationEvent(eventText);
			display.setText(output);
			System.out.println("OPERATOR:"+output);
			return;
		}
		else if(eventText.equals("=")){
			System.out.println("eventText: "+eventText+"calculator state: "+controller.getCurrentCalcState());
			String output = controller.handleEqualOperator();
			display.setText(output);
			return;
		}
		else if(eventText.equals("C")){
			System.out.println("eventText: "+eventText+"calculator state: "+controller.getCurrentCalcState());
			String output = controller.handleClearOperation();
			display.setText(output);
			return;
		}
		else if(eventText.matches("[\\sqrt\\+/-]")){
			System.out.println("eventText: "+eventText+"calculator state: "+controller.getCurrentCalcState());
			String output = controller.handleUnaryOperation();
			display.setText(output);
			return;
		}
		else if (eventText.equals(Calculator.DECIMAL_SEPARATOR)){
			System.out.println("eventText: "+eventText+"calculator state: "+controller.getCurrentCalcState());
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
}

