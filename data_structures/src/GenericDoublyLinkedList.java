public class GenericDoublyLinkedList<T> {
    private class Node{
        Node next = null;
        Node previous = null;
        T value;

        Node(){}

        Node(T value){
            this.value = value;
        }
    }
    private int numberOfElements;
    Node lastNode = null;

    public GenericDoublyLinkedList(){
        this.numberOfElements = 0;
    }

    public void add(T value){
        if(this.lastNode == null){
            this.lastNode = new Node(value);
        }
        else {
            this.lastNode.next = new Node(value);
            this.lastNode.next.previous = this.lastNode.next;
            this.lastNode = this.lastNode.next;
        }
        this.numberOfElements++;
    }

    public void insertAfter(T value1, T value2){

    }
    public void insertBefore(T value1, T value2){

    }
}

