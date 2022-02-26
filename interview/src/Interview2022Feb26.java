import java.util.HashSet;
import java.util.Set;

/**
 * @author Iris 2022/2/26
 */
public class Interview2022Feb26 {

    /**
     * @param s1 字符串1
     * @param s2 字符串2
     * @return 字符串2能否由字符串1通过旋转后得到
     * @apiNote 解题思路 >>> 字符串1是否包含字符串2全部字符
     * @see 面试题01.09.字符串轮转
     */
    public static boolean isFlipedString(String s1, String s2) {
        // 长度不同直接返回False
        if (s1.length() != s2.length()) return false;
        // 通过s1自身拼接后是否包含s2，还原了旋转
        return (s1.equals(s2)) ? true : (s1 + s1).contains(s2);
    }

    public static void main(String[] args) {
        System.out.println(isFlipedString("aa", "aba"));
    }

    /**
     * @param head 头节点
     * @return 移除重复元素后的头节点
     * @apiNote 通过一个Set进行重复校验
     * @see 面试题02.01.移除重复节点
     */
    public ListNode removeDuplicateNodes(ListNode head) {
        if (head == null || head.next == null) return head;
        Set<Integer> check = new HashSet<>();
        ListNode res = new ListNode(-1);
        res.next = head;
        ListNode temp = res;
        while (temp.next != null) {
            if (check.add(temp.next.val)) {
                temp = temp.next;
            } else {
                temp.next = temp.next.next;
            }
        }
        return res.next;
    }

    /**
     * @param head 头节点
     * @param k    目标索引
     * @return 目标节点
     * @apiNote 快慢指针，先有快指针走出k，然后快慢指针同时前进，直到快指针指向末尾，返回慢指针指向的值
     * @see 面试题02.02.返回倒数第k个节点
     */
    public int kthToLast(ListNode head, int k) {
        // 因为索引是保证有效的
        if (head == null || head.next == null) return head.val;
        ListNode fast = head, slow = head;
        while (k > 0) {
            fast = fast.next;
            k--;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow.val;
    }

    /**
     * @param node 给定要删除的中间节点[保证非头非尾]
     * @apiNote 将下一个节点的相关属性值（val&next）copy到本节点上
     * @see 面试题02.03.删除中间节点
     */
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    /**
     * @param head 头节点
     * @return 所给链表是否为回文链表
     * @apiNote 反转后半段链表（避免判断长度的奇偶），进行循环比较
     * @see 面试题02.06.回文链表
     */
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        // 快慢指针找到中间节点
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // 反转后半段链表
        ListNode half = null;
        while (slow != null) {
            // 预留下一节点位置
            fast = slow.next;
            // 当前节点指向临时节点，形成环
            slow.next = half;
            // 临时节点指向当前节点，形成单独的封闭环
            half = slow;
            // 当前节点向后移动，完成破环操作
            slow = fast;
        }
        // 前后段链表进行值的比较
        fast = head;
        while (half != null) {
            if (half.val != fast.val) return false;
            half = half.next;
            fast = fast.next;
        }
        return true;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
