package String;

/**
 * No.541反转字符串II (easy)
 */
public class No_541 {
    StringBuilder sb = new StringBuilder();
    public String reverseStr(String s, int k) {
        int idx = 0;
        while (idx < s.length()) {
            if (idx + 2 * k <= s.length()) {
                reverse(s, idx, idx + k - 1);
                sb.append(s, idx + k, idx + 2 * k);
                idx += 2 * k;
            } else if (idx + k <= s.length()) {
                reverse(s, idx, s.length() - 1);
                idx = s.length();
            } else {
                reverse(s, idx, idx + k - 1);
                sb.append(s, idx + k, s.length());
                idx = s.length();
            }
        }

        return sb.toString();
    }

    private void reverse(String s, int begin, int end) { //[begin, end]
        while (end >= begin) {
            sb.append(s.charAt(end --));
        }
    }
}
