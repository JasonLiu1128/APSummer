package p1;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class UserBags {
	private User[] arr;
	private int numElms;

	public UserBags(int maxSize) {
		arr = new User[maxSize];
		numElms = 0;
	}

	public void insert(User user) {
		arr[numElms++] = user;
	}

	public User findByUser(String username) {
		for (int i = 0; i < numElms; i++) {
			if (arr[i].getUsername().equalsIgnoreCase(username)) {
				return arr[i];
			}
		}
		return null;
	}

	public User removeByUser(String username) {
		int i = 0;
		for (i = 0; i < numElms; i++) {
			if (arr[i].getUsername().equalsIgnoreCase(username)) {
				break;
			}
		}
		if (i == numElms) {
			return null;
		} else {
			User temp = arr[i];
			for (int j = 1; j < numElms; j++) {
				arr[j] = arr[j + 1];
			}
			numElms--;
			return temp;
		}
	}

	public void display() {
		for (int i = 0; i < numElms; i++) {
			System.out.println(arr[i]);
		}
	}

	public User find(String username, String password) {
		for (int i = 0; i < numElms; i++) {
			if (arr[i].getUsername().equalsIgnoreCase(username) && arr[i].getPassword().contentEquals(password)) {
				return arr[i];
			}
		}
		return null;
	}

	public User find(String username) {
		for (int i = 0; i < numElms; i++) {
			if (arr[i].getUsername().equalsIgnoreCase(username)) {
				return arr[i];
			}
		}

		return null;
	}

	public void storeUsers() throws IOException {
		FileOutputStream fos = new FileOutputStream("Users.dat");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		for (int i = 0; i < numElms; i++) {
			oos.writeObject(arr[i]);
		}
		oos.close();
	}
}