package poker.card;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Trump {

	private List<Card> deck;

	public Trump() {
		deck = new ArrayList<>();
		String[] suits = { "Spades", "Hearts", "Diamonds", "Clubs" };
		for (String suit : suits) {
			for (int rank = 2; rank <= 14; rank++) { // 2～14 (J=11, Q=12, K=13, A=14)
				deck.add(new Card(rank, suit));
			}
		}
		shuffleDeck();
	}

	public void shuffleDeck() {
		Collections.shuffle(deck);
	}

	public List<Card> dealHand() {
		List<Card> hand = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			hand.add(deck.remove(0));
		}
		return hand;
	}

	public List<Card> getDeck() {
		return deck;
	}
}
