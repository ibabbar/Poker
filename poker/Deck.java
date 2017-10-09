package poker;

public class Deck {

	private Card[] cards;

	public Deck() {
		this.cards = new Card[52];
		int cardCounter = 0;
		for (int suit = 0; suit < 4; suit++){
			for (int value = 1; value < 14; value ++) {
			cards[cardCounter] = new Card(value, suit);
			cardCounter++;
			}
		}
		
	}

	public Deck(Deck other) {
		this.cards = new Card[other.cards.length];
		for (int x = 0; x < other.getNumCards(); x++) {
			this.cards[x] = new Card(other.cards[x].getValue(), other.cards[x].getSuit());
		}
	}

	public Card getCardAt(int position) {
		return cards[position];
	}

	public int getNumCards() {
		return cards.length;
	}

	public void shuffle() {
		Card[] bottomHalf = new Card[cards.length / 2];
		Card[] topHalf = new Card[cards.length / 2 + cards.length % 2];
		
		
		// separating them
		for (int y = 0; y < cards.length / 2; y++) {
			topHalf[y] = new Card(cards[y].getValue(), cards[y].getSuit()); 
			bottomHalf[y] = new Card(cards[y + cards.length / 2 + cards.length % 2].getValue(), cards[y + cards.length / 2 + cards.length % 2].getSuit()); 
		}
		if(cards.length % 2 == 1) {
			topHalf[topHalf.length - 1] = new Card(cards[cards.length / 2].getValue(), cards[cards.length / 2].getSuit());
		}
		
		// shuffling them
		int y = 0;
		for (int x = 0; x < cards.length - cards.length % 2; x = x + 2) {
			cards[x] = new Card(topHalf[y].getValue(), topHalf[y].getSuit());
			cards[x + 1] = new Card(bottomHalf[y].getValue(), bottomHalf[y].getSuit());
			y++;
		}
		if(cards.length % 2 == 1) {
			cards[cards.length - 1] = new Card(topHalf[cards.length / 2].getValue(), cards[cards.length / 2].getSuit());
		}
	}

	public void cut(int position) {
		Card[] cut = new Card[position];
		
		//cutting the cards
		for (int x = 0; x < position; x++) {
			cut[x] = new Card(cards[x].getValue(), cards[x].getSuit());	
		}
		
		// replacing 
		for (int value = 0; value < cards.length - cut.length; value++) {
			cards[value] =  new Card(cards[value + cut.length].getValue(), cards[value + cut.length].getSuit());
		}
		
		//putting the cut cards back to the pile
		for (int z = 0; z < cut.length; z++) {
			cards[z + cards.length - cut.length] = new Card(cut[z].getValue(), cut[z].getSuit());
		}
	}

	public Card[] deal(int numCards) {
		Card[] deal = new Card[numCards];
		Card[] smaller = new Card[cards.length-numCards];
		
		//taking the top cards
		for (int j = 0; j < numCards; j++) {
			deal[j] = cards[j];
		}
		
		//reorganising the deck
		for (int w = 0; w < cards.length - numCards; w++) {
			smaller[w] = cards[numCards + w];
		}
		cards = new Card[cards.length - numCards];
		for (int w = 0; w < smaller.length; w++) {
			cards[w] = smaller[w];
		}
	return deal;		
	}
		
}
