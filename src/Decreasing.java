import java.util.Scanner;
import java.util.Arrays;

/**
 * 가장 긴 감소하는 부분
 * https://www.acmicpc.net/problem/11722
 */
public class Decreasing {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();

        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = scan.nextInt();
        }

        int[] dp = new int[n];
        for(int i=0; i<n; i++){
            dp[i] = 1;
            for(int j=0; j<i; j++){
                if( arr[i] < arr[j] && dp[i] < dp[j] + 1){      //잊지말자! dp[]안에 들어갈 값은 가장 긴!! 수열의 길이다!!
                    dp[i] = dp[j] + 1;
                } //if()
            }
        } //for()

        Arrays.sort(dp);
        System.out.println("정답 : " + dp[dp.length-1]);
    }
}
