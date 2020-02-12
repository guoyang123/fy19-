import java.util.HashMap;

/**
 * LRU缓存算法实现
 * */
public class LRUCache {

    private  int  capacity;
    private HashMap<Integer,DoubleNode> map;
    private  DoubleLinkedList list;


    /**
     * @param capacity 缓存最大容量
     * */
    public LRUCache(int capacity) {

        this.capacity=capacity;
        map=new HashMap<>();
        list=new DoubleLinkedList();

    }

    /**
     * 获取缓存项
     * */
    public int get(int key) {

        //从哈希表中获取
        if(!map.containsKey(key)){
            return -1;
        }

        int value=map.get(key).value;

        //更新(key,value)所在链表中的位置

        put(key,value);

        return value;


    }

    /**
     *更新节点在链表和哈希表中的位置
     * */
    public void put(int key, int value) {


        DoubleNode node=new DoubleNode(key,value);

        if(map.containsKey(key)){//节点存在

            //删除原来的节点
            list.remove(map.get(key));
            //将新节点node插入到头结点上
            list.addHeadNdoe(node);
            //添加到hash表
            map.put(key,node);


        }else{//节点不存在

            //判断缓存是否已满
            if(this.capacity==list.size()){//缓存已满
                //删除尾结点
                DoubleNode tailNode=list.removeTailNode();
                //从hash表删除
                map.remove(tailNode.key);
            }

            //将新的节点添加到头结点
            list.addHeadNdoe(node);
            //在hash表中添加新的节点
            map.put(key,node);

        }


    }



}


/**
 *
 * 封装双向链表类DoubleLinkedList
 * */

class DoubleLinkedList{


    private  DoubleNode preHead,tail;//指向头尾的虚节点

    private  int size;

    public  DoubleLinkedList(){


        preHead=new DoubleNode();
        tail=new DoubleNode();

        preHead.nextNode=tail;
        tail.preNode=preHead;
    }

    /**
     * 添加到头结点
     * */
    public  void  addHeadNdoe(DoubleNode node){


        //原先的头结点
       DoubleNode  head=  preHead.nextNode;

       //将当前结点Node插入到head节点前，作为新的头结点

       preHead.nextNode=node;
       node.preNode=preHead;

       node.nextNode=head;
       head.preNode=node;


       this.size++;

    }


    /**
     * 遍历结点
     * */
    public  void  foreach(){

        DoubleNode p=preHead;

        while((p=p.nextNode)!=tail){

            System.out.println(p.value);


        }

    }



    /**
     * 删除结点
     * @param node  需要删除的节点
     * */

    public  void remove(DoubleNode node){

        node.preNode.nextNode=node.nextNode;
        node.nextNode.preNode=node.preNode;

        node.preNode=null;
        node.nextNode=null;
        this.size--;

    }


    /**
     * 删除尾结点
     * */

    public  DoubleNode removeTailNode(){

        //获取尾结点
        DoubleNode tailNode=tail.preNode;

        tailNode.preNode.nextNode=tail;

        tail.preNode=tailNode.preNode;

        tailNode.nextNode=null;
        tailNode.preNode=null;

        this.size--;

        return tailNode;

    }



    /**
     * 获取链表长度
     * */

    public  int  size(){
        return this.size;
    }


}

/**
 * 双向链表结点
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
