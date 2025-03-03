package poker.card;

public class Card implements Comparable<Card>{
    private int rank;  // 2～14 (11=J, 12=Q, 13=K, 14=A)
    private String suit;  // スペード, ハート, ダイヤ, クラブ

    public Card(int rank, String suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public int getRank() {
        return rank;
    }

    public String getSuit() {
        return suit;
    }

    @Override
    public String toString() {
        String rankStr = switch (rank) {
            case 11 -> "J";
            case 12 -> "Q";
            case 13 -> "K";
            case 14 -> "A";
            default -> String.valueOf(rank);
        };
        return rankStr + " of " + suit;
    }

	@Override
	public int compareTo(Card other) {
		// TODO 自動生成されたメソッド・スタブ
		return Integer.compare(this.rank, other.rank);
	}
}
