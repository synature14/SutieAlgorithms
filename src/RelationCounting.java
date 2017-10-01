/**
 * 17.08.28
 * BFS - 촌수세기 https://www.acmicpc.net/problem/2644
* */

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class RelationCounting {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Queue<Integer> queue = new LinkedList<>();

        int bfsDepth = 0;
        int nNode = scan.nextInt() + 1;
        int from = scan.nextInt();
        int to = scan.nextInt();
        int nEdge = scan.nextInt();

        //0촌인 경우
        if(from == to){
            System.out.println(0);
            return ;        // 아래에 있는 코드 실행x
        }


        boolean[][] familyMap = new boolean[nNode][nNode];    //배열은 new로 힙에 메모리 할당, 생성하자마자 false로 초기화

        for(int i=0; i<nEdge; i++) {
            int x = scan.nextInt();
            int y = scan.nextInt();
            familyMap[x][y] = familyMap[y][x] = true;
        }
//확인
        for(int i=0; i<nNode; i++){
            for(int j=0; j<nNode; j++){
                System.out.print(familyMap[i][j] + " ");
            }
            System.out.println();
        }

        boolean[][] visited = new boolean[nNode][nNode];
        queue.add(from);
        queue.add(-100);

        boolean find_to = false;

        //큐에서 노드 하나 pop, 연결된 노드가 있다면? add?
        while(!queue.isEmpty()){
            int v = queue.poll();

            // 우리가 찾고자 하는 'to'정점을 찾으면, while문 끝!
            if(v == to) {
                find_to = true;
                break;
            }

            //Depth 계산
            if(v == -100){
                bfsDepth++;
                queue.add(-100);    //q: [7, -100, 2, -100, 8, 9, 1, -100, 3]
                continue;   // while문 처음으로 다시 실행
            }
            for(int i=0; i<nNode; i++){
                if(!visited[i][v] && familyMap[i][v] == true){  //미방문 && 연결된 노드가 있다면
                    queue.add(i);   //연결된 모든 노드를 큐에 넣는다다
                   visited[i][v] = true;
                }
            }

        } //while

        if(find_to == true){
            System.out.println(bfsDepth);
        }
        else System.out.println(-1);    //연결되어있지 않는 from과 to라면


    }
}
