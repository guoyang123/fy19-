import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Semaphore;

/**
 * 代码解释信号量
 * */
public class SemaphoreCode {


    //计数器
    int  count;
    //等待队列
    Queue queue;

    SemaphoreCode(){
        queue=new ArrayBlockingQueue(10);
    }

    //初始化计数器方法
    public void init(int count){
        this.count=count;
    }

    /**
     * 当有线程访问信号量时，调用down（）
     * */
    public void down(){

        count--;

        if(count<0){
            //将当前线程放到等带队列中 queue ，阻塞当前线程
        }
    }

    /**
     * 当线程执行完成后，主动调用up
     * */
    public void  up(){

        count++;

        if(count<=0){//说明队列中还存在需要访问信号量的线程
            //从等待队列中移除线程
            //唤醒线程
        }
    }


    public static void main(String[] args) {


        Semaphore semaphore;

    }




}
