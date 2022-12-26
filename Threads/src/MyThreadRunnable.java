public class MyThreadRunnable implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 12; i++){
            System.out.println(i + " from thread2.");
            try {
                Thread.sleep(1000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
