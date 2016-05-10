package demo;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PokerHandTest {
	PockerHand app;
	
	@Before
	public void setUp() throws Exception {
		app = new PockerHand();
	}
	@Test
	public void testGetHandRank_nothing() {		
		Card[] cards = new Card[] {
				new Card(Suit.CLUB, Value.ACE),
				new Card(Suit.SPADE, Value.KING),
				new Card(Suit.CLUB, Value.TWO),
				new Card(Suit.CLUB, Value.FIVE),
				new Card(Suit.CLUB, Value.TEN)						
			};
		
		
		int handRank = app.getHandRank(cards);
		assertEquals(-1, handRank);
	}
	
	@Test
	public void testGetHandRank_royalFlush() {		
		Card[] cards = new Card[] {
				new Card(Suit.CLUB, Value.ACE),
				new Card(Suit.CLUB, Value.KING),
				new Card(Suit.CLUB, Value.TEN),
				new Card(Suit.CLUB, Value.QUEEN),
				new Card(Suit.CLUB, Value.JACK)						
			};
		
		
		int handRank = app.getHandRank(cards);
		assertEquals(1, handRank);
	}

	@Test
	public void testGetHandRank_FourOfAKind() {		
		Card[] cards = new Card[] {
				new Card(Suit.CLUB, Value.ACE),
				new Card(Suit.SPADE, Value.ACE),
				new Card(Suit.DIMOND, Value.ACE),
				new Card(Suit.HEART, Value.ACE),
				new Card(Suit.CLUB, Value.TEN),
			};
		
		
		int handRank = app.getHandRank(cards);
		Assert.assertEquals(2, handRank);
	}
	@Test
	public void testGetHandRank_fullHouse() {		
		Card[] cards = new Card[] {
				new Card(Suit.CLUB, Value.ACE),
				new Card(Suit.SPADE, Value.ACE),
				new Card(Suit.DIMOND, Value.TEN),
				new Card(Suit.HEART, Value.TEN),
				new Card(Suit.CLUB, Value.TEN),
			};
		
		
		int handRank = app.getHandRank(cards);
		Assert.assertEquals(3, handRank);
	}
	
	@Test
	public void testGetHandRank_Straight() {		
		Card[] cards = new Card[] {
				new Card(Suit.CLUB, Value.ACE),
				new Card(Suit.SPADE, Value.KING),
				new Card(Suit.CLUB, Value.TEN),
				new Card(Suit.CLUB, Value.QUEEN),
				new Card(Suit.CLUB, Value.JACK)						
			};
		
		
		int handRank = app.getHandRank(cards);
		assertEquals(4, handRank);
	}
	
	@Test
	public void testGetHandRank_ThreeOfAKind() {		
		Card[] cards = new Card[] {
				new Card(Suit.CLUB, Value.ACE),
				new Card(Suit.SPADE, Value.ACE),
				new Card(Suit.DIMOND, Value.ACE),
				new Card(Suit.HEART, Value.TWO),
				new Card(Suit.CLUB, Value.TEN),
			};
		
		
		int handRank = app.getHandRank(cards);
		Assert.assertEquals(5, handRank);
	}
	
	@Test
	public void testGetHandRank_twoPairs() {		
		Card[] cards = new Card[] {
				new Card(Suit.CLUB, Value.ACE),
				new Card(Suit.SPADE, Value.ACE),
				new Card(Suit.DIMOND, Value.TEN),
				new Card(Suit.HEART, Value.TEN),
				new Card(Suit.CLUB, Value.TWO),
			};
		
		
		int handRank = app.getHandRank(cards);
		Assert.assertEquals(6, handRank);
	}
	
	@Test
	public void testGetHandRank_APairs() {		
		Card[] cards = new Card[] {
				new Card(Suit.CLUB, Value.ACE),
				new Card(Suit.SPADE, Value.ACE),
				new Card(Suit.DIMOND, Value.TEN),
				new Card(Suit.HEART, Value.JACK),
				new Card(Suit.CLUB, Value.TWO),
			};
		
		
		int handRank = app.getHandRank(cards);
		Assert.assertEquals(7, handRank);
	}
	
	@Test
	public void testGetHandRank_isFlush() {		
		Card[] cards = new Card[] {
				new Card(Suit.CLUB, Value.ACE),
				new Card(Suit.CLUB, Value.TWO),
				new Card(Suit.CLUB, Value.THREE),
				new Card(Suit.CLUB, Value.JACK),
				new Card(Suit.CLUB, Value.KING),
			};
		
		
		int handRank = app.getHandRank(cards);
		Assert.assertEquals(8, handRank);
	}

}
