import javax.sound.midi.Soundbank;

public class ThreadSafe {

    public  int  a;


    public static void main(String[] args) throws InterruptedException {

        ThreadSafe threadSafe=new ThreadSafe();


        MyRunnable runnable=new MyRunnable(threadSafe);
        Thread t1=new Thread(runnable);
        t1.start();


        MyRunnable runnable2=new MyRunnable(threadSafe);
        Thread t2=new Thread(runnable2);
        t2.start();


       // Thread.sleep(1000);
        t1.join();
        t2.join();

        System.out.println(threadSafe.a);

    }




}

class  MyRunnable  implements  Runnable{

    ThreadSafe threadSafe;

    int a;
    public MyRunnable(ThreadSafe a){
        this.threadSafe=a;
    }
    @Override
    public   void run() {
        for(int i=0;i<10000;i++){

            synchronized (threadSafe){
                threadSafe.a++;
            }

        }

    }
}
