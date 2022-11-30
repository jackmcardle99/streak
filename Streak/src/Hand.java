import java.util.EmptyStackException;

public class Hand<T> implements HandInterface<T>{
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
    public void fill(int handSize, Deck<Card> deck){
        for(int i = 0; i < handSize; i++){
            stash((T) deck.deal());
        }
    }

    private static void swap(Card[] arr, int first, int second){ // Swap method for quicksort
        Card temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }

    public Card[] toArray(int handSize){
        Card[] tempArr = new Card[handSize];
        for(int i = 0; i < handSize; i++){
            tempArr[i] = (Card) deal();
        }
        return tempArr;
    }
    public Card[] quickSort(Card[] tempArr, int first, int last){ //IMPLEMENTING QUICKSORT
        int pivot = tempArr[last].getRankValue();
        int indexFromLeft = first, indexFromRight = last;
        while(indexFromLeft <= indexFromRight){
            while(tempArr[indexFromLeft].getRankValue() < pivot) indexFromLeft++;
            while (tempArr[indexFromRight].getRankValue() > pivot) indexFromRight--;
            if(indexFromLeft <= indexFromRight) swap(tempArr, indexFromLeft++, indexFromRight--);
            if(first < indexFromRight) quickSort(tempArr, first, indexFromRight);
            if(indexFromLeft < last) quickSort(tempArr, indexFromLeft, last);
        }
        return tempArr;
    }

    public void sort(int handSize){
        arrToStack(quickSort(toArray(handSize),0, handSize-1));
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
    } // add empty stakc exception

    public int getCapacity(){
        return numberOfCards;
    } //returns current size of hand

    public int getMaxCapacity(){return MAX_CAPACITY;} // returns max size of hand

    public int getDefaultCapacity(){return  DEFAULT_CAPACITY;} // returns min size of hand

    public void clear(){
        topNode = null;
    }
}
