
/**
 * 线程安全单例设计模式
 *
 * 类的类型 Class
 *
 * 1） 双层空检测
 * 2）加锁
 * 3）禁用指令重排
 *
 * 懒汉式单例模式
 * */

public class Singleton {


    private  static volatile   Singleton instance;
    private Singleton(){}



    public  static  Singleton getInstance(){


        if(instance==null){

            synchronized (Singleton.class){
                if(instance==null){
                    instance=new Singleton();
                }
            }
        }


        return instance;

    }


    public static void main(String[] args) {
        for(int i=0;i<10;i++){
            System.out.println(getInstance()==getInstance());
        }

    }

}
