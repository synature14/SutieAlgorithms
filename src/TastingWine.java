import java.util.Scanner;
import static java.lang.Math.max;


/**
 * 포도주 시식하기
 * https://www.acmicpc.net/problem/2156
 */
public class TastingWine {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        int[] wine = new int[n+1];

        for(int i=1; i<=n; i++){
            wine[i] = scan.nextInt();
        } //입력

        int[][] dp = new int[n+1][3];   // 1~n번째까지 포도주 마신양 중 연속으로 0/1/2번 마셨을 경우
        dp[1][0] = 0;       //0번 마셨다
        dp[1][1] = wine[1];     //  1번 마셨다
        dp[1][2] = 0;     //  2번 연속으로 마셨다 --> 1번째까지 포도주 마실수 있는데 두번 마실수가 없음

        for(int i=2; i<=n; i++){
            for(int j=0; j<=2; j++){    // 0번, 1번, 2번 마시는 경우
                if(j == 0){         //n번째에 마시지 않았다면, n-1번째에는 0번 or 1번 or 2번 마시는 경우
                    dp[i][j] = max(  max(dp[i-1][0] , dp[i-1][1])  ,  dp[i-1][2] );
                }
                if(j == 1){         // n번째에 1번 연속으로 마셨다 --> 무조건 n-1번째에는 안마시고 + wine[n]
                    dp[i][j] = dp[i-1][0] + wine[i];
                }
                if(j == 2){         // n번째까지 총 연속으로 두번 마신다 --> 무조건 n-1번째에는 마셔야 한다! + wine[n]
                    dp[i][j] = dp[i-1][1] + wine[i];
                }
            }
        } // for()

        System.out.println(" 정답 : " + max(  max(dp[n][0], dp[n][1]),   dp[n][2] )  );

    }
}
