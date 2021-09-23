package code;

public class P0096 {
    public static void main(String[] args) {
        P0096 main = new P0096();
        System.out.println(main.numTrees(3));
    }
    public int numTrees(int n) {
        int[] arr = new int[n+1];
        arr[0] = 1;
        arr[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                arr[i] += arr[j]*arr[i-j-1];
            }
        }
        return arr[n];
    }
}
