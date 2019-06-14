import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.CountDownLatch;


class Processor implements Runnable{
    private java.util.concurrent.CountDownLatch ll;
    public Processor(java.util.concurrent.CountDownLatch l){
        ll = l;
    }
    @Override
    public void run()  {
        try {

            System.out.println(Thread.currentThread().getName() + " " + " waiting..");
            Thread.sleep(300);
        }
        catch (InterruptedException ex){
        }
        finally {
            System.out.println(ll.getCount());
            ll.countDown();
        }
    }
}

public class CountDownLatchh {
    public static void main(String[] args) {
        java.util.concurrent.CountDownLatch ll = new  java.util.concurrent.CountDownLatch(3);
        ExecutorService threads = Executors.newFixedThreadPool(3);

        for (int i = 0; i < 3; i++) {
            threads.execute(new Processor(ll));
        }
        try {
            ll.await();
        }
        catch (InterruptedException ex){
         System.out.println("interrupted.");
        }
        System.out.println("Completed");
        System.out.println(ll.getCount());
    }
}
