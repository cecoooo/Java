import java.util.ArrayList;

public class GeneralTree<T> {
    private Node root;
    private int numberOfNodes;
    private Node currentNode;
    private class Node{
        T value = null;
        Node parent = null;
        ArrayList<Node> children = null;
        Node(T val, Node parent){
            this.value = val;
            this.parent = parent;
            children = new ArrayList<>();
        }

        Node getParent(){
            return this.parent;
        }

        ArrayList<Node> getChildren(){
            return this.children;
        }

    }

    public GeneralTree(T root){
        this.numberOfNodes = 1;
        this.root = new Node(root, null);
    }

    public T get(T value){
        traverse(this.root, value, true);
        return this.currentNode.value;
    }


    public void add(T val1, T val2){
        traverse(this.root, val1, true);
        Node parent = this.currentNode;
        parent.children.add(new Node(val2, parent));
        this.numberOfNodes++;
    }

    public int getNumberOfNodes(){
        return this.numberOfNodes;
    }

    public T getParent(T value){
        traverse(this.root, value, true);
        return this.currentNode.getParent().value;
    }

    public ArrayList<T> getChildren(T value){
        ArrayList<T> res = new ArrayList<>();
        traverse(this.root, value, true);
        Node par = this.currentNode;
        for (int i = 0; i < par.getChildren().size(); i++){
            res.add(par.getChildren().get(i).value);
        }
        return res;
    }

    private void traverse(Node curNode, T value, boolean isNodeNull){
        if(this.root.value == value && isNodeNull) {
            this.currentNode = curNode;
            isNodeNull = false;
        }
        for (int i = 0; i < curNode.getChildren().size(); i++){
            if(curNode.getChildren().get(i).value.equals(value)) {
                this.currentNode = curNode.getChildren().get(i);
                isNodeNull = false;
            }
            traverse(curNode.getChildren().get(i), value, isNodeNull);
        }
    }
}