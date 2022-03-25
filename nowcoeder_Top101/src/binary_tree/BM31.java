package binary_tree;

import java.util.Stack;

/**
 * @author Iris 2022/3/25
 */
public class BM31 {
    public static void main(String[] args) {

    }

    /**
     * 判断当前二叉树是否为对称的二叉树
     * @param pRoot
     * @return
     */
    boolean isSymmetrical(TreeNode pRoot) {
        if (pRoot == null) return true;
        else return helper(pRoot.left, pRoot.right);
    }

    private boolean helper(TreeNode r1, TreeNode r2) {
        if (r1 == null && r2 == null) return true;
        if (r1 == null || r2 == null) return false;
        if (r1.val != r2.val) return false;
        return helper(r1.left, r2.right) && helper(r1.right, r2.left);
    }
}
