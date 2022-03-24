package binary_tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

/**
 * @author Iris 2022/3/24
 */
public class BM26_27 {
    public static void main(String[] args) {
        /*
            1
          2   3
        4 -1 5 6
        预期结果
        层序遍历：{{1},{2,3},{4,5,6}}
        之字形打印：{{1},{3,2},{4,5,6}}
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
        ArrayList<ArrayList<Integer>> res = new BM26_27().levelOrder(r);
        System.out.println("层序遍历>>>"+Arrays.toString(new ArrayList[]{res}));
        ArrayList<ArrayList<Integer>> res2 = new BM26_27().Print(r);
        System.out.println("之字形遍历>>>"+Arrays.toString(new ArrayList[]{res2}));
    }

    /**
     * @see 二叉树的层序遍历
     * @param root
     * @return
     */
    public ArrayList<ArrayList<Integer>> levelOrder (TreeNode root) {
        Stack<TreeNode> nodes = new Stack<>();
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (root == null) return res;

        nodes.push(root);
        while (!nodes.isEmpty()) {
            ArrayList<Integer> data = new ArrayList<>();
            ArrayList<TreeNode> floorNodes = new ArrayList<>();
            while (!nodes.isEmpty()) {
                floorNodes.add(nodes.pop());
            }
            for (int i = floorNodes.size()-1; i >= 0; i--) {
                TreeNode node = floorNodes.get(i);
                if (node.left != null) nodes.add(node.left);
                if (node.right != null) nodes.add(node.right);
                data.add(node.val);
            }
            res.add(data);
        }
        return res;
    }

    public ArrayList<ArrayList<Integer> > Print(TreeNode root) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Stack<TreeNode> nodes = new Stack<>();
        int inx = 0;

        nodes.push(root);
        while (!nodes.isEmpty()) {
            ArrayList<Integer> data = new ArrayList<>();
            ArrayList<Integer> reverse = new ArrayList<>();
            ArrayList<TreeNode> floorNodes = new ArrayList<>();
            while (!nodes.isEmpty()) {
                TreeNode node = nodes.pop();
                floorNodes.add(node);
                reverse.add(node.val);
            }
            for (int i = floorNodes.size()-1; i >= 0; i--) {
                TreeNode node = floorNodes.get(i);
                if (node.left != null) nodes.add(node.left);
                if (node.right != null) nodes.add(node.right);
                data.add(node.val);
            }
            res.add((inx % 2 == 0) ? data : reverse);
            inx ++;
        }
        return res;
    }
}
