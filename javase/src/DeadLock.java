import java.util.concurrent.locks.Lock;

/**
 * �߳�����
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



         synchronized (o1){//��ȡo1�������



             System.out.println(Thread.currentThread().getName()+"�Ѿ���ȡ��o1����������ȴ�o2�������");

             try {
                 Thread.sleep(100);
             } catch (InterruptedException e) {
                 e.printStackTrace();
             }
             synchronized (o2){
                  System.out.println(Thread.currentThread().getName()+"�Ѿ���ȡ��o2����������߳�ִ�����");
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


        synchronized (o2){//��ȡo2�������

            System.out.println(Thread.currentThread().getName()+"�Ѿ���ȡ��o2����������ȴ�o1�������");

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (o1){
                System.out.println(Thread.currentThread().getName()+"�Ѿ���ȡ��o1����������߳�ִ�����");
            }

        }

    }
}


