import java.util.Scanner;

/**
 * Created by suyeon on 2017-09-22.
 */



public class LCABasic {
    public static int nNode;    //코드 실행과 상관없이 컴파일 되는 순간에 메모리에 올라간다 --> 프로그램 죽일때까지 계속 있음
    public static boolean[] visited;
    public static int[] depthArray;
    public static boolean[][] tree;
    public static int[] parent;

    //dfs method
    public static void dfs(int here, int depth){        //컴파일 되는 시점에 dfs()를 클래스로 만들지 않고 바로 호출 가능! 번거로우니까!
       // System.out.println("here :" + here);
        visited[here] = true;
        depthArray[here] = depth;    //here번 노드의 depth

        for(int i=1; i<tree[here].length; i++ ){
           // System.out.println("i : " +i+ "  here : " +here);
            if(tree[here][i] == true && !visited[i]){
                parent[i] = here;   //인덱스가 자식, 값이 부모 노드
                dfs(i, depth+1);
            }
        }
    } //dfs()

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        nNode = scan.nextInt();
        visited = new boolean[nNode+1];
        depthArray = new int[nNode+1];
        tree = new boolean[nNode+1][nNode+1];
        parent = new int[nNode+1];

        // 연결된 노드들 2차원 배열에 true로 표시
        for(int i=1; i<nNode; i++){
            int p1 = scan.nextInt();
            int p2 = scan.nextInt();
            tree[p1][p2] = tree[p2][p1] = true;
        }

   /*     for(int x=1; x<=nNode; x++){
            for(int y=1; y<=nNode; y++){
                System.out.print(tree[x][y]);
            }
            System.out.println();
        }

    */
        // 공통조상을 알고싶은 쌍의 개수
        int nPair = scan.nextInt();
        int[] small = new int[nPair];
        int[] big = new int[nPair];
        int[] answer = new int[nPair];

        //전체의 depth를 탐색
        dfs(1, 0);  //루트부터 시작!

        //parent[1]은 1의 부모가 없으므로 0
        parent[1] = 0;

        for(int i=0; i<nPair; i++){
            small[i] = scan.nextInt();
            big[i] = scan.nextInt();
        } //for()

        for(int i=0; i<nPair; i++){
            if(small[i] > big[i]){
                int temp = small[i];
                small[i] = big[i];
                big[i] = temp;
            }

            while(depthArray[big[i]] != depthArray[small[i]]){
                big[i] = parent[big[i]];
            }

            while(big[i] != small[i]){      //big과 small의 depth가 같은 상태
                big[i] = parent[big[i]];
                small[i] = parent[small[i]];

               // if(big[i] == small[i])  break;
            }

            //big이나 small의 공통조상
            answer[i] = big[i];

        }



        for(int i=0; i<nPair; i++){
            System.out.println(answer[i]);
        }


    }
}
