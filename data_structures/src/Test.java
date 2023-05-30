public class Test {
    public static void main(String[] args) {
//        AdjacencyListGraph<String> graph = new AdjacencyListGraph<>();
//        graph.AddVertex("A");
//        graph.AddVertex("B");
//        graph.AddVertex("C");
//        graph.AddVertex("D");
//        graph.AddVertex("E");
//        graph.AddVertex("F");
//        graph.AddVertex("G");
//        graph.AddVertex("H");
//        graph.AddConnection("A", "D", 2);
//        graph.AddConnection("D", "C");
//        graph.AddConnection("G", "A");
//        graph.AddConnection("F", "C");
//        graph.AddConnection("E", "F");
//        graph.AddConnection("F", "B");
//        graph.AddConnection("F", "G");
//        graph.AddConnection("E", "B", 3);
//        graph.AddConnection("B", "H");
//        graph.AddConnection("H", "E");
//        graph.AddConnection("H", "C");
//        graph.AddConnection("C", "D");
//        System.out.println(graph.ViewConnections());

        GeneralTree<Integer> tree = new GeneralTree<Integer>(1);
        tree.add(1, 2);
        tree.add(1, 3);
        tree.add(1, 4);
        tree.add(2, 5);
        tree.add(2, 6);
        tree.add(3, 7);
        tree.add(3, 8);
        tree.add(4, 9);
        tree.add(4, 10);
        tree.add(4, 11);
        tree.add(8, 12);
        tree.add(12, 13);

        System.out.println(tree.getHeightOfTree());
    }
}