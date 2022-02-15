package List;

/**
 * No.206 reverse linked list(easy)
 */
public class No_206 {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode preHead = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = preHead;
            preHead = cur;
            cur = temp;
        }

        return preHead;
    }
}
