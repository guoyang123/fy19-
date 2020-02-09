public class Fun {



    /**
     * Çó½×³Ë
     *
     * n!
     *
     * n*(n-1)!
     * n*(n-1)(n-2)!
     *
     * ...
     * n*(n-1)(n-2)¡£¡£¡£*1
     *
     * n=1
     * f(1)=1
     *
     * */

    public  static int  fn(int n){

        if(n==1){
            return 1;
        }

        return n*fn(n-1);
    }

    public static void main(String[] args) {

        System.out.println(fn(5));
    }

}
