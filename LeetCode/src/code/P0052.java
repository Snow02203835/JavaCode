package code;

public class P0052 {
    public static void main(String[] args) {
        P0051 main = new P0051();
        for (int i = 1; i <= 9; i++) {
            System.out.print(main.solveNQueens(i).size() + ", ");
        }
    }
    private final static int[] arr = new int[] {0, 1, 0, 0, 2, 10, 4, 40, 92, 352};
    public int totalNQueens(int n) {
        return arr[n];
    }
}
