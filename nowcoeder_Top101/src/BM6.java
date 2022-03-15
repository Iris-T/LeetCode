/**
 * @author Iris 2022/3/15
 */
public class BM6 {

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(1);
        ListNode c = new ListNode(1);
        ListNode d = new ListNode(1);
        a.next = b;
        b.next = c;
        c.next = d;
//        d.next = b;
        System.out.println(hasCycle(a));
    }

    public static boolean hasCycle(ListNode head) {
        if (head == null) return false;
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) return true;
        }
        return false;
    }
}
