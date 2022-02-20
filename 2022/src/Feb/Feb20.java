package Feb;

/**
 * @author Iris 2022/2/20
 */
public class Feb20 {

    /**
     * 二叉树比较
     * 解题思路：方法嵌套，匹配每个节点的值是否相同即可
     * @param p 树1
     * @param q 树2
     * @return 是否相同 True | False
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // p、q均为空
        if (p == null && q == null) return true;
        // p、q其中一个不为空
        if (p == null || q == null) return false;
        // 均不为空
        return p.val == q.val ? isSameTree(p.left, q.left) && isSameTree(p.right, q.right) : false;
    }

    /**
     * 判断给定二叉树是否为对称二叉树
     * 解题思路：与二叉树比较有相似点，因为是要比较相异的点，所以写两个函数
     * @param root 二叉树
     * @return 是否为对称树 True | False
     */
    public boolean isSymmetric(TreeNode root) {
        // 为空
        if (root == null) return true;
        return checkNode(root.left, root.right);
    }
    boolean checkNode(TreeNode n1, TreeNode n2) {
        if (n1 == null && n2 == null) return true;
        if(n1 == null || n2 == null || n1.val != n2.val) return false;
        return checkNode(n1.left, n2.right) && checkNode(n1.right, n2.left);
    }

    /**
     * 二叉树最大深度
     * 解题思路：嵌套，返回左右节点的最大值
     * @param root 二叉树
     * @return 最大深度
     */
    public static int maxDepth(TreeNode root) {
        return root == null ? 0 : Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    /**
     * 将有序数组转换为高度平衡二叉搜索树
     * 解题思路：从数组中间向两边延伸添加节点
     * @param nums 给定数组(严格升序)
     * @return 返回二叉树根节点
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        // 左右等分建立左右子树，中间节点作为子树根节点，递归该过程
        return nums == null ? null : buildTree(nums, 0, nums.length - 1);
    }
    private TreeNode buildTree(int[] nums, int l, int r) {
        if (l > r) return null;
        int m = l + (r - l) / 2;
        TreeNode root = new TreeNode(nums[m]);
        root.left = buildTree(nums, l, m - 1);
        root.right = buildTree(nums, m + 1, r);
        return root;
    }

    /**
     * 判断二叉树是否为平衡二叉树
     * 解题思路：嵌套，对每个子树进行判断
     * @param root 二叉树
     * @return True |　False
     */
    public boolean isBalanced(TreeNode root) {
        return height(root) >= 0;
    }
    private int height(TreeNode root) {
        if(root == null) return 1;
        int lh = height(root.left);
        int rh = height(root.right);
        return (lh >= 0 && rh >= 0 && Math.abs(lh - rh) <= 1) ? Math.max(lh, rh) + 1 : -1;
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
