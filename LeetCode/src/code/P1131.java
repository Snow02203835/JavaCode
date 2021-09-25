package code;

import java.util.Arrays;

/**
 * 绝对值表达式的最大值
 * @author snow
 * @since 2021/09/25 14:45
 */
public class P1131 {
    public int maxAbsValExpr(int[] arr1, int[] arr2) {
        int[][] arr = new int[4][arr1.length];
        for (int i = 0; i < arr1.length; i++) {
            int sum = arr1[i] + arr2[i];
            int gap = arr1[i] - arr2[i];
            arr[0][i] = sum + i;
            arr[1][i] = sum - i;
            arr[2][i] = gap + i;
            arr[3][i] = gap - i;
        }
        int[] answer = new int[4];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = max(arr[i]) - min(arr[i]);
        }
        return max(answer);
    }
    public int max(int[] arr) {
        int max = 0x80000000;
        for (int value : arr) {
            if (value > max) {
                max = value;
            }
        }
        return max;
    }
    private int min(int[] arr) {
        int min = 0x7fffffff;
        for (int value : arr) {
            if (value < min) {
                min = value;
            }
        }
        return min;
    }

//    def maxAbsValExpr(self, arr1, arr2):
//            """
//        :type arr1: List[int]
//        :type arr2: List[int]
//        :rtype: int
//        """
//    A, B, C, D= [], [], [], []
//            for i in range(len(arr1)):
//    x, y = arr1[i], arr2[i]
//            A.append(x + y + i)
//            B.append(x + y - i)
//            C.append(x - y + i)
//            D.append(x - y - i)
//
//    a = max(A) - min(A)
//    b = max(B) - min(B)
//    c = max(C) - min(C)
//    d = max(D) - min(D)
//        return max(a, b, c, d)
}
