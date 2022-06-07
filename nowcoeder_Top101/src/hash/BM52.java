package hash;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author Iris 2022/6/7
 */
public class BM52 {
    public int[] FindNumsAppearOnce(int[] array) {
        // write code here
        if (array.length == 2) {
            return array;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> res = new ArrayList<>();

        for (int i : array) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }

        for (int i : array) {
            if (map.get(i) == 1) {
                res.add(i);
            }
        }

        return res.get(0) > res.get(1)
                ? new int[]{res.get(1), res.get(0)}
                : new int[]{res.get(0), res.get(1)};
    }
}
