import java.util.Scanner;

/**
 * Created by suyeon on 2017-10-01.
 */
public class SutieMap {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int width = scan.nextInt();
        int height = scan.nextInt();

        int[][] map = new int[height][width];


        // 1로 초기화 (1열의 1~height까지, height행의 1~width열까지)
        for(int i = 1; i<map.length; i++){
            map[i][0] = 1;
        }
        for(int j = 1; j<map[0].length; j++){
            map[0][j] = 1;
        }

        for(int i=1; i< map.length; i++){
            for(int j=1; j< map[0].length; j++){
               // if(i>0 && j>0 && i <= height && j <= width){
                    map[i][j] = map[i-1][j] + map[i][j-1];

                //}
            }
        } //for()

        System.out.println(map[height-1][width-1]);
    }
}
