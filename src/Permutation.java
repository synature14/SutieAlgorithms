import java.util.Scanner;

/**
 * Created by suyeon on 2017-09-06.
 */
public class Permutation {
    static int[] array = null;

    public static void perm(int index){
        System.out.print("index: " + index + " ");
        for(int i=0; i<array.length; i++){
            System.out.print(array[i]);
        }
        System.out.println();

        if(index >= array.length){   //종료
            System.out.println("Terminated");
        }

        for (int i=index; i<array.length; i++) {
            swap(index, i);
            System.out.print("index: " + index + " to: " + i + " ");
            perm(index+1);      //호출
            swap(index, i);     //다시 배열 원상태로 복구
        }
    }

    private static void swap(int from, int to) {
        int temp = array[from];
        array[from] = array[to];
        array[to] = temp;
    }


    public static void main(String[] args){

        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        array = new int[n];

        for(int i=0; i<n; i++){
            array[i] = i+1;
        }

        perm(0);
    }
}
