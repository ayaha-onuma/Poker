package ポーカー;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Trump {

    // トランプのスート（絵柄）
    private enum Suit {
        HEARTS, DIAMONDS, CLUBS, SPADES
    }

    // トランプのランク（数字）
    private enum Rank {
        ACE(14),
        TWO(2),
        THREE(3),
        FOUR(4),
        FIVE(5),
        SIX(6),
        SEVEN(7),
        EIGHT(8),
        NINE(9),
        TEN(10),
        JACK(11),
        QUEEN(12),
        KING(13);

        private final int value;

        Rank(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }
   
   //トランプのカード一組
   private List<String> deck;
   
   public Trump() {
	   deck = new ArrayList<>();
   }

    // トランプのカード一組を作成するメソッド
   public List<String> createDeck() {
	    for (Suit suit : Suit.values()) {
	        for (Rank rank : Rank.values()) {
	            deck.add(rank.getValue() + " of " + suit); // 数値でランクを表現
	        }
	    }
	    return deck;
	}

    // トランプのデッキをシャッフルするメソッド
    public void shuffleDeck(List<String> deck) {
        Collections.shuffle(deck);
    }

    // 手札に5枚カードを配るメソッド
    public List<String> dealHand() {
    	List<String> hand = new ArrayList<>();
        if (deck.isEmpty()) {
            createDeck(); // デッキが空の場合、作成する
            shuffleDeck(deck); // 作成後シャッフル
        }
        for (int i = 0; i < 5; i++) {
            hand.add(deck.remove(0)); // 山札の先頭からカードを引く
        }
        return hand;
    }
    
    public List<String> getDeck() {
		return deck;
    }
    
    public void setDeck(List<String> deck) {
    	this.deck = deck;
    }
}