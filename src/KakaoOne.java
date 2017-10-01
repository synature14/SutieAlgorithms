import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Created by suyeon on 2017-09-16.
 */
public class KakaoOne {
    public static void main(String[] args) {
        // KakaoOne k = new KakaoOne();

        int n=5;
        int[] arr1 = new int[]{9, 20, 28, 18, 11};
        int[] arr2 = new int[]{30, 1, 21, 17, 28};

        Stack<Integer> st = new Stack<>();
        char[][] mapOne = new char[n][n];
        char[][] mapTwo = new char[n][n];
        int temp1 = 0, temp2 = 0;

        for (int i = 0; i < n; i++) {
            int origin = arr1[i];
            do {
                temp1 = origin / 2;  // 몫
                temp2 = origin % 2;  // 나머지

                st.push(temp2);

                origin = temp1;

            } while (temp1 >= 2);
            st.push(temp1);


            // 스택 사이즈 체크!
            if(st.size() < n){
                while(st.size() < n){
                    st.push(0);
                }
            }
            for (int j = 0; j < n; j++) {
                int POP = st.peek();
                if (POP == 1) {
                    mapOne[i][j] = '#';
                    st.pop();
                } else {
                    mapOne[i][j] = ' ';
                    st.pop();
                }
            }

        } //mapOne[][]

//Test
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                System.out.print(mapOne[i][j]);
            }
            System.out.println();
        }



        for (int i = 0; i < n; i++) {
            int origin = arr2[i];
            do {
                temp1 = origin / 2;  // 몫
                temp2 = origin % 2;  // 나머지

                st.push(temp2);

                origin = temp1;

            } while (temp1 >= 2);

            st.push(temp1);

            //스택 사이즈 체크!
            if(st.size() < n){
                while(st.size() < n){
                    st.push(0);
                }
            }

            for (int j = 0; j < n; j++) {
                int POP = st.peek();
                if (POP == 1) {
                    mapTwo[i][j] = '#';
                    st.pop();
                } else {
                    mapTwo[i][j] = ' ';
                    st.pop();
                }
            }

        } //mapTwo[][]


//Test
        System.out.println("mapTwo");
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                System.out.print(mapTwo[i][j]);
            }
            System.out.println();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (mapOne[i][j] == '#' && mapTwo[i][j] == ' ') {
                    mapTwo[i][j] = '#';
                }
            }
        }





        List<String> lines = new LinkedList<>();
        for (int i=0; i<n; i++) {
            StringBuilder b = new StringBuilder();
            for (int j=0; j<n; j++) {
                b.append(mapTwo[i][j]);
              //  System.out.print(mapTwo[i][j]);
            }
           // System.out.println();
            lines.add(b.toString());
        }

        String[] answer = new String[n];
        answer = lines.toArray(answer);
        System.out.println(Arrays.toString(answer));

       // k.solution(5, arr1, arr2);
    }

    /*

    public String[] solution(int n, int[] arr1, int[] arr2) {

        Stack<Integer> st = new Stack<>();
        char[][] mapOne = new char[n][n];
        char[][] mapTwo = new char[n][n];
        int temp1=2, temp2 = 2;

        for (int i = 0; i < n; i++) {
            while (temp1 < 2) {
                temp1 = arr1[i] % 2;
                st.push(temp1);
            }
            temp1 = 2; //초기화
            for (int j = 0; j < n; j++) {
                int POP = st.pop();
                if (POP == 1) {
                    mapOne[i][j] = '#';
                } else mapOne[i][j] = ' ';
            }
        }

        for (int i = 0; i < n; i++) {
            while (temp2 < 2) {
                temp2 = arr2[i] % 2;
                st.push(temp2);
            }
            temp2 = 2; //초기화
            for (int j = 0; j < n; j++) {
                int POP = st.pop();
                if (POP == 1) {
                    mapTwo[i][j] = '#';
                } else mapTwo[i][j] = ' ';
            }
        }


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (mapOne[i][j] == '#' && mapTwo[i][j] == ' ') {
                    mapTwo[i][j] = '#';
                }
            }
        }
        System.out.println(mapTwo);
        // String[] answer = {};
          return null;
    }

    */
}

