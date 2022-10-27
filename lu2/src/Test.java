public class Test {
    public static void main(String[] args) {
        Person p1 = new Person();
        p1.setName("Ivan");
        System.out.println(p1.getName());
        Person p2 = new Person("Georgi", "02...10");
        System.out.println(p2.getName());
    }
}

