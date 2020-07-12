package LibraryProject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import p1.User;

public class Demo1 extends Application{

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		try {
			Scanner scan = new Scanner(System.in);
			String[] fullBookArr = 	BooksManager.makeFullBookName("textbook_titles.txt", "textbook_isbns.txt", "First_Names.txt", "Last_Names.txt");
			String[] fullDVDArr = BooksManager.makeFullDVD("DVDTitles.txt", "Genres.txt");
			String[] fullMagazineArr = BooksManager.makeFullMagazine("Magazines.txt");
			FileOutputStream fos = new FileOutputStream("books.dat");
			ObjectOutputStream oos = new ObjectOutputStream(fos);	
			for (int i = 0; i < fullBookArr.length; i++) {
				oos.writeObject(fullBookArr[i] + "\n");
			}
			for (int i = 0; i < fullDVDArr.length; i++) {
				oos.writeObject(fullDVDArr[i] + "\n");
			}
			for (int i = 0; i < fullMagazineArr.length; i++) {
				oos.writeObject(fullMagazineArr[i] + "\n");
			}
			oos.close();
			BookBag bookBag = new BookBag(fullBookArr.length + 100);
			BooksManager.fillBookBag(bookBag, "First_Names.txt", "Last_Names.txt", "textbook_titles.txt", "textbook_isbns.txt", "DVDTitles.txt", "Genres.txt", "Magazines.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		FileOutputStream fos = new FileOutputStream("books.dat");
		ObjectOutputStream oos = new ObjectOutputStream(fos);	
		TextArea t1 = new TextArea("Welcome.");
		t1.setPrefSize(300, 50);
		
		HBox hbox0 = new HBox();
		hbox0.setAlignment(Pos.CENTER);
		hbox0.getChildren().add(t1);

		TextField bookField = new TextField();
		bookField.setPrefSize(80, 20);
		bookField.setPromptText("Book ISBN");
		
		TextField dvdField = new TextField();
		dvdField.setPrefSize(80, 20);
		dvdField.setPromptText("DVD Titles");

		TextField magField = new TextField();
		magField.setPrefSize(80, 20);
		magField.setPromptText("Magazine Titles");

		HBox hbox1 = new HBox(20);
		hbox1.setAlignment(Pos.CENTER);

		hbox1.getChildren().addAll(bookField, magField, dvdField);

		Button findBookBtn = new Button("Search Book");
		findBookBtn.setPrefSize(150, 30);
		
		Button findDVDBtn = new Button("Search DVD");
		findDVDBtn.setPrefSize(150, 30);

		Button findMagBtn = new Button("Search Magazine");
		findMagBtn.setPrefSize(150, 30);
		
		Button newBookBtn = new Button("New Book");
		newBookBtn.setPrefSize(100, 30);
		
		Button newDVDBtn = new Button("New DVD");
		newDVDBtn.setPrefSize(100, 30);
		
		Button newMagBtn = new Button("New Mag");
		newMagBtn.setPrefSize(100, 30);

		Button bckupBtn = new Button("Backup");
		bckupBtn.setPrefSize(70, 30);

		Button rtrveBtn = new Button("Retrieve");
		bckupBtn.setPrefSize(70, 30);

		HBox hbox2 = new HBox(20);
		hbox2.setAlignment(Pos.CENTER);
		hbox2.getChildren().addAll(findBookBtn, findDVDBtn, findMagBtn);
		
		HBox hbox3 = new HBox(20);
		hbox3.setAlignment(Pos.CENTER);
		hbox3.getChildren().addAll(newBookBtn, newDVDBtn, newMagBtn);
		
		HBox hbox4 = new HBox(20);
		hbox4.setAlignment(Pos.CENTER);
		hbox4.getChildren().addAll(bckupBtn, rtrveBtn);
		
		findBookBtn.setOnAction(e -> {
			String bookISBN = bookField.getText();
			Books book = BookBag.findByISBN(bookISBN);
			if (book == null) {
				t1.setText("No book found!");
				bookField.clear();
			} else {
				t1.setText(book + " was found!");
				bookField.clear();
			}
		});

		findDVDBtn.setOnAction(e -> {
			String DVDName = dvdField.getText();
			DVD dvd = BookBag.findByTitle(DVDName);
			if (dvd == null) {
				t1.setText("No DVD found!");
				dvdField.clear();
			} else {
				t1.setText(dvd + " was found!");
				dvdField.clear();
			}
		});
		
		findMagBtn.setOnAction(e -> {
			String magName = magField.getText();
			Magazine mag = BookBag.magazineFindByTitle(magName);
			if (mag == null) {
				t1.setText("No magazine found!");
				dvdField.clear();
			} else {
				t1.setText(mag + " was found!");
				dvdField.clear();
			}
		});
		
		newBookBtn.setOnAction(e -> {	
			String bookName = bookField.getText();
			Books book = BookBag.findByISBN(bookName);
			if (book == null) {
				t1.setText("Your book was added!");
				try {
					oos.writeUTF(bookName + "\n");
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				bookField.clear();
			} else {
				t1.setText("This book already exists");
				bookField.clear();
			}
		});
		
		newDVDBtn.setOnAction(e -> {
			String NewDVD = dvdField.getText();
			DVD dvd = BookBag.findByTitle(NewDVD);
			if (dvd == null) {
				t1.setText("Your dvd was added!");
				try {
					oos.writeUTF(NewDVD + "\n");
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				dvdField.clear();
			} else {
				t1.setText("This DVD already exists");
				dvdField.clear();
			}
		});
		
		newMagBtn.setOnAction(e -> {
			String newMag = magField.getText();
			Magazine mag = BookBag.magazineFindByTitle(newMag);
			if (mag == null) {
				t1.setText("Your magazine was added!");
				try {
					oos.writeUTF(newMag + "\n");
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				dvdField.clear();
			} else {
				t1.setText("This magazine already exists");
				dvdField.clear();
			}
		});
		
		VBox root = new VBox(20);
		root.setAlignment(Pos.CENTER);

		root.getChildren().addAll(hbox0, hbox1, hbox2, hbox3, hbox4);

		Scene scene = new Scene(root, 600, 600);
		stage.setScene(scene);
		stage.setTitle("My GUI");
		stage.show();
		oos.close();
	}
}
