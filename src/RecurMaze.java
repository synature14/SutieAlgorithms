/**
 * Created by suyeon on 2017-09-06.
 * 탐색문제 풀땐 재귀호출 사용 x
 * 순열문제 <-- 재귀호출
 */
class RecurMazePoint{
    public int x,y;

    public RecurMazePoint(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class RecurMaze {
    static int[][] maze = {
            {0, 1, 0, 0, 0},
            {0, 1, 1, 0, 0},
            {0, 0, 1, 0, 0},
            {0, 0, 0, 1, 0},
            {0, 1, 0, 0, 0}
    };

    static int[] moveRow = {0, 0, 1, -1};
    static int[] moveCol = {1, -1, 0, 0};

    static RecurMazePoint exitPoint = new RecurMazePoint(4, 4);

    static boolean[][] visited = new boolean[10][10];

    public static void recursive(RecurMazePoint p){

        //재귀호출 맨앞에 항상 종료조건
        if(p.x == exitPoint.x && p.y == exitPoint.y){
            System.out.println("심봤다!");
            return;
        }
        //방문했다면, for구문 안의 recursive() 완료 --> 다시 for구문안에서 다음 코드 수행
        if(visited[p.y][p.x]){
            return;
        }
        visited[p.y][p.x] = true;

        for(int i=0; i<4; i++){
            int nextY = moveRow[i] + p.y;
            int nextX = moveCol[i] + p.x;

            if (nextX >=0 && nextX <maze[0].length && nextY >=0 && nextY < maze.length && !visited[nextY][nextX]) {
                recursive(new RecurMazePoint(nextX, nextY));
            }
        }

    }

    public static void main(String[] args){

        RecurMazePoint entryPoint = new RecurMazePoint(0, 0);
        recursive(entryPoint);


    }
}
