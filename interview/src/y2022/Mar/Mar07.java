package y2022.Mar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author Iris 2022/3/7
 */
public class Mar07 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(drawLine(15, 96, 81, 95, 1)));
    }

    /**
     * @see 面试题05.02.二进制数转字符串
     * @param num
     * @return
     */
    public String printBin(double num) {
        StringBuffer res = new StringBuffer("0.");
        for (int i = 0; i < 33; i++) {
            if (num == 0) return res.toString();
            num *= 2;
            if (num >= 1) {
                res.append('1');
                num--;
            } else {
                res.append('0');
            }
        }
        return "ERROR";
    }

    /**
     * @see 面试题05.04.下一个数
     * @param num
     * @return 返回给定正整数所含位1数量相同且大小最为接近的两个数
     */
    public int[] findClosedNumbers(int num) {
        // 特殊情况
        if (num == Integer.MAX_VALUE) return new int[]{-1, -1};
        int left = num-1, right = num+1;
        int cnt = getOneCnt(num);
        while (getOneCnt(right) != cnt) {
            right++;
            // 较大值越界则返回-1
            if (right<0) {
                right = -1;
                break;
            }
        }
        while (getOneCnt(left) != cnt) {
            left--;
            if (left<0) {
                left = -1;
                break;
            }
        }
        return new int[]{right, left};
    }
    private int getOneCnt(int num) {
        int cnt = 0;
        while (num != 0) {
            num &= num-1;
            cnt++;
        }
        return cnt;
    }

    /**
     * @see 面试题05.08.绘制直线
     * @param length 总长度
     * @param w 32倍数，像素点（0|1位）
     * @param x1 起始位点
     * @param x2 终止位点
     * @param y y轴维度
     * @return
     */
    public static int[] drawLine(int length, int w, int x1, int x2, int y) {
        if (length == 0) return null;
        int[] res = new int[length];
        // 找到数组中左右端点位置
        int left = (y*w + x1) / 32;
        int right = (y*w + x2) / 32;
        // 将 left 至 right 之间的数全部初始化
        for (int i = left; i <= right; i++) {
            res[i] = -1;
        }
        // 最左的数高位补零 (x1 % 32)
        res[left] = res[left] >>> x1 % 32;
        res[right] = res[right] & Integer.MIN_VALUE >> x2 % 32;
        return res;
    }

    /**
     * @see 面试题08.02.迷路的机器人
     * @param obstacleGrid
     * @return 返回机器人从左上角到右下角的路线（1为障碍物）
     */
    public List<List<Integer>> pathWithObstacles(int[][] obstacleGrid) {
        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;
        boolean[][] visited = new boolean[row][col];
        List<List<Integer>> res = new ArrayList<>();
        // 特殊情况
        if (obstacleGrid[0][0] == 1 || obstacleGrid[row-1][col-1] == 1) return res;
        visited[0][0] = true;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (obstacleGrid[i][j] == 0) {
                    // 查询当前节点是否与路径(左或上)连接
                    if (i > 0) visited[i][j] |= visited[i - 1][j];
                    if (j > 0) visited[i][j] |= visited[i][j - 1];
                }
            }
        }
        // 若目标点未被识别为true >>> 无到达路径
        if (!visited[row-1][col-1]) return res;
        row --;
        col --;
        // 从目标点回溯路径
        while (row>=0 && col>=0) {
            res.add(Arrays.asList(row, col));
            if (row != 0 && visited[row-1][col]) row--;
            else col--;
        }
        Collections.reverse(res);
        return res;
    }

    private List<List<Integer>> ans = new ArrayList<>();
    /**
     * @see 面试题08.04.幂集
     * @param nums
     * @return 返回集合所包含的所有子集的集合（不包含重复元素）
     */
    public List<List<Integer>> subsets(int[] nums) {
        dfs(nums, 0, new ArrayList<>());
        return ans;
    }
    private void dfs(int[] nums, int start, ArrayList<Integer> arr) {
        ans.add(new ArrayList<>(arr));
        for (int i = start; i < nums.length; i++) {
            arr.add(nums[i]);
            dfs(nums, i+1, arr);
            arr.remove(arr.size()-1);
        }
    }
}
