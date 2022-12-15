public class QueueTest {

    /*
    This class is for testing the queue and priority queue data structures.
     */

    static Scoreboard<Integer> scoreboard = new Scoreboard<>();
    static Replay<String> replay = new Replay<>();

    public static void main(String[] args){
        testPQueue();
        testQueue();
    }

    public static void testPQueue(){
        System.out.println("Enqueuing 1\n");
        scoreboard.enqueue(1);
        System.out.println("Enqueuing 6\n");
        scoreboard.enqueue(6);
        System.out.println("Enqueuing 14\n");
        scoreboard.enqueue(14);
        System.out.println("Enqueuing 12\n");
        scoreboard.enqueue(12);

        System.out.println("\nGetting front of PQueue.");
        System.out.println(scoreboard.getFront());
        System.out.println("\nDe-queueing front of PQueue");
        scoreboard.dequeue();
        System.out.println("\nGetting front of PQueue.");
        System.out.println(scoreboard.getFront());
        System.out.println("\nDe-queueing front of PQueue");
        scoreboard.dequeue();
        System.out.println("\nGetting front of PQueue.");
        System.out.println(scoreboard.getFront());
        System.out.println("\nDe-queueing front of PQueue");
        scoreboard.dequeue();
        System.out.println("\nGetting front of PQueue.");
        System.out.println(scoreboard.getFront());
        System.out.println("\nDe-queueing front of PQueue");
        scoreboard.dequeue();
        if(scoreboard.isEmpty()) System.out.println("\n\nPQueue now empty...");
    }

    public static void testQueue(){
        System.out.println("Enqueueing items into queue....\n");
        replay.enqueue("Hello");
        replay.enqueue("World");
        replay.enqueue("------------");
        replay.enqueue("My");
        replay.enqueue("Name");
        replay.enqueue("Is");
        replay.enqueue("Jack");

        for(int i = 0; i < 8; i++){
            System.out.println(replay.getFront());
            replay.dequeue();
            if(replay.isEmpty()){
                System.out.println("Queue is now empty...");
                break;
            }
        }
    }
}
