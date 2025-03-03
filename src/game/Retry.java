package game;

import java.util.InputMismatchException;
import java.util.Scanner;



public class Retry {

	//どのゲームか指定するためのゲームインターフェイス
	private Game game;
	
	//ユーザーからの回答を受け取る変数、やめるフラグ
	private	int retry;
	
	public Retry(Game game) {
		
		//やめるフラグ（1:続行 0:終了）
		retry = 1;
		//
		this.game = game;
		
	}

	public void retry() {
		
		game.play();


		//ユーザー入力を受け取るためのScanner生成
		Scanner sc = new Scanner(System.in);

		//ゲームを繰り返すか否か
		while (true) {

			try {

				System.out.println("もう一度ゲームをしますか？（1:続行 0:終了）");

				//ユーザーから回答を受け取る
				retry = sc.nextInt();

				//ゲームを終了する
				if (retry == 0) {
					break;

				}
				//	リトライする
				else if (retry == 1) {
					game.play();
				}
				//0か１以外の数値の場合
				else {
					System.out.println("0か1を入力してください");
					continue;
				}

			} //文字が入力された場合
			catch (InputMismatchException e) {
				// TODO: handle exception
				System.out.println("0か1を入力してください");
			}

		}
	}


}
