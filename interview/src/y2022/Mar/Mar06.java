package y2022.Mar;

/**
 * @author Iris 2022/3/6
 */
public class Mar06 {
    public static void main(String[] args) {

    }

    /**
     * @see 面试题04.05.合法二叉搜索树
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        return helper(root, null, null);
    }
    private boolean helper(TreeNode node, Integer lower, Integer upper) {
        if (node == null) return true;

        int val = node.val;
        if (lower != null && val <= lower) return false;
        if (upper != null && val >= upper) return false;

        if (!helper(node.right, val, upper)) return false;
        if (!helper(node.left, lower, val)) return false;
        return true;
    }

    /**
     * @see 面试题04.06.后继者[二叉搜索树]
     * @param root
     * @param p
     * @return 返回目标节点的下一节点，否则返回null
     */
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null) return root;
        // 若目标节点大于当前节点的值，则说明目标节点在当前节点的右子树上
        if (p.val >= root.val) return inorderSuccessor(root.right, p);
        TreeNode node = inorderSuccessor(root.left, p);
        return (node == null) ? root : node;
    }

    /**
     * @see 面试题04.08.首个共同祖先
     * @param root
     * @param p 目标节点1
     * @param q 目标节点2
     * @return 两者第一个共同祖先
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return root;
        if (p==root || q==root) return root;
        TreeNode lNode = lowestCommonAncestor(root.left, p, q);
        TreeNode rNode = lowestCommonAncestor(root.right, p, q);
        if (lNode!=null && rNode!=null) return root;
        return lNode == null ? rNode : lNode;
    }

    /**
     * @see 面试题04.10.检查子树
     * @param t1
     * @param t2
     * @return 返回t2是否为t1的一部分
     */
    public boolean checkSubTree(TreeNode t1, TreeNode t2) {
        // 若t1 || t2为空则直接返回
        if (t2 == null) return true;
        if (t1 == null) return false;
        // 在某一节点t1与t2值相同，则放回两树左右子树比较结果
        if (t1.val == t2.val) return checkSubTree(t1.left, t2.left) && checkSubTree(t1.right, t2.right);
        // 否则返回t1左右子树是否包含t2
        else return checkSubTree(t1.left, t2) || checkSubTree(t1.right, t2);
    }

    /**
     * @see 面试题04.12.求和路径
     * @param root
     * @param sum
     * @return 返回二叉树中目标和为sum的路径总个数
     */
    public int pathSum(TreeNode root, int sum) {
        return (root==null) ? 0 : helperSum(root, sum)+pathSum(root.left, sum)+pathSum(root.right, sum);
    }
    private int helperSum(TreeNode root, int sum) {
        if (root == null) return 0;
        sum -= root.val;
        // 若sum为0则表示以获取到一条路径
        int cnt = (sum==0) ? 1 : 0;
        // 对左右子树做循环查找
        cnt += helperSum(root.left, sum);
        cnt += helperSum(root.right, sum);
        return cnt;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {val = x;}
    }
}
