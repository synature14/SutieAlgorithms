import java.util.Scanner;

/**
 * 오르막수
 * https://www.acmicpc.net/problem/11057
 */
public class Climbing {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        int[][] dp = new int[n+1][10];

        for(int i=0; i<=9; i++){
            dp[1][i] = 1;
        }

        for(int i=2; i<=n; i++){
            for(int j=0; j<=9; j++){
                for(int k=0; k<=j; k++){
                    dp[i][j] += dp[i-1][k];
                    dp[i][j] %= 10007;
                }
            }
        }
        int answer = 0;

        for(int i=0; i<=9; i++){
            answer += dp[n][i];
        }
        System.out.println("답 : " + answer);

    }
}
