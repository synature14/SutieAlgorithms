import java.util.Arrays;
import java.util.Scanner;

/**
 * 연속합 구하기
 * https://www.acmicpc.net/problem/1912
 */
public class ContinuousSum {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();

        int[] arr = new int[n];

        for(int i=0; i<n; i++){
            arr[i] = scan.nextInt();
        }

        int[] dp = new int[n];

        dp[0] = arr[0];

        for(int i=1; i<n; i++){
          //  dp[i] = arr[i];

            if(dp[i-1] + arr[i] > dp[i]){  // i번째에서 새로 연속합 시작할때 vs 그전의 연속합 크기 비교
                dp[i] = dp[i-1] + arr[i];   //arr[i]도 연속해서 더해줄때
            }
            else{
                dp[i] = arr[i]; //연속합은 끝. 새롭게 계산 시작
            }

        } //for()

        Arrays.sort(dp);
        System.out.println("정답 : " + dp[n-1]);
    }
}
