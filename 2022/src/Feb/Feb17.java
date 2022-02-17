package Feb;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author Iris 2022/2/17
 */
public class Feb17 {
    /**
     * 有效的括号（括号匹配）
     * 1.栈匹配
     *
     * @param s 给定字符串包含()[]{}
     * @return True | False
     */
    public static boolean isValid(String s) {
        Stack<Character> strStack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                strStack.push(')');
            } else if (c == '[') {
                strStack.push(']');
            } else if (c == '{') {
                strStack.push('}');
            } else if (strStack.isEmpty() || c != strStack.pop()) {
                return false;
            }
        }
        return strStack.isEmpty();
    }

    /**
     * 合并有序链表
     * 1.循环遍历
     *
     * @param list1 链表1
     * @param list2 链表2
     * @return 合并后的链表
     */
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        ListNode res = list1.val < list2.val ? list1 : list2;
        res.next = mergeTwoLists(res.next, list1.val >= list2.val ? list1 : list2);
        return res;
    }

    /**
     * 删除有序数组中的重复项
     * 不要使用额外的空间，你必须在【原地】修改输入数组并在使用【O(1)】额外空间的条件下完成。
     *
     * @param nums 给定升序排列的数组
     * @return 返回删除重复值后的数组长度
     */
    public static int removeDuplicates(int[] nums) {
        int len = 1;
        if (nums.length == 0 || nums.length == 1) {
            return nums.length;
        }
        int i = 1;
        while (i < nums.length) {
            if (nums[i] == nums[i - 1]) {
                i++;
            } else {
                if (i != len) {
                    nums[len] = nums[i];
                }
                i++;
                len++;
            }
        }
        return len;
    }

    /**
     * 移除元素，从给定数组中移除指定数值
     *
     * @param nums 给定数组
     * @param val  给定值
     * @return 数组删除后的长度
     */
    public static int removeElement(int[] nums, int val) {
        int leftIndex = 0;
        int rightIndex = nums.length - 1;
        if (nums.length == 0) {
            return 0;
        }
        while (leftIndex <= rightIndex) {
            if (nums[rightIndex] == val) {
                rightIndex--;
                continue;
            }
            if (nums[leftIndex] == val) {
                nums[leftIndex] = nums[rightIndex];
                rightIndex--;
            }
            leftIndex++;
            System.out.println(Arrays.toString(nums));
        }
        return leftIndex;
    }

    /**
     * 在字符串haystack中找到needle第一次出现的首字母下标
     *
     * @param haystack 给定字符串
     * @param needle   目标字符串
     * @return 下标值
     */
    public static int strStr(String haystack, String needle) {
        int nLen = needle.length();
        if (nLen == 0) {
            return 0;
        }
        if (nLen > haystack.length()) {
            return -1;
        }
        for (int i = 0, j = haystack.length() - nLen; i <= j; i++) {
            int k = 0;
            while (k < nLen && haystack.charAt(k + i) == needle.charAt(k)) {
                k++;
            }
            if (k == nLen) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(strStr("abc", "c"));
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
