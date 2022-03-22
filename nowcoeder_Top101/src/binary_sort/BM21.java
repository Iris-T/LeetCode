package binary_sort;

/**
 * @author Iris 2022/3/22
 */
public class BM21 {
    public static void main(String[] args) {
        int[] data1 = {3, 999, 323, 5, 3, 1, 45, 63, 32, 453};
        int[] data2 = {4, 3};
        System.out.println(minNumberInRotateArray(data2));
    }

    /**
     * @see 旋转数组的最小值
     * @param array
     * @return
     */
    public static int minNumberInRotateArray(int [] array) {
        if (array.length == 0) return Integer.MIN_VALUE;
        int low = 0, high = array.length-1;
        while (low < high) {
            int mid = (high - low)/2 + low;
            if (array[mid] > array[high]) low = mid + 1;
            else if (array[mid] == array[high]) high --;
            else high = mid;
        }
        return array[low];
    }
}
