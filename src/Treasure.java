import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by suyeon on 2017-08-30.
 * BFS - 보물섬
 */
class TreasurePoint{
    public int x;
    public int y;

    public TreasurePoint(int x, int y){
        this.x = x; // col
        this.y = y; // row
    }
}

public class Treasure {
    public static void main (String[] args){
        Scanner scan = new Scanner(System.in);

        int row = scan.nextInt();
        int col = scan.nextInt();
        char[][] suvelyMap = new char[row][col];
        int[] moveRow = new int[] {0,0,1,-1};
        int[] moveCol = new int[] {1,-1,0,0};

        Queue<TreasurePoint> queueL = new LinkedList<>();   //'L'이 있는 좌표 저장용
        for (int iRow=0; iRow<row; iRow++) {
            String line = scan.next();
            for (int iLine=0; iLine<line.length(); iLine++) {
                char ch = line.charAt(iLine);
                suvelyMap[iRow][iLine] = ch;
                //'L'찾으면 그걸 시작점으로
                if(ch == 'L') {
                    queueL.add(new TreasurePoint(iLine, iRow));
                }
            }

        }   //입력

        Queue<TreasurePoint> queuePoint = new LinkedList<>();
        int cntMax=-1;  // 이동칸수 최대값 저장할 변수

        while(!queueL.isEmpty()){
            TreasurePoint p1 = queueL.poll();
            System.out.println("[START] x: " + p1.x + " y: " + p1.y);

            /////////////////여기가 visited위치!!!
            boolean[][] visited = new boolean[row][col];

            int cntMove= 0; //이동할수 있는 칸 수 --> BFS호출시마다 증가
            queuePoint.add(p1);
            queuePoint.add(null);   //첫번째 depth 끝

            while(!queuePoint.isEmpty()){
                TreasurePoint p2 = queuePoint.poll();

                if(p2 == null){
                    if(queuePoint.isEmpty()) {
                        break;
                    }
                    queuePoint.add(null);  // L의 그다음 칸(p2)의 상하좌우 좌표 저장할 예정이므로 NULL로 구분점
                    cntMove++;
                    continue;
                }

                if (visited[p2.y][p2.x] == true) {
                    continue;
                } else {
                    visited[p2.y][p2.x] = true;
                }

                System.out.println("[CONTINUE] x: " + p2.x + " y: " + p2.y);

                for(int iSearch=0; iSearch<4; iSearch++){
                    int nextY = p2.y + moveRow[iSearch];  //행
                    int nextX = p2.x + moveCol[iSearch];  //열

                    if(nextY >=0 && nextY <row && nextX >=0 && nextX <col){
                        if (suvelyMap[nextY][nextX] == 'L') {
                            if (visited[nextY][nextX] == false) {
                                queuePoint.add(new TreasurePoint(nextX, nextY));    //열,행 순으로 넣기
                            }
                        }
                    }
                } //for(상하좌우 L탐색)
            } //while()

            System.out.println("CntMove: " + cntMove);

            // BFS 끝나는 시점
            // 새로운 L 좌표 꺼내올때, 그 위치를 출발점으로 하는 새로운 경로 카운팅 시작
            if(cntMax < cntMove){
                cntMax = cntMove;
            }

        } //while(queueL)

        scan.close();
    }

}
