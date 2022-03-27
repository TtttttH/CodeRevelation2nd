package dp.bagIssue;

import java.util.List;

/**
 * No.139 单词拆分(middle) Microsoft
 */
public class No_139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i ++) {
            for (String word : wordDict) {
                if (word.length() <= i && s.substring(i - word.length(), i).equals(word) && dp[i - word.length()]) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
