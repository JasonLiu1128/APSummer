package LibraryProject;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class DemoSwapPanes extends Application{

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		BookBag bookBag = new BookBag(1000000);
		VBox root = new VBox(10);
		HBox btnBox = new HBox(30);
		
		Button insertBtn = new Button("INSERT");
		insertBtn.setOnAction(e -> {
			NewPane newPane = new NewPane(bookBag);
			Pane gridPane = newPane.getPane();
			gridPane.setPadding(new Insets(30, 10, 0, 100));
			root.getChildren().clear();
			root.getChildren().addAll(btnBox, gridPane);
		});

		
	}

}
