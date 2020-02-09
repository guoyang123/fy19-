import java.io.IOException;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockTest {

    private final Lock lock=new ReentrantLock();//��������

    private int  value;

    public  void  addOne(){


        //��ȡ��
        lock.lock();
        try{
            value++;
        }finally {
            //�ͷ���
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



