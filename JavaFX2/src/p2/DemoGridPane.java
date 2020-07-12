package p2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Random;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class DemoGridPane extends Application{
	private final int NUM_OF_ROW = 10;
	private final int NUM_OF_COL = 10;
	private Button[][] buttons = new Button[NUM_OF_ROW][NUM_OF_COL];
	private int[] location = new int[2];
	public static void main(String[] args) {
		launch(args);

	}

	@Override
	public void start(Stage stage) throws Exception {
		
		
		
		
		for(int i = 0; i < NUM_OF_ROW; i++) {
			for(int j = 0; j < NUM_OF_COL; j++) {
				buttons[i][j] = new Button();
				buttons[i][j].setPrefSize(50, 50);
				buttons[i][j].setMaxSize(51, 51);
				buttons[i][j].setMinSize(50, 50);
			}
		}
		
		GridPane root = new GridPane();
		for(int i = 0; i < NUM_OF_ROW; i++) {
			for(int j = 0; j < NUM_OF_COL; j++) {
				root.add(buttons[i][j], i, j);
			}
		}
		for(int i = 0; i < 10; i++) {
		Random random = new Random();
		int o = random.nextInt(10);
		int j = random.nextInt(10);
		buttons[o][j].setOnAction(e -> {
			FileInputStream input = null;
				try {
					input = new FileInputStream("C:\\Users\\jason\\eclipse-2019-12-workspace\\bomb.png");
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			Image image = new Image(input);
			ImageView imageView = new ImageView(image);
			buttons[o][j].setGraphic(imageView);
			
		});
		}
		root.setPadding(new Insets(40));
		Scene scene = new Scene(root, 600, 600);
		stage.setScene(scene);
		stage.show();
	}
	
	public void show(int c, int r, String what) {
		FileInputStream input = null;
		try {
			input = new FileInputStream("C:\\Users\\jason\\eclipse-2019-12-workspace\\" + what + ".png");
		}catch(FileNotFoundException e1) {
			e1.printStackTrace();
		}
		Image image = new Image(input);
		ImageView imageView = new ImageView(image);
		
		buttons[c][r].setGraphic(imageView);
		location[0] = c;
		location[1] = r;
	}

}
