package binary_tree;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @author Iris 2022/3/23
 */
public class BM23_24_25 {

    public static void main(String[] args) {

        /*
         * 测试数据
         *    1
         *  2   3
         * 4 n 5 6
         * 理想结果：
         *      前序遍历：124n356
         *      中序遍历：42n1536
         *      后序遍历：4n25631
         */
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
        BM23_24_25 this_obj = new BM23_24_25();
        int[] preOrder = this_obj.preorderTraversal(r);
        int[] inOrder = this_obj.inorderTraversal(r);
        int[] postOrder = this_obj.postorderTraversal(r);

        System.out.println("preOrder>>>"+ Arrays.toString(preOrder));
        System.out.println("inOrder>>>"+ Arrays.toString(inOrder));
        System.out.println("postOrder>>>"+ Arrays.toString(postOrder));

    }

    /**
     * @see 二叉树前序遍历-根、左、右
     * @param root
     * @return
     */
    public int[] preorderTraversal (TreeNode root) {
        if (root == null) return new int[0];
        Stack<TreeNode> nodes = new Stack<>();
        nodes.push(root);
        LinkedList<Integer> data = new LinkedList<>();
        while (!nodes.isEmpty()) {
            TreeNode node = nodes.pop();
            data.add(node.val);
            // FILO
            if (node.right != null) nodes.push(node.right);
            if (node.left != null) nodes.push(node.left);
        }
        int[] res = new int[data.size()];
        Iterator<Integer> iterator = data.iterator();
        int inx = 0;
        while (iterator.hasNext()) {
            res[inx ++] = iterator.next();
        }
        return res;
    }

    /**
     * @see 二叉树中序遍历-左、根、右
     * @param root
     * @return
     */
    public int[] inorderTraversal (TreeNode root) {
        if (root == null) return new int[0];
        Stack<TreeNode> nodes = new Stack<>();
        LinkedList<Integer> data = new LinkedList<>();
        TreeNode curNode = root;
        while (!nodes.isEmpty() || curNode!=null) {
            while (curNode != null) {
                nodes.push(curNode);
                curNode = curNode.left;
            }
            if (!nodes.isEmpty()) {
                TreeNode node = nodes.pop();
                data.add(node.val);
                curNode = node.right;
            }
        }
        int[] res = new int[data.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = data.get(i);
        }
        return res;
    }

    LinkedList<Integer> nums = new LinkedList<>();
    /**
     * @see 二叉树后序遍历-左、右、根
     * @param root
     * @return
     */
    public int[] postorderTraversal (TreeNode root) {

        if (root == null) return new int[0];
        postorderTraversal(root.left);
        postorderTraversal(root.right);
        nums.add(root.val);
        return nums.stream().mapToInt(Integer::valueOf).toArray();
    }
}
