package doublePoint;

/**
 * No.392 判断子序列(easy)
 */
public class No_392 {
    public boolean isSubsequence(String s, String t) {
        int slen = s.length() - 1, tlen = t.length() - 1;
        if (slen > tlen) return false;
        while (slen > 0 && tlen > 0) {
            if (s.charAt(slen) == t.charAt(tlen)) {
                slen --;
            }
            tlen --;
        }

        return slen == 0;
//        int[][] dp = new int[slen + 1][tlen + 1];
//        for (int i = 1; i <= slen; i ++) {
//            for (int j = 1; j <= tlen; j ++) {
//                if (s.charAt(i - 1) == t.charAt(j - 1)) {
//                    dp[i][j] = dp[i - 1][j - 1] + 1;
//                } else {
//                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
//                }
//            }
//        }
//
//        return dp[slen][tlen] == slen;
    }
}
