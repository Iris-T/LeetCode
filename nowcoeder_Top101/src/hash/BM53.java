package hash;

import java.util.HashMap;

/**
 * @author Iris 2022/6/7
 */
public class BM53 {
    public int minNumberDisappeared (int[] nums) {
        // write code here
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            if (i > 0) {
                map.put(i, 1);
            }
        }

        int res = 1;
        while (map.containsKey(res)) {
            res ++;
        }
        return res;
    }
}
