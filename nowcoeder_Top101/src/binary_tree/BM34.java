package binary_tree;

/**
 * @author Iris 2022/3/26
 */
public class BM34 {
    public static void main(String[] args) {
        TreeNode tTree = new TreeNode(2);
        tTree.left = new TreeNode(1);
        tTree.right = new TreeNode(3);

        TreeNode fTree = new TreeNode(1);
        fTree.left = new TreeNode(2);
        fTree.right = new TreeNode(3);

        System.out.println(new BM34().isValidBST(tTree)+" | "+new BM34().isValidBST(fTree));
    }

    /**
     * 判断二叉树是否为搜索二叉树
     * @param root
     * @return
     */
    public boolean isValidBST (TreeNode root) {
        if (root == null) return true;
        if (root.left == null && root.right == null) {
            return true;
        } else if (root.left == null || root.right == null) {
            if (root.left != null && maxVal(root.left) >= root.val)
                return false;
            if (root.right != null && maxVal(root.right) <= root.val)
                return false;
        } else {
            if (!(maxVal(root.left) < root.val && root.val < maxVal(root.right)))
                return false;
        }
        return isValidBST(root.left) && isValidBST(root.right);
    }

    /**
     * 获取子树中的最大值
     * @param node
     * @return
     */
    private int maxVal(TreeNode node) {
        if (node == null) return 0;
        TreeNode temp = node;
        int res = 0;
        while (temp != null) {
            res = temp.val;
            temp = temp.right;
        }
        return res;
    }
}
