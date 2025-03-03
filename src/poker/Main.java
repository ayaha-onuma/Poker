package poker;

import game.Retry;

public class Main {
	public static void main(String[] args){
		
		Retry poker = new Retry(new Poker());
		poker.retry();
	}

}
