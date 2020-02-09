
/**
 * �̰߳�ȫ�������ģʽ
 *
 * ������� Class
 *
 * 1�� ˫��ռ��
 * 2������
 * 3������ָ������
 *
 * ����ʽ����ģʽ
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
