

/**
*
* ��������ʵ��ѭ������
* */
public class LoopArrayQueue {

  private String[] items;

  //head��ʾ��ͷ�±꣬tail��ʾ��β�±�
    private int head=0,tail=0;

    private  int n;

    public LoopArrayQueue(int count){

        items=new String[count];

        n=count;

    }


    /**
     * ���
     * */

    public  boolean  enqueue(String item){

        // ������ (tail+1)%n == head
        if((tail+1)%n ==head){
            //������
            return false;
        }

        items[tail]=item;
        tail=(tail+1)%n; // tail
        return true;
    }

    /**
     * ����
     * */

    public  String dequeue(){


        if(head==tail){
            return null;
        }

        String ret=items[head];
        head=(head+1)%n;
        return ret;

    }








}
