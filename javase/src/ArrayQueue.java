

/**
*
* 基于数组实现顺序队列
* */
public class ArrayQueue {

  private String[] items;

  //head表示队头下标，tail表示队尾下标
    private int head=0,tail=0;

    private  int n;

    public  ArrayQueue(int count){

        items=new String[count];

        n=count;

    }


    /**
     * 入队
     * */

    public  boolean  enqueue(String item){

        //判断队列是否已满
        if(tail==n){//队列满

            if(head==0) {
                return false;
            }
        //数据搬移
            for(int i=head;i<tail;i++){
                items[i-head]=items[i];//元素向前移动head个距离
            }
            tail-=head;
            head=0;

        }

        items[tail]=item;
        tail++;

        return true;
    }

    /**
     * 出队
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
