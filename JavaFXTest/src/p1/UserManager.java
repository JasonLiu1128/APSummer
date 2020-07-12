package p1;

import java.util.Scanner;
import java.util.Random;

public class UserManager {
	public static String[] makeFullUser(String[] username, String[] password) {
		String[] fullUserArr = new String[200];
		for(int i = 0; i < username.length;i++) {
			fullUserArr[i] = username[i] + password[i];
		}
		return fullUserArr;
	}
	public static void add(UserBags userbags, User user) {
		userbags.insert(user);
	}
	public static void create(UserBags userbags) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter an username and password: ");
		String newUser = scan.nextLine();
		String[] userTokens = newUser.split(" ");
		User newUsers = new User(userTokens[0], userTokens[1]);
		userbags.insert(newUsers);
	}

	public static boolean isLoggedIn(UserBags userbag, String username, String password) {
		User userFound = userbag.findByUser(username);
		boolean loggedIn = false;
		if (userFound != null) {
			if (password.equals(userFound.getPassword())) {
				loggedIn = true;
			}
		}
		return loggedIn;
	}

	public static void display(UserBags userbag, String username, String password) {
		User userFound = userbag.findByUser(username);
		if (isLoggedIn(userbag, username, password)) {
			System.out.println("Welcome " + userFound.getUsername() + ", you have logged in successfully.");

		} else {
			System.out.println("Login failed, please try again.");
		}
	}
	
	public static void createUsers(UserBags userbag, int numberofUsers) {
		for(int i = 0; i < numberofUsers; i++) {
			create(userbag);
		}
	}
	
	public static void fillTheBag(UserBags userbag, int integer) {
		Random random = new Random();
		for(int i = 0; i < integer; i++) {
			int randomNumber1 = random.nextInt(9437);
			int randomNumber2 = random.nextInt(9437);
			String username = "u" + randomNumber1;
			String password = "p" + randomNumber2;
			User newUser = new User(username, password);
			userbag.insert(newUser);
		}
	}
}

