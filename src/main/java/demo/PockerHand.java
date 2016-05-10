package demo;

import java.util.Arrays;

public class PockerHand {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int getHandRank(Card[] cards) {

		// sort cards by Value		
		Arrays.sort(cards, 
				(Card c1, Card c2)->Integer.compare(c1.getValue().rank, c2.getValue().rank)
				);

		if (isRoyalFlush(cards)) {
			return 1;
		}
		if (isFourOfAKind(cards)) {
			return 2;
		}
		if (isFullHouse(cards)) {
			return 3;
		}
		if (isStraight(cards)) {
			return 4;
		}
		if (isThreeOfAKind(cards)) {
			return 5;
		}
		if (isTwoPairs(cards)) {
			return 6;
		}
		if (isAPair(cards)) {
			return 7;
		}
		if (isFlush(cards)) {
			return 8;
		}

		return -1;
	}

	private boolean isFlush(Card[] cards) {
		Card firstCard = cards[0];
		for (int i = 1; i < cards.length; i++) {
			// same suit?
			if (cards[i].getSuit() != firstCard.getSuit())
				return false;
		}
		// else passed
		return true;
	}

	private boolean isStraight(Card[] cards) {
		Card firstCard = cards[0];
		for (int i = 1; i < cards.length; i++) {
			if (firstCard.getValue().rank + i != cards[i].getValue().rank)
				return false;
		}
		return true;
	}

	private boolean isFullHouse(Card[] cards) {
		int[] cardsMatchingValues = getMatchingCards(cards);
		boolean threeOfAKind = false;
		boolean pair = false;
		for (int i = 0; i < cardsMatchingValues.length; i++) {
			if (cardsMatchingValues[i] == 3) {
				threeOfAKind = true;
			} else if (cardsMatchingValues[i] == 2) {
				pair = true;
			}
		}
		return threeOfAKind && pair;
	}

	private boolean isTwoPairs(Card[] cards) {
		int[] cardsMatchingValues = getMatchingCards(cards);
		int twoPairs = 0;
		for (int i = 0; i < cardsMatchingValues.length; i++) {
			if (cardsMatchingValues[i] == 2) {
				twoPairs++;
			}
		}
		return twoPairs == 4;// resulted in sum of 4
	}

	private boolean isAPair(Card[] cards) {
		int[] cardsMatchingValues = getMatchingCards(cards);
		int twoPairs = 0;
		for (int i = 0; i < cardsMatchingValues.length; i++) {
			if (cardsMatchingValues[i] == 2) {
				twoPairs++;
			}
		}
		return twoPairs == 2;// resulted in sum of 4
	}

	private boolean isThreeOfAKind(Card[] cards) {
		int[] cardsMatchingValues = getMatchingCards(cards);
		for (int i = 0; i < cardsMatchingValues.length; i++) {
			if (cardsMatchingValues[i] == 3) {
				return true;
			}
		}
		return false;
	}

	private boolean isFourOfAKind(Card[] cards) {
		int[] cardsMatchingValues = getMatchingCards(cards);
		for (int i = 0; i < cardsMatchingValues.length; i++) {
			if (cardsMatchingValues[i] == 4) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Given 5 cards, returns an array of matching counts corresponding to the card position. 
	 * Single card would denote as 1. Multiple matches will denote as 2 or more. 
	 * 
	 * @param cards
	 * @return
	 */
	private int[] getMatchingCards(Card[] cards) {
		final int[] results = new int[cards.length];
		for (int i = 0; i < cards.length; i++) {
			for (int j = 0; j < cards.length; j++) {
				if (cards[i].getValue().rank == cards[j].getValue().rank) {
					results[j]++;
				}
			}
		}
		// System.out.println("begin...");
		// for(int index = 0; index < results.length; index++) {
		// System.out.println("results["+index+"]=" + results[index]);
		// }
		// System.out.println("...end...");
		return results;
	}

	private boolean isRoyalFlush(Card[] cards) {
		// checks for 10,JACK,QUEEN,KING, ACE with the same Suit
		Card firstCard = cards[0];
		if (firstCard.getValue() != Value.TEN)
			return false;
		for (int i = 1; i < cards.length; i++) {
			// same suit?
			if (cards[i].getSuit() != firstCard.getSuit())
				return false;
			// sequential?
			if (firstCard.getValue().rank + i != cards[i].getValue().rank)
				return false;
		}
		// else passed
		return true;
	}

//	private void sortCards(Card[] cards) {
//		Arrays.sort(cards, new Comparator<Card>() {
//			@Override
//			public int compare(Card o1, Card o2) {
//				return o1.getValue().rank < o2.getValue().rank ? -1 : 1;
//			}
//		});
//
//	}

}
