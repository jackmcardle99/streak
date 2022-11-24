public class Card {

    private  int RANK, SUIT;
    private String rank,suit, colour;

    private final String[] SUITS = {"Spades ♠️", "Hearts ♥️", "Clubs ♣️", "Diamonds ♦️"};
    private final String[] RANKS = {"2","3","4","5","6","7","8","9","10","Jack","Queen","King","Ace"};

    public Card(int rank, int suit){
        this.rank = RANKS[rank];
        this.suit = SUITS[suit];
    }

    public Card(){}

    public String toString(){
        return getRank() + " of " + getSuit();
    }

    public String getRank(){
        return rank;
    }
    public String getSuit(){
        return suit;
    }



     //if suit = diamond or heart, suit = red
    //class will be used to create card objects to populate data structures
    //attributes should include - suit, colour, rank, rank value

    //accessor methods for getting the card attribute data
}
