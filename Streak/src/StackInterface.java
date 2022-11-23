public interface StackInterface<T> {
    /*
    this interface should contain behaviours for manipulating the stack
    - pop (deal)
    - push (stash)
    - shuffle deck
    - count cards
    look into other needed methods
     */

    public T deal();
    /*
    this method is the equivalent
     */

    public void stash(T newCard);

    public T peek();

    public void shuffle();


}
