package poker.logic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import poker.player.Player;

public class Ranking {
    private List<Player> players;

    public Ranking(List<Player> players) {
        this.players = new ArrayList<>(players);
    }

    public void determineRanking() {
        // 役の強さでソート（低い値が強い）
        Collections.sort(players, Comparator.comparingInt(Player::getRank));

        // 同じ役のプレイヤーをキーとなるカードでソート
        for (int i = 0; i < players.size() - 1; i++) {
            Player p1 = players.get(i);
            Player p2 = players.get(i + 1);

            if (p1.getRank() == p2.getRank()) {
                List<Integer> keyRanks1 = new HandRank(p1).getKeyRanks();
                List<Integer> keyRanks2 = new HandRank(p2).getKeyRanks();

                for (int j = 0; j < Math.min(keyRanks1.size(), keyRanks2.size()); j++) {
                    int rank1 = keyRanks1.get(j);
                    int rank2 = keyRanks2.get(j);
                    if (rank1 > rank2) {
                        break; // p1が強い
                    } else if (rank1 < rank2) {
                        Collections.swap(players, i, i + 1);
                        break; // p2が強い
                    }
                }
            }
        }

        /* デバッグ情報
        System.out.println("デバッグ情報:");
        for (Player p : players) {
            new HandRank(p).printDebugInfo(p.getName());
        }*/

        // 結果を表示
        System.out.println("順位:");
        for (int i = 0; i < players.size(); i++) {
            Player p = players.get(i);
            HandRank handRank = new HandRank(p);
            System.out.println((i + 1) + "位: " + p.getName() + " - " + handRank.getHandName());
        }
    }
}