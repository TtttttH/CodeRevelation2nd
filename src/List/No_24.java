package List;

/**
 * No.24 Swap Nodes in Pairs(middle)
 */
public class No_24 {
//    public ListNode swapPairs(ListNode head) {
//        ListNode dummyHead = new ListNode(0);
//        dummyHead.next = head;
//        ListNode cur = dummyHead;
//        ListNode preNode = dummyHead;
//        while (cur.next != null && cur.next.next != null) {
//            cur = preNode.next;
//            preNode.next = cur.next;
//            cur.next = cur.next.next;
//            preNode.next.next = cur;
//            preNode = cur;
//        }
//
//        return dummyHead.next;
//    }

    //递归写法
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode next = head.next;
        ListNode newNode = swapPairs(next.next);
        next.next = head;
        head.next = newNode;
        return next;
    }
}
