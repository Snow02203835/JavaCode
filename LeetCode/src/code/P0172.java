package code;

public class P0172{
	public static void main(String[] args) {
		System.out.println(trailingZeroes(5787));
	}
    public static int trailingZeroes(int n) {
        int sums = 0;
        for (int i = 5; i <= n; i += 5) {
			sums += count(i);
        }
        return sums;
    }
    private static int count(int num) {
		System.out.print(num);
        int i = 0;
        while (num%5 == 0) {
            i++;
            num /= 5;
        }
		System.out.println(": " + i);
        return i;
    }
}