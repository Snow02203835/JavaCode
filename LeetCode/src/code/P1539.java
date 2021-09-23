package code;

public class P1539{
    public static int findKthPositive(int[] arr, int k) {
		int index = 0;
		for (int i = 1; i < 2005; i++) {
			if (arr[index] == i) {
				index++;
			} else {
				k--;
				if (k == 0) {
					return i;
				}
			}
		}
		return 0;
    }
}