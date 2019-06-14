import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

public class LBQ {

    public static void main(String[] args) {
        LinkedBlockingQueue lbq = new LinkedBlockingQueue(10);
        ExecutorService exec = Executors.newFixedThreadPool(3);
        exec.submit(new Producer(lbq));
        exec.submit(new Consumer(lbq));
        exec.submit(new Consumer(lbq));
    }
}

class Producer implements Runnable {
   private LinkedBlockingQueue plbq;
    Producer(LinkedBlockingQueue l) {
        plbq = l;
    }
   @Override
    public void run() {

        for (int i = 0; i <= 20; i++) {
            int rand = new Random().nextInt(50);
            try {
                Thread.sleep(10);
                int ii = 1;
            } catch (Exception e) {
                System.out.println("Exception - Interrupted");
            }

            String sToQ = "String " + i;
            try {
                plbq.put(sToQ);
                System.out.println("Added to the queue " + sToQ + " Q size " + plbq.size());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Consumer implements Runnable {

    private LinkedBlockingQueue plbq;

    Consumer(LinkedBlockingQueue l) {
        plbq = l;
    }

    @Override
    public void run() {

        String taken = "empty";
        //while (plbq.remainingCapacity() > 0 ) {
        while (true) {
            try {
                taken = (String) plbq.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Consuming number ..  " + taken + " Thread [" + Thread.currentThread().getName() + " ]");
        }
    }
}

