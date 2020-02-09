import apple.laf.JRSUIUtils;

/**
 *
 * 二叉树
 * */
public class BinaryTree {


    public static void main(String[] args) {


        TreeNode node4=new TreeNode("D",null,null);
        TreeNode node5=new TreeNode("E",null,null);



        TreeNode node6=new TreeNode("F",null,null);
        TreeNode node7=new TreeNode("G",null,null);


        TreeNode node2=new TreeNode("B",node4,node5);

        TreeNode node3=new TreeNode("C",node6,node7);

        TreeNode node1=new TreeNode("A",node2,node3);


        BinaryTree binaryTree=new BinaryTree();
        binaryTree.postOrder(node1);

    }

    /**
     * 前序遍历
     * 对于树中的任意节点来说，先打印这个节点，然后再打印它的左子树，最后打印它的右子树
     * */
    public  void  preOrder(TreeNode rootNode){


        if(rootNode==null){
            return;
        }

        System.out.println(rootNode.data);
        //递归遍历结点的左子树
        preOrder(rootNode.leftNode);
        //递归遍历结点的右子树
        preOrder(rootNode.rightNode);



    }

    /**
     *
     * 中序遍历
     * 对于树中的任意节点来说，先打印它的左子树，然后打印它本身，最后打印它的右子树
     * */
    public  void  inOrder(TreeNode rootNode){


        if(rootNode==null){
            return ;
        }

        //递归遍历rootNode结点的左子树
        inOrder(rootNode.leftNode);
        System.out.println(rootNode.data);
        //递归遍历rootNode结点的右子树
        inOrder(rootNode.rightNode);

    }

    /**
     * 后序遍历
     * 对于树中的任意节点来说，先打印它的左子树，然后打印它的右子树，最后打印节点本身
     *
     * */
    public  void  postOrder(TreeNode rootNode){

        if(rootNode==null){
            return ;
        }

        //递归遍历rootNode结点的左子树
        postOrder(rootNode.leftNode);
        //递归遍历rootNode结点的右子树
        postOrder(rootNode.rightNode);
        System.out.println(rootNode.data);



    }

}



/**
 * 树的节点
 * */
class TreeNode{

    public  String  data;
    public  TreeNode leftNode;
    public TreeNode rightNode;

    public TreeNode(){}
    public TreeNode(String data,TreeNode leftNode,TreeNode rightNode){
        this.data=data;
        this.leftNode=leftNode;
        this.rightNode=rightNode;
    }

    @Override
    public String toString() {
        return this.data;
    }
}