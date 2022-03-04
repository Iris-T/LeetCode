package y2022.Mar;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Iris 2022/3/4
 */
public class Mar04 {

    /**
     * @see 面试题01.05.一次编辑
     * @param first
     * @param second
     * @return 判断两个字符串能否通过一次（添加 | 修改 | 删除）字符相互转换
     * @apiNote 通过ArrayList去除相同元素，判断剩余元素个数
     */
    public static boolean oneEditAway(String first, String second) {
        int n1 = first.length(), n2 = second.length();
        int diff = Math.abs(n1-n2); // 字符长度差
        int cnt = 0;   // 记录字符不同的个数，超过一个则为false
        // 长度差值为1以上则为false
        if (diff > 1)  return false;
        else if (diff == 0) { // 长度相同只能通过替换操作
            for (int i=0; i<n1; i++) {
                if (first.charAt(i) != second.charAt(i)) cnt++;
                if (cnt > 1) return false;
            }
            return true;
        } else {    // 字符长度差为1，只能通过插入和删除
            if (n1 == 0 || n2 == 0) return true;
            int i = 0, j = 0;
            while (cnt <= 1) {
                if (first.charAt(i) == second.charAt(j)) {
                    i++; j++;
                } else {
                    cnt++;
                    if (n1 > n2) i++;
                    else j++;
                }
                if ((i >= n1 || j >= n2) && cnt <= 1) return true;
            }
            return false;
        }
    }

    /**
     * @see 面试题01.07.旋转矩阵[不占用额外的内存空间]
     * @param matrix
     */
    public static void rotate(int[][] matrix) {
        int n = matrix.length;
        // 先以对角线（左上-右下）为轴进行翻转
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
        // 再对每一行以中点进行翻转
        int mid = n >> 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < mid; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][n - 1 - j];
                matrix[i][n - 1 - j] = tmp;
            }
        }
    }

    /**
     * @see 面试题01.08.零矩阵
     * @param matrix
     * @apiNote 0所在行和列均变为零
     */
    public static void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[] col = new int[m];
        int[] row = new int[n];
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (matrix[i][j] == 0) {
                    // 记录0的坐标
                    col[i] = 1;
                    row[j] = 1;
                }
            }
        }
        // 清空标记列
        for (int i = 0; i < m; i++) {
            if (col[i] == 1) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = 0;
                }
            }
        }
        // 清空标记行
        for (int i = 0; i < n; i++) {
            if (row[i] == 1) {
                for (int j = 0; j < m; j++) {
                    matrix[j][i] = 0;
                }
            }
        }
    }

    /**
     * @see 面试题02.04.分割链表
     * @param head
     * @param x
     * @return 将所有大于目标值的节点均向后移
     */
    public ListNode partition(ListNode head, int x) {
        ListNode newHead = new ListNode(-1);
        ListNode bigHead = new ListNode(-1);
        ListNode tempNew = newHead;
        ListNode tempBig = bigHead;
        while (head != null) {
            if (head.val < x) {
                tempNew.next = head;
                tempNew = tempNew.next;
            } else {
                tempBig.next = head;
                tempBig = tempBig.next;
            }
            head = head.next;
        }
        tempNew.next = bigHead.next;
        tempBig.next = null;
        return newHead.next;
    }

    /**
     * @see 面试题02.05.链表求和
     * @param l1
     * @param l2
     * @return 链表为倒序排列{7，1，6}&{5，9，2}=617+295
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int res = 0;
        ListNode ans = new ListNode(0);
        ListNode cur = ans;
        while (l1!=null || l2!=null) {
            res += (l1==null) ? 0 : l1.val;
            res += (l2==null) ? 0 : l2.val;

            cur.next = new ListNode(res%10);
            res /= 10;

            l1 = (l1==null) ? null : l1.next;
            l2 = (l2==null) ? null : l2.next;
            cur = cur.next;
        }
        if (res == 1) cur.next = new ListNode(res);
        return ans.next;
    }

    public static void main(String[] args) {

    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {val = x;}
    }
}
