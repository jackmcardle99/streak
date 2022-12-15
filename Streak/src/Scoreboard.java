public class Scoreboard<T extends Comparable<T>> implements QueueInterface<T>{
    /*
    This class is the implementation of the priority queue structure. It is implemented as a singly linked list.
     */
    private MyNode<T> front;

    private int numberOfEntries = 0;

    public Scoreboard(){
        front = null;
    }

    @Override
    public void enqueue(T newEntry) {
        MyNode<T> newNode = new MyNode<>(newEntry);
        if(isEmpty()) front = newNode;
        else if (front.getData().compareTo(newEntry)  < 0){
            newNode.setNext(front);
            front = newNode;
        }
        else {
            MyNode<T> currentNode = front;
            while(currentNode.getNext() != null && currentNode.getNext().getData().compareTo(newEntry) > 0){
                currentNode = currentNode.getNext();
            }
            newNode.setNext(currentNode.getNext());
            currentNode.setNext(newNode);
        }
        numberOfEntries++;
    }

    @Override
    public T dequeue() {
        if(isEmpty()) return null;
        else {
            T valueToReturn = front.getData();
            front = front.getNext();
            numberOfEntries--;
            return valueToReturn;
        }
    }

    @Override
    public T getFront() {
        if(isEmpty()) return null;
        else return front.getData();
    }

    @Override
    public boolean isEmpty() {
        return (front == null);
    }

    @Override
    public void clear() {
        front = null;
        numberOfEntries = 0;
    }

    public int getNumberOfEntries(){
        return numberOfEntries;
    }

}
