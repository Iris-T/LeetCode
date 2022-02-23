package Feb;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Iris 2022/2/23
 */
public class Feb23 {

    /**
     * 设计一个支持push，pop，top操作，且能在常数时间内检索到最小元素的栈
     * 最优解：以链表形式获取头节点之后的最小值
     */
    static class MinStack {

        private StackNode head;

        public void push(int val) {
            if (head == null) {
                head = new StackNode(val, val);
            } else {
                head = new StackNode(val, Math.min(val, head.minValue), head);
            }
        }

        public void pop() {
            head = head.next;
        }

        public int top() {
            return head.value;
        }

        public int getMin() {
            return head.minValue;
        }

        private static class StackNode {
            int value;
            int minValue;
            StackNode next;

            private StackNode(int value, int minValue) {
                this(value, minValue, null);
            }
            private StackNode(int value, int minValue, StackNode next) {
                this.value = value;
                this.minValue = minValue;
                this.next = next;
            }
        }
    }

    /**
     * 相交链表，若没有相交则返回null，否则返回相交的节点
     * 解题思路：让两个指针交叉前进
     * 指针 走到链表末尾则指向另一条链表，否则指向下一节点
     * 当两指针相同时，即为相交点
     * @param headA 链表A头节点
     * @param headB 链表B头节点
     * @return null | 相交节点
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA==null || headB==null) return null;
        ListNode nodeA = headA;
        ListNode nodeB = headB;
        // 如果两条链表没有交点，则均为空值
        while (nodeA != nodeB) {
            nodeA = (nodeA == null) ? headB : nodeA.next;
            nodeB = (nodeB == null) ? headA : nodeB.next;
        }
        return nodeA;
    }

    /**
     * Excel表列名称
     * 将整数转换为Excel对应表列名（AA -> 27）
     * A~Z >>> 65~90
     * @param num 给定整数
     * @return 返回字符串类型的表列名
     */
    public static String convertToTitle(int num) {
        if (num <= 0) return "";
        StringBuffer result = new StringBuffer();
        while (num > 0) {
            // num-- 用于将 0~25 与 A~Z 对应，形成标准的26进制
            num--;
            result.append((char) (num%26+'A'));
            num /= 26;
        }
        return result.reverse().toString();
    }

    /**
     * 多数元素(变向的找众数)
     * 解题思路
     * 1.直接查找，单次循环，若元素值相同则次数加1，否则减1，若次数为0，则换目标数
     * 2.排序后输出中间数
     * @param nums 给定数组非空，且必定存在多数元素
     * @return 返回出现次数大于num.length/2的数字
     */
    public static int majorityElement(int[] nums) {
        int result = nums[0], count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (result == nums[i]) count++;
            else {
                count--;
                if (count == 0) {
                    result = nums[i+1];
                }
            }
        }
        return result;
    }
    public static int majorityElement2(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }

    /**
     * Excel表列序号
     * @param columnTitle 给定字符串
     * @return 返回其表示的列数
     */
    public static int titleToNumber(String columnTitle) {
        int res = 0;
        int length = columnTitle.length();
        for (int i = 0; i < length; i++) {
            res += (columnTitle.charAt(i)-'A'+1)*(int) Math.pow(26, length-1-i);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(titleToNumber("AB"));
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }

    }
}
