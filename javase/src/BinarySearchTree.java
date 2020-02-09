
/**
 *
 * ���������
 *
 * */
public class BinarySearchTree {


    private  BinarySearchTreeNode tree;//���������ڵ�

    public BinarySearchTree(){


    }


    public  BinarySearchTreeNode find(int data){

        BinarySearchTreeNode p=tree;

        while(p!=null){

            if(data<p.data){
                p=p.leftNode;
            }else if(data>p.data){
                p=p.rightNode;
            }else{
                return p;
            }
        }

        return null;

    }

    public  void  insert(int data){


        if(tree==null){//�յ���
            tree=new BinarySearchTreeNode
                    (data,null,null);
            return;
        }

        //���ҽ������λ��
        BinarySearchTreeNode p=tree;

        while(p!=null){

            if(data>p.data){//���뵽������
                if(p.rightNode==null){
                    p.rightNode=new BinarySearchTreeNode
                            (data,null,null);
                    return;
                }
                p=p.rightNode;//���Ҳ���λ��

            }else{//���뵽������

                if(p.leftNode==null){
                    p.leftNode=new BinarySearchTreeNode
                            (data,null,null);
                    return;
                }

                p=p.leftNode;
            }

        }





    }


    /**
     *
     * �������
     * �������е�����ڵ���˵���ȴ�ӡ������������Ȼ���ӡ����������ӡ����������
     * */
    public  void  inOrder(BinarySearchTreeNode rootNode){


        if(rootNode==null){
            return ;
        }

        //�ݹ����rootNode����������
        inOrder(rootNode.leftNode);
        System.out.println(rootNode.data);
        //�ݹ����rootNode����������
        inOrder(rootNode.rightNode);

    }

    public static void main(String[] args) {

        BinarySearchTree binarySearchTree=new BinarySearchTree();

        binarySearchTree.insert(13);
        binarySearchTree.insert(10);
        binarySearchTree.insert(16);
        binarySearchTree.insert(9);
        binarySearchTree.insert(11);
        binarySearchTree.insert(14);


        binarySearchTree.inOrder(binarySearchTree.tree);


       BinarySearchTreeNode node= binarySearchTree.find(19);

        System.out.println(node);

    }


}




/**
 * ���Ľڵ�
 * */
class BinarySearchTreeNode{

    public  int  data;
    public  BinarySearchTreeNode leftNode;
    public BinarySearchTreeNode rightNode;

    public BinarySearchTreeNode(){}
    public BinarySearchTreeNode(int data,BinarySearchTreeNode leftNode,BinarySearchTreeNode rightNode){
        this.data=data;
        this.leftNode=leftNode;
        this.rightNode=rightNode;
    }

    @Override
    public String toString() {
        return this.data+"";
    }
}
