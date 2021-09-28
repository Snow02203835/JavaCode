package code;

/**
 * 找出游戏的获胜者
 * @author snow
 * @since 2021/09/28 13:40
 */
public class P1823 {
    public static void main(String[] args) {
        P1823 main = new P1823();
        System.out.println(main.findTheWinner(5, 2));
    }
    public int findTheWinner(int n, int k) {
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
        int index = 0, count = 1, size = n;
        while (size != 1) {
            while (arr[index] == -1) {
                index = increase(index, n);
            }
            if (count == k) {
                arr[index] = -1;
                --size;
                count = 1;
            } else {
                count++;
            }
            index = increase(index, n);
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != -1) {
                return i+1;
            }
        }
        return 0;
    }
    private int increase(int index, int size) {
        return index + 1 < size ? index+1 : 0;
    }
}
