import java.util.Stack;

public class Test {
    public static void main(String[] args) {
//        AdjacencyMatrixGraph<Book> strings = new AdjacencyMatrixGraph<>();
//        Book book1 = new Book();
//        Book book2 = new Book();
//        Book book3 = new Book();
//        strings.AddElement(book1);
//        strings.AddElement(book2);
//        strings.AddElement(book3);
//        strings.AddConnection(1, 2);
//        strings.AddConnection(1, 0);
//        System.out.println(strings.getConnections());
        Stack<Integer> s1 = new Stack<Integer>();
        Stack<Integer> s2 = new Stack<Integer>();
        Stack<Integer> s3 = new Stack<Integer>();
        s1.push(3);
        s1.push(2);
        s1.push(1);
        while(s3.size() != 3){
            int biggest = 0;
            int towerOfBiggest = 0;
            if(s1.size() != 0) {
                biggest = s1.peek();
                towerOfBiggest = 1;
            }
            if(s2.size() != 0){
                if(s2.peek() > biggest) {
                    biggest = s2.pop();
                    towerOfBiggest = 2;
                }
                else
                    s1.pop();
            }
            else
                s1.pop();
            if(s3.size() != 0){
                if(s3.peek() > biggest){
                    s3.push(biggest);
                    continue;
                }
            }
            else {
                s3.push(biggest);
                continue;
            }
            if(s2.size() != 0){
                if(s2.peek() > biggest && towerOfBiggest != 2){
                    s2.push(biggest);
                    continue;
                }
            }
            else if(towerOfBiggest != 2) {
                s2.push(biggest);
                continue;
            }
            if(towerOfBiggest == 1)
                s1.push(biggest);
            else if(towerOfBiggest == 2)
                s2.push(biggest);
            int smallest = 0;
            int towerOfSmallest = 0;
            if(s3.size() != 0){
                smallest = s3.peek();
                towerOfSmallest = 3;
            }
            if(s2.size() != 0){
                if(s2.peek() < smallest) {
                    smallest = s2.pop();
                    towerOfSmallest = 2;
                }
                else
                    s3.pop();
            }
            else
                s3.pop();
            if(s2.size() != 0){
                if(s2.peek() > smallest && towerOfSmallest != 2) {
                    s2.push(smallest);
                    continue;
                }
            }
            if(s1.size() != 0){
                if(s1.peek() < smallest) {
                    s1.push(smallest);
                }
            }
        }

        System.out.println(s3.pop());      // 1
        System.out.println(s3.pop());      // 2
        System.out.println(s3.pop());      // 3
    }
}