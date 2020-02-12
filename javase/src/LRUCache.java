import java.util.HashMap;

/**
 * LRU�����㷨ʵ��
 * */
public class LRUCache {

    private  int  capacity;
    private HashMap<Integer,DoubleNode> map;
    private  DoubleLinkedList list;


    /**
     * @param capacity �����������
     * */
    public LRUCache(int capacity) {

        this.capacity=capacity;
        map=new HashMap<>();
        list=new DoubleLinkedList();

    }

    /**
     * ��ȡ������
     * */
    public int get(int key) {

        //�ӹ�ϣ���л�ȡ
        if(!map.containsKey(key)){
            return -1;
        }

        int value=map.get(key).value;

        //����(key,value)���������е�λ��

        put(key,value);

        return value;


    }

    /**
     *���½ڵ�������͹�ϣ���е�λ��
     * */
    public void put(int key, int value) {


        DoubleNode node=new DoubleNode(key,value);

        if(map.containsKey(key)){//�ڵ����

            //ɾ��ԭ���Ľڵ�
            list.remove(map.get(key));
            //���½ڵ�node���뵽ͷ�����
            list.addHeadNdoe(node);
            //��ӵ�hash��
            map.put(key,node);


        }else{//�ڵ㲻����

            //�жϻ����Ƿ�����
            if(this.capacity==list.size()){//��������
                //ɾ��β���
                DoubleNode tailNode=list.removeTailNode();
                //��hash��ɾ��
                map.remove(tailNode.key);
            }

            //���µĽڵ���ӵ�ͷ���
            list.addHeadNdoe(node);
            //��hash��������µĽڵ�
            map.put(key,node);

        }


    }



}


/**
 *
 * ��װ˫��������DoubleLinkedList
 * */

class DoubleLinkedList{


    private  DoubleNode preHead,tail;//ָ��ͷβ����ڵ�

    private  int size;

    public  DoubleLinkedList(){


        preHead=new DoubleNode();
        tail=new DoubleNode();

        preHead.nextNode=tail;
        tail.preNode=preHead;
    }

    /**
     * ��ӵ�ͷ���
     * */
    public  void  addHeadNdoe(DoubleNode node){


        //ԭ�ȵ�ͷ���
       DoubleNode  head=  preHead.nextNode;

       //����ǰ���Node���뵽head�ڵ�ǰ����Ϊ�µ�ͷ���

       preHead.nextNode=node;
       node.preNode=preHead;

       node.nextNode=head;
       head.preNode=node;


       this.size++;

    }


    /**
     * �������
     * */
    public  void  foreach(){

        DoubleNode p=preHead;

        while((p=p.nextNode)!=tail){

            System.out.println(p.value);


        }

    }



    /**
     * ɾ�����
     * @param node  ��Ҫɾ���Ľڵ�
     * */

    public  void remove(DoubleNode node){

        node.preNode.nextNode=node.nextNode;
        node.nextNode.preNode=node.preNode;

        node.preNode=null;
        node.nextNode=null;
        this.size--;

    }


    /**
     * ɾ��β���
     * */

    public  DoubleNode removeTailNode(){

        //��ȡβ���
        DoubleNode tailNode=tail.preNode;

        tailNode.preNode.nextNode=tail;

        tail.preNode=tailNode.preNode;

        tailNode.nextNode=null;
        tailNode.preNode=null;

        this.size--;

        return tailNode;

    }



    /**
     * ��ȡ������
     * */

    public  int  size(){
        return this.size;
    }


}

/**
 * ˫��������
 * */
class DoubleNode{

    public  DoubleNode preNode;
    public DoubleNode nextNode;
    public int key,value;


    public  DoubleNode(){}
    public DoubleNode(int key,int value){
        this.key=key;
        this.value=value;
    }
    public DoubleNode(int key,int value,DoubleNode preNode,DoubleNode nextNode){
        this.key=key;
        this.value=value;
        this.preNode=preNode;
        this.nextNode=nextNode;
    }

}
