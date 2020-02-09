import apple.laf.JRSUIUtils;

/**
 *
 * ������
 * 
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
     * ǰ�����
     * �������е�����ڵ���˵���ȴ�ӡ����ڵ㣬Ȼ���ٴ�ӡ����������������ӡ����������
     * */
    public  void  preOrder(TreeNode rootNode){


        if(rootNode==null){
            return;
        }

        System.out.println(rootNode.data);
        //�ݹ��������������
        preOrder(rootNode.leftNode);
        //�ݹ��������������
        preOrder(rootNode.rightNode);



    }

    /**
     *
     * �������
     * �������е�����ڵ���˵���ȴ�ӡ������������Ȼ���ӡ����������ӡ����������
     * */
    public  void  inOrder(TreeNode rootNode){


        if(rootNode==null){
            return ;
        }

        //�ݹ����rootNode����������
        inOrder(rootNode.leftNode);
        System.out.println(rootNode.data);
        //�ݹ����rootNode����������
        inOrder(rootNode.rightNode);

    }

    /**
     * �������
     * �������е�����ڵ���˵���ȴ�ӡ������������Ȼ���ӡ����������������ӡ�ڵ㱾��
     *
     * */
    public  void  postOrder(TreeNode rootNode){

        if(rootNode==null){
            return ;
        }

        //�ݹ����rootNode����������
        postOrder(rootNode.leftNode);
        //�ݹ����rootNode����������
        postOrder(rootNode.rightNode);
        System.out.println(rootNode.data);



    }

}



/**
 * ���Ľڵ�
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