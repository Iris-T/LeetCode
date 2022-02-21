package Feb;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Iris 2022/2/21
 */
public class Feb21 {

    /**
     * 二叉树最小深度
     * @param root 二叉树
     * @return 最小深度
     */
    public int minDepth(TreeNode root) {
        if (root==null) return 0;
        int lDep = minDepth(root.left);
        int rDep = minDepth(root.right);
        return (lDep==0 || rDep==0) ? 1+lDep+rDep : 1+Math.min(lDep,rDep);
    }

    /**
     * 112.路径总和
     * @param root 给定二叉树
     * @param targetSum 给定路径值的总和
     * @return 当总和相等时返回true，否则返回false
     */
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root==null) return false;
        if (root.left==null && root.right==null) return targetSum- root.val==0;
        return hasPathSum(root.left, targetSum- root.val) || hasPathSum(root.right, targetSum- root.val);
    }

    /**
     * 杨辉三角
     * 1
     * 1 1
     * 1 2 1
     * @param numRows 给定输出的杨辉三角的行数
     * @return 返回输出列表
     */
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        // 用于存储数值
        int[][] temp = new int[numRows][numRows];
        for (int i = 0; i < numRows; i++) {
            // 用于存储每一层的值
            List<Integer> subList = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j==0 || j==i) {
                    temp[i][j] = 1;
                } else {
                    temp[i][j] = temp[i-1][j] + temp[i-1][j-1];
                }
                subList.add(temp[i][j]);
            }
            // 结果添加每一行的数值
            result.add(subList);
        }
        return result;
    }

    /**
     * 返回杨辉三角的某一行数值
     * @param rowIndex 行的inx
     * @return 一行的值
     */
    public static List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<>();
        // 用于存储数值
        // +1为避免输入值为0的情况,同时避免了inx越界
        int[][] temp = new int[rowIndex+1][rowIndex+1];
        for (int i = 0; i <= rowIndex; i++) {
            for (int j = 0; j <= i; j++) {
                if (j==0 || j==i) {
                    temp[i][j] = 1;
                } else {
                    temp[i][j] = temp[i-1][j] + temp[i-1][j-1];
                }
                if (i==rowIndex) result.add(temp[i][j]);
            }
        }
        return result;
    }

    /**
     * 买股的最佳时机
     * 仅买卖一次
     * @param prices 给定价格走势的数值
     * @return 返回最大利润，若无则返回0
     */
    public static int maxProfit(int[] prices) {
        if (prices.length<=1) return 0;
        int cost = prices[0];
        int maxMoneyGet = 0;
        for (int i = 1; i < prices.length; i++) {
            // 最大利润
            maxMoneyGet = Math.max(maxMoneyGet, prices[i]-cost);
            // 最小花销
            cost = Math.min(cost, prices[i]);
        }
        return maxMoneyGet;
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7,1,5,3,6,4}));
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
