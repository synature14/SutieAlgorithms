import java.util.Scanner;

/**
 * 삼성SW역량 기출 01 - 로봇청소기
 * https://www.acmicpc.net/problem/14503
 */

public class SSERobot {
    static int n;
    static int m;
    static int[][] room;
    static boolean[][] isClean;
    static int[] vy = {-1, 0, 1, 0};    //행
    static int[] vx = { 0, 1, 0, -1};   //열
    static int nCleaned;
    public static void recur(int y, int x, int d){   //행, 열, 방향
        //범위 체크
        if(y < 0 || y >=n || x< 0 || x>= m)     return;

        // 1단계 - 빈공간이며 청소하지 않은 곳이라면? 청소한다
        if(!isClean[y][x] && room[y][x] == 0)  {  isClean[y][x] = true;    nCleaned++; }


        ////////////////4방향 탐색 -종료조건
        int movable = 0;

        for(int i=0; i<4; i++) {
            int searchY = vy[i] + y;
            int searchX = vx[i] + x;

            //2-3, 2-4 : 네 방향 모두 청소가 이미 되어있거나 벽인 경우에는,
            if (isClean[searchY][searchX] || room[searchY][searchX] == 1) {
                movable++;
            }
        }//for(4방향)



        ///////////////2단계
        //왼쪽 방향 찾아내기
        int left = 0;
        if(d == 0)  left = 3;   //현재방향이 북쪽이라면, 그것의 왼쪽 방향은 서쪽
        else if(d > 0) left = d-1;
        //반대 방향 찾기(뒤쪽 방향)
        int back = 0;
        if(d >= 2)  back = d-2;
        else back = d+2;

        int nextY = y + vy[left];    //왼쪽 칸의 행
        int nextX = x + vx[left];    //왼쪽 칸의 열
        int backY = y + vy[back];      //반대방향 칸의 행
        int backX = x + vx[back];      //반대방향 칸의 열

        if(nextY >= 0 && nextY < n && nextX >=0 && nextX < m){
            //네 방향 모두 청소 or 벽일 경우
            if(movable == 4){

                //2-4 뒤쪽 방향이 벽이라 후진도 할 수 없는 경우에는 작동을 멈춘다.
                if(room[backY][backX] == 1){
                   // System.out.println("2-4번 조건 수행");
                    return;         }
            }

            //2-1. 왼쪽 방향에 아직 청소하지 않은 공간이 존재한다면, 그 방향으로 회전한 다음 한 칸을 전진하고 1번부터 진행한다.
            else if(!isClean[nextY][nextX] && room[nextY][nextX] == 0){
                recur(nextY, nextX, left);
            }

            //2-2. 왼쪽 방향에 청소할 방향이 없다면, 그 방향으로 회전하고 2번으로 돌아간다.
            else if(isClean[nextY][nextX] || room[nextY][nextX] == 1){   // 청소 되어있거나, 벽이 있을 경우
                recur(y, x, left);
            }


            //2-3. 바라보는 방향을 유지한 채로 한 칸 후진을 하고 2번으로 돌아간다.
            if(movable == 4 && room[backY][backX] == 0) {
             //   System.out.println("2-3번 조건 수행");
                recur(backY, backX, d);     }

        }   //if()

    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        int row = sc.nextInt();
        int col = sc.nextInt();
        int dir = sc.nextInt();

        room = new int[n][m];
        isClean = new boolean[n][m];

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                room[i][j] = sc.nextInt();
            }
        }

        recur(row, col, dir);

        System.out.println("청소한 칸의 개수 : " + nCleaned);

    }
}
