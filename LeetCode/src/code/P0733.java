package code;

import java.util.Arrays;

public class P0733 {
    public static void main(String[] args) {
        P0733 main = new P0733();
        System.out.println(Arrays.deepToString(main.floodFill(new int[][]{{1, 1, 1}, {1, 1, 0}, {1, 0, 1}}, 1, 1, 2)));
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image[sr][sc] != newColor) {
            floodFill(image, sr, sc, image[sr][sc], newColor);
        }
        return image;
    }
    private void floodFill(int[][] image, int row, int col, int oldColor, int newColor) {
        image[row][col] = newColor;
        if (row > 0 && image[row-1][col] == oldColor) {
            floodFill(image, row-1, col, oldColor, newColor);
        }
        if (row + 1 < image.length && image[row+1][col] == oldColor) {
            floodFill(image, row+1, col, oldColor, newColor);
        }
        if (col > 0 && image[row][col] == oldColor) {
            floodFill(image, row, col-1, oldColor, newColor);
        }
        if (col + 1 < image[0].length && image[row][col+1] == oldColor) {
            floodFill(image, row, col+1, oldColor, newColor);
        }
    }
}
