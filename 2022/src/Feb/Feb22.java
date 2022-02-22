package Feb;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Iris 2022/2/22
 */
public class Feb22 {

    /**
     * 验证回文串
     *
     * @param s 给定字符串，包含空格、字符等
     * @return 仅验证字符串（不包含任意符号）是否为回文（不区分大小写）
     */
    public static boolean isPalindrome(String s) {
        if (s == null) return true;
        // 因为包含数字，所以先进行转小写
        s = s.toLowerCase();
        StringBuffer sBuffer = new StringBuffer();
        for (char c : s.toCharArray()) {
            if ((c >= 'a' && c <= 'z') || (c >= '0' && c <= '9')) {
                sBuffer.append(c);
            }
        }
        return sBuffer.toString().equals(sBuffer.reverse().toString());
    }

    /**
     * 只出现一次的数字
     *
     * @param nums 给定数组
     * @return 返回第一个只出现一次的数字
     */
    public static int singleNumber(int[] nums) {
//        1.暴力求解
//        List<Integer> temp = new ArrayList<>();
//        for (int num : nums) {
//            if (temp.contains(num)) {
//                temp.remove(temp.indexOf(num));
//            } else {
//                temp.add(num);
//            }
//        }
//        return (int) temp.toArray()[0];
//        2.异或运算
        if (nums.length == 1) return nums[0];
        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            result ^= nums[i];
        }
        return result;
    }

    /**
     * 环形链表
     * 最初思路：ArrayList是否包含该节点
     * 解题思路：环形链表>>>快慢指针，若相遇则返回有环（套圈）
     *
     * @param head 头节点
     * @return 返回链表中是否存在环
     */
    public static boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;
        ListNode fast = head.next.next;
        ListNode slow = head.next;
        while (fast != null && fast.next != null) {
            if (fast == slow) {
                return true;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        return false;
    }

    /**
     * 二叉树的前序遍历
     * @param root 给定二叉树
     * @return 遍历结果
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        getNum(root, result);
        return result;
    }
    public void getNum(TreeNode root, List<Integer> nums) {
        if (root == null) return;
        nums.add(root.val);
        getNum(root.left, nums);
        getNum(root.right, nums);
    }

    /**
     * 二叉树的后序遍历
     * @param root 给定二叉树
     * @return 遍历结果
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        getNum2(root, result);
        return result;
    }
    public void getNum2(TreeNode root, List<Integer> nums) {
        if (root == null) return;
        getNum2(root.left, nums);
        getNum2(root.right, nums);
        nums.add(root.val);
    }

    public static void main(String[] args) {

    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {
        }
        TreeNode(int val) {
            this.val = val;
        }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
