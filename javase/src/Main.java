public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");


        int a=1;

        int res=0;
        int ret=a+add(3,5);
        System.out.println(ret);

    }

    public static   int  add(int x,int y){
        int sum=0;
        sum=x+y;
        return sum;
    }
}
