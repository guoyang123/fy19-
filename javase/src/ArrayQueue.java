

/**
*
* ��������ʵ��˳�����
* */
public class ArrayQueue {

  private String[] items;

  //head��ʾ��ͷ�±꣬tail��ʾ��β�±�
    private int head=0,tail=0;

    private  int n;

    public  ArrayQueue(int count){

        items=new String[count];

        n=count;

    }


    /**
     * ���
     * */

    public  boolean  enqueue(String item){

        //�ж϶����Ƿ�����
        if(tail==n){//������

            if(head==0) {
                return false;
            }
        //���ݰ���
            for(int i=head;i<tail;i++){
                items[i-head]=items[i];//Ԫ����ǰ�ƶ�head������
            }
            tail-=head;
            head=0;

        }

        items[tail]=item;
        tail++;

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
        head++;
        return ret;

    }








}
