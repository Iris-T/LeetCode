package binary_tree;

import java.util.Stack;

/**
 * @author Iris 2022/3/24
 */
public class BM28 {
    public static void main(String[] args) {
        TreeNode r = new TreeNode(1);
        TreeNode a1 = new TreeNode(2);
        TreeNode a2 = new TreeNode(3);
        TreeNode a1b1 = new TreeNode(4);
        TreeNode a2b1 = new TreeNode(5);
        TreeNode a2b2 = new TreeNode(6);
        r.left = a1;
        r.right = a2;
        a1.left = a1b1;
        // -1代表空节点
        a1.right = new TreeNode(-1);
        a2.left = a2b1;
        a2.right = a2b2;
    }

    /**
     * @see 二叉树最大深度
     * @param root
     * @return
     */
    public int maxDepth (TreeNode root) {
        if (root == null) return 0;
        return (Math.max(maxDepth(root.left), maxDepth(root.right)))+1;
    }
}
