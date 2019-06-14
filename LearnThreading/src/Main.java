
class MyJob implements Runnable {
    //  private  int i = 0;
    //  private variables are not stored in memory theya re stored in register.

    public void run() {
       System.out.println(Thread.currentThread().getName() + " [running]...");
       for(int i =0; i < 100000; i++){
            System.out.println(Thread.currentThread().getName() + " i [" + i + "]");
        }
        System.out.println(Thread.currentThread().getName() + " [ending]...");
    }
}
public class Main {

    public static void main(String[] args) {
        //System.out.println("Hello World!");
        System.out.println(Thread.currentThread().getName() + " [running main]");
        Runnable r = new MyJob();
        Thread t = new Thread(r);
        t.start();
        Thread t2 = new Thread(r);
        t2.start();

        System.out.println("main Exiting");
    }
}
