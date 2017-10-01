import java.util.Stack;

/**
 * Created by suyeon on 2017-09-16.
 */
public class Test {
    static public int n = 5;

    public static void main(String[] args){
        int[] arr1 = new int[]{9, 20, 28, 18, 11};
        int[] arr2 = new int[]{30, 1, 21, 17, 28};
        Stack<Integer> st = new Stack<>();
        char[][] mapOne = new char[n][n];
        char[][] mapTwo = new char[n][n];
        int temp1 = 0, temp2 = 0;


        for (int i = 0; i < 1; i++) {
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

            while (!st.isEmpty()){
                System.out.print(st.pop());
            }


            //    temp1 = 0; // arr[i]에 있는 수를 2로 나누었을때 몫을 담아둘 변수 초기화
            //   temp2 = 0;

         //   for(int j=0; j<n; j++){
         //       System.out.println(st.pop());
         //   }
/*
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
*/
        } //mapOne[][]


    }
}
