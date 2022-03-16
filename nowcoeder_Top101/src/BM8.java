import com.sun.org.apache.bcel.internal.generic.ARETURN;

/**
 * @author Iris 2022/3/16
 */
public class BM8 {

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(5);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        ListNode res = FindKthToTail(a, 2);
        System.out.println((res == null) ? res : res.toString());
    }

    public static ListNode FindKthToTail (ListNode pHead, int k) {
        if (pHead == null || k == 0) return null;
        ListNode fast = pHead;
        ListNode slow = pHead;
        // 预先前进k个位置，排除越界可能
        // 此时slow向后走，当fast到达尾部时，与slow距离k
        while (fast != null) {
            if (k != 0) k--;
            else slow = slow.next;
            fast = fast.next;
        }
        return (k > 0) ? null : slow;
    }
}
