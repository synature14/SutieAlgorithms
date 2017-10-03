import java.util.Scanner;

/**
 * https://www.acmicpc.net/problem/11726, 11727
 * 2xn 타일채우기
 */
public class TileCombination {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        int[] dp = new int[n+1];

        dp[1] = 1;
        dp[2] = 3;

        for(int i=3; i<=n; i++){
            dp[i] = dp[i-1] + 2*dp[i-2];
        }


    /*    dp[1] = 1;
        dp[2] = 2;

        for(int i=3; i<=n ; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }

    */
        System.out.println("2xn의 타일 :" + dp[n]);

    }
}
