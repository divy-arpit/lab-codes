package sharedMemory;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Increment implements Runnable{
    private static int count=0;
    private static final int poolCount=5;
    private static final int limit=10;
    private static final Object lock=new Object();
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(poolCount);
        for (int i = 0; i < poolCount; i++) {
            executorService.submit(new Increment());
        }
        executorService.shutdown();
    }

    @Override
    public void run() {
        while (count < limit) {
            increaseCounter();
            try {
                Thread.currentThread().sleep(100);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    private void increaseCounter() {
        synchronized (lock) {
            
            System.out.println(Thread.currentThread().getName() + " : " + count);
            
            count++;
            
           
        }
    }
}