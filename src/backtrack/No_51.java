package backtrack;

import java.util.*;

/**
 * No.51 N皇后 (hard)
 */
public class No_51 {
    //记录区分左对角线上是否有皇后的集合
    Set<Integer> diagonals1 = new HashSet<>();
    //记录区分右对角线上是否有皇后的集合
    Set<Integer> diagonals2 = new HashSet<>();
    //记录区分当前列上是否有皇后的集合
    Set<Integer> column = new HashSet<>();
    List<List<String>> res = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        int[] queens = new int[n];
        Arrays.fill(queens, -1);
        backtrack(n, queens, 0);
        return res;
    }

    private void backtrack(int n, int[] queens, int row) {
        if (row == n)  {
            List<String> list = generateBoard(queens);
            res.add(list);
            return;
        }
        for (int i = 0; i < n; i ++) {
            if (column.contains(i)) continue;
            int diagonal1 = i + row; //计算左对角线值
            if (diagonals1.contains(diagonal1)) continue;
            int diagonal2 = i - row; //计算右对角线值
            if (diagonals2.contains(diagonal2)) continue;
            column.add(i);
            diagonals1.add(diagonal1);
            diagonals2.add(diagonal2);
            queens[row] = i;
            backtrack(n, queens, row);
            queens[row] = -1;
            column.remove(i);
            diagonals1.remove(diagonal1);
            diagonals2.remove(diagonal2);
        }
    }

    private List<String> generateBoard(int[] queens) {

        List<String> list = new ArrayList<>();
        for (int queen : queens) {
            char[] s = new char[queens.length];
            Arrays.fill(s, '.');
            s[queen] = 'Q';
            list.add(Arrays.toString(s));
        }

        return list;
    }
}
