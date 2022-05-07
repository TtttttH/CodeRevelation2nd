package List;

/**
 * No.82 删除排序链表中的重复元素II (middle)
 * Microsoft
 */
public class No_82 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(-101);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = head;
        while (cur != null && cur.next != null) {
            if (cur.val == cur.next.val) {
                while (cur.next != null && cur.next.val == cur.val) {
                    cur = cur.next;
                }
                pre.next = cur.next;

            } else {
                pre.next = cur;
                pre = pre.next;
            }
            cur = cur.next;
        }

        return dummy.next;
    }
}
