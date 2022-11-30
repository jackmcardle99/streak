public interface HandInterface<T> {

    public T deal();

    public void stash(T newCard);

    public T peek();

    public void fill(int handSize, Deck<Card> deck);  // THESE ARE NOT GENERIC TYPES
    /*
    This method will be used to fill the hand.
     */

    public void display();

    //void fill(int handSize, Deck<Card> deck);

    public void sort();

    public void clear();
}
