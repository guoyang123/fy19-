import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Semaphore;

/**
 * ��������ź���
 * */
public class SemaphoreCode {


    //������
    int  count;
    //�ȴ�����
    Queue queue;

    SemaphoreCode(){
        queue=new ArrayBlockingQueue(10);
    }

    //��ʼ������������
    public void init(int count){
        this.count=count;
    }

    /**
     * �����̷߳����ź���ʱ������down����
     * */
    public void down(){

        count--;

        if(count<0){
            //����ǰ�̷߳ŵ��ȴ������� queue ��������ǰ�߳�
        }
    }

    /**
     * ���߳�ִ����ɺ���������up
     * */
    public void  up(){

        count++;

        if(count<=0){//˵�������л�������Ҫ�����ź������߳�
            //�ӵȴ��������Ƴ��߳�
            //�����߳�
        }
    }


    public static void main(String[] args) {


        Semaphore semaphore;

    }




}
