import java.util.Scanner;

/**
 * Created by suyeon on 2017-10-01.
 */
public class SutieMap {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        int height = scan.nextInt();
        int width = scan.nextInt();

        System.out.print("경유할 곳 행 : ");
        int stopX = scan.nextInt();
        System.out.print("열: ");
        int stopY = scan.nextInt();

        int[][] map = new int[height+1][width+1];


        // 1로 초기화 (1열의 1~height까지, height행의 1~width열까지)
        for(int i = 1; i<map.length; i++){
            map[i][1] = 1;
        }
        for(int j = 1; j<map[0].length; j++){
            map[1][j] = 1;
        }

        // (1,1) ~ 경유할 곳까지의 최단경로
        for(int i=2; i <= stopX ; i++){
            for(int j=2; j <= stopY; j++){
                map[i][j] = map[i-1][j] + map[i][j-1];
            }
        } //for()
        System.out.println("(1,1) ~ 경유지의 최단경로 수 : " + map[stopX][stopY]);



        //stopX, stopY를 출발점이라 생각하고 1로 초기화
        for(int i = stopX+1; i<map.length; i++){
            map[i][stopY] = 1;
        }
        for(int j = stopY+1; j<map[0].length; j++){
            map[stopX][j] = 1;
        }


        // (stopX+1, stopY+1) ~ (height, width) 까지의 최단경로
        for(int i=stopX+1; i< map.length; i++){
            for(int j=stopY+1; j< map[0].length; j++){
                map[i][j] = map[i-1][j] + map[i][j-1];
            }
        }
        System.out.println("경유지 ~ 목적지까지 최단경로 수 : " + map[height][width]);

        int answer = map[height][width] * map[stopX][stopY];

        System.out.println("정답 : " + answer );
    }
}
