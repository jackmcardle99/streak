public class Replay<T> implements ReplayInterface<T>{

    private MyNode<T> front, rear;
    private static int numberOfEntries= 0;
    public Replay(){
        front = null;
        rear = null;
    }
    @Override
    public void enqueue(T anEntry) {
        MyNode<T> newNode = new MyNode<>(anEntry);
        if(isEmpty()){
            front = newNode;
            rear = newNode;
        }else {
            rear.setNext(newNode);
            rear = newNode;
        }
        numberOfEntries++;
    }

    @Override
    public T dequeue() {
        if(isEmpty()) return null;
        else {
            T valueToReturn = front.getData();
            front = front.getNext();
            if(isEmpty()) rear = null;
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
        rear = null;
    }

//    public void display(){
//        Hand<Card> hand = new Hand<>();
//        for(int i = 0; i < getNumberOfEntries(); i++){
//            getFront();
//        }
//    }
    public int getNumberOfEntries(){
        return numberOfEntries;
    }

    public static void main(String[] args){
        Replay<String> queue = new Replay<String>();

        queue.enqueue("Milk");
        queue.enqueue("Eggs");
        queue.enqueue("Bread");

        for(int i = 1; i <= 4; i++){
            System.out.println("Get front = " + queue.getFront());
            System.out.println("Dequeue = " + queue.dequeue());
        }

        queue.enqueue("Cheese");
        queue.enqueue("Steak");
        queue.enqueue("Fish");
        System.out.println("Queue empty is " + queue.isEmpty());
        queue.clear();
        System.out.println("Queue empty is " + queue.isEmpty());


    }
    /*
    this class will be responsible for storing the played cards from single player game. When card is popped from
    single-player game it is stored in this stack to show all played cards at the end.
     */
}
