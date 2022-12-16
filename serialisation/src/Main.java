import java.io.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        try {
            Book b1 = new Book("Zahari Karabashliev", "18% sivo", 20);
            Book b2 = new Book("James Clavell", "King Rat", 35);
            Book b3 = new Book("Steven King", "It", 30);
            ArrayList<Book> arrBooks = new ArrayList<>();
            FileOutputStream fileOut = new FileOutputStream("C:\\Users\\User\\Desktop\\library.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            FileInputStream fileIn = new FileInputStream("C:\\Users\\User\\Desktop\\library.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);

            try {
                out.writeObject(b1);
                out.writeObject(b2);
                out.writeObject(b3);
                out.flush();
                out.close();

                Book book = new Book();
                while ((book = (Book) in.readObject()) != null) {
                    arrBooks.add(book);
                }

            } catch (IOException e) {
                try {
                    in.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                for (int i = 0; i < arrBooks.size(); i++) {
                    System.out.println(arrBooks.get(i).getAuthor());
                    System.out.println(arrBooks.get(i).getTitle());
                    System.out.println(arrBooks.get(i).getPrice());
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();

            }
        }catch (IOException exception){
            exception.printStackTrace();
        }
    }
}

/*
steps for serialization in java:

1. create a FileOutputStream object => given parameter is String (file's path)
2. create an ObjectOutputStream object => given parameter is a FileOutputStream object
3. write objects in it:
-> use method writeObject(obj) from class ObjectOutputStream, obj is the object which must be serialized
4. close the file (FileOutputStream)
flush is not mandatory to use.


steps for deserialization in java:

1. create a FileInputStream object => (!)given parameter must be a String of an existing file, containing serialized objects
2. create an ObjectInputStream object => given parameter is a FileInputStream object
3. read information:
-> use readObject() method from class ObjectInputStream, which returns an Object type.
It's not a static method and needs instance!
4. close the file (FileInputStream)
*/