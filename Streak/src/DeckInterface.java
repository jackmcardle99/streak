public interface DeckInterface<T> {
    /*
    This interface contains behaviours for manipulating the stack.
     */

    T deal();
    /*
    This method is the equivalent of pop(). It removes an item from the top of the stack.
     */

    void stash(T newCard);
    /*
    This method is the equivalent of push(). It adds an item on top of the stack.
     */

    T peek();
    /*
    This method allows for viewing the top item of the stack without adding or removing it.
     */

    void fill();
    /*
    This method allows for filling the deck back to 52 cards.
     */

    void shuffle();
    /*
    This method shuffles the contents of the stack.
     */

    void display();
    /*
    This method displays the contents of the stack.
     */

    void clear();
    /*
    This method clears the contents of the stack, creating an empty stack.
     */
}
