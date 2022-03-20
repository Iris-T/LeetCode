package list_prom;

/**
 * @author Iris 2022/3/20
 */
public class BM14 {

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(2);
        ListNode e = new ListNode(1);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        ListNode res = oddEvenList(a);
        System.out.println(res.toString());
    }

    /**
     * @see 按照节点奇偶分链表
     * @param head
     * @return
     */
    public static ListNode oddEvenList (ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode res = new ListNode(-1);
        res.next = head;
        ListNode even = head.next;
        ListNode evenHead = even;
        ListNode cur = head.next.next;
        int inx = 3;
        while (cur != null) {
            ListNode next = cur.next;
            if (inx % 2 == 0) {
                even.next = cur;
                even = even.next;
                even.next = null;
            } else {
                head.next = cur;
                head = head.next;
                head.next = null;
            }
            cur = next;
            inx ++;
        }
        head.next = evenHead;
        return res.next;
    }
}
