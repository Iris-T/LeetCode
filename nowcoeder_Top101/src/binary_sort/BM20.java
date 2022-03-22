package binary_sort;

/**
 * @author Iris 2022/3/22
 */
import java.util.Arrays;
public class BM20 {

    static int count = 0;

    public static int InversePairs(int[] array) {
        sort(array, 0, array.length - 1);
        return count;
    }

    static void sort(int[] array, int l, int r) {
        if (l >= r)
            return;
        int mid = (l + r) / 2;
        sort(array, l, mid);
        sort(array, mid + 1, r);

        if (array[mid] > array[mid + 1]) {
            count += merge(array, l, mid, r);
            if(count >1000000007)
                count -=1000000007;
        }

    }

    static int merge(int[] array, int l, int mid, int r) {
        int tc = 0;
        int c = 0;
        int[] temp = Arrays.copyOfRange(array, l, r + 1);
        int i = l, j = mid + 1;
        for (int k = l; k <= r; k++) {
            if (i > mid) {
                array[k] = temp[j - l];
                j++;
            } else if (j > r) {
                array[k] = temp[i - l];
                c += tc;
                tc = 0;
                i++;
            } else if (temp[i - l] < temp[j - l]) {
                array[k] = temp[i - l];
                c += tc;
                tc = 0;
                i++;
            } else {
                array[k] = temp[j - l];
                tc += mid - i + 1;
                j++;

            }
        }
        return c;
    }
}
