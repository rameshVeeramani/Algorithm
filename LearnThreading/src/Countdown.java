import java.util.concurrent.CountDownLatch;

public class Countdown {

    public static int num_thread = 3;
    public static void main(String []args){
        final CountDownLatch countdown = new CountDownLatch(num_thread);
        for (int i = 0; i < num_thread; ++ i){
            Thread t= new Thread() {
                public void run()    {

                    System.out.println("Running Thread [ " + Thread.currentThread().getName() + " ]") ;
                    try {
                        System.out.println("Sleeping Thread [ " + Thread.currentThread().getName() + " ]") ;
                        Thread.sleep(10000);

                    } catch (InterruptedException e) {
                        System.out.println(e);
                    }
                    countdown.countDown();
                    System.out.printf("Done [%s] Waiting [%d] threads. %n",Thread.currentThread().getName(), countdown.getCount());
                    try {
                        countdown.await();     //waits until everyone reaches this point
                    } catch (InterruptedException e) {

                        System.out.println(e);
                    }
                    //finish();
                }
            };
            t.start();
        }
    }
}
