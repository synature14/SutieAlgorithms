import java.util.Scanner;

/**
 * https://www.acmicpc.net/problem/1463
 * 1로 만들기
 */
public class DPfirst {

    static Scanner scan = new Scanner(System.in);

    static int n;
  //  static int[] D = new int[n];

   /* public static int go(int n){
        if (n == 1) return 0;

        if(D[n] >0) return D[n];

        D[n] = go(n-1) + 1; //???

        if(n %3 == 0){
            int temp = go(n/3) + 1;     //3으로 나눴을때의 횟수와
            if(D[n] > temp) D[n] = temp;     // D[n] --> n까지의
        }

        if(n%2 == 0) {
            int temp = go(n / 2) + 1;
            if (D[n] > temp) D[n] = temp;

        }
        return D[n];
    }
    */


    public static void main(String[] args){
        n = scan.nextInt();
        int[] dp = new int[n+1];

        dp[1] = 0;

        for(int i=2; i<=n; i++){
            dp[i] = dp[i-1] + 1;    //n -> n-1
            if(n%2 == 0 && dp[i] > dp[i/2] +1){
                dp[i] = dp[i/2] + 1;
            }
            if(n%3 == 0 && dp[i] > dp[i/3] +1){
                dp[i] = dp[i/3] + 1;
            }
        }

        System.out.println("결과 : " + dp[n]);



     //   System.out.println(" count : " + go(n));

    }

}
