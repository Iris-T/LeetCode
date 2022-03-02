package y2022.Mar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @author Iris 2022/3/2
 */
public class Mar02 {

    /**
     * @see 面试题10.01.合并排序的数组
     * @param A
     * @param m
     * @param B
     * @param n
     */
    public void merge(int[] A, int m, int[] B, int n) {
        int inx = m+n-1, aInx = m-1, bInx = n-1;
        while (aInx>=0 && bInx>=0) {
            if (A[aInx] < B[bInx]) {
                A[inx--] = B[bInx--];
            } else {
                A[inx--] = A[aInx--];
            }
        }
        while (bInx>=0) A[inx--] = B[bInx--];
    }

    /**
     * @see 面试题10.05.稀疏数组搜索
     * @param words
     * @param s
     * @return 返回匹配字符串的下标
     */
    public static int findString(String[] words, String s) {
        int left = 0;
        int right = words.length-1;
        while (left <= right) {
            if (s.equals(words[left])) return left;
            if (s.equals(words[right])) return right;
            left++; right--;
        }
        return -1;
    }

    /**
     * @see 面试题16.05.阶乘尾数
     * @param n
     * @return 返回阶乘结果尾数中零的个数
     */
    public static int trailingZeroes(int n) {
        // 只有2*5 == 10 --> 记录数量少的(5)
        int cnt = 0;
        while (n>=5) {
            n/=5;
            cnt+=n;
        }
        return cnt;
    }

    /**
     * @see 面试题16.07.最大数值
     * @param a
     * @param b
     * @return 不使用if-else或比较运算符
     */
    public static int maximum(int a, int b) {
        long dif = (long)a - (long)b;
        int k = (int)(dif >>> 63);
        return a*(k^1) + b*k;
    }

    /**
     * @see 面试题16.11.跳水版
     * @param shorter 短板长
     * @param longer  长板长
     * @param k       使用板数
     * @return        可能长度的数组
     */
    public static int[] divingBoard(int shorter, int longer, int k) {
        if (k==0) return new int[]{};
        if (shorter == longer) return new int[]{shorter * k};
        int[] res = new int[k + 1];
        for (int i = k; i >= 0; i--) {
            res[k-i] = shorter*i + longer*(k-i);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] ints = divingBoard(1, 2, 3);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }
}
