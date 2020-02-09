import java.util.concurrent.locks.Lock;

/**
 * 线程死锁
 * */
public class DeadLock {


    private   Object o1=new Object();
    private Object o2=new Object();


    public static void main(String[] args) {
        DeadLock deadLock=new DeadLock();
        Thread t1=new Thread(new MyRunnable1(deadLock.o1,deadLock.o2),"t1");
        Thread t2=new Thread(new MyRunnable2(deadLock.o1,deadLock.o2),"t2");

        t1.start();
        t2.start();


    }


}


class  MyRunnable1 implements  Runnable{

    Object o1;
    Object o2;

    public MyRunnable1(Object o1,Object o2){
        this.o1=o1;
        this.o2=o2;
    }

    @Override
    public void run() {



         synchronized (o1){//获取o1对象的锁



             System.out.println(Thread.currentThread().getName()+"已经获取了o1对象的锁，等待o2对象的锁");

             try {
                 Thread.sleep(100);
             } catch (InterruptedException e) {
                 e.printStackTrace();
             }
             synchronized (o2){
                  System.out.println(Thread.currentThread().getName()+"已经获取了o2对象的锁，线程执行完成");
              }

         }

    }
}

class  MyRunnable2 implements  Runnable{

    Object o1;
    Object o2;

    public MyRunnable2(Object o1,Object o2){
        this.o1=o1;
        this.o2=o2;
    }

    @Override
    public void run() {


        synchronized (o2){//获取o2对象的锁

            System.out.println(Thread.currentThread().getName()+"已经获取了o2对象的锁，等待o1对象的锁");

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (o1){
                System.out.println(Thread.currentThread().getName()+"已经获取了o1对象的锁，线程执行完成");
            }

        }

    }
}


