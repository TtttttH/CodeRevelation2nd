package List;

/**
 * 面试题02.07. Intersection of Two Linked Lists LCCI
 */
public class No_02_07 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode curA = headA;
        ListNode curB = headB;
        int countA = 0;
        int countB = 0;
        while (curA!= null) {
            countA ++;
            curA = curA.next;
        }

        while (curB != null) {
            countB ++;
            curB = curB.next;
        }
        curA = headA;
        curB = headB;
        if (countA > countB) {
            for (int i = 0; i < countA - countB; i ++) {
                curA = curA.next;
            }
        } else {
            for (int i = 0; i < countB - countA; i++) {
                curB = curB.next;
            }
        }

        while (curA != curB) {
            curA = curA.next;
            curB = curB.next;
        }

        return curA;
    }

    //数学方法,类似环形链表思想
//    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
//        ListNode curA = headA;
//        ListNode curB = headB;
//        while (curA != curB) {
//            curA = curA == null ? headB : curA.next;
//            curB = curB == null ? headA : curB.next;
//        }
//
//        return curA;
//    }
}
