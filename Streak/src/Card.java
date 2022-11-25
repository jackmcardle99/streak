public class Card implements Comparable<Card> {

    private  int RANK, SUIT;

    private final String[] SUITS = {"Spades ♠️", "Hearts ♥️", "Clubs ♣️", "Diamonds ♦️"};
    private final String[] RANKS = {"2","3","4","5","6","7","8","9","10","Jack","Queen","King","Ace"};

    public Card(int rank, int suit){
        //this.rank = RANKS[rank];
        //this.suit = SUITS[suit];
        RANK = rank;
        SUIT = suit;
    }

    public Card(){}

    public String toString(){
        return getRank() + " of " + getSuit();
    }

    public String getRank(){
        return RANKS[RANK];
    }
    public String getSuit(){
        return SUITS[SUIT];
    }

    public String getColour(){
        if (getSuit().equals(SUITS[0]) || getSuit().equals(SUITS[2])) return "black";
        else return "red";
    }

    public int getRankValue(){
        return RANK;
    }


    @Override
    public int compareTo(Card otherCard) {
        if(this.getRankValue() < otherCard.getRankValue()) return -1;
        else if (this.getRankValue() > otherCard.getRankValue()) return 1;
        else return 0;
    }


    //if suit = diamond or heart, suit = red
    //class will be used to create card objects to populate data structures
    //attributes should include - suit, colour, rank, rank value

    //accessor methods for getting the card attribute data
}
