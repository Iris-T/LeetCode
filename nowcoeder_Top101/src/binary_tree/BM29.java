package binary_tree;

/**
 * @author Iris 2022/3/25
 */
public class BM29 {

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
        System.out.println(new BM29().hasPathSum(r, 9));
    }

    /**
     * @see 找出二叉树中是否有路径值总和为sum的路径
     * @param root
     * @param sum
     * @return
     */
    public boolean hasPathSum (TreeNode root, int sum) {
        if (root == null) return false;
        if (root.left == null && root.right == null) return sum == root.val;
        if (root.left != null && hasPathSum(root.left, sum - root.val)) return true;
        return root.right != null && hasPathSum(root.right, sum - root.val);
    }

}
