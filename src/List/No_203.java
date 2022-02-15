package List;

/**
 * No.203 移除链表元素 (easy)
 */
public class No_203 {
    public ListNode removeElements(ListNode head, int val) {
        ListNode preHead = new ListNode(0);
        preHead.next = head;
        ListNode cur = preHead;
        while (cur.next != null) {
            if (cur.next.val == val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }

        return preHead.next;
    }
}
