package List;

/**
 * No.707 Design LinkedList (middle)
 */
public class No_707 {
    public class MyLinkedList {
        int size;
        ListNode head;
        public MyLinkedList(){
            this.size = 0;
            head = new ListNode(0);
        }

        public int get(int index) {
            if (index < 0 || index >= size) {
                return -1;
            }

            ListNode cur = head;
            while (index >= 0) {
                cur = cur.next;
                index --;
            }

            return cur.val;
        }

        public void addAtHead(int val) {
            ListNode node = new ListNode(val);
            ListNode temp = head.next;
            head.next = node;
            node.next = temp;
            size ++;
        }

        public void addAtTail(int val) {
            ListNode node = new ListNode(val);
            ListNode cur = head;
            while (cur.next != null) {
                cur = cur.next;
            }

            cur.next = node;
            size ++;
        }

        public void addAtIndex(int index, int val) {
            if (index < 0) {
                index = 0;
            }
            if (index > size) {
                return;
            }
            ListNode preNode = head;
            for (int i = 0; i < index; i ++) {
                preNode = preNode.next;
            }
            ListNode node = new ListNode(val);
            node.next = preNode.next;
            preNode.next = node;
            size ++;
        }

        public void deleteAtIndex(int index) {
            if (index >= 0 && index < size) {
                ListNode preNode = head;
                for (int i = 0; i < index; i ++) {
                    preNode = preNode.next;
                }
                preNode.next = preNode.next.next;
                size --;
            }
        }
    }
}
