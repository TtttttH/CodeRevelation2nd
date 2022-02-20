package String;

/**
 * 剑指offerII 58 左旋转字符串 (easy)
 */
public class Offer_58 {
    public String reverseLeftWords(String s, int n) {
        return s.substring(n) + s.substring(0, n);
    }
}
