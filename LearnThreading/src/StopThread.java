import java.util.WeakHashMap;
import java.util.concurrent.TimeUnit;

public class StopThread {
    private static boolean stopRequested;

    private static synchronized void requestStop(){
        stopRequested  = true;
    }

    private static synchronized  boolean returnStopRequested(){
        return  stopRequested;
    }

    public static void main(String[] args) throws InterruptedException {
        Thread backgroundThread = new Thread(() ->
        {
            int i = 0;
            while (!returnStopRequested()) {
                i++;
                System.out.println(i);
            }
        });
        backgroundThread.start();

        TimeUnit.SECONDS.sleep(1);
        //Thread.sleep(1);
        //stopRequested = true;
        requestStop();

    }
}