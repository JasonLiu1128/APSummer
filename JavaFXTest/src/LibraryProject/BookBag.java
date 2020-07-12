package LibraryProject;

import java.util.function.Predicate;

public class BookBag {
	private static Books[] arr;
	private static DVD[] array;
	private static Magazine[] arrays;
	private static int numElms;
	private static int nElms;
	private static int numElm;
	public BookBag(int maxSize){
		arr = new Books[maxSize];
		array = new DVD[maxSize];
		arrays = new Magazine[maxSize];
		numElms = 0;
		nElms = 0;
		numElm = 0;
	}
	public void insert(Books book) {
		arr[numElms++] = book;
	}
	public void insert(DVD dvd) {
		array[nElms++] = dvd;
	}
	public void insert(Magazine mag) {
		arrays[numElm++] = mag;
	}
	public static void display() {
		for(int i = 0; i < numElms; i++) {
			System.out.println(arr[i]);
		}
		for(int i = 0; i < nElms; i++) {
			System.out.println(array[i]);
		}
		for(int i = 0; i < numElm; i++) {
			System.out.println(arrays[i]);
		}
	}
	public static Books findByISBN(String ISBN) {
		for(int i = 0; i < numElms; i++) {
			if(arr[i].getBookISBNs().equalsIgnoreCase(ISBN)) {
				System.out.println(arr[i]);
				arr[i].setReserve(true);
				return arr[i];
			}
		}
		return null;
	}
	
	public static DVD findByTitle(String DVDtitle) {
		for(int i = 0; i < nElms; i++) {
			if(array[i].getTitle().equalsIgnoreCase(DVDtitle)) {
				System.out.println(array[i]);
				array[i].setReserve(true);
				return array[i];
			}
		}
		return null;
	}
	public static Magazine magazineFindByTitle(String bookTitle) {
		for(int i = 0; i < numElm; i++) {
			if(arrays[i].getTitle().equalsIgnoreCase(bookTitle)) {
				System.out.println(arrays[i]);
				arrays[i].setReserve(true);
				return arrays[i];
			}
		}
		return null;
	}
	
	public Books removeByISBN(String ISBN) {
		int i = 0;
		for(i = 0; i < numElms; i++) {
			if(arr[i].getBookISBNs().equalsIgnoreCase(ISBN)) {
				break;
			}
		}
		if(i == numElms) {
			return null;
		}else {
			Books temp = arr[i];
			for(int j = 1; j < numElms; j++) {
				arr[j] = arr[j + 1];
			}
			numElms--;
			return temp;
		}
	}
	
	public Books search(Predicate<Books> predicate) {
		for(int i = 0; i < numElms; i++) {
			if(predicate.test(arr[i])) {
				return arr[i];
			}
		}
		return null;
	}
}
