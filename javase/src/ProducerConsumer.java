
/**
 * ��������������ģ��
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
 * ������
 * */
 class ProducerRunnable implements  Runnable{

    MantouStack mantouStack;//װ��ͷ�Ŀ�
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
  * �������߳�
  * */

 class CusumerRunnable implements  Runnable{


     MantouStack mantouStack;//װ��ͷ�Ŀ�
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
     * ��ջ
     */


    public  synchronized boolean push(Mantou o) {



        while (index == items.length) {
            //��
            //�������ߵȴ�

            try {
                this.wait();//�õ�ǰ���������ڷ��ʵ��̵߳ȴ�
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

            this.notify();//����������

            items[index] = o;
            index++;


        System.out.println("��������ͷ�����:"+o);

        return true;
    }

    /**
     * ��ջ
     */

    public  synchronized  Mantou pop() {


        while (index == 0) {

            try {
                this.wait();//���������̵߳ȴ�
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

        this.notify();//����������
        index--;
        Mantou o = items[index];
        System.out.println("���ѵ���ͷ�����:"+o);
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
        return "��ͷ�ı�ţ�"+this.id;
    }
}
