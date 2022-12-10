public interface QueueInterface<T> {

    /*
    This interface will be a queue (First In First Out - FIFO) interface that allows the player's hands to be
    replayed at the end of the game, and will allow for PriorityQueue creation for
    scoreboard.
     */

    void enqueue(T anEntry);
    /*
    This method will enqueue a new entry into the queue.
     */

    T dequeue();
    /*
    This method will dequeue the front element from the queue.
     */

    T getFront();
    /*
    This method will return the data from the front element of the queue.
     */

    boolean isEmpty();
    /*
    This method will return a boolean on whether the queue is empty or not.
     */

    void clear();
    /*
    This method will clear the queue of all elements.
     */
}
