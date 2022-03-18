package list_prom;

/**
 * @author Iris 2022/3/13
 */
public class BM1 {

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        n1.next = n2;
        ListNode n3 = new ListNode(3);
        n2.next = n3;
        ListNode head = n1;
        while (head != null) {
            System.out.print(head.val+" ");
            head = head.next;
        }
        System.out.println();

        ListNode newHead = ReverseList(n1);
        while (newHead != null) {
            System.out.print(newHead.val+" ");
            newHead = newHead.next;
        }
    }

    /**
     * @see 反转链表
     * @param head
     * @return
     */
    public static ListNode ReverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode res = null, next = null;
        while (head != null) {
            next = head.next;
            head.next = res;
            res = head;
            head = next;
        }
        return res;
    }
}
