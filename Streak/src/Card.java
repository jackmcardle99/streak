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

    public static void main(String[] args){
        Card card1 = new Card(0,0);
        Card card2 = new Card(1,0);
        Card card3 = new Card(11,1);
        Card card4 = new Card(12,1);


        System.out.println("Card 1 is : "  + card1 + ". The colour is " + card1.getColour() + ". The suit is " + card1.getSuit() + " and the value is " + card1.getRankValue());
        System.out.println("Card 2 is : "  + card2 + ". The colour is " + card2.getColour() +  ". The suit is " + card2.getSuit() + " and the value is " + card2.getRankValue());
        System.out.println("Card 3 is : "  + card3 + ". The colour is " + card3.getColour() +  ". The suit is " + card3.getSuit() + " and the value is " + card3.getRankValue());
        System.out.println("Card 4 is : "  + card4 + ". The colour is " + card4.getColour() +  ". The suit is " + card4.getSuit() +" and the value is " + card4.getRankValue());

        if(card1.compareTo(card2) > 0) System.out.println("\nCard one is higher than card two.");
        else System.out.println("\nCard one is lower than card two.");

        if(card3.compareTo(card2) > 0) System.out.println("\nCard three is higher than card two.");
        else System.out.println("\nCard three is lower than card two.");


    }
}
