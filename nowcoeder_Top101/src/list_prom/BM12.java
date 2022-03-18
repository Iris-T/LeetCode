package list_prom;

/**
 * @author Iris 2022/3/18
 */
public class BM12 {
    public static void main(String[] args) {
        ListNode a = new ListNode(2);
        ListNode b = new ListNode(1);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(5);
        ListNode f = new ListNode(6);
        a.next = c;
        c.next = d;
        d.next = b;
        b.next = f;
        f.next = e;
        System.out.println(a.toString());
        ListNode newHead = sortInList(a);
        System.out.println(newHead.toString());
    }

    /**
     * @see 单链表排序
     * @param head
     * @return
     */
    public static ListNode sortInList (ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode res = new ListNode(-1);
        res.next = head;
        ListNode inx = res;
        while (inx.next != null) {
            ListNode cur = inx;
            ListNode next = inx.next;
            ListNode min = null, minNext = null;
            while (next != null) {
                if (minNext == null || next.val < minNext.val) {
                    min = cur;
                    minNext = next;
                }
                cur = cur.next;
                next = next.next;
            }

            min.next = minNext.next;
            minNext.next = inx.next;
            inx.next = minNext;
            inx = minNext;
        }
        return res.next;
    }

    public static ListNode sortInList2 (ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode move = head;
        while (move.next != null) {
            ListNode temp = move.next;
            while (temp != null) {
                if (temp.val < move.val) {
                    int val = temp.val;
                    temp.val = move.val;
                    move.val = val;
                }
                temp = temp.next;
            }
            move = move.next;
        }
        return head;
    }
}
