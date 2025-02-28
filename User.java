package ポーカー;

import java.util.ArrayList;
import java.util.Scanner;

public class User extends Player {


	User() {
		/*初期化する。
		名前を決定し、
		手札が5枚入る変数を作成する。*/
		System.out.println("あなたの名前を教えてください。");
		Scanner sc = new Scanner(System.in);
		 String username = sc.nextLine();
		this.name = username;
		hand = new ArrayList<String>(5);
	}


}
