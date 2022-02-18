package Feb;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author Iris 2022/2/18
 */
public class Feb18 {

    /**
     * 找出插入数据的下标位置
     * 1.首尾同时索引
     * 运行：0ms，超越100%；内存：41.1MB
     * @param nums 给定数组
     * @param target 目标数（插入数）
     * @return 下标值
     */
    public static int searchInsert(int[] nums, int target) {
        int len = nums.length;
        // 特殊情况（首尾）
        if (target <= nums[0]) {
            return 0;
        }
        if (target == nums[len-1]) {
            return len -1;
        }
        if (target > nums[len-1]) {
            return len;
        }
        for (int i = 1; i < (len/2)+1; i++) {
            if (nums[i] == target) {
                return i;
            }
            if (nums[len-i] == target) {
                return len-i;
            }
            if (nums[i-1] < target && target < nums[i]) {
                return i;
            }
            if (nums[len-1-i]< target && target < nums[len-i]) {
                return len-i;
            }
        }
        // 左右均不满足条件，只剩下中间位置
        return len%2==0 ? len/2 : (len/2)+1;
    }

    /**
     * 找出最大连续子数组之和
     * @param nums 给定数组
     * @return 最大和
     */
    public static int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        // 设为负数方便进行比较
        int temp = -1;
        for (int num : nums) {
            temp = Math.max(num, temp+num);
            maxSum = Math.max(maxSum, temp);
        }
        return maxSum;
    }

    /**
     * 最后一个单词的长度
     * 1.去除' '，然后取最后元素长度    (1ms,39.6MB)
     * 2.直接遍历，求长度值            (0ms,39.5MB)
     * @param s 给定字符串
     * @return 最后一个单词的长度
     */
    public static int lengthOfLastWord(String s) {
        /*---1---*/
//        String[] split = s.split(" ");
//        return split[split.length-1].length();
        /*---2---*/
        int len = 0;
        for (int i = s.length()-1; i >= 0; i--) {
            if (s.charAt(i)!=' ') {
                len++;
            } else if (len!=0) {
                return len;
            }
        }
        return len;
    }

    /**
     * 加1
     * 0ms,40MB
     * @param digits 给定数组>>>表示一个整数
     * @return 加1后的数组
     */
    public static int[] plusOne(int[] digits) {
        if (digits.length == 1) {
            digits[0]++;
        } else {
            digits[digits.length - 1]++;
        }
        for (int i = digits.length-1; i >= 0; i--) {
            if (digits[i] >= 10) {
                digits[i] = digits[i] % 10;
                if (i > 0) {
                    digits[i-1] ++;
                } else {
                    int[] temp = new int[digits.length+1];
                    temp[0] = 1;
                    System.arraycopy(digits, 0, temp, 1, digits.length);
                    return temp;
                }
            }
        }
        return digits;
    }

    /**
     * 二进制求和
     * @param a 字符串1
     * @param b 字符串2
     * @return 返回二进制字符串之和
     */
    public static String addBinary(String a, String b) {
        if(a == null || a.length() == 0) return b;
        if(b == null || b.length() == 0) return a;

        StringBuilder stb = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;

        int c = 0;  // 进位
        while(i >= 0 || j >= 0) {
            if(i >= 0) c += a.charAt(i --) - '0';
            if(j >= 0) c += b.charAt(j --) - '0';
            stb.append(c % 2);
            c >>= 1;
        }

        String res = stb.reverse().toString();
        return c > 0 ? '1' + res : res;
    }

    public static void main(String[] args) {
        System.out.println(addBinary("1010","1011"));
    }
}
