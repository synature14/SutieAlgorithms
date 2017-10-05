import java.util.Arrays;
import java.util.Scanner;

/**
 * https://www.acmicpc.net/problem/11053
 * 가장 긴 증가하는 부분 수열
 */
public class Longest{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] per = new int[n];

        for(int i=0; i<n; i++){
            per[i] = scan.nextInt();
        }

        int[] dp = new int[n];    //n번째 길이의 가장 긴 부분의 수열 크기


        for(int i=0; i<n; i++){
            dp[i] = 1;  //가장 긴 길이의 수열 --> 길이가 1일땐 1임!

            for(int j=0; j<i; j++){
                if(per[j] < per[i] && dp[i] < dp[j] + 1){ // i번째 수의 크기가 j번째보다 클 경우
                    dp[i] = dp[j] + 1;
                }
            }

        } //for()

        Arrays.sort(dp);
        System.out.println("정답 : " + dp[dp.length-1]);

    }
}
