public class MyStack {


    public  Object[] items;
    public  int index;

    public MyStack(){}

    public MyStack(int length){
        items=new Object[length];
    }


    /**
     * ��ջ
     * */


    public  boolean  push(Object o){

        if(index==items.length){
            //��
            return false;
        }

        items[index]=o;

        index++;

        return true;
    }

    /**
     * ��ջ
     * */

    public  Object pop(){


        if(index==0){
            return null;
        }
        index--;
        Object o=items[index];
        return o;

    }


    /**
     * ����ջ
     * */


    public  void  foreach(){



    }

    /**
     * ��ջ��Ԫ�صĸ���
     * */


    public int  size(){

        return index;
    }


    public static void main(String[] args) {
        MyStack myStack=new MyStack(4);

        System.out.println(myStack.push(1));
        System.out.println(myStack.push(2));
        System.out.println(myStack.push(3));
        System.out.println(myStack.push(4));
        //System.out.println(myStack.push(5));

        System.out.println( myStack.pop());
        System.out.println( myStack.pop());
//        System.out.println( myStack.pop());
//        System.out.println( myStack.pop());
//        System.out.println( myStack.pop());

        System.out.println(myStack.size());

    }


}
