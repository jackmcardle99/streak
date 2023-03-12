import java.util.EmptyStackException;

public class Hand<T> implements HandInterface<T>{
    /*
    This class is an implementation of the hand interface, and is a stack implemented as a singly linked list. It
    holds upto 10 cards.
     */
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
    public void fill(int handSize, Deck<T> deck){
        for(int i = 0; i < handSize; i++){
            stash(deck.deal());
        }
    }

    public Card[] toArray(int handSize){
        Card[] tempArr = new Card[handSize];
        for(int i = 0; i < handSize; i++){
            tempArr[i] = (Card) deal();
        }
        return tempArr;
    }

    private Card[] insertionSort(Card[] tempArr){
        Card nextToInsert;
        int index;

        for(int i = 1; i<tempArr.length; i++){
            nextToInsert = tempArr[i];
            index = i -1;
            while(index >= 0 && tempArr[index].getRankValue() > nextToInsert.getRankValue()){
                tempArr[index + 1] = tempArr[index];
                index--;
            }
            tempArr[index + 1] = nextToInsert;
        }
        return tempArr;
    }

    public void sort(int handSize){
        arrToStack(insertionSort(toArray(handSize)));
    }

    public void arrToStack(Card[] arr){
        for (int i = arr.length-1; i >= 0; i--) {
            stash((T) arr[i]); // array of cards put back into stack in ascending order
        }
    }

    //@Override
    public void display() {
        MyNode<T> current = topNode;
        char c = (char)65; //ascii value for A https://www.cs.cmu.edu/~pattis/15-1XX/common/handouts/ascii.html
        while(current != null){
            System.out.println(c+" : " + current.getData());
            c++; // increment char ascii value by 1 each time A,B,C,D,E... etc
            current = current.getNext();
        }
//        return false; // not exactly sure why I need to return false here - line 86 in streak class is the cause
    } // add empty stakc exception

    public boolean isEmpty(){
        return topNode==null;
    }

    public int getCapacity(){
        return numberOfCards;
    } //returns current size of hand

    public int getMaxCapacity(){return MAX_CAPACITY;} // returns max size of hand

    public int getDefaultCapacity(){return  DEFAULT_CAPACITY;} // returns min size of hand

    public void clear(){
        topNode = null;
    }
}
