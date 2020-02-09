public class TestThreadByRunnable  implements  Runnable{
    @Override
    public void run() {

        for(int i=0;i<300;i++){
            System.out.println(i);
        }

    }

    public static void main(String[] args) {

        Runnable runnable=new TestThreadByRunnable();
        Thread thread=new Thread(runnable);
        thread.start();
    }

}
