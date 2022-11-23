import java.util.EmptyStackException;

public class Deck<T> implements StackInterface<T>{
    static int numberOfCards = 0;
    int MAX_CAPACITY = 52; //max cards allowed in deck
    //Card[] deck; // array for deck, each element is card object
    MyNode<T> topNode;


    public Deck(){topNode=null;}
    public T deal() { //stack.pop
       T dataToReturn = peek();
       topNode = topNode.getNext();
       numberOfCards--;
       return dataToReturn;
    }

    @Override
    public void stash(T newCard) { //stack.push
        MyNode<T> newNode = new MyNode<>(newCard);
        newNode.setNext((topNode));
        topNode = newNode;
        numberOfCards++;
    }

    @Override
    public T peek() {
        if(topNode == null) throw new EmptyStackException(); //if the stack is empty then pass this exception
        else return topNode.getData(); //else show the data of the top node
    }

    @Override
    public void shuffle() {

    }

    public void clear(){
        topNode = null;
    }

    public int getCapacity(){
        return numberOfCards;
    }
    /*
    - this class will contain the methods for behaviours on deck of cards
    - should have max capacity of 52 cards
    - implemented as array stack

    include test main method to test stack methods
     */

}
