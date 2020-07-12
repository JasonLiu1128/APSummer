package application;
	

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			Text t = new Text();
			Pane p = new Pane();
			Scene scene = new Scene(p,1000,400);
			Button b = new Button();
			PasswordField passwordfield = new PasswordField();
			passwordfield.setPrefSize(80, 50);
			passwordfield.setPromptText("Password");
			b.setOnAction(e -> {
				t.setText("You are a poop");
			});
			b.setLayoutX(0);
			b.setLayoutY(0);
			b.setText("poop");
			b.setAlignment(Pos.CENTER);
			t.setX(100);
			t.setY(100);
			HBox hbox1 = new HBox(20);
			hbox1.setAlignment(Pos.CENTER);
			
			TextField nameField = new TextField();
			nameField.setPrefSize(200, 200);
			hbox1.getChildren().add(nameField);
			
			VBox root = new VBox(50);
			root.getChildren().add(hbox1);
			root.setAlignment(Pos.CENTER);
			
			DropShadow shadow = new DropShadow();
			b.addEventHandler(MouseEvent.MOUSE_ENTERED, 
			    new EventHandler<MouseEvent>() {
			        @Override public void handle(MouseEvent e) {
			            b.setEffect(shadow);
			        }
			});
			b.setStyle("-fx-font: 25 arial; -fx-base: #b6e7c9;");
			b.addEventHandler(MouseEvent.MOUSE_EXITED, 
			    new EventHandler<MouseEvent>() {
			        @Override public void handle(MouseEvent e) {
			            b.setEffect(null);
			        }
			});
			p.getChildren().add(b);
			p.getChildren().add(t);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setTitle("POOP");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
		//There are 2 threads:
			//GUI:Graphic user Interface/Interactions
			//User Programs
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
