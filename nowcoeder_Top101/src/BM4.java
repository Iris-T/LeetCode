/**
 * @author Iris 2022/3/14
 */
public class BM4 {
    public static void main(String[] args) {

    }

    /**
     * @see 合并两个排序的链表
     * @param list1
     * @param list2
     * @return
     */
    public ListNode Merge(ListNode list1,ListNode list2) {
        if (list1 == null || list2 == null) return (list1 == null) ? list2 : list1;
        ListNode temp, inx1 = list1, inx2 = list2;
        if (list1.val <= list2.val) {
            list1.next = Merge(list1.next, list2);
            return list1;
        }
        else {
            list2.next = Merge(list1, list2.next);
            return list2;
        }
    }
}
