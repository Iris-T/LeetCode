package y2022.Feb;

/**
 * @author Iris 2022/2/28
 */
public class Feb28 {

    /**
     * @see 面试题04.02.最小高度树
     * @param nums 升序数组
     * @return 创建一颗高度最小的二叉搜索树
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length);
    }
    private TreeNode helper(int[] nums, int left, int right) {
        if (left == right) return null;
        int mid = (left + right) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(nums, left, mid);
        root.right = helper(nums, mid+1, right);
        return root;
    }

    private boolean flag = true;
    /**
     * @see 面试题04.04.检查平衡性
     * @param root
     * @return 每个节点左右子树的高度差不超过1
     */
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        dfs(root);
        return flag;
    }
    private int dfs(TreeNode root){
        if(root == null) return 0;
        // 左子树的深度
        int leftDepth = dfs(root.left);
        // 右子树的深度
        int rightDepth = dfs(root.right);
        // 判断本结点所在树是否平衡
        if(Math.abs(leftDepth - rightDepth) > 1) flag = false;
        // 返回本结点所在树的深度
        return Math.max(leftDepth, rightDepth) + 1;
    }

    /**
     * @see 面试题05.01.插入
     * @param N
     * @param M
     * @param i
     * @param j
     * @return 将N倒数第i~j位用M替换，不足则添零
     */
    public int insertBits(int N, int M, int i, int j) {
        int res = 0;
        // M左移i位补零
        M <<= i;
        for (int k = 0; k < Integer.SIZE; k++) {
            // 在i~j中，就在M中取位，否则在N中取位
            res += (k>=i && k<=j) ? M&(1<<k) : N&(1<<k);
        }
        return res;
    }

    /**
     * @see 面试题05.03.反转数位
     * @param num 给定一个数
     * @return 返回反转其中一个0位，所得到的1位的最多数量
     */
    public static int reverseBits(int num) {
        int max = 0;
        int reverse = 0;
        int curLen = 0;
        for (int i = 0; i < Integer.SIZE; i++) {
            // 如果末位为1，则reverse和curLen均+1
            if ((num&1)==1) {
                curLen++; reverse++;
            } else {
                // 否则reverse=当前1位数+1
                reverse = curLen+1;
                // 当前1位数清零
                curLen = 0;
            }
            if (reverse > max) max = reverse;
            // num右移一位
            num >>= 1;
        }
        return max;
    }

    /**
     * @see 面试题05.06.整数转换
     * @param A 数A
     * @param B 数B
     * @return A需要转换几个位才能变为B
     */
    public static int convertInteger(int A, int B) {
        int count = 0;
        for (int i = 0; i < 32; i++) {
            if ((B&1) != (A&1)) count++;
            A >>= 1;
            B >>= 1;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(convertInteger(1, 2));
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {val = x;}
    }
}
