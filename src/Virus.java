import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by suyeon on 2017-08-31.
 * BFS - 바이러스 https://www.acmicpc.net/problem/2606
 */
public class Virus {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        int node = scan.nextInt();
        int edge = scan.nextInt();
        boolean[][]  virusMap = new boolean[node+1][node+1];

        for(int i=1; i<=edge; i++){
            int start = scan.nextInt();
            int end = scan.nextInt();
            virusMap[start][end] = virusMap[end][start] = true;
        }

        int count = 0;
        boolean[] visited = new boolean[node+1];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);   //1번 컴퓨터와 연결된 컴퓨터 찾기
        visited[1] = true;   //1번 컴퓨터 방문 표시!!
        while(!queue.isEmpty()){
            System.out.println("Counting :" + count);
            int from = queue.poll();

            for(int to=1; to<=node; to++){
                if( !visited[to] && virusMap[from][to] == true){
                    if(!queue.contains(to)){
                        queue.add(to);
                        visited[to] = true;
                        count++;
                    }
                }
            }

        } //while()

        System.out.println("Total: " + count);


    }

}
