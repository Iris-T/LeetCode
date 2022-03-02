package y2022.Mar;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Iris 2022/3/1
 */
public class Mar01 {

    /**
     * @see 面试题05.07.配对交换[尽量使用较少指令]
     * @param num 给定一个数
     * @return 将该数位0与位1交换，位2与位3交换，以此类推
     */
    public int exchangeBits(int num) {
        return ((num&0x55555555)<<1) | ((num&0xaaaaaaaa)>>1);
    }

    /**
     * @see 面试题08.01.三步问题
     * @param n 给定楼梯阶数
     * @return 小孩每次走 1 | 2 | 3步，返回走法次数
     * @apiNote 类似于斐波拉契
     */
    public int waysToStep(int n) {
        if (n <= 2) return n;
        if (n == 3) return 4;
        // 定义数组来存放数值
        int pre1 = 1, pre2 = 2, pre3 = 4;
        int res = -1;
        while (--n >= 3) {
            res = ((pre1 + pre2)%1000000007 + pre3)%1000000007;
            pre1 = pre2;
            pre2 = pre3;
            pre3 = res;
        }
        return res;
    }

    /**
     * @see 面试题08.03.魔术索引
     * @param nums 升序整数数组
     * @return
     */
    public int findMagicIndex(int[] nums) {
        if (nums.length == 1 && nums[0] == 0) return 0;
        if (nums.length == 1 && nums[0] != 0) return -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]==i) return i;
        }
        return -1;
    }

    /**
     * @see 面试题08.06.汉诺塔
     * @param A
     * @param B
     * @param C
     */
    public static void hanota(List<Integer> A, List<Integer> B, List<Integer> C) {
        move(A, B, C, A.size());
    }
    public static void move(List<Integer> A, List<Integer> B, List<Integer> C, int n) {
        // 仅剩最后一个盘子
        if (n==1) {
            C.add(A.remove(A.size()-1));
            return;
        }
        move(A, C, B, n-1);
        C.add(A.remove(A.size()-1));
        move(B, A, C, n-1);
    }

    /**
     * @see 面试题08.10.颜色填充
     * @param image 给定图片坐标数组
     * @param sr 初始行坐标
     * @param sc 初始列坐标
     * @param newColor 新的颜色代码
     * @return 颜色填充后的新数组
     * @apiNote 若一个坐标点附近存在与其相同的值，则其附近的坐标点均被填充
     */
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int M = image.length;    // 行
        int N = image[0].length; // 列
        int oldColor = image[sr][sc];
        if (oldColor != newColor) {
            dfs(image, sr, sc, newColor, oldColor);
        }
        return image;
    }

    private void dfs(int[][] image, int row, int col, int newColor, int oldColor) {
        int M = image.length;    // 行
        int N = image[0].length; // 列
        // 特殊情况：超界 | 查到非对应颜色坐标点
        if (row>=M || row<0 || col>=N || col<0 || image[row][col]!=oldColor) {
            return;
        }
        image[row][col] = newColor;
        // 深度优先
        dfs(image, row + 1, col, newColor, oldColor);
        dfs(image, row - 1, col, newColor, oldColor);
        dfs(image, row, col + 1, newColor, oldColor);
        dfs(image, row, col - 1, newColor, oldColor);
    }

    public static void main(String[] args) {
        List<Integer> A = new ArrayList<>();
        List<Integer> B = new ArrayList<>();
        List<Integer> C = new ArrayList<>();
        A.add(2);
        A.add(1);
        A.add(0);
        hanota(A, B, C);
        System.out.println(C.toString());
    }
}
