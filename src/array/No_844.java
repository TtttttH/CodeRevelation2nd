package array;

/**
 * No.844 比较含退格的字符串 (easy)
 */
public class No_844 {
    public boolean backspaceCompare(String s, String t) {
        StringBuilder sbs = new StringBuilder();
        StringBuilder sbt = new StringBuilder();
        buildSb(sbs, s);
        buildSb(sbt, t);
        if (sbs.length() != sbt.length()) {
            return false;
        }

        for (int i = 0; i < sbs.length(); i ++) {
            if (sbs.charAt(i) != sbt.charAt(i)) {
                return false;
            }
        }

        return true;
    }

    private void buildSb (StringBuilder sb, String s) {
        for (char c : s.toCharArray()) {
            if (c != '#') {
                sb.append(c);
            } else if (sb.length() > 0) {
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
}
