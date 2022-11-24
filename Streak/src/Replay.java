public class Replay<T> implements StackInterface<T>{
    @Override
    public T deal() {
        return null;
    }

    @Override
    public void stash(T newCard) {
    }

    @Override
    public T peek() {
        return null;
    }

    @Override
    public void shuffle() {

    }

    @Override
    public void display() {

    }

    /*
    this class will be responsible for storing the played cards from single player game. When card is popped from
    single-player game it is stored in this stack to show all played cards at the end.
     */
}
