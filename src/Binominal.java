import java.util.Scanner;

/** https://www.acmicpc.net/problem/2193
 * 이친수 개수 구하기
 */
public class Binominal {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();

        int[] dp = new int[n+1];

        dp[1] = 1;
        dp[2] = 1;

        for(int i=3; i<=n; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }

        System.out.println("정답 : " + dp[n]);
    }
}
