import java.util.*;

/**
 * @author Iris 2022/2/25
 */
public class Interview2022Feb25 {

    /**
     * @see 面试题01.01.判断字符是否唯一[不适用额外数据结构会很加分]
     * @apiNote 解题思路 >>> 未说明不可调用已有方法
     * @apiNote >>> 可以使用最后出现下标进行匹配
     * @apiNote >>> 根据源码，可以通过双重循环去查找最后一次出现的下标进行比较
     * @param astr 给定字符串
     * @return 字符串中每个字符是否唯一 >>> True | False
     */
    public static boolean isUnique(String astr) {
        if (astr == null) return true;
        for (int i = 0; i < astr.length(); i++) {
            if (astr.lastIndexOf(astr.charAt(i)) != i) {
                return false;
            }
        }
        return true;
    }

    /**
     * @see 面试题01.02.判定是否互为字符重排
     * @apiNote 解题思路 >>> 数组排序比较
     * @param s1 给定字符串1
     * @param s2 给定字符串2
     * @return 字符串1是否包含相同数量的字符串2的字符 Ture | False
     */
    public static boolean CheckPermutation(String s1, String s2) {
        // 若能够互排，则长度相等
        if (s1.length() != s2.length()) return false;
        char[] c1 = s1.toCharArray();
        Arrays.sort(c1);
        char[] c2 = s2.toCharArray();
        Arrays.sort(c2);
        return Arrays.equals(c1, c2);
    }

    /**
     * @see 面试题01.03.URL化[Java实现，使用字符数组实现，方便在数组上操作]
     * @apiNote 解题思路 >>> 两个字符数组进行数量匹配
     * @param S 给定字符串
     * @param length 给定字符串“真实长度”（不包含前后空格）
     * @return 返回将空格字符替换为%20的“真实字符串”
     */
    public static String replaceSpaces(String S, int length) {
        // 长度不匹配，直接返回null
        if (S==null || length>S.length()) return null;
        int resLen = 0;
        int inx = 0;
        for (int i = 0; i < length; i++) {
            if (S.charAt(i) == ' ') resLen++;
        }
        // 每个空格等于多加两个字符空间
        resLen = resLen*2 + length;
        char[] res = new char[resLen];
        for (int i = 0; i < length; i++) {
            if (S.charAt(i) == ' ') {
                res[inx++] = '%';
                res[inx++] = '2';
                res[inx++] = '0';
            } else {
                res[inx++] = S.charAt(i);
            }
        }
        return new String(res);
    }

    /**
     * @see 面试题01.04.回文排列
     * @param s 给定字符串
     * @return 字符串中字符能否形成回文串
     * @apiNote 解题思路 >>> 字符串中只能够有一个出现单次的字符
     */
    public static boolean canPermutePalindrome(String s) {
        if (s==null) return false;
        Set<Character> check = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            // 使用变量 >>> 减少运行时间
            char c = s.charAt(i);
            if (!check.add(c)) {
                check.remove(c);
            }
        }
        return check.size() <= 1;
    }

    /**
     * @see 面试01.06.字符串压缩[可以假设字符串仅含大小写字母]
     * @param S 给定字符串
     * @return 返回压缩后的字符串（若长度未变短，则返回原字符串）
     * @apiNote 解题思路 >>> 遍历即可
     */
    public static String compressString(String S) {
        // 特殊情况
        if (S.equals("") || S.isEmpty() || S.length() <= 2) return S;
        StringBuffer res = new StringBuffer();
        char[] chars = S.toCharArray();
        for (int i=0; i<chars.length;) {
            char c = chars[i];
            // 最后两位不等
            if (i == chars.length-1) {
                res.append(c).append(1);
                break;
            }
            res.append(c);
            int count = 1;
            while (c == chars[i+count]) {
                count++;
                // 最后两位相等
                if (i+count >= chars.length) break;
            }
            res.append(count);
            i += count;
        }
        return (chars.length <= res.length()) ? S : res.toString();
    }

    public static void main(String[] args) {}
}
