package list_prom;

/**
 * @author Iris 2022/3/20
 */
public class BM16 {
    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(1);
        ListNode c = new ListNode(2);
        ListNode d = new ListNode(2);
        ListNode e = new ListNode(3);
        ListNode f = new ListNode(3);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;
        ListNode res = deleteDuplicates(a);
//        System.out.println(res.toString());
    }

    /**
     * @see 删除所有重复元素，不保留
     * @param head
     * @return
     */
    public static ListNode deleteDuplicates (ListNode head) {
        if (head == null) return null;
        ListNode res = new ListNode(-1);
        res.next = head;
        ListNode pre = res;
        int cnt = 0;
        while (head != null) {
            while (head.next != null && head.val == head.next.val) {
                cnt++;
                head = head.next;
            }
            if (cnt != 0) {
                pre.next = head.next;
            } else {
                pre = head;
            }
            head = head.next;
            cnt = 0;
            System.out.println(res.toString());
        }
        return res.next;
    }
}
