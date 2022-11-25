import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.EmptyStackException;

public class Hand<T> implements StackInterface<T>{
    private static final int MAX_CAPACITY = 10;
    private static final int DEFAULT_CAPACITY = 5;
    private static int numberOfCards = 0;
    MyNode<T> topNode;

    @Override
    public T deal() {
        T dataToReturn = peek();
        topNode = topNode.getNext();
        numberOfCards--;
        return dataToReturn;
    }

    @Override
    public void stash(T newCard) {
        MyNode<T> newNode = new MyNode<>(newCard);
        newNode.setNext(topNode);
        topNode = newNode;
        numberOfCards++;

    }

    @Override
    public T peek() {
        if(topNode == null) throw new EmptyStackException();
        else return topNode.getData();
    }

    @Override
    public void shuffle() {

    }

    public void quickSort(int arrSize){ //IMPLEMENTING QUICKSORT
        Card[] tempArr = new Card[arrSize];
        for(int i = 0; i < arrSize; i++){
            tempArr[i] = (Card) deal();
        }
        Card pivot = tempArr[arrSize-1];
        int indexFromLeft = 0, indexFromRight = arrSize-1;


    }

    //@Override
    public void display() {
        MyNode<T> current = topNode;
        while(current != null){
            System.out.println(current.getData());
            current = current.getNext();
        }
    }

    public int getCapacity(){
        return numberOfCards;
    }



    // include test main method to test bag methods
}
