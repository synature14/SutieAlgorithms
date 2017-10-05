import java.util.Arrays;
import java.util.Scanner;

/**
 * 가장 긴 바이토닉 부분 수열
 * https://www.acmicpc.net/problem/11054
 */
public class Bitonic {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();

        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = scan.nextInt();
        }


        int[] increase = new int[n];
        int[] decrease = new int[n];
        int[] length = new int[n];

        for(int i=0; i<n; i++){
            increase[i] = 1;
            decrease[i] = 1;
            for(int j=0; j<i; j++){
                if( arr[i] > arr[j] && increase[i] < increase[j] + 1){  //증가하는 수열의 최장길이 구하기
                    increase[i] = increase[j] + 1;
                }
                if( arr[i] < arr[j] && decrease[i] < decrease[j] +1 ){
                    decrease[i] = decrease[i] + 1;
                }

                // 가장 긴 바이토닉 수열찾기! -1 해주는 이유? --> 증가 후 감소 하는 수열에서 증가수열의 끝값과 감소시작하는 값이 중복되므로
                if(increase[i] + decrease[i] - 1 > length[i]){
                    length[i] = increase[i] + decrease[i] + 1;
                }
            }

        } //for()


        Arrays.sort(length);
        System.out.println("정답 : " + length[n-1]);
    }
}
