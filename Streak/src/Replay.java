public class Replay<T> implements QueueInterface<T> {
    /*
        this class will be responsible for storing the played cards from single player game. When card is popped from
        single-player game it is stored in this stack to show all played cards at the end.
         */
    private MyNode<T> front, rear;
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

    public static void main(String[] args){
        Replay<String> replay = new Replay<>();

        replay.enqueue("Milk");
        replay.enqueue("Eggs");
        replay.enqueue("Bread");

        for(int i = 1; i <= 4; i++){
            System.out.println("Get front = " + replay.getFront());
            System.out.println("Dequeue = " + replay.dequeue());
        }

        replay.enqueue("Cheese");
        replay.enqueue("Steak");
        replay.enqueue("Fish");
        System.out.println("Queue empty is " + replay.isEmpty());
        replay.clear();
        System.out.println("Queue empty is " + replay.isEmpty());


    }

}
