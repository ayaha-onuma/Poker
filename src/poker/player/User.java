package poker.player;

import java.util.Scanner;

public class User extends Player {

	public User() {
		System.out.println("あなたの名前を教えてください。");
		Scanner sc = new Scanner(System.in);
		String username = sc.nextLine();
		this.name = username;
	}

}
