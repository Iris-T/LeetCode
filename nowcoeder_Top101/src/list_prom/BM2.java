package list_prom;

/**
 * @author Iris 2022/3/13
 */
public class BM2 {

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
        ListNode newHead = reverseBetween(n1, 2, 4);
        while (newHead != null) {
            System.out.print(newHead.val+" ");
            newHead = newHead.next;
        }
    }

    /**
     * @see 链表指定区间反转
     * @param head
     * @param m
     * @param n
     * @return
     */
    public static ListNode reverseBetween (ListNode head, int m, int n) {
        if (head == null || head.next == null || m==n) return head;
        ListNode res = new ListNode(Integer.MIN_VALUE);
        res.next = head;
        ListNode preTail = res, inx = head;
        // 遍历前部分节点
        for (int i = 1; i < m; i++) {
            preTail = inx;
            inx = inx.next;
        }
        for (int i = 0; i < n - m; i++) {
            ListNode next = inx.next;
            inx.next = next.next;
            next.next = preTail.next;
            preTail.next = next;
        }
        return res.next;
    }
}
