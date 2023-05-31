public class BinaryTree<T extends Comparable<? super T>> {
    private class Node{
        Node lChild = null;
        Node rChild = null;
        T value;

        Node(){}
        Node(T value){
            this.value = value;;
        }
    }

    private Node root;
    private int numberOfNodes;

    private T min = null;
    private T max = null;
    public BinaryTree(){
        root = new Node();
    }

    public Node getRoot() {
        return this.root;
    }

    public void add(T value){
        if(this.numberOfNodes == 0)
            this.root.value = value;
        else{
            add(this.root, value);
        }
        this.numberOfNodes++;
    }

    public T getMin(){
        if(this.numberOfNodes == 1)
            return this.root.value;
        min(this.root);
        return this.min;
    }

    private void add(Node curNode, T value){
        if(value.compareTo(curNode.value) > 0) {
            if(curNode.rChild != null) add(curNode.rChild, value);
            curNode.rChild = new Node(value);
        }
        else{
            if(curNode.lChild != null) add(curNode.lChild, value);
            curNode.lChild = new Node(value);
        }
    }

    private void min(Node curNode){
        if(curNode.lChild == null)
            this.min = curNode.value;
        else min(curNode.lChild);
    }
}