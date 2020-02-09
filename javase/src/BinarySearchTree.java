
/**
 *
 * 二叉查找树
 *
 * */
public class BinarySearchTree {


    private  BinarySearchTreeNode tree;//二叉树根节点

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


        if(tree==null){//空的树
            tree=new BinarySearchTreeNode
                    (data,null,null);
            return;
        }

        //查找结点插入的位置
        BinarySearchTreeNode p=tree;

        while(p!=null){

            if(data>p.data){//插入到右子树
                if(p.rightNode==null){
                    p.rightNode=new BinarySearchTreeNode
                            (data,null,null);
                    return;
                }
                p=p.rightNode;//查找插入位置

            }else{//插入到左子树

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
     * 中序遍历
     * 对于树中的任意节点来说，先打印它的左子树，然后打印它本身，最后打印它的右子树
     * */
    public  void  inOrder(BinarySearchTreeNode rootNode){


        if(rootNode==null){
            return ;
        }

        //递归遍历rootNode结点的左子树
        inOrder(rootNode.leftNode);
        System.out.println(rootNode.data);
        //递归遍历rootNode结点的右子树
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
 * 树的节点
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
