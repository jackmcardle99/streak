public interface DeckInterface<T> {
    /*
    This interface contains behaviours for manipulating the stack.
    - pop (deal)
    - push (stash)
    - shuffle deck
    - count cards
    look into other needed methods
     */

    public T deal();
    /*
    This method is the equivalent of pop(). It removes an item from the top of the stack.
     */

    public void stash(T newCard);
    /*
    This method is the equivalent of push(). It adds an item on top of the stack.
     */

    public T peek();
    /*
    This method allows for viewing the top item of the stack without adding or removing it.
     */

    public void shuffle();
    /*
    This method shuffles the contents of the stack.
     */

    public void display();
    /*
    This method displays the contents of the stack.
     */

    public void clear();
    /*
    This method clears the contents of the stack, creating an empty stack.
     */
}
