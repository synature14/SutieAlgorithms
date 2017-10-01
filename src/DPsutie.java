import java.util.Scanner;

/**
 * Created by suyeon on 2017-09-11.
 * DP - 배열 최단경로
 */
public class DPsutie {

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);  //입력받는 스트림을 scanner에 연결한 것임!

        int width = scan.nextInt(); // 열
        int height = scan.nextInt();   // 행
        int[][] map = new int[height][width];

        // 막혀있는 위치 개수 & 좌표 입력받는다
        int nBlock = scan.nextInt();
        for(int i=0; i < nBlock; i++){
            int x = scan.nextInt();
            int y = scan.nextInt();
            map[x][y] = -1;
        }


        for(int i=0; i<height; i++){
            for(int j=0; j<width; j++) {
             /*   if(i == 0){
                    map[i][j] = 1;
                }
                else if(j == 0){
                    map[i][j] = 1;
                }
                else {
                    map[i][j] = map[i][j-1] + map[i-1][j];
                }
                System.out.println("map["+i+"]"+"["+j+"]="+map[i][j]);
                */
                if(map[i][j] == -1){
                    map[i][j] = 0;
                }
                else if (i == 0) {
                    map[i][j] = 1;
                } else if (j == 0) {
                    map[i][j] = 1;
                }
                else {
                    map[i][j] = map[i][j-1] + map[i-1][j];
                    System.out.println("map[" + i + "]" + "[" + j + "]=" + map[i][j - 1] + "+" + map[i - 1][j]);
                }
            }
        }

        System.out.println(map[height-1][width-1]);

        scan.close();   // 자동으로 메모리 해제가 안되서.. 사용자가 직접 선언한게 x,
                        // OS한테 자원을 할당 받은것 -->OS는 언제 이 자원을 다시 해제해야할 지 모름!
                        // 따라서 사용자가 직접 반납하겠다고 close()해야함
                        // if 반납 x, 다른 프로세스가 할당받은 자원(system.in, out)을 필요로 할때 이 프로세스가 종료할때까지 기다리게됨.
    }
}
