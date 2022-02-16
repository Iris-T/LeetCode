package Feb;

/**
 * @author Iris 2022/2/16
 */
public class Feb16 {
    /**
     * 重新排序字符串
     * 给定的数组对应字符串字符下标
     * 1.直接遍历
     *
     * @param s       字符串
     * @param indices 数组
     * @return 重新排序的字符串
     */
    public static String restoreString(String s, int[] indices) {
        char[] res = new char[indices.length];
        for (int i = 0; i < indices.length; i++) {
            res[indices[i]] = s.charAt(i);
        }
        return new String(res);
    }

    /**
     * 在数组中找出能够满足和值为给定数的两数下标
     * 1.双重循环，暴力求解
     *
     * @param nums   给定数组
     * @param target 给定数字
     * @return 满足条件的数字下标
     */
    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (target == nums[i] + nums[j] && i != j) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    /**
     * 回文数判断
     * 1.通过回文数特点，直接转换为字符串折半遍历
     * @param x 给定数字
     * @return True | False
     */
    public static boolean isPalindrome(int x) {
        char[] chars = String.valueOf(x).toCharArray();
        for (int i = 0; i < chars.length / 2; i++) {
            if (chars[i] != chars[chars.length - 1 - i]) {
                return false;
            }
        }
        return true;
    }

    /**
     * 罗马数字转换为阿拉伯数字
     * IV = 4   IX = 9
     * XL = 40  XC = 90
     * CD = 400 CM = 900
     * >> 可得出在左边的情况仅相差一个十进制单位
     * 1.通过罗马数字书写规则进行字符串匹配
     *
     * @param s 给定罗马数字字符串
     * @return int数值
     */
    public static int romanToInt(String s) {
        int res = 0;
        String[] special = new String[]{"CM", "CD", "XC", "XL", "IX", "IV"};
        // 在左边的数量只会有一个，使用replaceAll
        for (String spl : special) {
            if (s.contains(spl) && !"".equals(s)) {
                String[] split = s.split(spl);
                StringBuffer temp = new StringBuffer();
                for (String strs : split) {
                    temp.append(strs);
                }
                s = new String(temp);
                switch (spl) {
                    case "CM":
                        res += 900;
                        break;
                    case "CD":
                        res += 400;
                        break;
                    case "XC":
                        res += 90;
                        break;
                    case "XL":
                        res += 40;
                        break;
                    case "IX":
                        res += 9;
                        break;
                    case "IV":
                        res += 4;
                    default:
                        break;
                }
            }
        }
        if (!"".equals(s)) {
            for (char c : s.toCharArray()) {
                switch (c) {
                    case 'M':
                        res += 1000;
                        break;
                    case 'D':
                        res += 500;
                        break;
                    case 'C':
                        res += 100;
                        break;
                    case 'L':
                        res += 50;
                        break;
                    case 'X':
                        res += 10;
                        break;
                    case 'V':
                        res += 5;
                        break;
                    case 'I':
                        res++;
                    default:
                        break;
                }
            }
        }
        return res;
    }

    /**
     * 最长公共前缀
     * 1.暴力求解
     * @param strs 给定字符串数组
     * @return 最长公共前缀
     */
    public static String longestCommonPrefix(String[] strs) {
        StringBuffer maxPreStr = new StringBuffer(strs[0]);
        for (int i = 1; i < strs.length; i++) {
            StringBuffer tempPreStr = new StringBuffer();
            for (int j = 0; j < Math.min(maxPreStr.length(),strs[i].length()); j++) {
                if (strs[i].charAt(j) == maxPreStr.charAt(j)) {
                    tempPreStr.append(maxPreStr.charAt(j));
                } else {
                    maxPreStr.delete(j, maxPreStr.length());
                }
            }
            if (tempPreStr.length() < maxPreStr.length()) {
                maxPreStr = tempPreStr;
                continue;
            }
            tempPreStr.delete(0, tempPreStr.length());
        }
        return new String(maxPreStr);
    }

    public static void main(String[] args) {}
}
