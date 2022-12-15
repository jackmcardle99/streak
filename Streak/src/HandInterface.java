public interface HandInterface<T> {
    /*
    This interface details the behaviours than can be used on the hand stack.
     */

    T deal();
    /*
    Equivalent to stack.pop(). This method is used for popping an element from the stack.
     */

    void stash(T newCard);
     /*
    This method is the equivalent of push(). It adds an item on top of the stack.
     */

    T peek();
     /*
    This method allows for viewing the top item of the stack without adding or removing it.
     */

    void fill(int handSize, Deck<T> deck);
    /*
    This method will be used to fill the hand.
     */

    void display();
     /*
    This method displays the contents of the stack.
     */

    void sort(int handSize);
    /*
    This method sorts the contents of the stack.
     */

    void clear();
    /*
    This method clears the contents of the stack, creating an empty stack.
     */
}
