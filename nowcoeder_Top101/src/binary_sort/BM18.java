package binary_sort;

/**
 * @author Iris 2022/3/21
 */
public class BM18 {
    public static void main(String[] args) {
        int[] a = {1,2,8,9};
        int[] b = {2,4,9,12};
        int[] c = {4,7,10,13};
        int[] d = {6,8,11,15};
        int[][] data = {a, b, c, d};
        System.out.println(Find(13, data));
    }

    /**
     * @see 在二维数组中是否包含目标数
     * @param target
     * @param array 每一列递增
     * @return
     */
    public static boolean Find(int target, int [][] array) {
        int rowInx = 0, colInx = array[0].length-1;
        while (rowInx <= array.length-1 && colInx >= 0) {
            int num = array[rowInx][colInx];
            if (num == target) return true;
            else if (num > target) colInx --;
            else rowInx ++;
        }
        return false;
    }
}
