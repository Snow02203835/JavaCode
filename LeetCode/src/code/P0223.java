package code;

/**
 * 矩形面积
 * @author snow
 * @since 2021/09/30 13:58
 */
public class P0223 {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int area = (ax2 - ax1) * (ay2 - ay1) + (bx2 - bx1) * (by2 - by1);
        int sameW = cover(ay1, ay2, by1, by2), sameL = cover(ax1, ax2, bx1, bx2);
        return area - sameW * sameL;
    }
    private int cover(int a1, int a2, int b1, int b2) {
        int same;
        if (a2 > b2) {
            if (b2 <= a1) {
                same = 0;
            } else {
                if (a1 >= b1) {
                    same = b2 - a1;
                } else {
                    same = b2 - b1;
                }
            }
        } else if (a2 == b2){
            same = a2 - Math.max(a1, b1);
        } else {
            if (a2 <= b1) {
                same = 0;
            } else {
                if (b1 >= a1) {
                    same = a2 - b1;
                } else {
                    same = a2 - a1;
                }
            }
        }
        return same;
    }
}
