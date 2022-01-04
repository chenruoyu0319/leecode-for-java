package leecode;

/**
 * @author cry777
 * @program demo1
 * @description 剑指 Offer 29. 顺时针打印矩阵
 * @create 2022-01-04
 */
public class SolutionOffer29 {

    /**
     * matrix = [[1,2,3],[4,5,6],[7,8,9]]
     * 1 2 3
     * 4 5 6
     * 7 8 9
     */
    public static int[] spiralOrder(int[][] matrix) {
        if (matrix.length == 0) {
            return new int[0];
        }
        int l = 0;
        int r = matrix[0].length - 1;  // 2
        int t = 0;
        int b = matrix.length - 1; // 2
        int x = 0;
        int[] res = new int[(r + 1) * (b + 1)];
        while (true) {
            for (int i = l; i <= r; i++) {
                res[x++] = matrix[t][i]; // left to right.
            }
            if (++t > b) {
                break;
            }
            for (int i = t; i <= b; i++) {
                res[x++] = matrix[i][r]; // top to bottom.
            }
            if (l > --r) {
                break;
            }
            for (int i = r; i >= l; i--) {
                res[x++] = matrix[b][i]; // right to left.
            }
            if (t > --b) {
                break;
            }
            for (int i = b; i >= t; i--) {
                res[x++] = matrix[i][l]; // bottom to top.
            }
            if (++l > r) {
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        int[] ints = spiralOrder(matrix);
        for (int i = 0; i < ints.length; i++) {
            System.out.print(i + " ");
        }
    }
}
