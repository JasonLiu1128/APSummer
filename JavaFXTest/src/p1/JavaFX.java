package p1;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class JavaFX extends Application {
	private static UserBags userBag = new UserBags(200);

	public static void main(String[] args) {
		launch(args);

	}

	@Override
	public void start(Stage stage) throws Exception {
		UserManager.fillTheBag(userBag, 100);
		User user1 = new User("Jason", "liu");
		User user2 = new User("Terry", "zhang");

		userBag.insert(user1);
		userBag.insert(user2);

		Text text1 = new Text("Enter Username and Password to login");

		HBox hbox0 = new HBox();
		hbox0.setAlignment(Pos.CENTER);
		hbox0.getChildren().add(text1);

		TextField nameField = new TextField();
		nameField.setPrefSize(80, 20);
		nameField.setPromptText("Username");

		PasswordField passwdField = new PasswordField();
		passwdField.setPrefSize(80, 20);
		passwdField.setPromptText("Password");

		HBox hbox1 = new HBox(20);
		hbox1.setAlignment(Pos.CENTER);

		hbox1.getChildren().addAll(nameField, passwdField);

		Button loginBtn = new Button("Login");
		loginBtn.setPrefSize(70, 30);

		Button newAccountBtn = new Button("New");
		newAccountBtn.setPrefSize(70, 30);

		Button bckupBtn = new Button("Backup");
		bckupBtn.setPrefSize(70, 30);

		Button rtrveBtn = new Button("Retrieve");
		bckupBtn.setPrefSize(70, 30);

		HBox hbox2 = new HBox(20);
		hbox2.setAlignment(Pos.CENTER);

		hbox2.getChildren().addAll(loginBtn, newAccountBtn, bckupBtn, rtrveBtn);

		loginBtn.setOnAction(e -> {
			String userName = nameField.getText();
			String password = passwdField.getText();
			User user = userBag.find(userName, password);
			if (user == null) {
				text1.setText("Incorrect username or password!");
				nameField.clear();
				passwdField.clear();
				userBag.display();
			} else {
				text1.setText(userName + " logged in successfully!");
				nameField.clear();
				passwdField.clear();
			}
		});

		newAccountBtn.setOnAction(e -> {
			String username = nameField.getText();
			String password = passwdField.getText();
			User existingUser = userBag.find(username);
			if (existingUser == null) {
				User user = new User(username, password);
				userBag.insert(user);
				nameField.clear();
				passwdField.clear();
				text1.setText("New User Account created successfully!");
			} else {
				text1.setText("The user name is already in use! Enter another: ");
				nameField.clear();
			}
		});

		bckupBtn.setOnAction(e -> {
			try {
				userBag.storeUsers();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});

		rtrveBtn.setOnAction(e -> {

		});

		VBox root = new VBox(20);
		root.setAlignment(Pos.CENTER);

		root.getChildren().addAll(hbox0, hbox1, hbox2);

		Scene scene = new Scene(root, 500, 300);
		stage.setScene(scene);
		stage.setTitle("My GUI");
		stage.show();
	}
}
