package LibraryProject;

import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

public abstract class NewPane extends Node{
	private HBox hbox1;
	TextField titleField = new TextField();
	TextField isbnField = new TextField();
	TextField authorField = new TextField();
	TextField priceField = new TextField();
	public NewPane() {
		BookBag bookBag = new BookBag(1000000);
		titleField.setPrefSize(150, 20);
		titleField.setPromptText("New Title");
		isbnField.setPrefSize(150, 20);
		isbnField.setPromptText("New ISBN");
		authorField.setPrefSize(150, 20);
		authorField.setPromptText("New Author");
		priceField.setPrefSize(150, 20);
		priceField.setPromptText("New Price");
		hbox1 = new HBox(5);
		hbox1.getChildren().addAll(titleField);
		Button okBtn = new Button("OK");
		okBtn.setPrefSize(100,10);
		okBtn.setOnAction(e -> {
			String title = titleField.getText();
			String isbn = isbnField.getText();
			String author = authorField.getText();
			String price = priceField.getText();
			Books newBook = new Books(title, isbn, author, price);
			bookBag.insert(newBook);
			BookBag.display();
		});
	}
	public void clearAll() {
		titleField.clear();
		isbnField.clear();
		authorField.clear();
		priceField.clear();
	}
	public void getPane() {
		
	}
}
