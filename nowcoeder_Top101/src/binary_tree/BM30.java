package binary_tree;

import java.util.Stack;

/**
 * @author Iris 2022/3/25
 */
public class BM30 {

    public static void main(String[] args) {

    }

    /**
     * 将二叉树转换为双向链表要求空间复杂度为O(1)时间复杂度为O(n)
     * @param pRootOfTree
     * @return
     */
    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null) return pRootOfTree;

        TreeNode list_head = null;
        Stack<TreeNode> nodes = new Stack<>();
        while (pRootOfTree != null || !nodes.isEmpty()) {
            if (pRootOfTree != null) {
                nodes.push(pRootOfTree);
                pRootOfTree = pRootOfTree.right;
            } else {
                pRootOfTree = nodes.pop();
                if (list_head == null) list_head = pRootOfTree;
                else {
                    list_head.left = pRootOfTree;
                    pRootOfTree.right = list_head;
                    list_head = pRootOfTree;
                }
                pRootOfTree = pRootOfTree.left;
            }
        }
        return list_head;
    }

    private TreeNode list_head = null;
    /**
     * 递归方式
     * @param root
     * @return
     */
    public TreeNode Convert2(TreeNode root) {
        if (root == null) return root;
        Convert2(root.right);

        if (list_head == null) list_head = root;
        else {
            list_head.left = root;
            root.right = list_head;
            list_head = root;
        }
        Convert2(root.left);
        return list_head;
    }

    private TreeNode head, pre;
    /**
     * dfs
     * @param root
     * @return
     */
    public TreeNode Convert3(TreeNode root) {
        if (root == null) return null;
        dfs(root);
        return head;
    }

    private void dfs(TreeNode root) {
        if (root.left != null) dfs(root.left);
        // 当前一节点不为空才进行双向连接
        if (pre != null) pre.right = root;
        // 否则放入当前节点（根节点）
        else head = root;
        // 当前节点指向前一节点
        root.left = pre;
        // 连接节点后移
        pre = root;
        if (root.right != null) dfs(root.right);
    }
}
