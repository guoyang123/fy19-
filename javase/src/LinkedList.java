public class LinkedList {



    //ָ��ͷ����ָ��
    private  Node  preHead;//ͷָ��

    public LinkedList(){
        preHead=new Node(null,null);
    }


    /**
     * ����������ӽ��
     *
     * �������ӵ������ĩβ��
     *
     * */

    public  void  addNode(Object o){


       Node headNode= preHead.next;
       if(headNode==null){//�յ�����


           Node node=new Node(o,null);
           preHead.next=node;//ͷ���
           return;

       }

       //����Ϊ��

        Node  indexNode=preHead;

       while(indexNode.next!=null){

           indexNode=indexNode.next;//�ƶ�ָ��indexNode

       }

       //β���
        indexNode.next=new Node(o,null);
    }


    /**
     *
     * �������
     * */

    public  void  foreach(){


        Node  indexNode=preHead;

        while(indexNode.next!=null){

            indexNode=indexNode.next;//�ƶ�ָ��indexNode

            System.out.println(indexNode.data);

        }


    }


    /**
     * ɾ��������
     *
     * 1.�ȱ��������ҵ���Ҫɾ���Ľ�㣬��Ŀ����
     * 2.�ҵ�Ŀ��Ľ���ǰ�����
     * 3.��ǰ������ָ����ָ���̽��
     *
     * */

    public  void  remove(Object o){


        Node  indexNode=preHead;

        Node preNode=preHead;

        while(indexNode.next!=null){

            preNode=indexNode;
            indexNode=indexNode.next;//�ƶ�ָ��indexNode

           if(indexNode.data==o){
               //indexNode��ΪĿ���㣬Ҳ����Ҫɾ���Ľ��

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
