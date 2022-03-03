package y2022.Mar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

/**
 * @author Iris 2022/3/3
 */
public class Mar03 {

    /**
     * @see 面试题16.15.珠玑妙算
     * @param solution 原有颜色
     * @param guess 猜测颜色
     * @return 猜中对应位颜色为猜中一次，只猜中颜色但是槽不对为伪猜中，猜中不算伪猜中
     */
    public static int[] masterMind(String solution, String guess) {
        int res1 = 0;
        int res2 = 0;
        char[] s = solution.toCharArray();
        char[] g = guess.toCharArray();
        for (int i = 0; i < 4; i++) {
            if (s[i] == g[i]) {
                res1++;
                s[i] = '_';
                g[i] = '_';
            }
        }
        for (int i=0; i<4; i++){
            if (s[i]=='_') continue;
            for (int j=0; j<4; j++) {
                if (s[i] == g[j]) {
                    res2++;
                    g[j] = '-';
                    break;
                }
            }
        }
        return new int[]{res1, res2};
    }

    /**
     * @see 面试题16.17.连续数列
     * @param nums 给定整数数组
     * @return 找出总和最大的连续数列
     */
    public int maxSubArray(int[] nums) {
        if (nums.length == 1) return nums[0];
        int curSum = nums[0], maxSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            // 如果当前总和小于当前值，则前面的总和不是最大，从当前值开始重新计数
            curSum = curSum+nums[i] <= nums[i] ? nums[i] : curSum+nums[i];
            maxSum = (curSum > maxSum) ? curSum : maxSum;
        }
        return maxSum;
    }

    /**
     * @see 面试题17.01.不用加号或者其他运算符的加法
     * @param a
     * @param b
     * @return
     */
    public int add(int a, int b) {
        int n1 = a ^ b;
        int n2 = (a & b) << 1;
        return (n2==0) ? n1 : add(n1, n2);
    }

    /**
     * @see 面试题17.04.消失的数组
     * @param nums
     * @return 返回数字中长度内缺失的数字
     */
    public static int missingNumber(int[] nums) {
        int res = 0;
        for (int i = 1; i <= nums.length; i++) {
            res += i - nums[i-1];
        }
        return res;
    }

    /**
     * @see 面试题17.10.主要元素
     * @param nums
     * @return 数组中出现次数大于nums.length/2的数字，否则返回-1
     * @apiNote 摩尔投票法
     */
    public int majorityElement(int[] nums) {
        int cnt = 0, prev = -1;
        for (int num : nums) {
            if (cnt == 0) {
                cnt++; prev = num;
            } else if (prev == num) {
                cnt++;
            } else {
                cnt--;
            }
        }
        if (cnt > 0) {
            int n = 0;
            for (int num : nums) {
                if (prev == num)  n++;
                if (n > nums.length / 2) return prev;
            }
        }
        return -1;
    }

    /**
     * @see 面试题17.12.BiNode
     * @param root
     * @return 将二叉树变为单向链表
     */
    private TreeNode temp;
    public TreeNode convertBiNode(TreeNode root) {
        temp = new TreeNode(Integer.MIN_VALUE);
        TreeNode pre = temp;
        dfs(root);
        return pre.right;
    }
    private void dfs(TreeNode root) {
        if (root == null) return;
        dfs(root.left);
        temp.right = root;
        root.left = null;
        temp = temp.right;
        dfs(root.right);
    }

    /**
     * @see 面试题17.16.按摩师
     * @param nums
     * @return 求最大总和（不能加相邻节点）
     */
    public int massage(int[] nums) {
        int a = 0, b = 0;
        for (int num : nums) {
            int c = (b > a+num) ? b : a+num;
            a = b;
            b = c;
        }
        return b;
    }

    public static void main(String[] args) {
        System.out.println(missingNumber(new int[]{9,6,4,2,3,5,7,0,1}));
    }

    public class TreeNode {
       int val;
       TreeNode left;
       TreeNode right;
       TreeNode(int x) { val = x; }
    }
}
