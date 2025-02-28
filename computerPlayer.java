package ポーカー;

import java.util.ArrayList;

public class computerPlayer extends Player {
	private String[] names = { "player1", "player2", "player3", "player4", "player5" };

	computerPlayer(int i) {
		/*初期化する。
		名前を決定し、
		手札が5枚入る変数を作成する。*/
		name = names[i];
		hand = new ArrayList<String>(5);
	}

	

	/* カードを交換するメソッド
	public void exchangeCards(Trump trump) {
	    List<Integer> exchangeIndices = CardAnalyzer.getCardsToExchange(hand);
	    if (!exchangeIndices.isEmpty()) {
	        List<String> discardedCards = discardCards(exchangeIndices);
	        List<String> newCards = new ArrayList<>();
	        for (int i = 0; i < discardedCards.size(); i++) {
	            List<String> newCard = trump.dealHand();
	            if (!newCard.isEmpty()) {
	                newCards.add(newCard.get(0));
	            }
	        }
	        drawNewCards(newCards);
	    }
	}
	
	// 札を捨てるメソッド(Userクラスからコピー)
	private List<String> discardCards(List<Integer> discardIndices) {
	    List<String> discardedCards = new ArrayList<>();
	    discardIndices.sort(Collections.reverseOrder());
	
	    for (int index : discardIndices) {
	        int actualIndex = index - 1;
	
	        if (actualIndex >= 0 && actualIndex < hand.size()) {
	            discardedCards.add(hand.remove(actualIndex));
	        } else {
	            System.out.println("無効な番号:" + index + "はスキップされました。");
	        }
	    }
	    return discardedCards;
	}
	
	// 新しい札を引くメソッド(Userクラスからコピー)
	private void drawNewCards(List<String> newCards) {
	    hand.addAll(newCards);
	}
	*/


}
