import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by suyeon on 2017-08-31.
 BFS - NQueen
 */

/**
public class NQueen {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        int N = scan.nextInt();

       // boolean[][] queenMap = new boolean[N][N];
        int[] moveCol = {0, 0, 1, -1, 1, -1, 1, -1};
        int[] moveRow = {1, -1, 0, 0, 1, -1, -1, 1};

        boolean[][] isQueen = new boolean[N][N];
        Queue<boolean[][]> queue = new LinkedList<>();
        queue.add(isQueen); // 텅빈 boolean 배열 부터 시작

        while(!queue.isEmpty()){
            boolean[][] tempMap = queue.poll();

            // (0,0)부터 (N-1,N-1)까지 퀸 배치 시작점 가능
            for(int x=0; x<N; x++){
                for(int y=0; y<N; y++){
                    if (tempMap[y][x] == false){    // 비어있다면
                        boolean[][] copyMap = new boolean[N][N];
                        for (int z=0; z<N; z++) {
                            for (int k=0; k<N; k++) {
                                copyMap[z][k] = tempMap[z][k];  // 깊은 복사
                            }
                        }
                        copyMap[y][x] = true;   //
                        queue.add(copyMap); //tempMap의 주소
                    }

                }
            }

            for(int iSearch=0; iSearch<8; iSearch++){
                int nextY = p1.y + moveRow[iSearch];    //행
                int nextX = p1.x + moveCol[iSearch];    //열

                boolean[][] newMap = new boolean[N][N];

                if(nextY >= 0 && nextY < N && nextX >=0 && nextX <N && !isQueen[nextY][nextX]){ //퀸을 두지 않은 빈칸이며 범위내라면,
                    newMap[nextY][nextX] = true;


                    for(int iiSearch=0; iiSearch<N; iiSearch++){
                        int gap = nextY-nextX;
                        [iiSearch+gap][iiSearch];   //예를들어, 퀸이 (3,1)에 위치 --오른쪽 하향--> 3-1=2만큼씩 행의 좌표 차이남
                    }

                    queue.add(new QueenPoint(nextX, nextY));
                }


            }
            // 체스판에 N개의 퀸 배치할 수 있는 경우(규칙과 무관하게)를 큐에 2차원 배열 형태로 넣는다



        }   //while()



    }
}
**/