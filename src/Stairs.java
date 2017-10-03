import java.util.Scanner;

/**
 * 쉬운계단수
 * https://www.acmicpc.net/problem/10844
 */
public class Stairs {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();

        int[][] dp = new int[n+1][10];

        for(int i=1; i<=9; i++){
            dp[1][i] = 1 ;
        }

        for(int i=2; i<=n; i++){
            for(int j=0; j<=9; j++){
                if(j-1 >= 0){
                    dp[i][j] += dp[i-1][j-1];
                }
                if(j+1 <=9){
                    dp[i][j] += dp[i-1][j+1];
                }
                dp[i][j] %= 100000000;
            }
        } //for()

        int answer = 0;
        for(int i=0; i<=9; i++){
            answer += dp[n][i];
        }
        System.out.println("정답 : " + answer);
    }

}
