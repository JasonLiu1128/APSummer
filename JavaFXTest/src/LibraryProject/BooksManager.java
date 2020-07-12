package LibraryProject;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

import p1.User;
import p1.UserBags;

public class BooksManager {
	public static String[] readNames(String fileName) throws FileNotFoundException {
		File file = new File(fileName);
		Scanner scan = new Scanner(file);
		ArrayList<String> bookList = new ArrayList<>();
		while (scan.hasNextLine()) {
			bookList.add(scan.nextLine());
		}
		String[] nameArr = new String[bookList.size()];
		for (int i = 0; i < bookList.size(); i++) {
			nameArr[i] = bookList.get(i);
		}
		scan.close();
		return nameArr;
	}

	public static String[] makeFullBookName(String bookTitles, String bookISBNs, String firstNames, String lastNames)
			throws FileNotFoundException {
		String[] bookTitlesArr = readNames(bookTitles);
		String[] bookISBNsArr = readNames(bookISBNs);
		String[] firstNameArray = readNames(firstNames);
		String[] lastNameArray = readNames(lastNames);
		String[] fullBookArr = new String[bookTitlesArr.length];

		for (int i = 0; i < fullBookArr.length; i++) {
			double price = Math.random() * 200;
			double round = (double) (Math.round(price * 100) / 100d);
			String fullPrice = "$" + Double.toString(round);
			fullBookArr[i] = bookTitlesArr[i] + " " + bookISBNsArr[i] + " by:" + extractRandomName(firstNameArray) + " "
					+ extractRandomName(lastNameArray) + " " + fullPrice;
		}
		return fullBookArr;
	}

	public static String[] makeFullDVD(String DVDTitles, String genre) throws FileNotFoundException {
		Random random = new Random();
		String[] DVDTitlesArr = readNames(DVDTitles);
		String[] GenreArr = readNames(genre);
		String[] fullDVDArr = new String[DVDTitlesArr.length];
		for (int i = 0; i < fullDVDArr.length; i++) {
			int year = random.nextInt(20) + 2000;
			double price = Math.random() * 200;
			int genreNumber = random.nextInt(4);
			double round = (double) (Math.round(price * 100) / 100d);
			String fullPrice = "$" + Double.toString(round);
			fullDVDArr[i] = DVDTitlesArr[i] + " " + GenreArr[genreNumber] + year + fullPrice;
		}
		return fullDVDArr;
	}

	public static String[] makeFullMagazine(String MagazineTitles) throws FileNotFoundException {
		Random random = new Random();
		String[] MagazineTitlesArr = readNames(MagazineTitles);
		String[] fullMagazineArr = new String[MagazineTitlesArr.length];
		for (int i = 0; i < fullMagazineArr.length; i++) {
			int randomTime = random.nextInt(5000000);
			Date randomDate = new Date(randomTime);
			fullMagazineArr[i] = MagazineTitlesArr[i] + " " + randomDate;
		}
		return fullMagazineArr;
	}

	public static String extractRandomName(String[] names) {
		int randomIndex = (int) (Math.random() * names.length);
		return names[randomIndex];
	}

	public static void fillBookBag(BookBag bookbag, String firstNameFile, String lastNameFile, String bookNamesFile,
			String bookISBNFile, String DVDTitles, String Genre, String Magazines) throws FileNotFoundException {
		String[] fullNameArr = makeFullName(firstNameFile, lastNameFile);
		String[] TitlesArr = readNames(bookNamesFile);
		String[] ISBNArr = readNames(bookISBNFile);
		Random random = new Random();
		String[] DVDTitlesArr = readNames(DVDTitles);
		String[] GenreArr = readNames(Genre);
		String[] fullDVDArr = new String[DVDTitlesArr.length];
		String[] MagazineTitlesArr = readNames(Magazines);
		String[] fullMagazineArr = new String[MagazineTitlesArr.length];
		for (int i = 0; i < fullNameArr.length; i++) {
			double price = Math.random() * 200;
			double round = (double) (Math.round(price * 100) / 100d);
			String fullPrice = "$" + Double.toString(round);
			Books book = new Books(TitlesArr[i], ISBNArr[i], fullNameArr[i], fullPrice);
			bookbag.insert(book);
		}
		for (int i = 0; i < fullDVDArr.length; i++) {
			int year = random.nextInt(20) + 2000;
			double price = Math.random() * 200;
			int genreNumber = random.nextInt(4);
			double round = (double) (Math.round(price * 100) / 100d);
			DVD dvd = new DVD(DVDTitlesArr[i], false, GenreArr[genreNumber], year, round);
			bookbag.insert(dvd);
		}
		for (int i = 0; i < fullMagazineArr.length; i++) {
			int randomTime = random.nextInt(5000000);
			Date randomDate = new Date(randomTime);
			Magazine mag = new Magazine(MagazineTitlesArr[i], randomDate);
			bookbag.insert(mag);
		}
	}

	private static String[] makeFullName(String firstName, String lastName) throws FileNotFoundException {
		String[] firstNameArray = readNames(firstName);
		String[] lastNameArray = readNames(lastName);
		String[] fullNameArray = new String[firstNameArray.length];

		for (int i = 0; i < fullNameArray.length; i++) {
			fullNameArray[i] = extractRandomName(firstNameArray) + " " + extractRandomName(lastNameArray);
		}
		return fullNameArray;
	}
}
