public class Test {
    public static void main(String[] args) {
        AdjacencyMatrixGraph<Book> strings = new AdjacencyMatrixGraph<>();
        Book book1 = new Book();
        Book book2 = new Book();
        Book book3 = new Book();
        strings.AddElement(book1);
        strings.AddElement(book2);
        strings.AddElement(book3);
        strings.AddConnection(1, 2);
        strings.AddConnection(1, 0);
        System.out.println(strings.getConnections());
    }
}