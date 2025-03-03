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
        Collections.sort(players, Comparator.comparingInt(Player::getRank));
        System.out.println("順位:");
        for (int i = 0; i < players.size(); i++) {
            Player p = players.get(i);
            System.out.println((i + 1) + "位: " + p.getName());
        }
    }
}
