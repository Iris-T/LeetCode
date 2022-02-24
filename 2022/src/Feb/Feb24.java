package Feb;

import java.util.*;

/**
 * @author Iris 2022/2/24
 */
public class Feb24 {

    /**
     * 颠倒二进制位
     * 解题思路：位运算
     *
     * @param n 给定十进制数值
     * @return 将其二进制数颠倒后的十进制数输出
     */
    public static int reverseBits(int n) {
        int result = 0;
//        Integer为32位
        for (int i = 0; i < Integer.SIZE; i++) {
            result <<= 1;
            result |= n & 1;
            n >>>= 1;
        }
        return result;
    }

    /**
     * 1的个数（汉明重量）
     *
     * @param n 给定整数
     * @return 返回为1的数值
     */
    public static int hammingWeight(int n) {
        int count = 0;
        for (int i = 0; i < Integer.SIZE; i++) {
            // 用n的末位与1做与运算，即是验证bit是否为1
            count += n & 1;
            n >>= 1;
        }
        return count;
    }

    /**
     * 快乐数
     * 例如 19
     * 1^2 + 9^2 = 82
     * 8^2 + 2^2 = 68
     * 6^2 + 8^2 = 100
     * 1^2 + 0^2*2 = 1
     * true
     * 解题思路：非快乐数会进入循环 --> 使用循环和集合进行判断
     *
     * @param n 给定整数
     * @return True | False
     */
    public static boolean isHappy(int n) {
        Set<Integer> checks = new HashSet();
        while (n != 1 && !checks.contains(n)) {
            checks.add(n);
            int sum = 0;
            while (n > 0) {
                sum += (n % 10) * (n % 10);
                n /= 10;
            }
            n = sum;
        }
        return n == 1;
    }

    /**
     * 同构字符串
     * @param s 字符串1
     * @param t 字符串2
     * @return add & egg return True | else return False
     */
    public static boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> check = new HashMap<>();
        for(int i=0; i<s.length(); i++){
            if(!check.containsKey(s.charAt(i))){
                if(check.containsValue(t.charAt(i))){
                    return false;
                }
                check.put(s.charAt(i), t.charAt(i));
            }else{
                if(check.get(s.charAt(i))!=t.charAt(i)){
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * 反转链表
     * 实现方法
     * 1.迭代
     * 2.递归
     * @param head 头节点
     * @return 反转链表头节点
     */
    public ListNode reverseList1(ListNode head) {
        ListNode inx = head, res = null;
        while (inx != null) {
            // 通过形成环，将后面的元素加在pre后方
            ListNode next = inx.next;
            inx.next = res;
            res = inx;
            inx = next;
        }
        return res;
    }

    public ListNode reverseList2(ListNode head) {
        return reverse(null, head);
    }
    private ListNode reverse(ListNode pre, ListNode inx) {
        if (inx == null) return pre;
        ListNode next = inx.next;
        inx.next = pre;
        return reverse(inx, next);
    }

    /**
     * 移除链表元素
     * 解题思路：在链表前方添加一个节点 >>> 头节点为目标节点
     * 最后返回预留节点的下一节点即可
     * @param head 给定链表头节点
     * @param val 删除节点的值
     * @return 返回新的头节点
     */
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return null;
        ListNode temp = new ListNode(-1);
        temp.next = head;
        ListNode inx = temp;
        while (inx.next != null) {
            if (inx.next.val == val) {
                inx.next = inx.next.next;
            } else {
                inx = inx.next;
            }
        }
        return temp.next;
    }

    /**
     * 包含重复元素
     * @param nums 给定数组
     * @return 若出现 出现次数>=2的数 则返回True，否则返回False
     */
    public static boolean containsDuplicate(int[] nums) {
        HashSet<Integer> check = new HashSet<>();
        for (int num : nums) {
            if (!check.add(num)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 存在重复元素V2.0
     * @param nums 给定数组
     * @param k 可能重复的数值的左右范围
     * @return True 存在 | False 不存在
     */
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> check = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer inx = check.get(nums[i]);
            if (inx!=null && i-inx<=k) {
                return true;
            }
            check.put(nums[i], i);
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(containsNearbyDuplicate(new int[]{1,2,3,1}, 1));
    }

    public class ListNode {
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
