package LibraryProject;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class NamesManager {
	public static String[] makeFullName(String fileFirstName, String fileLastName) throws FileNotFoundException {
		String[] firstNameArray = readNames(fileFirstName);
		String[] lastNameArray = readNames(fileLastName);
		String[] fullNameArray = new String[200];

		for (int i = 0; i < fullNameArray.length; i++) {
			fullNameArray[i] = extractRandomName(firstNameArray) + " " + extractRandomName(lastNameArray);
		}
		for (int i = 0; i < fullNameArray.length; i++) {
			System.out.println(fullNameArray[i]);
			
		}
		return fullNameArray;
	}

	public static String[] readNames(String fileName) throws FileNotFoundException {
		File file = new File(fileName);
		Scanner scan = new Scanner(file);
		ArrayList<String> nameList = new ArrayList<>();
		while (scan.hasNextLine()) {
			nameList.add(scan.nextLine());
		}
		String[] nameArr = new String[nameList.size()];
		for (int i = 0; i < nameList.size(); i++) {
			nameArr[i] = nameList.get(i);
		}
		return nameArr;
	}
	public static String extractRandomName(String[] names) {
		int randomIndex = (int) (Math.random() * names.length);
		return names[randomIndex];
	}

}
