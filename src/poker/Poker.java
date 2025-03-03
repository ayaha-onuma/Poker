package poker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import game.Game;
import poker.card.Trump;
import poker.logic.Change;
import poker.logic.HandRank;
import poker.logic.Ranking;
import poker.player.ComputerPlayer;
import poker.player.Player;
import poker.player.User;

public class Poker implements Game {

	public void play() {

		//ルール説明
		System.out.println("ドローポーカーです。"
				+ "\n最初に手札が五枚配られて、一回だけそのうちの好きな枚数を山札と交換できます。"
				+ "\n強い役を作った人が勝ちです。");

		//プレイヤーを何人用意するか
		System.out.println("対戦相手の数を1-5の間で入力してください。");
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		ComputerPlayer[] player = new ComputerPlayer[num];

		//入力された数プレイヤーを生成
		for (int i = 0; i < num; i++) {
			player[i] = new ComputerPlayer(i);
		}
		System.out.println("対戦相手が準備できました。");

		//ユーザーの席を用意
		User user = new User();

		//トランプを用意
		Trump trump = new Trump();

		// デッキをシャッフル
		trump.shuffleDeck();
		System.out.println("トランプを用意しました");

		//各プレイヤーとユーザーにトランプから手札を分ける
		for (ComputerPlayer p : player) {
			p.setHand(trump.dealHand());
		}
		user.setHand(trump.dealHand());

		//ユーザーに手札を表示
		user.displayHand();

		//ユーザーはどの札を捨てるか選択
		Change change = new Change(user, trump);
		change.exchangeCards();

		//手札を表示し強さを判定
		HandRank u = new HandRank(user);
		user.setRank(u.judge());

		for (ComputerPlayer players : player) {
			players.displayHand();
			HandRank p = new HandRank(players);
			players.setRank(p.judge());
		}

		// 順位判定
		List<Player> allPlayers = new ArrayList<>();
		allPlayers.add(user);
		Collections.addAll(allPlayers, player);
		Ranking ranking = new Ranking(allPlayers);
		ranking.determineRanking();
	}
}