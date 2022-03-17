/**
 * @author Iris 2022/3/17
 */
public class BM9 {

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(5);
        ListNode f = new ListNode(6);
        a.next = b;
//        b.next = c;
//        c.next = d;
//        d.next = e;
//        e.next = f;
//        ListNode res = removeNthFromEnd(a, 2);
        ListNode res = removeNthFromEnd(a, 1);
        System.out.println((res == null) ? null : res.toString());
    }

    /**
     * 删除第n个节点，返回头指针
     * @param head
     * @param n
     * @return
     */
    public static ListNode removeNthFromEnd (ListNode head, int n) {
        ListNode fast = head, slow = head, temp = null;
        while (--n > 0) {
            fast = fast.next;
        }
        while (fast.next != null) {
            temp = slow;
            fast = fast.next;
            slow = slow.next;
        }
        if (temp != null) temp.next = slow.next;
        else head = head.next;
        return head;
    }
}
