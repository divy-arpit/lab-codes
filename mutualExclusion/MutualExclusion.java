package mutualExclusion;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

public class MutualExclusion implements Runnable{
    String name;
    static ReentrantLock lock;
    boolean workDone=false;
    public MutualExclusion(String name){
        this.name=name;
        
    }
    public static void main(String[] args) {
         lock=new ReentrantLock();
        ExecutorService pool = Executors.newFixedThreadPool(4);  
        MutualExclusion exe1=new MutualExclusion("One");
        MutualExclusion exe2=new MutualExclusion("Two");
        MutualExclusion exe3=new MutualExclusion("Three");
        MutualExclusion exe4=new MutualExclusion("Four");
        pool.execute(exe1);
        pool.execute(exe2);
         pool.execute(exe3);
         pool.execute(exe4);
      
    }

    @Override
    public void run() {

        while(!workDone){
        try{
            if(lock.tryLock()){
                System.out.println(name+" has the current lock");
              
                //Thread.sleep(300);
            }
            else{
                System.out.println(name+" is waiting for lock");
            }
        }
        catch(Exception e){
            System.out.println("Process failed");
        }
        finally{
            try{
            lock.unlock();
            workDone=true;
            
            }
            catch(Exception e){
             //   System.out.println(name+"is throwing the exception");
            }
        }
    }
        
    }
    
}
