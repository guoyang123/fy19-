public class ThreadTest  extends  Thread{


    public static void main(String[] args) {


        Thread thread=new ThreadTest();

        thread.start();//�����߳�


//        try {
//            thread.join();//�̼߳�һ��
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        for(int i=0;i<500;i++){
            System.out.println("====���߳�==="+i);

            try {
                Thread.sleep(10);

                if(i%10==0){
                    Thread.yield();
                }



            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }

    }

    @Override
    public void run() {//�߳��巽��


        for(int i=0;i<500;i++){

            System.out.println(i);

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }
}
