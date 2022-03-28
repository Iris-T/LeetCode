package binary_tree;

/**
 * @author Iris 2022/3/28
 */
public class BM37_38 {
    public static void main(String[] args) {

    }

    /**
     * 寻找二叉搜索树中两个节点最近公共祖先的值
     * @param root
     * @param p
     * @param q
     * @return
     */
    public int lowestCommonAncestor (TreeNode root, int p, int q) {
        if (p > q) {
            int temp = p;
            p = q;
            q= temp;
        }
        // ≥小值，≤大值，则是大值为祖先
        if (root.val >= p && root.val <= q)
            return root.val;
        // 当前节点值过大，则向左子节点下移
        else if (root.val > p && root.val > q)
            return lowestCommonAncestor(root.left, p, q);
        // 否则向右子节点下移（当前节点值过小）
        else return lowestCommonAncestor(root.right, p, q);
    }

//    37-遍历方法
    public int lowestCommonAncestor2 (TreeNode root, int p, int q) {
        while (true) {
            if (p > q) {
                int temp = p;
                p = q;
                q= temp;
            }
            // ≥小值，≤大值，则是大值为祖先
            if (root.val >= p && root.val <= q) break;
            // 当前节点值过大，则向左子节点下移
            else if (root.val > p && root.val > q) root = root.left;
            // 否则向右子节点下移（当前节点值过小）
            else root = root.right;
        }
        return root.val;
    }

    /**
     * 寻找二叉树中两个节点最近公共祖先的值
     * @param root
     * @param o1
     * @param o2
     * @return
     */
    public int lowestCommonAncestor_38 (TreeNode root, int o1, int o2) {
        return helper_38(root, o1, o2).val;
    }

    private TreeNode helper_38(TreeNode root, int o1, int o2) {
        // 若当前节点为o1 || o2其中一个则表示，其为另一个节点的父节点
        if (root == null || root.val == o1 || root.val == o2)
            return root;
        // 向左右子树找到至少一个与o1 || o2匹配的节点
        TreeNode l = helper_38(root.left, o1, o2);
        TreeNode r = helper_38(root.right, o1, o2);
        if(l == null) return r;
        if(r == null) return l;
        // 若左右子树的结果都为空，则证明当前节点就是两个目标点的最近祖先
        return root;
    }
}
