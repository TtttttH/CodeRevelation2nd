package String;

/**
 * No.28 实现strStr() easy(但是KMP我觉得是hard)
 */
public class No_28 {

    public int strStr(String haystack, String needle) {
        int nLen = needle.length();
        int hLen = haystack.length();
        if (nLen == 0) return 0;
        int[] next = new int[nLen];
        getNext(next, needle);
        int j = -1;
        for (int i = 0; i < hLen; i ++) {
            while (j >= 0 && haystack.charAt(i) != needle.charAt(j + 1)) {
                j = next[j];
            }

            if (haystack.charAt(i) == needle.charAt(j + 1)) {
                j ++;
            }

            if (j == nLen - 1) return i - nLen + 1;
        }

        return -1;
    }

    private void getNext(int[] next, String needle) {
        int j = -1;
        next[0] = j;
        for (int i = 1; i < needle.length(); i ++) {
            while (j >= 0 && needle.charAt(i) != needle.charAt(j + 1)) {
                j = next[j];
            }

            if (needle.charAt(i) == needle.charAt(j + 1)) {
                j ++;
            }

            next[i] = j;
        }
    }

    public static void main(String[] args) {
        String haystack = "aaabbb";
        String needle = "abb";
        No_28 test = new No_28();
        System.out.println(test.strStr(haystack, needle));
    }
}
