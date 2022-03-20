package list_prom;

import java.util.HashSet;

/**
 * @author Iris 2022/3/20
 */
public class BM15 {
    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(1);
        ListNode c = new ListNode(2);
        ListNode d = new ListNode(2);
        ListNode e = new ListNode(3);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        ListNode res = deleteDuplicates(a);
        System.out.println(res.toString());
    }

    /**
     * @see 删除已重复的元素
     * @param head
     * @return
     */
    public static ListNode deleteDuplicates (ListNode head) {
        if (head == null) return null;
        ListNode res = new ListNode(-1);
        res.next = head;
        ListNode pre = res;

        while (head != null) {
            if (pre.val == head.val) {
                pre.next = head.next;
                head = pre.next;
            } else {
                pre = pre.next;
                head = head.next;
            }
        }
        return res.next;
    }
}
