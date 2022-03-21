package binary_sort;

/**
 * @author Iris 2022/3/21
 */
public class BM19 {
    public static void main(String[] args) {
        int[] data = {1, 2, 3, 4, 3, 5, 1};
        System.out.println(findPeakElement(data));
    }

    /**
     * @see 返回山峰（大于左和右）的索引
     * @param nums
     * @return
     */
    public static int findPeakElement (int[] nums) {
        int l = 0, r = nums.length-1;
        while (l < r) {
            int m = (r-l)/2 + l;
            if (nums[m] < nums[m+1]) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return l;
    }
}
