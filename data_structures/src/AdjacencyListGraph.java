import java.util.*;

public class AdjacencyListGraph<T> {

    private class Node{
        public T value;
        public int weight;

        public Node(T value, int weight){
            this.value = value;
            this.weight = weight;
        }
        public Node(T value){
            this.value = value;
            this.weight = 1;
        }

        public String ToString() {
            return value.toString();
        }
    }
    private Map<T, LinkedList<Node>> data;
    private int num_of_elements;

    public AdjacencyListGraph(){
        this.data = new HashMap<T, LinkedList<Node>>();
        this.num_of_elements = 0;
    }

    public void AddVertex(T vertex){
        this.data.put(vertex, new LinkedList<Node>());
        this.num_of_elements++;
    }

    public void AddConnection(T v1, T v2){
        if(this.data.containsKey(v1) && this.data.containsKey(v2)) {
            boolean doesItContainsValue = false;
            for(Node node: this.data.get(v1)){
                if(node.value.equals(v2))
                    doesItContainsValue = true;
            }
            if (doesItContainsValue)
            {
                try{
                    throw new Exception("Connection between vertices " + v1.toString() + " and " + v2.toString() + " still exists with the same weight.");
                }catch (Exception e){
                    e.printStackTrace();
                    System.exit(1);
                }
            }
            this.data.get(v1).add(new Node(v2));
        }
        else{
            try{
                throw new Exception("Cannot make connections between nonexistent vertices.");
            }catch (Exception e){
                e.printStackTrace();
                System.exit(1);
            }
        }
    }
    public void AddConnection(T v1, T v2, int weight){
        if(this.data.containsKey(v1) && this.data.containsKey(v2)) {
            boolean doesItContainsValue = false;
            for(Node node: this.data.get(v1)){
                if(node.value.equals(v2) && node.weight == weight)
                    doesItContainsValue = true;
            }
            if (doesItContainsValue)
            {
                try{
                    throw new Exception("Connection between vertices " + v1.toString() + " and " + v2.toString() + " still exists with the same weight.");
                }catch (Exception e){
                    e.printStackTrace();
                    System.exit(1);
                }
            }
            this.data.get(v1).add(new Node(v2, weight));
        }
        else{
            try{
                throw new Exception("Cannot make connections between nonexistent vertices.");
            }catch (Exception e){
                e.printStackTrace();
                System.exit(1);
            }
        }
    }

    public String ViewConnections(){
        StringBuilder sb = new StringBuilder();
        this.data.forEach((key, value) -> {
            boolean isDifferentThanZero = false;
            sb.append(key.toString()).append(" -> ");
            for(Node node: value){
                sb.append(node.ToString()).append("("+ node.weight +")").append(", ");
                isDifferentThanZero = true;
            }
            if(isDifferentThanZero) {
                sb.delete(sb.length() - 2, sb.length());
            }
            sb.append(";\n");
        });
        return sb.toString();
    }
}
