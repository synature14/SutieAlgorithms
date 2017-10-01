import java.util.*;

/**
 * Solved by suyeon on 2017-08-30.
 * BFS - 단지번호붙이기 https://www.acmicpc.net/problem/2667
 */
class NumberPoint{
    public int x;
    public int y;

    public NumberPoint(int x, int y){
        this.x = x; //열
        this.y = y; //행
    }
}

public class Numbering {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[][] numberMap = new int[n][n];

        int[] moveRow = new int[] {0,0,1,-1};
        int[] moveCol = new int[] {1,-1,0,0};

        Queue<NumberPoint> queueOne = new LinkedList<>();

        for(int iRow=0; iRow <n; iRow++){
            String line = scan.next();
            for(int iCol=0; iCol<n; iCol++){
                char ch = line.charAt(iCol);
                numberMap[iRow][iCol] = Integer.parseInt(Character.toString(ch));

                //입력 받자마자 1인곳이 있는지 체크
                if(numberMap[iRow][iCol] == 1){
                    queueOne.add(new NumberPoint(iCol, iRow));  //열, 행 순으로 입력!!!!!!!
                }
            }
        }


        //단지수 세기 위한 배열
        int[] cntHouse = new int[n*n];
        int town = 0; //cntHouse[]의 인덱스가 될것임!!
        /////여기서는 초기화 될 필요가 없음
        boolean[][] visited = new boolean[n][n];

        while(!queueOne.isEmpty()){
            NumberPoint p1 = queueOne.poll();

            if(visited[p1.y][p1.x]) continue;

            // 미방문이어서 BFS 탐색이 요하는 집이라면,
            town++; // 단지수 증가!!

            // '1'인 곳 주변 탐색위해
            Queue<NumberPoint> queueP = new LinkedList<>();
            queueP.add(p1);

            while(!queueP.isEmpty()){
                NumberPoint p2 = queueP.poll();

                if(visited[p2.y][p2.x]) continue;

                visited[p2.y][p2.x] = true;
                cntHouse[town]++;   // 집 개수 증가

                for(int iSearch=0; iSearch < moveRow.length; iSearch++){
                    int nextY = p2.y + moveRow[iSearch];    //행
                    int nextX = p2.x + moveCol[iSearch];    //열

                    if(nextY >=0 && nextY < n && nextX >=0 && nextX < n && !visited[nextY][nextX]
                            && numberMap[nextY][nextX] == 1 ){
                        queueP.add(new NumberPoint(nextX, nextY));
                    }
                } // for

            }   // while(집수세기)
        }   // while(단지 찾기)

        // 오름차순 정렬
        Arrays.sort(cntHouse);
        System.out.println("단지수 :" + town);
        int index = n*n-town;
        for(int x = index; x < n*n; x++){
            System.out.println("집의 개수 " + x + ": "+ cntHouse[x]);
        }





    }
}
