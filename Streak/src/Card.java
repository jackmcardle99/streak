public class Card implements Comparable<Card> {

    /*
    This class is the blueprint for creating card objects, and accessor methods for accessing values. This class
    implements the comparable interface to allow numerical comparisons between rank values for sorting and determining
    the longest streak the player can obtain.
     */
    private final int RANK, SUIT;
    private final String[] SUITS = {"Spades ♠️", "Hearts ♥️", "Clubs ♣️", "Diamonds ♦️"};
    private final String[] RANKS = {"2","3","4","5","6","7","8","9","10","Jack","Queen","King","Ace"};

    public Card(int rank, int suit){
        RANK = rank;
        SUIT = suit;
    }

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
        if(this.getSuit().equals(SUITS[0]) || this.getSuit().equals(SUITS[2])) return "black";
        else return "red";
    }

    public int getRankValue(){
        return RANK;
    }

    @Override
    public int compareTo(Card otherCard) {
        if(getRankValue() == otherCard.getRankValue()) return 0;
        else if (getRankValue() == otherCard.getRankValue() -1) return -1;
        else return 1;
    }
}
