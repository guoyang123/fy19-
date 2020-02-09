public class LinkedList {



    //指向头结点的指针
    private  Node  preHead;//头指针

    public LinkedList(){
        preHead=new Node(null,null);
    }


    /**
     * 向链表中添加结点
     *
     * 将结点添加到链表的末尾。
     *
     * */

    public  void  addNode(Object o){


       Node headNode= preHead.next;
       if(headNode==null){//空的链表


           Node node=new Node(o,null);
           preHead.next=node;//头结点
           return;

       }

       //链表不为空

        Node  indexNode=preHead;

       while(indexNode.next!=null){

           indexNode=indexNode.next;//移动指针indexNode

       }

       //尾结点
        indexNode.next=new Node(o,null);
    }


    /**
     *
     * 遍历结点
     * */

    public  void  foreach(){


        Node  indexNode=preHead;

        while(indexNode.next!=null){

            indexNode=indexNode.next;//移动指针indexNode

            System.out.println(indexNode.data);

        }


    }


    /**
     * 删除链表结点
     *
     * 1.先遍历链表，找到需要删除的结点，即目标结点
     * 2.找到目标的结点的前驱结点
     * 3.将前驱结点的指针域指向后继结点
     *
     * */

    public  void  remove(Object o){


        Node  indexNode=preHead;

        Node preNode=preHead;

        while(indexNode.next!=null){

            preNode=indexNode;
            indexNode=indexNode.next;//移动指针indexNode

           if(indexNode.data==o){
               //indexNode即为目标结点，也就是要删除的结点

               preNode.next=indexNode.next;
               return;
           }

        }




    }



    public static void main(String[] args) {

        LinkedList linkedList=new LinkedList();

        linkedList.addNode(10);

        linkedList.addNode(20);

        linkedList.addNode(30);

        linkedList.addNode(40);



      //  linkedList.foreach();


        linkedList.remove(30);

        linkedList.foreach();




    }

}
