import java.util.Scanner;

import static sun.swing.MenuItemLayoutHelper.max;

/**
 * https://www.acmicpc.net/problem/11052
 * 붕어빵 판매하기
 */
public class FishBread {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        int num = scan.nextInt();
        int[] price = new int[num+1];

        for(int i = 1; i<= num; i++){
            price[i] = scan.nextInt();
        }

        int[] dp = new int[num+1];

        for(int i=1; i<=num; i++){
            for(int j=1; j<=i; j++){
               dp[i] = max(dp[i], dp[i-j] + price[j]);
            }
        }

        System.out.println("결과 : " + dp[num]);

    }
}
