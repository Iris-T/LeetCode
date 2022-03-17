/**
 * @author Iris 2022/3/17
 */
public class BM10 {

    public static void main(String[] args) {

    }

    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        ListNode inx1 = pHead1, inx2 = pHead2;
        while (inx1 != inx2) {
            inx1 = (inx1 == null) ? pHead2 : inx1.next;
            inx2 = (inx2 == null) ? pHead1 : inx2.next;
        }
        return inx1;
    }
}
