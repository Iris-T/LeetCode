package list_prom;

import java.util.Stack;

/**
 * @author Iris 2022/3/18
 */
public class BM11 {

    public static void main(String[] args) {
        ListNode a = new ListNode(9);
        ListNode b = new ListNode(3);
        ListNode c = new ListNode(7);
        a.next = b;
        b.next = c;

        ListNode d = new ListNode(6);
        ListNode e = new ListNode(3);
        d.next = e;

        ListNode res = addInList(a, d);
        System.out.println(res == null ? null : res.toString());
    }

    /**
     * @see 链表相加
     * @param head1
     * @param head2
     * @return
     */
    public static ListNode addInList (ListNode head1, ListNode head2) {
        if (head1 == null || head2 == null) return (head1 == null) ? head2 : head1;

        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        Stack<Integer> res = new Stack<>();

        while (head1 != null || head2 != null) {
            if (head1 != null) {
                s1.push(head1.val);
                head1 = head1.next;
            }
            if (head2 != null) {
                s2.push(head2.val);
                head2 = head2.next;
            }
        }

        int upNum = 0;
        int times = s1.size() >= s2.size() ? s1.size() : s2.size();
        for (int i = 0; i < times; i++) {
            if (!s1.isEmpty()) upNum += s1.pop();
            if (!s2.isEmpty()) upNum += s2.pop();
            res.push((upNum > 9) ? upNum - 10 : upNum);
            upNum = (upNum > 9) ? 1 : 0;
        }
        if (upNum > 0) res.push(upNum);

        ListNode head = new ListNode(res.pop());
        ListNode ans = head;
        while (!res.isEmpty()) {
            head.next = new ListNode(res.pop());
            head = head.next;
        }
        return ans;
    }
}
