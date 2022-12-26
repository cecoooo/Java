public class MyThread extends Thread{
    public void run(){
        for (int i = 0; i < 12; i++){
            System.out.println(i + " From thread1.");
            try {
                Thread.sleep(1000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
