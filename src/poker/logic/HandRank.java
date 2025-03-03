package poker.logic;

import java.util.Collections;
import java.util.List;

import poker.card.Card;
import poker.player.Player;

public class HandRank {
    private List<Card> hand;

    public HandRank(Player p) {
        this.hand = p.getHand();
        Collections.sort(hand); // ランク順にソート
    }

    public boolean isFlush() {
        String firstSuit = hand.get(0).getSuit();
        for (Card card : hand) {
            if (!card.getSuit().equals(firstSuit)) {
                return false;
            }
        }
        return true;
    }

    public boolean isStraight() {
        // 通常のストレートチェック
        boolean normalStraight = true;
        for (int i = 1; i < hand.size(); i++) {
            if (hand.get(i).getRank() != hand.get(i - 1).getRank() + 1) {
                normalStraight = false;
                break;
            }
        }
        if (normalStraight) {
            return true;
        }

        // A-2-3-4-5 の特別なケースをチェック
        if (hand.get(0).getRank() == 2 && 
            hand.get(1).getRank() == 3 && 
            hand.get(2).getRank() == 4 && 
            hand.get(3).getRank() == 5 && 
            hand.get(4).getRank() == 14) {
            return true;
        }
        return false;
    }

    public boolean isFourCard() {
        return hasSameRank(4);
    }

    public boolean isThreeCard() {
        return hasSameRank(3);
    }

    public boolean isOnePair() {
        return hasSameRank(2);
    }

    public boolean isTwoPair() {
        int pairCount = 0;
        for (int i = 0; i < hand.size() - 1; i++) {
            if (hand.get(i).getRank() == hand.get(i + 1).getRank()) {
                pairCount++;
                i++; // 連続するペアをカウントしたら、次のチェックをスキップ
            }
        }
        return pairCount == 2;
    }

    public boolean isFullHouse() {
        int[] rankCount = new int[15]; // 2〜14のランクを格納するため（index 2〜14を使用）

        // 各ランクのカードの枚数をカウント
        for (Card card : hand) {
            rankCount[card.getRank()]++;
        }

        boolean hasThree = false;
        boolean hasTwo = false;

        for (int count : rankCount) {
            if (count == 3) {
                hasThree = true;
            } else if (count == 2) {
                hasTwo = true;
            }
        }

        return hasThree && hasTwo;
    }


    // 指定した枚数の同じランクが存在するかチェック
    private boolean hasSameRank(int count) {
        int matchCount = 1; // 1枚目からカウント開始
        for (int i = 1; i < hand.size(); i++) {
            if (hand.get(i).getRank() == hand.get(i - 1).getRank()) {
                matchCount++;
                if (matchCount == count) {
                    return true;
                }
            } else {
                matchCount = 1; // 連続が途切れたらリセット
            }
        }
        return false;
    }

    public int judge() {
        if (isFlush() && isStraight() && hand.get(0).getRank() == 10) {
            System.out.println("ロイヤルフラッシュ");
            return 0;
        }
        if (isFlush() && isStraight()) {
            System.out.println("ストレートフラッシュ");
            return 1;
        }
        if (isFourCard()) {
            System.out.println("フォーカード");
            return 2;
        }
        if (isFullHouse()) {
            System.out.println("フルハウス");
            return 3;
        }
        if (isFlush()) {
            System.out.println("フラッシュ");
            return 4;
        }
        if (isStraight()) {
            System.out.println("ストレート");
            return 5;
        }
        if (isThreeCard()) {
            System.out.println("スリーカード");
            return 6;
        }
        if (isTwoPair()) {
            System.out.println("ツーペアー");
            return 7;
        }
        if (isOnePair()) {
            System.out.println("ワンペアー");
            return 8;
        }
        System.out.println("ノーペアー（ハイカード）");
        return 9;
    }
    
    
    // テスト用、直接 List<Card> を渡せるコンストラクタを追加
    public HandRank(List<Card> hand) {
        this.hand = hand;
        Collections.sort(this.hand); // ランク順にソート
    }
}
