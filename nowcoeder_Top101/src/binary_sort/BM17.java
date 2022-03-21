package binary_sort;

/**
 * @author Iris 2022/3/21
 */
public class BM17 {
    public static void main(String[] args) {
        int[] data = {-1, 0, 3, 4, 6, 10, 13, 14};
        System.out.println(search(data, 6));
    }

    /**
     * @see 返回目标数的下标，否则返回-1
     * @param nums
     * @param target
     * @return
     */
    public static int search (int[] nums, int target) {
        int left = 0, right = nums.length-1;
        while (left <= right) {
            int mid = mid = left+right/2;
            if (nums[mid] == target) return mid;
            else if(nums[mid] > target) right --;
            else left ++;
        }
        return -1;
    }
}
