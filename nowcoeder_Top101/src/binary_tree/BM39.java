package binary_tree;

import java.util.Arrays;
import java.util.Stack;

/**
 * 序列化二叉树，提供序列化和反序列化方法
 * @author Iris 2022/3/28
 */
public class BM39 {
    private int inx = -1;
    String Serialize(TreeNode root) {
        StringBuffer sb = new StringBuffer();
        if (root == null) {
            sb.append("#,");
            return sb.toString();
        }
        sb.append(root.val+",");
        sb.append(Serialize(root.left));
        sb.append(Serialize(root.right));
        return sb.toString();
    }

    TreeNode Deserialize(String str) {
        inx ++;
        int len = str.length();
        if (inx >= len) return null;
        String[] strs = str.split(",");
        TreeNode cur = null;
        if (!strs[inx].equals("#")) {
            cur = new TreeNode(Integer.parseInt(strs[inx]));
            cur.left = Deserialize(str);
            cur.right = Deserialize(str);
        }
        return cur;
    }
}
