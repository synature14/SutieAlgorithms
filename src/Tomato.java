import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 *  2017-08-29.
 *  BFS - 토마토 익히기 https://www.acmicpc.net/problem/7576
 */
class TomatoPoint{
    public int x;
    public int y;

    public TomatoPoint(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class Tomato {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        int col = scan.nextInt();    // 가로 --> 열의 수
        int row = scan.nextInt();    // 세로 --> 행의 수
        int cntRiped = 0;
        int total = 0;
        Queue<TomatoPoint> queue = new LinkedList<>();  // 익은토마토의 위치 저장하기 위한 큐
        int[][] tomato = new int[row][col]; //토마토 익으면 1, 안익으면 0, 없으면 -1

        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                tomato[i][j] = scan.nextInt();

                if(tomato[i][j] == 1){
                    queue.add(new TomatoPoint(j, i));
                    cntRiped++;
                }   //익은 토마토 위치를 큐에 저장
                if(tomato[i][j] == -1){ // 토마토 자체가 없는 배열칸이 있을 경우,
                    total = col*row -1;
                }
            }
        }// 입력for()
        if(cntRiped == total) { // 처음부터 토마토가 다 익어있다면
            System.out.println(0);
            return;
        }

        queue.add(null);    //첫번째 depth - 1세대

        boolean[][] visited = new boolean[row][col];
        int[] moveRow = {0, 0, 1, -1};
        int[] moveCol = {1, -1, 0, 0};
        int cntDay=0;
        while(!queue.isEmpty()){
            TomatoPoint p1 = queue.poll();  //1세대를 pop하는 순간 다음세대 안익은 토마토(2세대)찾으므로

            if(p1 == null){ //세대 끝이라면,
                if(queue.isEmpty()) break;  // 큐가 다 비어있을때 == 전체 토마토가 다 익어서 더이상 익힐 토마토가 없을 때
                queue.add(null);    //세대의 끝 표현
                cntDay++;
                continue;
            }
            // null이 아니라면
            tomato[p1.y][p1.x] = 1; //토마토 익었다고 표시
            visited[p1.y][p1.x] = true; //방문했다고 표시

            //bfs시작
            for(int iSearch=0; iSearch<moveRow.length; iSearch++){
                int nextX = p1.x + moveCol[iSearch];    // col
                int nextY = p1.y + moveRow[iSearch];    // row

                // 토마토밭 범위 내 and 안익은 토마토가 있는 경우 && 미방문일 경우
                if(nextX >=0 && nextX<col && nextY >=0 && nextY < row && tomato[nextY][nextX] == 0 && !visited[nextY][nextX]) {
                    queue.add(new TomatoPoint(nextX, nextY));
                }
            } //for(상하좌우)


        }  //while()

        for(int y=0; y<row; y++){
            for(int x=0; x<col; x++){
                if(tomato[y][x] == 0){
                    System.out.println(-1);
                    return;
                }
            }
        }

        System.out.println(cntDay);
    }
}
