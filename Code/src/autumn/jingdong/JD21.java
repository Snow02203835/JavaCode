package autumn.jingdong;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JD21 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        List<JD11.Point> points = new ArrayList<>(num);
        int x, y;
        int maxX = 0, maxY = 0;
        for (int i = 0; i < num; i++) {
            x = scanner.nextInt();
            y = scanner.nextInt();
            maxX = Math.max(x, maxX);
            maxY = Math.max(y, maxY);
            points.add(new JD11.Point(x, y));
        }
        int sums = 0;
        for (int i = 1; i <= maxY; i++) {
            int pairs = 0;
            for (JD11.Point point : points) {
                if (point.isLine(0, i)) {
                    pairs++;
                }
            }
            sums += (pairs*(pairs-1))/2;
        }
        for (int i = 2; i <= maxX; i++) {
            int pairs = 0;
            for (JD11.Point point : points) {
                if (point.isLine(i, 0)) {
                    pairs++;
                }
            }
            sums += (pairs*(pairs-1))/2;
        }
        for (int i = 2; i <= maxX; i++) {
            int pairs = 0;
            for (JD11.Point point : points) {
                if (point.isLine(i, maxY)) {
                    pairs++;
                }
            }
            sums += (pairs*(pairs-1))/2;
        }
        System.out.println(sums);
    }
    static class Point {
        int x, y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
        boolean isLine(int start, int end) {
            return Math.abs(start - x) == Math.abs(end - y);
        }
    }
}
