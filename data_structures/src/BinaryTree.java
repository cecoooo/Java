public class BinaryTree<T extends Comparable<? super T>> {
    private class Node{
        Node lChild;
        Node rChild;
        T value;

        Node(){
            this.lChild = new Node();
            this.rChild = new Node();
        }
        Node(T value){
            this.value = value;
            this.lChild = new Node();
            this.rChild = new Node();
        }
    }

    private Node root;
    private int numberOfNodes;

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
            traverse(this.root, value);
        }
        this.numberOfNodes++;
    }

    private void traverse(Node curNode, T value){
        if(curNode.value.compareTo(value) > 1) {
            if(curNode.rChild != null) traverse(curNode.rChild, value);
            curNode.rChild = new Node(value);
        }
        else{
            if(curNode.lChild != null) traverse(curNode.lChild, value);
            curNode.lChild = new Node(value);
        }
    }
}