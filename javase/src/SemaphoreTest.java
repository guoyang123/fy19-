import java.io.IOException;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SemaphoreTest {

   //初始化信号量
    Semaphore s=new Semaphore(1);

    private int  value;

    public  void  addOne(){



        try{
            s.acquire();
            value++;
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        finally {
            s.release();
        }

    }

    public static void main(String[] args) {




        SemaphoreTest lockTest=new SemaphoreTest();

        lockTest.addOne();

        System.out.println(lockTest.value);

    }




}



