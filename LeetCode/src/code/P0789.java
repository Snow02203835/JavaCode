package code;

public class P0789 {
    public static void main(String[] args) {

    }
    public boolean escapeGhosts(int[][] ghosts, int[] target) {
        int distance = Math.abs(target[0]) + Math.abs(target[1]);
        for (int[] src : ghosts) {
            if (countDistance(src, target) <= distance) {
                return false;
            }
        }
        return true;
    }
    private int countDistance(int[] src, int[] dis) {
        return Math.abs(src[0] - dis[0]) + Math.abs(src[1] - dis[1]);
    }
}
