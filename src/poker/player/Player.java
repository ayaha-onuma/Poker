package poker.player;

import java.util.List;

import poker.card.Card;

public abstract class Player {
	protected List<Card> hand;
	protected String name;
	protected int rank;

	public List<Card> getHand() {
		return hand;
	}

	public void setHand(List<Card> hand) {
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
		System.out.println(name + " さんの手札は");
		int count = 1;
		for (Card card : hand) {
			System.out.println(count + "枚目: " + card);
			count++;
		}
	}
}
