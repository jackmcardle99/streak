public class MyNode<T> {

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
        MyNode<Integer> node1 = null;
        node1.setData(1);
        MyNode<Integer> node2 = new MyNode<>(2);
        MyNode<Integer> node3 = new MyNode<>(3);
        
        
        
    }
}
