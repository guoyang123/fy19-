public class BinarySearch {






    /**
     * 数组排序
     * */
    public  void  sort(int[]a){
        //冒泡排序
        int temp=0;
        for(int i=0;i<a.length;i++){
            for(int j=0;j<a.length-i-1;j++){
                if(a[j]>a[j+1]){
                    //交换
                    temp=a[j];
                    a[j]=a[j+1];
                    a[j+1]=temp;
                }
            }
        }




    }



    /**
     * 查找target元素是否在a数组中存在。
     *
     * 二分查找：
     *   有序的数组。
     *
     * @param  a  有序数组
     *
     *
     * */
    public  boolean   binarySearch(int[] a,int target){


        int left=0,right=a.length-1;


        int mid=(left+right)/2;


        while(left<=right){
            if(a[mid]==target){

                return true;
            }
            if(a[mid]>target){
                right=mid-1;
            }else {
                left=mid+1;
            }

            mid=(left+right)/2;
        }


        return false;





    }

    public static void main(String[] args) {

        int[] a={1,6,2,9,19,12,8};

        BinarySearch binarySearch=new BinarySearch();
        binarySearch.sort(a);


       int target=19;

       boolean result=binarySearch.binarySearch(a,target);
        System.out.println(result);



    }


}
