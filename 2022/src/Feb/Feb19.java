package Feb;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author Iris 2022/2/19
 */
public class Feb19 {

    /**
     * 求算术平方根
     *
     * @param x 给定数值
     * @return int类型的平方根数值
     */
    public static int mySqrt(int x) {
        if (x <= 1) {
            return x;
        }
        int min = 0;
        int max = x;
        while (max - min > 1) {
            int m = (max + min) / 2;
            if (x / m < m) {
                max = m;
            } else {
                min = m;
            }
        }
        return min;
    }

    /**
     * 爬楼梯，有几种方法爬到顶（每次【1阶】/【2阶】）
     *
     * @param n 给定层数
     * @return 方案数
     * 1 >>> 1
     * 2 >>> 2
     * 3 >>> 2+1
     * 4 >>> 3+2
     * 类似于斐波拉契数列算法
     */
    public static int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        int res = 3;
        int pre = 2;
        int temp;
        for (int i = 3; i < n; i++) {
            temp = res;
            res += pre;
            pre = temp;
            System.out.println("res>>>" + res);
        }
        return res;
    }

    /**
     * 删除排序链表中的重复元素
     * 1.方法嵌套
     * 2.循环遍历
     *
     * @param head 头节点
     * @return 修改后的头节点
     */
    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode inx = new ListNode(Integer.MIN_VALUE);
        inx.next = head;
        head = inx;
        while (inx.next != null) {
            if (inx.val == inx.next.val) {
                inx.next = inx.next.next;
            } else {
                inx = inx.next;
            }
        }
        return head.next;
    }

    /**
     * 合并两个有序数组
     * num1初始长度为m+n，合并后的数组不由数组返回，存放在num1中
     * 1ms | 41.3MB
     *
     * @param nums1 数组一
     * @param m     数组一中的元素数目
     * @param nums2 数组二
     * @param n     数组二中的元素数目
     */
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        if (nums2.length == 0) {
            return;
        }
        if (m == 0) {
            System.arraycopy(nums2, 0, nums1, 0, nums2.length);
        }
        // 先将nums2放入nums1末尾
        System.arraycopy(nums2, 0, nums1, m, nums2.length);
        // 排序
        int temp = Integer.MIN_VALUE;
        for (int i = 0; i < nums1.length; i++) {
            for (int j = i; j < nums1.length; j++) {
                if (nums1[i] > nums1[j]) {
                    temp = nums1[i];
                    nums1[i] = nums1[j];
                    nums1[j] = temp;
                }
            }
        }
    }

    /**
     * 二叉树的中序遍历
     *
     * @param root 给定二叉树
     * @return 中序遍历后的数组
     */
    public static List<Integer> inorderTraversal(TreeNode root) {
        // 栈 先进后出
        // 前序遍历，出栈顺序：根左右; 入栈顺序：右左根
        // 中序遍历，出栈顺序：左根右; 入栈顺序：右根左
        // 后序遍历，出栈顺序：左右根; 入栈顺序：根右左
        List<Integer> ans = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<>();
        // root为空且stack为空，遍历结束
        while (root != null || !stack.isEmpty()) {
            // 先根后左入栈
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            // 此时root==null，说明上一步的root没有左子树
            // 1. 执行左出栈。因为此时root==null，导致root.right一定为null
            // 2. 执行下一次外层while代码块，根出栈。此时root.right可能存在
            // 3a. 若root.right存在，右入栈，再出栈
            // 3b. 若root.right不存在，重复步骤2
            root = stack.pop();
            ans.add(root.val);
            root = root.right;
        }
        return ans;
    }

    public static void main(String[] args) {

    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static class TreeNode {
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
