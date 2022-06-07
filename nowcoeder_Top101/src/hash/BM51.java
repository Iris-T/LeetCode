package hash;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author Iris 2022/6/7
 */
public class BM51 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,2,2,2,5,4,2};
        System.out.println(MoreThanHalfNum_Solution(nums));
    }

    public static int MoreThanHalfNum_Solution(int [] array) {
        if (array.length < 3) {
            return array[0];
        }
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int j : array) {
            if (map.containsKey(j)) {
                map.put(j, map.get(j) + 1);
                if (map.get(j) > array.length / 2) {
                    return j;
                }
            } else {
                map.put(j, 1);
            }
        }

        throw new IllegalArgumentException("No BM41");
    }
}
