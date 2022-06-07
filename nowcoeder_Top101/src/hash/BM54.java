package hash;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Iris 2022/6/7
 */
public class BM54 {
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (num.length < 3) return res;
        Arrays.sort(num);
        for (int i = 0; i < num.length-2; i++) {
            // 去重
            if (i != 0 && num[i] == num[i-1]) continue;
            int left = i + 1;
            int right = num.length-1;
            while(left < right) {
                if (num[left] + num[right] == -num[i]) {
                    ArrayList<Integer> data = new ArrayList<>();
                    data.add(num[i]);
                    data.add(num[left]);
                    data.add(num[right]);
                    res.add(data);
                    // 去重
                    while(left + 1 < right && num[left] == num[left + 1]) {
                        left ++;
                    }
                    // 去重
                    while(right - 1 > left && num[right] == num[right - 1]) {
                        right --;
                    }
                    // 收缩
                    left ++;
                    right --;
                    // 总和小于零，则左侧值过小
                } else if (num[left] + num[right] < -num[i]) {
                    left ++;
                } else {
                    right --;
                }
            }
        }
        return res;
    }
}
