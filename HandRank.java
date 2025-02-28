package ポーカー;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HandRank {
	private List<String> hand =new ArrayList<>();
	private List<Integer> rank=new ArrayList<>();
	private Integer previousRank;
	private int count = 1;
	private List<String> suit=new ArrayList<>();
	private String previouSuit;
	private int compareRank= 2;
	

	public HandRank(Player p) {
		Collections.sort(p.getHand());
		this.hand = p.getHand();
		for (String hand : hand) {
			rank.add(Integer.parseInt(hand.substring(0, hand.length() - hand.substring(hand.indexOf("of")).length() - 1)));
		}
		previousRank = rank.get(0);
		for (String hand : hand) {
			suit.add(hand.substring(hand.indexOf("of") + 3));
		}
		previouSuit = suit.get(0);
	}

	public boolean royalflush() {
		if (previousRank != 10) {
			return false;
		}
		for (int i = 1; i < hand.size(); i++) {
			if (rank.get(i) == previousRank + 1) {
				previousRank = rank.get(i);
			} else {
				return false;
			}

		}
		System.out.println("ロイヤルフラッシュ");
		return true;
	}

	public boolean straightflush() {
		for (int i = 1; i < hand.size(); i++) {
			if (previouSuit != suit.get(i)) {
				return false;
			} 
		}
		for (int i = 1; i < hand.size(); i++) {
			if (rank.get(i) == previousRank + 1) {
				previousRank = rank.get(i);
				compareRank =rank.get(i);
			} else {
				return false;
			}
		}
		System.out.println("ストレートフラッシュ");
		return true;

	}

	public boolean fourcard() {
		for (int i = 1; i < hand.size(); i++) {
			if (rank.get(i) == previousRank) {
				previousRank = rank.get(i);
				count++;
				if (count == 4) {
					compareRank =rank.get(i);
					System.out.println("フォーカード");
					return true;
				}
			}
			previousRank = rank.get(i);
			count = 1;
		}
		return false;
	}

	public boolean fullhouse() {
		int innerCount = 0;
		for (int i = 1; i < hand.size(); i++) {
			if (rank.get(i) == previousRank) {
				previousRank = rank.get(i);
				count++;
				if (count == 2) {
					innerCount++;
					if (compareRank <rank.get(i)) {
						compareRank =rank.get(i);
					}
				} else if (count == 3) {
					innerCount++;
					
				}
			}
			previousRank = rank.get(i);
			count = 1;
		}
		if (innerCount == 3) {
			System.out.println("フルハウス");
			return true;
		}
		return false;
	}

	public boolean flush() {
		for (int i = 1; i < hand.size(); i++) {
			if (previouSuit != suit.get(i)) {
				return false;
			} 
			compareRank =rank.get(i);
		}
		System.out.println("フラッシュ");
		return true;
	}

	public boolean straight() {

		for (int i = 1; i < hand.size(); i++) {
			if (rank.get(i) == previousRank + 1) {
				previousRank = rank.get(i);
			} else {
				return false;
			}
			compareRank =rank.get(i);
		}
		System.out.println("ストレート");
		return true;

	}

	public boolean threecard() {
		for (int i = 1; i < hand.size(); i++) {
			if (rank.get(i) == previousRank) {
				previousRank = rank.get(i);
				count++;
				if (count == 3) {
					compareRank =rank.get(i);
					System.out.println("スリーカード");
					return true;
				}
			}
			previousRank = rank.get(i);
			count = 1;
		}
		return false;
	}

	public boolean twopair() {
		int innerCount = 1;
		for (int i = 1; i < hand.size(); i++) {
			if (rank.get(i) == previousRank) {
				previousRank = rank.get(i);
				count++;
				if (count == 2) {
					innerCount++;
					if (compareRank <rank.get(i)) {
						compareRank =rank.get(i);
					}
				}
			}
			previousRank = rank.get(i);
			count = 1;
		}
		if (innerCount == 2) {
			System.out.println("ツーペアー");
			return true;
		}
		return false;

	}

	public boolean onepair() {
		for (int i = 1; i < hand.size(); i++) {
			if (rank.get(i) == previousRank) {
				previousRank = rank.get(i);
				count++;
				compareRank =rank.get(i);
				if (count == 2) {
					System.out.println("ワンペアー");
					return true;
				}
			}
			previousRank = rank.get(i);
			count = 1;
		}
		return false;

	}

	public int judge() {
		boolean handrank = royalflush();
		if (handrank == true) {
			return 0;
		}
		handrank = straightflush();
		if (handrank == true) {
			return 1;
		}
		handrank = fourcard();
		if (handrank == true) {
			return 2;
		}
		handrank = fullhouse();
		if (handrank == true) {
			return 3;
		}
		handrank = flush();
		if (handrank == true) {
			return 4;
		}
		handrank = threecard();
		if (handrank == true) {
			return 5;
		}
		handrank = twopair();
		if (handrank == true) {
			return 6;
		}
		handrank = onepair();
		if (handrank == false) {
			return 7;
		}
		return 8;
	}
	
}
