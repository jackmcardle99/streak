import java.util.EmptyStackException;
import java.util.Random;
import java.util.random.*;

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
    public void shuffle() {  // Fisher-Yates shuffle, O(n) time complexity
        Card[] tempArray = new Card[52];
        for(int i = 0; i < 52;i++){
            tempArray[i] = (Card) deal(); //first step is to pop cards into array for shuffling
        }
        Random ran = new Random();
        for(int i = tempArray.length-1; i >= 1; i--){ // loop from n-1 to 1
            int j = ran.nextInt(i+1);
//            Card temp = tempArray[i];
            tempArray[i] = tempArray[j]; //swap element [i] with element [j](random number)
            tempArray[j] = tempArray[i];
        }
        for (Card card : tempArray) { //after shuffle, push cards onto deck
            stash((T) card);
        }
    }

    @Override
    public void display() {
        MyNode<T> current = topNode;
        while(current != null){
            System.out.println(current.getData());
            current = current.getNext();
        }
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
    include test main method to test stack methods
     */

}
