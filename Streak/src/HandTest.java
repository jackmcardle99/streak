public class HandTest {

    /*
    This test class tests all the methods from the HandInterface class to ensure that they work as intended.
     */
    static Deck<Card> deck = new Deck<>();
    static Hand<Card> hand = new Hand<>();

    public static void main(String[] args){
        deck.fill();
        hand.fill(5,deck);
        System.out.println("\nDisplaying hand of 5 cards from un-shuffled deck...");
        hand.display();
        deck.clear();
        deck.fill();
        deck.shuffle();
        hand.clear();
        hand.fill(10,deck);
        System.out.println("\nDisplaying hand of 10 cards from shuffled deck...");
        hand.display();
        System.out.println("\nSorting hand...");
        hand.sort(10);
        hand.display();

        System.out.println("\nRemoving top card from hand...");
        hand.deal();
        hand.display();

        System.out.println("\nAdding a card to hand...");
        hand.stash(new Card(3,3));
        hand.display();

        System.out.println("\nPeeking at the top of the hand...");
        System.out.println(hand.peek());
    }
}
