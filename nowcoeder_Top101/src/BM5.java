import java.util.ArrayList;

/**
 * @author Iris 2022/3/15
 */
public class BM5 {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(3);
        n1.next = n2;
        ListNode n3 = new ListNode(2);
        ListNode n4 = new ListNode(4);
        n3.next = n4;
        ListNode n5 = new ListNode(5);
        ArrayList<ListNode> listNodes = new ArrayList<>();
        listNodes.add(n1);
        listNodes.add(n3);
        listNodes.add(n5);
        ListNode res = mergeKLists(listNodes);
        while (res != null) {
            System.out.print(res.val+" ");
            res = res.next;
        }
    }

    public static ListNode mergeKLists(ArrayList<ListNode> lists) {
        if (lists == null || lists.size() == 0) return null;
        return mergeList(lists, 0, lists.size()-1);
    }

    public static ListNode mergeList(ArrayList<ListNode> lists, int left, int right) {
        if (left == right) return lists.get(left);
        if (left > right) return null;
        int mid = left + ((right-left) >> 1);
        return merge(
                mergeList(lists, left, mid),
                mergeList(lists, mid+1, right));
    }

    public static ListNode merge(ListNode n1, ListNode n2) {
        if (n1 == null || n2 == null) return (n1 == null) ? n2 : n1;
        ListNode res = new ListNode(-1);
        ListNode inx = res;

        while (n1 != null && n2 != null) {
            if (n1.val < n2.val) {
                inx.next = n1;
                n1 = n1.next;
            } else {
                inx.next = n2;
                n2 = n2.next;
            }
            inx = inx.next;
        }
        inx.next = (n1 == null) ? n2 : n1;
        return res.next;
    }
}
