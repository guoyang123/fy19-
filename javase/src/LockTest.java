import java.io.IOException;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockTest {

    private final Lock lock=new ReentrantLock();//可重入锁

    private int  value;

    public  void  addOne(){


        //获取锁
        lock.lock();
        try{
            value++;
        }finally {
            //释放锁
            lock.lock();
        }

    }

    public static void main(String[] args) {


        IOException ioException;


        LockTest lockTest=new LockTest();

        lockTest.addOne();

        System.out.println(lockTest.value);

    }


}



