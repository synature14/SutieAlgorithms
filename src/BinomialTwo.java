import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import static sun.swing.MenuItemLayoutHelper.max;

/**
 * Created by suyeon on 2017-09-18.
 */
/*
class PointRect{
    public int x;
    public int y;

    public PointRect(int x, int y){
        this.x = x; // 열
        this.y = y; // 행
    }
}
*/
public class BinomialTwo {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt(); // 행
        int m = scan.nextInt(); // 열
        int[][] arr = new int[n+1][m+1];
        int[][] dp = new int[n+1][m+1];
        int max = 0;

        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                arr[i][j] = scan.nextInt();

            }
        } //배열 입력

        int size = 0;
        // 행과 열의 개수 중, 더 작은 값이 정사각형의 한변 크기가 될것임!
        if(n < m){  //행 < 열 (ex. 4행 3열 --> 3*3이 만들어질수 있는 정사각형 최대크기)
            size = m;
        }
        else{
            size = n;
        }

        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                if(arr[i][j] == 1){
                    int temp = Math.min(dp[i][j], dp[i-1][j-1]);

                }
            }
        }

        /*
        int[] nRect = new int[1000];
        while(!rectQ.isEmpty()){
            PointRect p1 = rectQ.poll();
            //2*2 정사각형부터 size*size까지!
            for(int s=1; s<size; s++){
                for(int i=0; i<n-1; i++) {
                    int nextX = p1.x + s;   //열
                    int nextY = p1.y + s;   //행

                    if (nextX < m && nextY < n) {
                        nRect[i] = max(nRect[i], arr[nextY][nextX] + arr[p1.y][nextX] + arr[p1.y][p1.x] + arr[nextY][p1.x] );

                    }
                }

                if( nRect[s]  == ((s+1)*(s+1)) ){    //nRect[1] --> 2*2의 값인 4가 들어있는지?


                }
            }   //for구문 한바퀴 돌때마다 2*2 --> 3*3 --> 4*4 --> size*size 정사각형 존재여부 확인!



        }

        System.out.println();
        */

    }
}
