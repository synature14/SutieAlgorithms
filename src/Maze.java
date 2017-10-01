import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by suyeon on 2017-09-06.
 */

class MazePoint {
    public int x, y;

    public MazePoint(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Maze {

    public static void main(String[] args){
        int[][] maze = {
            {0, 1, 0, 0, 0},
            {0, 1, 1, 0, 0},
            {0, 0, 1, 0, 0},
            {0, 0, 0, 1, 0},
            {0, 1, 0, 0, 0}
        };

        MazePoint entryPoint = new MazePoint(0, 0);
        MazePoint exitPoint = new MazePoint(4, 4);


        boolean[][] visited = new boolean[5][5];
        int[] moveRow = {0, 0, 1, -1};
        int[] moveCol = {1, -1, 0, 0};


        Stack<MazePoint> stack = new Stack();
        stack.push(new MazePoint(0,0));  //시작

        while(!stack.isEmpty()){

            MazePoint p1 = stack.pop();
            if(visited[p1.y][p1.x]){
                continue;
            }
            else{
                visited[p1.y][p1.x] = true;
            }

            System.out.println("Stack Node (x: " + p1.x + ", y: " + p1.y + ")");

            //출구
            if(p1.x == 4 && p1.y == 4){
                System.out.println("EXIT! x: " + p1.x + " y:"+ p1.y);
                return;
            }
            for(int i=0; i<4; i++){
                int nextY = p1.y + moveRow[i];  //행
                int nextX = p1.x + moveCol[i];  //열

                if( nextY >=0 && nextY < 5 && nextX >=0 && nextX <5 && maze[nextY][nextX] == 0 && !visited[nextY][nextX] ){
                    stack.push(new MazePoint(nextX, nextY));
                }
            }
        } //while()


        /* BFS

        Queue<MazePoint> queue = new LinkedList<>();
        queue.add(new MazePoint(0,0));  //시작

        while(!queue.isEmpty()){

            MazePoint p1 = queue.poll();
            if(visited[p1.y][p1.x]){
               continue;
            }
            else{
                visited[p1.y][p1.x] = true;
            }

            System.out.println("Node (x: " + p1.x + ", y: " + p1.y + ")");

            //출구
            if(p1.x == 4 && p1.y == 4){
                System.out.println("EXIT! x: " + p1.x + " y:"+ p1.y);
                return;
            }
            for(int i=0; i<4; i++){
                int nextY = p1.y + moveRow[i];  //행
                int nextX = p1.x + moveCol[i];  //열

                if( nextY >=0 && nextY < 5 && nextX >=0 && nextX <5 && maze[nextY][nextX] == 0 && !visited[nextY][nextX] ){
                    queue.add(new MazePoint(nextX, nextY));
                }
            }
        } //while()
        */

        //Stack st = new Stack();
    }
}
