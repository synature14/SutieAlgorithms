import java.util.Scanner;

/**
 * 가장 큰 증가하는 부분
 * https://www.acmicpc.net/problem/11055
 */
public class SumBiggest {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        int[] arr = new int[n];

        for(int i=0; i<n; i++){
            arr[i] = scan.nextInt();
        }

        int[] sub = new int[n];
        sub[0] = arr[0];
        for(int i=0; i<n; i++){
           // sub[i] = 1;
            for(int j=0; j<i; j++){
                if(arr[i] > arr[j] && sub[i] < arr[i] + sub[j] ){
                    sub[i] = arr[i] + sub[j];
                }
            }
        }//for()

        int biggest = 0;
        for(int i=0; i<n-1; i++){
            if(sub[i] > sub[i+1]){
                biggest = sub[i];
            }
        }
        System.out.println("정답 : " + biggest);
    }
}
