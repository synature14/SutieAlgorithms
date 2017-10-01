import javax.xml.soap.Node;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by suyeon on 2017-09-02.
 * BFS - 스타트링크 https://www.acmicpc.net/problem/5014
 */

class NodePoint{
    public int floor;
    public int count;

    public NodePoint(int floor, int count){
        this.floor = floor;
        this.count = count;
    }
}

public class StartLink {
    static int f,s,g,up, down;
    static int[] move = {1, -1};
    static boolean[] visited = new boolean[1000001];

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        f = scan.nextInt();
        s = scan.nextInt();
        g = scan.nextInt();
        up = scan.nextInt();
        down = scan.nextInt();

        // 위, 아래로 이동할칸수 설정
        move[0] *= up;
        move[1] *= down;

        Queue<NodePoint> q = new LinkedList<>();
        q.add(new NodePoint(s, 0));   //시작지점

        while(!q.isEmpty()){
            NodePoint nodeP = q.poll();
            int current = nodeP.floor;
            int cnt = nodeP.count;

            visited[current] = true;

            //도착하면 loop 탈출
            if(current == g){
                System.out.println(cnt);
                return ;
            }

            for(int i=0; i<2; i++){
                int next = nodeP.floor + move[i];

                if(next >= 0 && next <=f && !visited[next] ){
                    cnt = nodeP.count+1;
                    q.add(new NodePoint(next, cnt));
                }
            }
        } // while()

        System.out.println("use the stairs~~");

    }

}
