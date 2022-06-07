package hash;

import java.util.*;

/**
 * @author Iris 2022/6/7
 */
public class BM50 {
    /**
     *
     * @param numbers int整型一维数组
     * @param target int整型
     * @return int整型一维数组
     */
    public int[] twoSum (int[] numbers, int target) {
        // write code here
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<numbers.length; i++) {
            int diff = target - numbers[i];
            if(map.containsKey(diff)) {
                return new int[]{map.get(diff), i};
            } else {
                map.put(numbers[i], i+1);
            }
        }
        throw new IllegalArgumentException("No BM41");
    }
}
