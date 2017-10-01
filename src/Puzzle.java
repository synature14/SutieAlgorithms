/** 17.08.28(월)
    * 3x3 퍼즐을 맞춘다
    * 퍼즐의 각 블록은  1,2,3,4,5,6,7,8,9로 구성된다.
    * 초기 퍼즐의 모습은 아래와 같이 사용자에게 입력으로 받는다
    * 9 8 2
    * 1 3 4
    * 5 6 7
    *
    * 퍼즐을 풀기 위해선 1을 상,하,좌,우로 1칸씩 움직여
    * 아래와 같은 모습의 퍼즐을 만들어야 한다
    * 1 2 3
    * 4 5 6
    * 7 8 9
    *
    * 만약, 퍼즐을 맞출 수 없다면 Impossible을 출력하고
    * 퍼즐을 맞출 수 있다면 퍼즐을 맞추기 위해 1을 몇번이나 움직였는지 출력한다
    */

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Puzzle {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        int[] moveRow = new int[] {-1, 1, 0, 0};
        int[] moveCol = new int[] {0, 0, -1, 1};

        Integer[][] puzzle = new Integer[3][3]; //Integer는 클래스임

        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                puzzle[i][j] = scan.nextInt();
            }
        }

        Queue<Integer[][]> queue = new LinkedList<>();  //2차원 배열
        queue.add(puzzle);

        Integer[][] temp;  // 큐에 저장된 2차원 배열을 임시적으로 저장할곳
        Integer[][] cmp = new Integer[][] {{1,2,3}, {4,5,6}, {7,8,9}};  // 우리가 원하는 답(비교대상)

        HashSet<String> hashSet = new HashSet<>(); //hashset : 이전에 1이동시켰던 배열 상태와 같은지 비교
        boolean matched = true;

        while(!queue.isEmpty()){
            temp = queue.poll();
            // 123456789 로 나열됐는지 check
            for(int i=0; i<3; i++){
                for(int j=0; j<3; j++){
                    if(temp[i][j] != cmp[i][j]) {
                        //temp가 가리키는 시작주소로 간다 --> 큐에 담아있는 곳(처음엔 puzzle, 그 다음부턴 newMap)의
                        // i번지, j번지의 데이터와 비교
                        matched = false;
                        // break는 자신을 감싸는 가장 근접한 루프를 빠져나온다
                        break;
                    }
                } // 첫번째 for
                if (matched == false) {
                    break;  //두번쨰 for구문도 탈출
                }
            }  // 두번쨰 for

            if (matched) {
                break;  //while문 탈출
            }


            // find location of 1
            int colZero=-1, rowZero=-1;
            for(int i=0; i<3; i++){
                for(int j=0; j<3; j++){
                    //1의 위치
                    if(temp[i][j] == 1){
                        colZero = j;
                        rowZero = i;
                   }
               }
           }

           // relocate location of zero
            for (int i=0; i<moveCol.length; i++) {
                // check movable
                int nextRow = rowZero + moveRow[i];
                int nextCol = colZero + moveCol[i];
                // if movable, relocate
                if (nextRow >= 0 && nextRow < 3 && nextCol >= 0 && nextCol < 3){
                    Integer[][] newMap = new Integer[3][3];


                    //깊은 복사 ex) newMap = temp; 해버리면 temp가 가리키는 puzzle의 주소만 복사해버림
                    for (int k1=0; k1<3; k1++) {
                        for (int k2=0; k2<3; k2++) {
                            newMap[k1][k2] = temp[k1][k2];
                        }
                    }

                    // 1 이동시키기 swap
                    int tmp = newMap[nextRow][nextCol];
                    newMap[nextRow][nextCol] = newMap[rowZero][colZero];
                    newMap[rowZero][colZero] = tmp;

                    // hashset과 비교
                    // 2차원--> 1차원으로
                    // Jvm에서는 문자열을 문자열 풀에서 관리를 한다
                    //
                    StringBuilder builder = new StringBuilder();
                    for(int x=0; x<3; x++){
                        for (int y=0; y<3; y++) {
                            builder.append(newMap[x][y]);
                        }
                    }

                    String line = builder.toString();

                    if (!hashSet.contains(line)) {
                        // 큐에 1이동시킨 배열 넣기
                        queue.add(newMap);
                        hashSet.add(line);
                    }
                }
            } //for  : 4가지 방향이동 완료
            // 완성된 배열인지 아닌지 체크는 while문 처음으로 돌아가서 다시 실행할때

        } // while
        if (matched) {
            System.out.println("Matched");
        } else {
            System.out.println("Not Matched");
        }
    }
}