import java.util.Scanner;

/**
 * https://www.acmicpc.net/problem/9095
 * 1,2,3 더하기
 */
public class PlusNumber {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        int[] arr = new int[12];

        //입력
        for(int i=1; i<=n; i++){
            arr[i] = scan.nextInt();
        }


        int[] dp = new int[12];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for(int i=4; i<11; i++){
            dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
        }

        for(int j=1; j<= n; j++){
            System.out.println("결과 : " + dp[arr[j]]);
        }



    }
}
