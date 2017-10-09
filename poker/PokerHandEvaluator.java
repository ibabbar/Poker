package poker;

public class PokerHandEvaluator {

	public static boolean hasPair(Card[] cards) {

		if (cards.length != 5) {
			return false;
		}
		Card[] sorted = new Card[cards.length];
		boolean exists = false;
		boolean firstPossibility, secondPossibility, thirdPossibility, fourthPossibility;
		for (int d = 0; d < sorted.length; d++) {
			sorted[d] = new Card(sortByValue(cards)[d].getValue(), sortByValue(cards)[d].getSuit());
		}
		firstPossibility = sorted[0].getValue() == sorted[1].getValue();
		secondPossibility = sorted[1].getValue() == sorted[2].getValue();
		thirdPossibility = sorted[2].getValue() == sorted[3].getValue();
		fourthPossibility = sorted[3].getValue() == sorted[4].getValue();
		if (firstPossibility || secondPossibility || thirdPossibility || fourthPossibility) {
			exists = true;
		}
		return exists;
	}

	public static boolean hasTwoPair(Card[] cards) {

		if (cards.length != 5) {
			return false;
		}

		boolean exists = false;
		Card[] sorted = new Card[cards.length];
		boolean firstPossibility, secondPossibility, thirdPossibility;
		for (int d = 0; d < sorted.length; d++) {
			sorted[d] = new Card(sortByValue(cards)[d].getValue(), sortByValue(cards)[d].getSuit());
		}
		firstPossibility = sorted[0].getValue() == sorted[1].getValue() && sorted[2].getValue() == sorted[3].getValue();
		secondPossibility = sorted[0].getValue() == sorted[1].getValue()
				&& sorted[3].getValue() == sorted[4].getValue();
		thirdPossibility = sorted[1].getValue() == sorted[2].getValue() && sorted[3].getValue() == sorted[4].getValue();
		if (firstPossibility || secondPossibility || thirdPossibility || hasFourOfAKind(cards)) {
			exists = true;
		}
		return exists;
	}

	public static boolean hasThreeOfAKind(Card[] cards) {
		if (cards.length != 5) {
			return false;
		}

		boolean exists = false;
		Card[] sorted = new Card[cards.length];

		for (int d = 0; d < sorted.length; d++) {
			sorted[d] = new Card(sortByValue(cards)[d].getValue(), sortByValue(cards)[d].getSuit());
		}
		boolean firstPossibility = sorted[0].getValue() == sorted[1].getValue()
				&& sorted[1].getValue() == sorted[2].getValue();

		boolean secondPossibility = sorted[1].getValue() == sorted[2].getValue()
				&& sorted[2].getValue() == sorted[3].getValue();

		boolean thirdPossibility = sorted[2].getValue() == sorted[3].getValue()
				&& sorted[3].getValue() == sorted[4].getValue();

		if (firstPossibility || secondPossibility || thirdPossibility) {
			exists = true;
		}
		return exists;
	}

	public static boolean hasStraight(Card[] cards) {

		if (cards.length != 5) {
			return false;
		}
		boolean exists = false;
		Card[] sorted = new Card[cards.length];
		for (int d = 0; d < sorted.length; d++) {
			sorted[d] = new Card(sortByValue(cards)[d].getValue(), sortByValue(cards)[d].getSuit());
		}
		if (sorted[0].getValue() == 1) {
			// for ace
			boolean firstPossibility = sorted[1].getValue() == 2 && sorted[2].getValue() == 3
					&& sorted[3].getValue() == 4 && sorted[4].getValue() == 5;
			boolean secondPossibility = sorted[1].getValue() == 10 && sorted[2].getValue() == 11
					&& sorted[3].getValue() == 12 && sorted[4].getValue() == 13;

			if (firstPossibility || secondPossibility) {
				exists = true;
			}
		} else {
			int cardValue = sorted[0].getValue() + 1;
			int counter = 0;
			for (int i = 1; i < sorted.length; i++) {
				if (cardValue != sorted[i].getValue()) {
					exists = false;
					break;
				}
				cardValue++;
				counter++;
			}
			if (counter == 4) {
				exists = true;
			}
		}
		return exists;
	}

	public static boolean hasFlush(Card[] cards) {
		if (cards.length != 5) {
			return false;
		}

		boolean exists = false;
		Card[] sorted = new Card[cards.length];
		for (int d = 0; d < sorted.length; d++) {
			sorted[d] = new Card(sortBySuit(cards)[d].getValue(), sortBySuit(cards)[d].getSuit());
		}
		if (sorted[0].getSuit() == sorted[cards.length - 1].getSuit()) {
			exists = true;
		}
		return exists;
	}

	public static boolean hasFullHouse(Card[] cards) {
		if (cards.length != 5) {
			return false;
		}
		boolean exists = false;
		Card[] sorted = new Card[cards.length];
		for (int d = 0; d < sorted.length; d++) {
			sorted[d] = new Card(sortByValue(cards)[d].getValue(), sortByValue(cards)[d].getSuit());
		}

		boolean firstPossibility = sorted[0].getValue() == sorted[1].getValue()
				&& sorted[1].getValue() == sorted[2].getValue() && sorted[3].getValue() == sorted[4].getValue();

		boolean secondPossibility = sorted[0].getValue() == sorted[1].getValue()
				&& sorted[2].getValue() == sorted[3].getValue() && sorted[3].getValue() == sorted[4].getValue();

		if (firstPossibility || secondPossibility) {
			exists = true;
		}

		return exists;
	}

	public static boolean hasFourOfAKind(Card[] cards) {
		if (cards.length != 5) {
			return false;
		}

		boolean exists = false;
		Card[] sorted = new Card[cards.length];

		for (int d = 0; d < sorted.length; d++) {
			sorted[d] = new Card(sortByValue(cards)[d].getValue(), sortByValue(cards)[d].getSuit());
		}

		boolean firstPossibility = sorted[0].getValue() == sorted[1].getValue()
				&& sorted[1].getValue() == sorted[2].getValue() && sorted[2].getValue() == sorted[3].getValue();
		boolean secondPossibility = sorted[1].getValue() == sorted[2].getValue()
				&& sorted[2].getValue() == sorted[3].getValue() && sorted[3].getValue() == sorted[4].getValue();

		if (firstPossibility || secondPossibility) {
			exists = true;
		}
		return exists;
	}

	public static boolean hasStraightFlush(Card[] cards) {
		boolean exists = false;

		if (cards.length != 5) {
			return false;
		}

		if (hasStraight(cards) && hasFlush(cards)) {
			exists = true;
		}
		return exists;
	}

	public static Card[] sortByValue(Card[] cards) {
		Card temp;
		Card[] sorted = new Card[cards.length];
		for (int d = 0; d < sorted.length; d++) {
			sorted[d] = new Card(cards[d].getValue(), cards[d].getSuit());
		}
		for (int i = 0; i < cards.length; i++) {
			for (int j = i + 1; j < cards.length; j++) {
				if (sorted[i].getValue() > sorted[j].getValue()) {
					temp = new Card(sorted[i].getValue(), sorted[i].getSuit());
					sorted[i] = new Card(sorted[j].getValue(), sorted[j].getSuit());
					sorted[j] = new Card(temp.getValue(), temp.getSuit());
				}
			}
		}
		return sorted;
	}

	public static Card[] sortBySuit(Card[] cards) {
		Card temp;
		Card[] sorted = new Card[cards.length];
		for (int d = 0; d < sorted.length; d++) {
			sorted[d] = new Card(cards[d].getValue(), cards[d].getSuit());
		}
		for (int i = 0; i < cards.length; i++) {
			for (int j = i + 1; j < cards.length; j++) {
				if (sorted[i].getSuit() > sorted[j].getSuit()) {
					temp = new Card(sorted[i].getValue(), sorted[i].getSuit());
					sorted[i] = new Card(sorted[j].getValue(), sorted[j].getSuit());
					sorted[j] = new Card(temp.getValue(), temp.getSuit());
				}
			}
		}
		return sorted;
	}

}
