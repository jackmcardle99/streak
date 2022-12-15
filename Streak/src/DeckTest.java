public class DeckTest {

    /*
    Test class for behaviour on the deck.
     */

    static Deck<Card> deck = new Deck<>();

    public static void main(String[] args){

        System.out.println("Filling 52 card deck...");
        deck.fill();
        deck.display();

        System.out.println("\nShuffling 52 card deck...");
        deck.shuffle();
        deck.display();

        System.out.println("\nClearing 52 card deck...");
        deck.clear();
        deck.display();

        System.out.println("\nRefilling and re-shuffling 52 card deck...");
        deck.fill();
        deck.shuffle();

        System.out.println("\nDealing from deck...");
        System.out.println(deck.deal());
        System.out.println(deck.deal());
        System.out.println(deck.deal());

        System.out.println("\nStashing back into deck...");
        deck.stash(new Card(1,1));
        deck.stash(new Card(1,1));
        deck.stash(new Card(1,1));
        deck.display();

        System.out.println("\nPeeking top of deck...");
        System.out.println(deck.peek());
    }
}
