import java.time.Duration;
import java.time.Instant;

public class Main<T>{
    public static int amount = 0;

    public static<T> void print(T data){
        System.out.println(data);
    }

    public static void main(String[] args){
        Instant start = Instant.now();
        for (int i = 0; i < 10; i++) {
            MyThread thread1 = new MyThread();
            Thread thread2 = new Thread(new MyThreadRunnable());
            thread1.start();
//            try{
//                thread1.join();
//            }catch (InterruptedException e){
//                e.printStackTrace();
//            }
            thread2.start();
//            try{
//                thread2.join();
//            }catch (InterruptedException e){
//                e.printStackTrace();
//            }
            try {
                Thread.sleep(1000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        Instant stop = Instant.now();
        print(Duration.between(start, stop));
        print("I m the main thread.");
    }
}
// this programs needs 4 min to be executed if you uncomment the commented code above.