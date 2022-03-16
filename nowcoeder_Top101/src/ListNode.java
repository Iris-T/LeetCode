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
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}
