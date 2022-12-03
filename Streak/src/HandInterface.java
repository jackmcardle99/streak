public interface HandInterface<T> {

    T deal();

    void stash(T newCard);

    T peek();

    void fill(int handSize, Deck<T> deck);  // THESE ARE NOT GENERIC TYPES ASK ADRIAN ABOUT THIS
    /*
    This method will be used to fill the hand.
     */

    void display();

    void sort(int handSize);

    void clear();
}
