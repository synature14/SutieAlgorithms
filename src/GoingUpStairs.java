import java.util.Scanner;

/**
 * 계단 오르기 (포도주 시식하기와 비슷!)
 * https://www.acmicpc.net/problem/2579
 */
public class GoingUpStairs {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        int[] stair = new int[n];
        for(int i=0; i<n; i++){
            stair[i] = scan.nextInt();
        }


        System.out.println();
    }
}
