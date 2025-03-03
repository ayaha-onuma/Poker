package poker.logic;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import poker.card.Card;

class HandRankTest {

    @Test
    void testIsFullHouse() {
        // フルハウスの手札（例: 10, 10, 10, 5, 5）
        HandRank handRank = new HandRank(Arrays.asList(
            new Card(10, "Hearts"),
            new Card(10, "Diamonds"),
            new Card(10, "Clubs"),
            new Card(5, "Spades"),
            new Card(5, "Hearts")
        ));

        assertTrue(handRank.isFullHouse(), "フルハウスと判定されるべき");
    }

    @Test
    void testIsNotFullHouse() {
        // フルハウスではない手札（例: 10, 10, 9, 5, 5）
        HandRank handRank = new HandRank(Arrays.asList(
            new Card(10, "Hearts"),
            new Card(10, "Diamonds"),
            new Card(9, "Clubs"),
            new Card(5, "Spades"),
            new Card(5, "Hearts")
        ));

        assertFalse(handRank.isFullHouse(), "フルハウスではないのにフルハウスと判定される");
    }
}
