package ポーカー;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Poker implements Game {

	@Override
	public void play() {

		//ルール説明
		System.out.println("ドローポーカーです。"
				+ "\n最初に手札が五枚配られて、一回だけそのうちの好きな枚数を山札と交換できます。"
				+ "\n強い役を作った人が勝ちです。");

		//プレイヤーを何人用意するか
		System.out.println("対戦相手の数を1-5の間で入力してください。");
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		computerPlayer[] player = new computerPlayer[num];

		//入力された数プレイヤーを生成
		for (int i = 0; i < num; i++) {
			player[i] = new computerPlayer(i);
		}
		System.out.println("対戦相手が準備できました。");

		//ユーザーの席を用意

		User user = new User();

		//トランプを用意
		Trump trump = new Trump();
		// トランプのデッキを作成
        List<String> deck = trump.createDeck();
        // デッキをシャッフル
        trump.shuffleDeck(deck);
		System.out.println("トランプを用意しました");

		//各プレイヤーとユーザーにトランプから手札を分ける
		for (computerPlayer p : player) {
			p.setHand(trump.dealHand());
		}
		user.setHand(trump.dealHand());
		
		//ユーザーに手札を表示
		user.displayHand();
		
		//ユーザーはどの札を捨てるか選択
		// 札の交換処理
        Change change = new Change(user, trump);
        change.exchangeCards();
		
		/*・プレイヤーはそれぞれコンピューターで札を捨てるか判定
        for (Player p : player) {
            p.exchangeCards(trump); // 各プレイヤーがカードを交換
        }
        */
        
		//手札を表示し強さを判定
		//・各プレイヤーの札を表示
        HandRank u = new HandRank(user);
        user.setRank(u.judge());
        
        for (computerPlayer players : player) {
			players.displayHand();
			HandRank p = new HandRank(players);
			players.setRank(p.judge());
		}
		//・ユーザーとプレイヤーの役判定をし順位を決定して表示する*/
        
        List<Player> allPlayers = new ArrayList<>();
        allPlayers.add(user); // ユーザーをリストに追加
        for (computerPlayer p : player) {
            allPlayers.add(p); // プレイヤーをリストに追加
        }
        Collections.sort(allPlayers, Comparator.comparingInt(Player::getRank));// ランクでソート
        
        // ソートされたリストから順位を決定する
        System.out.println("順位:");
        for (int i = 0; i < allPlayers.size(); i++) {
            Player p = allPlayers.get(i);
            System.out.println((i + 1) + "位: " + p.getName() + " (" + p.getRank() + ")");
        }
        
	}
}
