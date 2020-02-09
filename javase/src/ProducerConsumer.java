
/**
 * 生产者与消费者模型
 *
 * */
public class ProducerConsumer {


    public static void main(String[] args) {


        MantouStack mantouStack=new MantouStack();

        ProducerRunnable producerRunnable=new ProducerRunnable(mantouStack);
        CusumerRunnable cusumerRunnable=new CusumerRunnable((mantouStack));

        Thread producerThread=new Thread(producerRunnable);
        Thread cosumerThread=new Thread(cusumerRunnable);
        producerThread.start();
        cosumerThread.start();

    }


}


/**
 *
 * 生产者
 * */
 class ProducerRunnable implements  Runnable{

    MantouStack mantouStack;//装馒头的框
    public ProducerRunnable(MantouStack mantouStack){
        this.mantouStack=mantouStack;
    }

     @Override
     public void run() {


        for(int i=0;i<10;i++){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Mantou mantou=new Mantou(i);
            mantouStack.push(mantou);
        }


     }
 }


 /**
  * 消费者线程
  * */

 class CusumerRunnable implements  Runnable{


     MantouStack mantouStack;//装馒头的框
     public CusumerRunnable(MantouStack mantouStack){
         this.mantouStack=mantouStack;
     }
     @Override
     public void run() {

         for(int i=0;i<10;i++){
             try {
                 Thread.sleep(500);
             } catch (InterruptedException e) {
                 e.printStackTrace();
             }
            Mantou mantou= mantouStack.pop();
         }

     }
 }


 class MantouStack {


    public Mantou[] items;
    public int index;



    public MantouStack() {
        items = new Mantou[5];
    }


    /**
     * 入栈
     */


    public  synchronized boolean push(Mantou o) {



        while (index == items.length) {
            //满
            //让生产者等待

            try {
                this.wait();//让当前对象上正在访问的线程等待
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

            this.notify();//唤醒消费者

            items[index] = o;
            index++;


        System.out.println("生产的馒头编号是:"+o);

        return true;
    }

    /**
     * 出栈
     */

    public  synchronized  Mantou pop() {


        while (index == 0) {

            try {
                this.wait();//让消费者线程等待
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

        this.notify();//唤醒生产者
        index--;
        Mantou o = items[index];
        System.out.println("消费的馒头编号是:"+o);
        return o;

    }



}

class  Mantou{

    private int id;


    public Mantou(){}
    public Mantou(int id){
        this.id=id;
    }

    @Override
    public String toString() {
        return "馒头的编号："+this.id;
    }
}
