package code;

import java.util.Scanner;

public class P1109 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] bookings = new int[n][3];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < 3; j++){
                bookings[i][j] = scanner.nextInt();
            }
        }
        int answer[] = corpFlightBookings(bookings, n);
        for (int ans:
             answer) {
            System.out.println(ans);
        }
    }
    public static int[] corpFlightBookings(int[][] bookings, int n) {
        int answer[] = new int[n];
        for(int i = 0; i < n; i++){
            answer[i] = 0;
        }
        for(int i = 0; i < n; i++){
            for(int j = bookings[i][0]-1; j < bookings[i][1]; j++){
                answer[j] += bookings[i][2];
            }
        }
        return answer;
    }
}
