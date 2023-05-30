import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.util.function.ObjLongConsumer;

public class AdjacencyMatrixGraph<T> {
    // could be used for directed, weighted graph
    private T[] data = null;
    private int num_of_elements;
    private int[][] matrix;

    public AdjacencyMatrixGraph(){
        this.num_of_elements = 0;
        this.data = (T[])new Object[4];
        this.matrix = new int[1][1];
    }

    public void AddElement(T element){
        if(this.data.length == this.num_of_elements) extend_data_space();
        this.data[num_of_elements] = element;
        this.num_of_elements++;
        extend_matrix();
    }

    public void AddConnection(int x, int y){
        this.matrix[x][y] = 1;
    }
    public void AddConnection(int x, int y, int weight){
        this.matrix[x][y] = weight;
    }

    public int getNodeIndex(T node){
        for (int i = 0; i < num_of_elements; i++){
            if(this.data[i].equals(node)) return i;
        }
        throw new RuntimeException("Element not found!");
    }

    public String getConnections(){
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < num_of_elements; i++){
            res.append(i).append(" -> ");
            for (int j = 0; j < num_of_elements; j++){
                if(matrix[i][j] != 0) res.append(j).append(" ");
            }
            res.append("\n");
        }
        return res.toString();
    }

    private void extend_data_space(){
        T[] new_data = (T[]) new Object[this.num_of_elements*2];
        for (int i = 0; i < num_of_elements; i++){
            new_data[i] = this.data[i];
        }
        this.data = new_data;
    }
    private void extend_matrix(){
        int[][] currMatrix = new int[this.num_of_elements][this.num_of_elements];
        for (int i = 0; i < this.num_of_elements-1; i++){
            for (int j = 0; j < this.num_of_elements-1; j++){
                currMatrix[i][j] = this.matrix[i][j];
            }
        }
        this.matrix = currMatrix;
    }
}