package binary_tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Iris 2022/3/28
 */
public class BM35 {
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
        a2.left = a2b1;
        a2.right = a2b2;
        System.out.println(new BM35().isCompleteTree(r));

    }


    /**
     * @see 判断是否是完全二叉树
     * @param root
     * @return
     */
    public boolean isCompleteTree (TreeNode root) {
        if (root == null) return true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode curNode;
        boolean flag = false;
        while (!queue.isEmpty()) {
            curNode = queue.poll();
            if (null == curNode) {
                flag = true;
                continue;
            }
            if (flag) return false;
            queue.offer(curNode.left);
            queue.offer(curNode.right);
        }
        return true;
    }
}
