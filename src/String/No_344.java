package String;

/**
 * No.344 反转字符串 (easy)
 */
public class No_344 {
    public void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;
        char temp;
        while (left < right) {
            temp = s[left];
            s[left++] = s[right];
            s[right --] = temp;
        }
    }
}
