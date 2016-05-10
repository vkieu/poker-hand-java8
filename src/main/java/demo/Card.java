package demo;

public class Card {
	private final Suit suit;
	private final Value value;
	public Card (Suit suit, Value value) {
		this.suit = suit;
		this.value = value;
	}
	public Suit getSuit() {
		return suit;
	}
	public Value getValue() {
		return value;
	}
}


enum Suit {
	HEART, DIMOND, SPADE, CLUB;
}

enum Value {
	TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7), EIGHT(8), NINE(9), TEN(10), 
	JACK(11), QUEEN(12), KING(13), ACE(14);
	public final int rank;

	private Value(int rank) {
		this.rank = rank;
	}
}