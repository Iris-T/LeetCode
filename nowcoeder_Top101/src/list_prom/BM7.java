package list_prom;

/**
 * @author Iris 2022/3/16
 */
public class BM7 {

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = b;
        System.out.println(EntryNodeOfLoop(a).val);
    }

    /**
     * @see 找出链表环的入口，没有环返回NULL
     * @param pHead
     * @return
     */
    public static ListNode EntryNodeOfLoop(ListNode pHead) {
        if (pHead == null) return null;
        ListNode slow = pHead, fast = pHead;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) break;
        }
        if (fast == null || fast.next == null) return null;
        slow = pHead;
        while (fast !=  slow) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
