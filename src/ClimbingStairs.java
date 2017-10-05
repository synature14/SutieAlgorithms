import java.util.Scanner;

import static java.lang.Math.max;

/**
 * 계단오르기
 * https://www.acmicpc.net/problem/2579
 */
public class ClimbingStairs {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        int[] stairs = new int[n+1];

        for(int i=1; i<=n; i++){
            stairs[i] = scan.nextInt();
        }

        int[][] dp = new int[n+1][3]; //dp[i][j] : i번째의 계단 위치에서 j가 1이면 한계단 오름, 2이면 두계단 오름

        dp[1][1] = stairs[1];   //첫번째 계단의 위치에 총 오른 계단의 점수

        for(int i=2; i<=n; i++){
            //i번째 위치가 한계단 오른 상태라면
            dp[i][1] = max(dp[i-2][1], dp[i-2][2])    +   stairs[i];

            //i번째 위치가 두계단 오른 상태라면
            dp[i][2] = dp[i-1][1] + stairs[i];

        } //for()

        System.out.println( "정답 : " + max(dp[n][1],  dp[n][2])   );
    }
}
