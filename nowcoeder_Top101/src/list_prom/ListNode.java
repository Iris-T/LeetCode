package list_prom;

/**
 * @author Iris 2022/3/13
 */
public class ListNode {
    int val;
    ListNode next = null;
    ListNode (int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}
