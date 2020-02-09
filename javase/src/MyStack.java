public class MyStack {


    public  Object[] items;
    public  int index;

    public MyStack(){}

    public MyStack(int length){
        items=new Object[length];
    }


    /**
     * 入栈
     * */


    public  boolean  push(Object o){

        if(index==items.length){
            //满
            return false;
        }

        items[index]=o;

        index++;

        return true;
    }

    /**
     * 出栈
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
     * 遍历栈
     * */


    public  void  foreach(){



    }

    /**
     * 求栈中元素的个数
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
