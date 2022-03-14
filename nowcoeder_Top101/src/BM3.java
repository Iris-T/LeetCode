/**
 * @author Iris 2022/3/14
 */
public class BM3 {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        n1.next = n2;
        ListNode n3 = new ListNode(3);
        n2.next = n3;
        ListNode n4 = new ListNode(4);
        n3.next = n4;
        ListNode n5 = new ListNode(5);
        n4.next = n5;
        ListNode head = n1;
        while (head != null) {
            System.out.print(head.val+" ");
            head = head.next;
        }
        System.out.println();
        ListNode newHead = reverseKGroup(n1, 3);
        while (newHead != null) {
            System.out.print(newHead.val+" ");
            newHead = newHead.next;
        }
    }

    /**
     * @see 链表中的节点每k个一组进行反转，不足k则不反转
     * @param head
     * @param k
     * @return
     */
    public static ListNode reverseKGroup (ListNode head, int k) {
        if (head == null || head.next == null || k<2) return head;
        ListNode res = new ListNode(Integer.MIN_VALUE);
        res.next = head;
        ListNode inx = head, pre = res, next;
        int len = 0;

        while (head != null) {
            len++;
            head = head.next;
        }
        for (int i = 0; i < len / k; i++) {
            for (int j = 0; j < k - 1; j++) {
                next = inx.next;
                inx.next = next.next;
                next.next = pre.next;
                pre.next = next;
            }
            pre = inx;
            inx = inx.next;
        }
        return res.next;
    }
}
