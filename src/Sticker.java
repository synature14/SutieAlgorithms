import java.util.Scanner;

import static java.lang.Math.max;


/**
 * 스티커
 * https://www.acmicpc.net/problem/9465
 */
public class Sticker {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();

        int[][] sticker = new int[3][n+1];       //행(1행부터 시작함),열

        for(int i=1; i<3; i++){
            for(int j=1; j<=n; j++){
                sticker[i][j] = scan.nextInt();
            }
        } //for() 입력

        int[][] dp = new int[n+1][3]; // 2*n개의 스티커중 점수합 최대, n열의 상태는 총 3가지 (0,0), (0,1), (1,0)

        dp[1][0] = 0;       //sticker 어느것도 떼지 않은 상태
        dp[1][1] = sticker[1][1];   //sticker 첫번째 열의 1행과 2행 중 위(1행)에 위치한 스티커 떼었을경우
        dp[1][2] = sticker[2][1];   //sticker 첫번째 열의 아래(2행)에 위치한 스티커 떼었을경우

        for(int i=2; i<=n; i++){
            for(int j=0; j<3; j++){
                if(j == 0){    // sticker배열의 i열의 위/아래를 떼거나 or 모두 떼지 않는 경우
                    dp[i][j] = max(  max(dp[i-1][0], dp[i-1][1]),   dp[i-1][2] );
                }
                if(j == 1){    // sticker배열의 i열의 위를 떼는 경우
                    dp[i][j] = max(dp[i-1][0] + sticker[1][i], dp[i-1][2] + sticker[1][i]); //sticker 첫번째 행의 i번째 열 값
                }
                if(j == 2) {    //sticker배열의 i열의 아래를 떼는 경우
                    dp[i][j] = max(dp[i - 1][0] + sticker[2][i], dp[i - 1][1] + sticker[2][i]); //sticker 두번째 행의 i번째 열 값
                }
            }
        } //for()

        System.out.println(" 정답 : " + max( max(dp[n][0], dp[n][1]) , dp[n][2]) );

    }
}
