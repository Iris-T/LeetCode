package binary_tree;

import java.util.Arrays;

/**
 * @author Iris 2022/3/26
 */
public class BM32_33 {

    public static void main(String[] args) {
//        1 2 # 4
        TreeNode r = new TreeNode(1);
        TreeNode a1 = new TreeNode(2);
        TreeNode a1b1 = new TreeNode(4);
//        3 5 6
        TreeNode a2 = new TreeNode(3);
        TreeNode a2b1 = new TreeNode(5);
        TreeNode a2b2 = new TreeNode(6);

        r.left = a1;
        a1.left = a1b1;
        r.right = a2;
        a2.left = a2b1;
        a2.right = a2b2;
//        TreeNode res = new BM32_33().mergeTrees(r, a2);
        TreeNode res = new BM32_33().Mirror(r);
        int[] data = new BM23_24_25().preorderTraversal(res);
        System.out.println(Arrays.toString(data));
    }

    /**
     * 合并二叉树，将两个二叉树上节点值合并
     * @param t1
     * @param t2
     * @return
     */
    public TreeNode mergeTrees (TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return null;
        if (t1 == null) {
            return t2;
        } else if (t2 == null) {
            return t1;
        } else {
            t1.val += t2.val;
        }
        t1.left = mergeTrees(t1.left, t2.left);
        t1.right = mergeTrees(t1.right, t2.right);
        return t1;
    }

    /**
     * 二叉树的镜像
     * @param pRoot
     * @return
     */
    public TreeNode Mirror (TreeNode pRoot) {
        if (pRoot == null) return null;
        // 先对子节点进行Mirror
        pRoot.left = Mirror(pRoot.left);
        pRoot.right = Mirror(pRoot.right);
        if (pRoot.left == null && pRoot.right == null) {
            return pRoot;
        } else if (pRoot.left == null) {
            pRoot.left = pRoot.right;
            pRoot.right = null;
        } else if (pRoot.right == null) {
            pRoot.right = pRoot.left;
            pRoot.left = null;
        } else {
            TreeNode temp = pRoot.left;
            pRoot.left = pRoot.right;
            pRoot.right = temp;
        }
        return pRoot;
    }
}
