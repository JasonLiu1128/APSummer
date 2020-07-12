package p1;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class textArea extends Application{

	public static void main(String[] args) {
		launch(args);

	}

	@Override
	public void start(Stage stage) throws Exception {
		TextField nameField = new TextField();
		nameField.setPrefSize(300, 300);
		
		HBox hbox1 = new HBox();
		hbox1.getChildren().addAll(nameField);
		hbox1.setAlignment(Pos.CENTER);
		
		VBox vbox1 = new VBox();
		vbox1.getChildren().addAll(hbox1);
		vbox1.setAlignment(Pos.CENTER);
		
		TextArea ta1 = new TextArea();
		ta1.appendText("John Doe\n");
		ta1.appendText("1 Main Street\n");
		ta1.appendText("Stony Brook, NY 11711\n\n");
		
		VBox root = new VBox(10);
		root.setAlignment(Pos.CENTER);
		
		root.getChildren().addAll(hbox1, vbox1);
		Scene scene = new Scene(root, 300, 300);
		stage.setScene(scene);
		stage.show();
	}

}
