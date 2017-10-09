package poker;

import static org.junit.Assert.*;
import org.junit.Test;

public class StudentTests {
	
	@Test
	public void hasPairTest() { 
		PokerHandEvaluator testerClass = new PokerHandEvaluator();
		Card[] tester = new Card[5];
		tester[0] = new Card(1, 1);
		tester[1] = new Card(1, 0);
		tester[2] = new Card(12, 2);
		tester[3] = new Card(7, 0);
		tester[4] = new Card(6, 0);
		assertTrue(testerClass.hasPair(tester));
		tester[1] = new Card(2, 0);
		assertTrue(testerClass.hasPair(tester) == false);
		
	}

	@Test
	public void hasTwoPairTest() {
		PokerHandEvaluator testerClass = new PokerHandEvaluator();
		Card[] tester = new Card[5];
		tester[0] = new Card(1, 1);
		tester[1] = new Card(6, 0);
		tester[2] = new Card(12, 2);
		tester[3] = new Card(6, 2);
		tester[4] = new Card(1, 0);
		assertTrue(testerClass.hasTwoPair(tester));
		tester[1] = new Card(7, 0);
		assertTrue(testerClass.hasTwoPair(tester) == false);
	}
	@Test
	public void hasThreeOfAKindTest() {
		PokerHandEvaluator testerClass = new PokerHandEvaluator();
		Card[] tester = new Card[5];
		tester[0] = new Card(1, 1);
		tester[1] = new Card(1, 0);
		tester[2] = new Card(1, 2);
		tester[3] = new Card(6, 1);
		tester[4] = new Card(6, 0);
		assertTrue(testerClass.hasThreeOfAKind(tester));
		tester[2] = new Card(7, 0);
		assertTrue(testerClass.hasThreeOfAKind(tester) == false);
	}
	@Test
	public void hasStraightTest() {
		PokerHandEvaluator testerClass = new PokerHandEvaluator();
		Card[] tester = new Card[5];
		tester[0] = new Card(1, 1);
		tester[1] = new Card(2, 0);
		tester[2] = new Card(3, 2);
		tester[3] = new Card(5, 1);
		tester[4] = new Card(4, 0);
		assertTrue(testerClass.hasStraight(tester));
		tester[2] = new Card(7, 0);
		assertTrue(testerClass.hasStraight(tester) == false);
	}
	@Test
	public void hasFlushTest() {
		PokerHandEvaluator testerClass = new PokerHandEvaluator();
		Card[] tester = new Card[5];
		tester[0] = new Card(1, 0);
		tester[1] = new Card(2, 0);
		tester[2] = new Card(3, 0);
		tester[3] = new Card(4, 0);
		tester[4] = new Card(5, 0);
		assertTrue(testerClass.hasFlush(tester));
		tester[2] = new Card(7, 2);
		assertTrue(testerClass.hasFlush(tester) == false);
	} 
	@Test
	public void hasFullHouseTest() {
		PokerHandEvaluator testerClass = new PokerHandEvaluator();
		Card[] tester = new Card[5];
		tester[0] = new Card(1, 0);
		tester[1] = new Card(1, 2);
		tester[2] = new Card(5, 3);
		tester[3] = new Card(5, 1);
		tester[4] = new Card(5, 0);
		assertTrue(testerClass.hasFullHouse(tester));
		tester[2] = new Card(7, 2);
		assertTrue(testerClass.hasFullHouse(tester) == false);
	} 
	@Test
	public void hasFourOfAKindTest() {
		PokerHandEvaluator testerClass = new PokerHandEvaluator();
		Card[] tester = new Card[5];
		tester[0] = new Card(1, 0);
		tester[1] = new Card(5, 2);
		tester[2] = new Card(5, 3);
		tester[3] = new Card(5, 1);
		tester[4] = new Card(5, 0);
		assertTrue(testerClass.hasFourOfAKind(tester));
		tester[2] = new Card(7, 2);
		assertTrue(testerClass.hasFourOfAKind(tester) == false);
	} 
	@Test
	public void hasStraightFlushTest() {
		PokerHandEvaluator testerClass = new PokerHandEvaluator();
		Card[] tester = new Card[5];
		tester[0] = new Card(4, 0);
		tester[1] = new Card(2, 0);
		tester[2] = new Card(3, 0);
		tester[3] = new Card(5, 0);
		tester[4] = new Card(6, 0);
		assertTrue(testerClass.hasStraightFlush(tester));
		tester[2] = new Card(7, 2);
		assertTrue(testerClass.hasStraightFlush(tester) == false);
	} 	
	

}
