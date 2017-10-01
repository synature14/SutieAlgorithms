/**
 * Created by suyeon on 2017-09-06.
 */


class StaticTest {
    public int add(int a, int b) {
        return a+b;
    }
}

public class Fibonacci {
    static int[] array = new int[50];
    static int[][] memo = new int[100][100];

    public static int binomial(int n, int r){
        //비어있는지 아닌지
        if(memo[n][r] != 0){
            return memo[n][r];
        }

        if(n==r){
            return memo[n][r] = 1;
        }
        if(r==0){
            return memo[n][r] = 1;
        }
        else{
            return memo[n][r] = binomial(n-1, r-1) + binomial(n-1, r);
        }
    }


    public static int fibo(int n){

        if(n==0){
          return array[n] = 1;
        }
        else if(n==1){
            return array[n] = 1;
        }
        else{
            return array[n] = fibo(n-1) + fibo(n-2);
        }
    }

    public static void main(String[] args){
     //   fibo(40);
     //   System.out.println(array[39]);

        System.out.println(binomial(10,5));
    }
}
