import java.util.Scanner;

/**
 * Created by suyeon on 2017-09-18.
 */
public class Binomial {
    public static void main(String[] args){

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int r = scan.nextInt();
        int[][] map = new int[n+1][n+1];

       // map[0][0] = 1;

        for(int i=0; i<=n; i++){
            for(int j=0; j<=i; j++){
                if(j == 0 || i == j){   //파스칼 삼각형의 양변을 1로 세팅
                    map[i][j] = 1;
                }
                else if(i>j){
                    map[i][j] = map[i-1][j-1] + map[i-1][j];
                }
            }
        }

        System.out.println("map[n][r] = " + map[n][r]);
    }


}
