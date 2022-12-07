public class Scoreboard<T extends Comparable<T>> implements QueueInterface<T>{

    // REMOVE EXTENDS COMPARABLE ABOVE
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

    public static void main(String[] args){
        Player player1 = new Player("jack", 1);
        Player player2 = new Player("lee", 4);
        Player player3 = new Player("mark", 50);
        Player player4 = new Player("patrick", 5);
        Player player5 = new Player("adam", 340);
        Player player6 = new Player("john", 40);

        Scoreboard<Player> replay = new Scoreboard<>();

        replay.enqueue(player1);
        replay.enqueue(player2);
        replay.enqueue(player3);
        replay.enqueue(player4);
        replay.enqueue(player5);
        replay.enqueue(player6);
        System.out.println(replay.getFront());
        System.out.println(replay.getNumberOfEntries());
    }

}
