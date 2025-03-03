package poker.logic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import poker.card.Card;
import poker.card.Trump;
import poker.player.User;

public class Change {
	private User user;
	private Trump trump;

	public Change(User user, Trump trump) {
		this.user = user;
		this.trump = trump;
	}

	// カード交換処理
	public void exchangeCards() {
		Scanner sc = new Scanner(System.in);
		System.out.println("捨てる札の番号をスペース区切りで入力してください (例: 1 3 5)。無ければ0を入力してください。");

		// ユーザーからの入力を文字列として取得
		String input = sc.nextLine();

		// 入力された文字列をスペースで分割し、文字列配列に格納
		String[] indices = input.split(" ");

		// 捨てる札の番号を格納するリスト
		List<Integer> discardIndices = new ArrayList<>();

		// 入力された番号が整数であるか、範囲内であるかをチェック
		try {
			for (String index : indices) {
				int discardIndex = Integer.parseInt(index); // 文字列を整数に変換
				if (discardIndex == 0) { // 0が入力された場合は交換しない
					System.out.println("カードを交換しません。");
					user.displayHand();
					return;
				}
				if (discardIndex < 1 || discardIndex > user.getHand().size()) {
					System.out.println("無効な番号: " + discardIndex + " はスキップされました。");
					continue;
				}
				discardIndices.add(discardIndex); // 捨てる札の番号をリストに追加
			}
		} catch (NumberFormatException e) {
			System.out.println("無効な入力です。数字を入力してください。");
			return;
		}

		// 捨てる札を処理
		List<Card> discardCards = new ArrayList<>();
		discardIndices.sort(Collections.reverseOrder()); // 降順ソート（後ろから削除するため）

		for (int index : discardIndices) {
			int actualIndex = index - 1; // ユーザ入力は1始まり、インデックスは0始まり
			discardCards.add(user.getHand().remove(actualIndex)); // 札を削除して記録
		}

		// 新しい札を引く
		List<Card> newHand = new ArrayList<>(user.getHand()); // 現在の手札をコピー
		for (int i = 0; i < discardCards.size(); i++) {
			if (trump.getDeck().isEmpty()) {
				System.out.println("山札が尽きました。");
				break;
			}
			newHand.add(trump.getDeck().remove(0)); // 山札から新しいカードを追加
		}

		user.setHand(newHand); // 新しい手札をセット
		System.out.println("捨てたカード: " + discardCards);
		user.displayHand();
	}
}