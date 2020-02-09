

/**
*
* 基于数组实现循环队列
* */
public class LoopArrayQueue {

  private String[] items;

  //head表示队头下标，tail表示队尾下标
    private int head=0,tail=0;

    private  int n;

    public LoopArrayQueue(int count){

        items=new String[count];

        n=count;

    }


    /**
     * 入队
     * */

    public  boolean  enqueue(String item){

        // 队列满 (tail+1)%n == head
        if((tail+1)%n ==head){
            //队列满
            return false;
        }

        items[tail]=item;
        tail=(tail+1)%n; // tail
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
        head=(head+1)%n;
        return ret;

    }








}
