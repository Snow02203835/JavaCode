import java.util.Arrays;
import java.util.Scanner;

public class P1956 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int arrLength1 = scanner.nextInt();
        int[] arr1 = new int[arrLength1];
        for(int i = 0; i < arrLength1; i++){
            arr1[i] = scanner.nextInt();
        }
        int arrLength2 = scanner.nextInt();
        int[] arr2 = new int[arrLength2];
        for(int i = 0; i < arrLength2; i++){
            arr2[i] = scanner.nextInt();
        }
        System.out.println(smallestDifference(arr1, arr2));
    }
    public static int smallestDifference(int[] a, int[] b) {
        Arrays.sort(a);
        Arrays.sort(b);
        int index = 0;
        long minAbs = 0x7fffffffffffL;
        for(int i = 0 ; i < a.length; i++){
            long current = 0x7fffffffffffL;
            for(int j = index; j < b.length; j++){
                long myAbs = Math.abs((long)a[i] - (long)b[j]);
                if(myAbs <= current){
                    current = myAbs;
                    index = j;
                }
                else{
                    break;
                }
            }
            if(current < minAbs){
                minAbs = current;
            }
        }
        return (int)minAbs;
    }
}
