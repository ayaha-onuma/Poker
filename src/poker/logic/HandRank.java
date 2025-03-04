package poker.logic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import poker.card.Card;
import poker.player.Player;

public class HandRank {
    private List<Card> hand;

    public HandRank(Player p) {
        this.hand = new ArrayList<>(p.getHand());
        Collections.sort(hand); // CardクラスにComparableが実装されている前提
    }

    public HandRank(List<Card> hand) {
        this.hand = new ArrayList<>(hand);
        Collections.sort(hand);
    }

    public int judge() {
        if (isFlush() && isStraight() && hand.get(0).getRank() == 10) return 0;
        if (isFlush() && isStraight()) return 1;
        if (isFourCard()) return 2;
        if (isFullHouse()) return 3;
        if (isFlush()) return 4;
        if (isStraight()) return 5;
        if (isThreeCard()) return 6;
        if (isTwoPair()) return 7;
        if (isOnePair()) return 8;
        return 9;
    }

    public String getHandName() {
        switch (judge()) {
            case 0: return "ロイヤルフラッシュ";
            case 1: return "ストレートフラッシュ";
            case 2: return "フォーカード";
            case 3: return "フルハウス";
            case 4: return "フラッシュ";
            case 5: return "ストレート";
            case 6: return "スリーカード";
            case 7: return "ツーペアー";
            case 8: return "ワンペアー";
            case 9: return "ノーペアー（ハイカード）";
            default: return "不明";
        }
    }

    public List<Integer> getKeyRanks() {
        List<Integer> keyRanks = new ArrayList<>();
        int[] rankCount = new int[15];
        for (Card card : hand) {
            rankCount[card.getRank()]++;
        }

        int rank = judge();
        switch (rank) {
            case 0: case 1: case 5:
                keyRanks.add(hand.get(hand.size() - 1).getRank());
                break;
            case 2:
                for (int i = 2; i <= 14; i++) {
                    if (rankCount[i] == 4) {
                        keyRanks.add(i);
                        break;
                    }
                }
                break;
            case 3:
                for (int i = 14; i >= 2; i--) {
                    if (rankCount[i] == 3) keyRanks.add(i);
                }
                for (int i = 14; i >= 2; i--) {
                    if (rankCount[i] == 2) keyRanks.add(i);
                }
                break;
            case 4: case 9:
                for (int i = hand.size() - 1; i >= 0; i--) {
                    keyRanks.add(hand.get(i).getRank());
                }
                break;
            case 6:
                for (int i = 14; i >= 2; i--) {
                    if (rankCount[i] == 3) {
                        keyRanks.add(i);
                        break;
                    }
                }
                break;
            case 7:
                List<Integer> pairs = new ArrayList<>();
                for (int i = 14; i >= 2; i--) {
                    if (rankCount[i] == 2) pairs.add(i);
                }
                keyRanks.add(pairs.get(0));
                keyRanks.add(pairs.get(1));
                for (int i = 14; i >= 2; i--) {
                    if (rankCount[i] == 1) {
                        keyRanks.add(i);
                        break;
                    }
                }
                break;
            case 8: // ワンペア
                int pairRank = 0;
                for (int i = 14; i >= 2; i--) {
                    if (rankCount[i] == 2) {
                        pairRank = i;
                        keyRanks.add(i);
                        break;
                    }
                }
                List<Integer> kickers = new ArrayList<>();
                for (int i = 14; i >= 2; i--) {
                    if (rankCount[i] == 1) kickers.add(i);
                }
                Collections.sort(kickers, Collections.reverseOrder()); // キッカーを降順に
                keyRanks.addAll(kickers);
                break;
        }
        return keyRanks;
    }

    // デバッグ用に手札とキー情報を表示
    public void printDebugInfo(String playerName) {
        System.out.println(playerName + " の手札: " + hand);
        System.out.println("役: " + getHandName());
        System.out.println("キー: " + getKeyRanks());
    }

    public boolean isFlush() {
        String firstSuit = hand.get(0).getSuit();
        for (Card card : hand) {
            if (!card.getSuit().equals(firstSuit)) return false;
        }
        return true;
    }

    public boolean isStraight() {
        boolean normalStraight = true;
        for (int i = 1; i < hand.size(); i++) {
            if (hand.get(i).getRank() != hand.get(i - 1).getRank() + 1) {
                normalStraight = false;
                break;
            }
        }
        if (normalStraight) return true;
        if (hand.get(0).getRank() == 2 && hand.get(1).getRank() == 3 &&
            hand.get(2).getRank() == 4 && hand.get(3).getRank() == 5 &&
            hand.get(4).getRank() == 14) return true;
        return false;
    }

    public boolean isFourCard() { return hasSameRank(4); }
    public boolean isThreeCard() { return hasSameRank(3); }
    public boolean isOnePair() { return hasSameRank(2); }

    public boolean isTwoPair() {
        int pairCount = 0;
        for (int i = 0; i < hand.size() - 1; i++) {
            if (hand.get(i).getRank() == hand.get(i + 1).getRank()) {
                pairCount++;
                i++;
            }
        }
        return pairCount == 2;
    }

    public boolean isFullHouse() {
        int[] rankCount = new int[15];
        for (Card card : hand) {
            rankCount[card.getRank()]++;
        }
        boolean hasThree = false, hasTwo = false;
        for (int count : rankCount) {
            if (count == 3) hasThree = true;
            else if (count == 2) hasTwo = true;
        }
        return hasThree && hasTwo;
    }

    private boolean hasSameRank(int count) {
        int matchCount = 1;
        for (int i = 1; i < hand.size(); i++) {
            if (hand.get(i).getRank() == hand.get(i - 1).getRank()) {
                matchCount++;
                if (matchCount == count) return true;
            } else {
                matchCount = 1;
            }
        }
        return false;
    }
}