public interface QueueInterface<T> {

    /*
    This interface will be a queue (First In First Out - FIFO) interface that allows the player's hands to be
    replayed at the end of the game, and will allow for PriorityQueue creation for
    scoreboard.
     */

    void enqueue(T anEntry);

    T dequeue();

    T getFront();

    boolean isEmpty();

    void clear();
}
