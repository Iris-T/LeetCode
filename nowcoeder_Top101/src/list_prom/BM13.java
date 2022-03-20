package list_prom;

import java.util.LinkedList;

/**
 * @author Iris 2022/3/20
 */
public class BM13 {

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
        System.out.println(isPail(a));
    }

    /**
     * @see 判断链表是否为回文结构
     * @param head
     * @return
     */
    public static boolean isPail (ListNode head) {
        if (head == null || head.next == null) return true;
        LinkedList<Integer> check = new LinkedList<>();
        while (head != null) {
            check.add(head.val);
            head = head.next;
        }
        int size = check.size();
        for (int i = 0; i < size/2; i++) {
            if (!check.pollFirst().equals(check.pollLast())) return false;
        }
        return true;
    }
}
