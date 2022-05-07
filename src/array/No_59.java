package array;

/**
 * No.59 螺旋矩阵II (middle) Microsoft
 */
public class No_59 {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int offset = 0;
        int loop = n / 2;
        int count = 1;
        while (loop > 0) {
            for (int j = offset; j < n - offset; j ++) {
                res[offset][j] = count;
                count ++;
            }

            for (int i = offset + 1; i < n - offset; i ++) {
                res[i][n - offset - 1] = count;
                count ++;
            }

            for (int j = n - offset - 2; j >= offset; j --) {
                res[n - offset - 1][j] = count;
                count ++;
            }

            for (int i = n -  offset - 2; i > offset; i --) {
                res[i][offset] = count;
                count ++;
            }

            loop --;
            offset ++;
        }

        if (n % 2 == 1) res[offset][offset] = count;
        return res;
    }
}
