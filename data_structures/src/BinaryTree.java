import java.util.HashSet;
import java.util.Set;

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

    public T getMax(){
        if(this.numberOfNodes == 1)
            return this.root.value;
        max(this.root);
        return this.max;
    }

    public void remove(T value){
        remove(this.root, value);
    }

    private void add(Node curNode, T value){
        if(isWrapperClass(value.getClass())){
            if (compare(value, curNode.value, value.getClass()) > 0) {
                if (curNode.rChild != null) add(curNode.rChild, value);
                else curNode.rChild = new Node(value);
            } else {
                if (curNode.lChild != null) add(curNode.lChild, value);
                else curNode.lChild = new Node(value);
            }
        }
        else{
            if (value.compareTo(curNode.value) > 0) {
                if (curNode.rChild != null) add(curNode.rChild, value);
                curNode.rChild = new Node(value);
            } else {
                if (curNode.lChild != null) add(curNode.lChild, value);
                curNode.lChild = new Node(value);
            }
        }
    }

    private void min(Node curNode){
        if(curNode.lChild == null)
            this.min = curNode.value;
        else min(curNode.lChild);
    }
    private void max(Node curNode){
        if(curNode.rChild == null)
            this.max = curNode.value;
        else max(curNode.rChild);
    }

    private void remove(Node curNode, T value){
        if(isWrapperClass(value.getClass())){
            if (compare(value, curNode.value, value.getClass()) > 0) {
                if (curNode.rChild.value.equals(value)){
                    if(curNode.rChild.lChild != null) curNode.rChild = curNode.rChild.lChild;
                    else if(curNode.rChild.rChild != null) curNode.rChild = curNode.rChild.rChild;
                    else curNode.rChild = null;
                }
                else remove(curNode.rChild, value);
            } else {
                if (curNode.lChild.value.equals(value)){
                    if(curNode.lChild.lChild != null) curNode.lChild = curNode.lChild.lChild;
                    else if(curNode.lChild.rChild != null) curNode.lChild = curNode.lChild.rChild;
                    else curNode.lChild = null;
                }
                else remove(curNode.lChild, value);
            }
        }
        else{
            if (value.compareTo(curNode.value) > 0) {
                if (curNode.rChild.value.equals(value)){
                    if(curNode.rChild.lChild != null) curNode.rChild = curNode.rChild.lChild;
                    else if(curNode.rChild.rChild != null) curNode.rChild = curNode.rChild.rChild;
                    else curNode.rChild = null;
                }
                else remove(curNode.rChild, value);
            } else {
                if (curNode.lChild.value.equals(value)){
                    if(curNode.lChild.lChild != null) curNode.lChild = curNode.lChild.lChild;
                    else if(curNode.lChild.rChild != null) curNode.lChild = curNode.lChild.rChild;
                    else curNode.lChild = null;
                }
                else remove(curNode.lChild, value);
            }
        }
    }

    private Set<Class<?>> getWrapperClass() {
        Set<Class<?>> ret = new HashSet<Class<?>>();
        ret.add(Boolean.class);
        ret.add(Character.class);
        ret.add(Byte.class);
        ret.add(Short.class);
        ret.add(Integer.class);
        ret.add(Long.class);
        ret.add(Float.class);
        ret.add(Double.class);
        ret.add(Void.class);
        return ret;
    }

    private int compare(T value1, T value2, Class<?> clazz){
        if(clazz == Character.class){
            return (Character)value1 > (Character)value2 ? 1: -1;
        }
        else if(clazz == Byte.class){
            return (Byte)value1 > (Byte)value2 ? 1: -1;
        }
        else if(clazz == Short.class){
            return (Short)value1 > (Short)value2 ? 1: -1;
        }
        else if(clazz == Integer.class){
            return (Integer) value1 > (Integer)value2 ? 1: -1;
        }
        else if(clazz == Long.class){
            return (Long)value1 > (Long)value2 ? 1: -1;
        }
        else if(clazz == Float.class){
            return (Float)value1 > (Float)value2 ? 1: -1;
        }
        else if(clazz == Double.class){
            return (Double)value1 > (Double)value2 ? 1: -1;
        }
        return 0;
    }

    private boolean isWrapperClass(Class<?> clazz){
        return getWrapperClass().contains(clazz);
    }
}