import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 17.08.28(월)
 * BFS - 유기농 배추 https://www.acmicpc.net/problem/1012
 */

class CabbagePoint {
    public int x;
    public int y;

    public CabbagePoint(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Cabbage {

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        CabbagePoint p = new CabbagePoint(1, 2);


        Queue<CabbagePoint> points = new LinkedList<>();    // 배추 위치 기록
        int[] moveRow = new int[] {0, 0, 1,-1};
        int[] moveCol = new int[] {1, -1, 0, 0};

        //전체 테스트 케이스 수
        int testCase = scan.nextInt();

        for(int iTestCase=0; iTestCase<testCase; iTestCase++) {
            //또 다른 배추 심어진 곳(덩어리)찾을때,
            boolean found = false;
            //배추밭 면적
            int col = scan.nextInt();   //가로는 '열의 개수'이다
            int row = scan.nextInt();   //세로는 '행의 개수'이다
            //배추 개수
            int nCabbage = scan.nextInt();
            //배추가 심어진 곳(true)과 아닌곳(false)
            boolean[][] isCabbage = new boolean[row][col];
            // 방문했는지 안했는지 표시
            boolean[][] visited = new boolean[row][col];   //행렬

            //배추 심은곳 표시
            for(int i=0; i<nCabbage; i++){
                int x = scan.nextInt(); //열이 x
                int y = scan.nextInt(); //행이 y
                isCabbage[y][x] = true;

                //배추를 심는다면, 그 위치를 저장
                if(isCabbage[y][x]){
                    points.add(new CabbagePoint(x, y));
                }
            }

            //배추흰지렁이 수
            int cntWorm=0;
            while(!points.isEmpty()){

                CabbagePoint p2 = points.poll();   //주소를 가져온다, 오른쪽에 있는 데이터 타입과 똑같이 생성.
                                                // heap에 새로운 공간 할당할 필요 없으므로 new CabbagePoint() 필요 없음

                System.out.println("[START] x: " + p2.x + " y: " + p2.y);

                // 이미 방문한경우(배추가 심어진곳)
                if(visited[p2.y][p2.x])    continue;
                cntWorm++;

                ////BFS시작
                Queue<CabbagePoint> queue = new LinkedList<>();   // 배추가 심어진곳의 상하좌우 탐색시 필요한 큐.
                queue.add(p2);
                while(!queue.isEmpty()) {
                    CabbagePoint p3 = queue.poll();
                    //상하좌우
                    for (int iSearch = 0; iSearch < 4; iSearch++) {
                        int newY = p3.y + moveRow[iSearch];
                        int newX = p3.x + moveCol[iSearch];

                        if (newX < col && newX >= 0 && newY < row && newY >= 0 && isCabbage[newY][newX]) {
                            System.out.println("[CONTINUE] x: " + newX + " y: " + newY);

                            //심어진 배추의 상하좌우 중 방문한곳이라면 다른 위치 탐색하도록.
                            if(visited[newY][newX]) continue;

                            visited[newY][newX] = true;
                            queue.add(new CabbagePoint(newX, newY));    //BFS탐색-배추있는곳찾으면 그걸 기준으로 다시 상하좌우 탐색하도록 큐에 그 위치 넣는다.
                        }
                    } //for(상하좌우)


                }// while()

            } //while(배추 심었다고 입력하자마자, 그것의 위치 하나씩)


            System.out.println(cntWorm);

        } //전체 for (testCase 수 만큼)



    }
}
