package ポーカー;

import java.util.List;

public abstract class Player {
	protected List<String> hand;
	protected String name;
	protected int rank;
	
	public List<String> getHand() {
		return hand;
	}

	public void setHand(List<String> hand) {
		this.hand = hand;
	}
	
	public String getName() {
		return name;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}
	
	public void displayHand() {
		System.out.println(this.name + "さんの手札は");

		int count = 1;
		for (String hand : hand) {
			String rank = hand.substring(0, hand.length() - hand.substring(hand.indexOf("of")).length() - 1);
			if (rank.equals("14")) {
				rank = "A"; // 14を"A"に変換
			} else if (rank.equals("13")) {
				rank = "K";
			} else if (rank.equals("12")) {
				rank = "Q";
			} else if (rank.equals("11")) {
				rank = "J";
			}
			System.out.println(count + "枚目:" +  rank + "\s" + hand.substring(hand.indexOf("of")));
			count++;
		}
	}
	


}
