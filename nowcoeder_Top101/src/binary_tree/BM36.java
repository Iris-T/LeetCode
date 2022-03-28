package binary_tree;

/**
 * @author Iris 2022/3/28
 */
public class BM36 {
    public static void main(String[] args) {

    }

    /**
     * 判断二叉树是否为平衡二叉树
     * @param root
     * @return
     */
    public boolean IsBalanced_Solution(TreeNode root) {
        return judge(root) > -1;
    }

    private int judge(TreeNode root) {
        if (root == null) return 0;
        int lDep = judge(root.left);
        if (lDep == -1) return lDep;
        int rDep = judge(root.right);
        if (rDep == -1) return rDep;
        // 高度差大于-1则返回
        return (Math.abs(lDep - rDep) > 1) ? -1 : 1+Math.max(lDep, rDep);
    }
}
