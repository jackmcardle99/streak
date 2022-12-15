public class MyNode<T> {

    /*
    This class is for the implementation of stack and queue linked list structures.
     */

    private T data;
    private MyNode next;

    public MyNode(T dataValue){
        data = dataValue;
        next = null;
    }

    public T getData(){
        return data;
    }

    public MyNode<T> getNext() {
        return next;
    }

    public void setData(T dataValue){
        data = dataValue;
    }

    public void setNext(MyNode<T> nextNode){
        next = nextNode;
    }

    public static void main(String[] args){
        MyNode<Integer> node1 = new MyNode<>(1);
        MyNode<Integer> node2 = new MyNode<>(2);
        MyNode<Integer> node3 = new MyNode<>(3);

        node1.setNext(node2);
        node2.setNext(node3);

        System.out.println("Node 1 = " + node1.getData());
        System.out.println("Node 2 = " + node1.getNext().getData());
        System.out.println("Node 3 = " + node1.getNext().getNext().getData());

        System.out.println("\nUpdating node 1...");
        node1.setData(10);
        System.out.println("\nRemoving current node 2 with a value of (2)...");
        node1.setNext(node2.getNext());

        System.out.println("\nNode 1 = " + node1.getData());
        System.out.println("Node 2 = " + node1.getNext().getData());


        
        
        
    }
}
