package y2022.Mar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Iris 2022/3/8
 */
public class Mar08 {
    public static void main(String[] args) {
        System.out.println(multiply(3, 4));
    }

    /**
     * @see 面试题08.05.递归乘法
     * @param A >0
     * @param B >0
     * @return 不使用*的前提下尽量少用+-和位移进行运算
     */
    public static int multiply(int A, int B) {
        if (A==0 || B==0) return 0;
        if (A==1) return B;
        if (B==1) return A;
        int res = 0;
        for (int i = 0; i < Math.min(A, B); i++) {
            res += Math.max(A, B);
        }
        return res;
    }

    private List<String> list = new ArrayList<>();
    private StringBuilder buffer = new StringBuilder();
    private boolean[] visited = new boolean[10];
    /**
     * @see 面试题08.07.无重复字符串的排列组合
     * @param S 1 <= length <= 9 且 均为英文字符
     * @return
     */
    public String[] permutation(String S) {
        dfs(S);
        String[] res = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
    private void dfs(String S) {
        if (buffer.length() == S.length()) {
            list.add(new String(buffer.toString()));
            return;
        }
        for (int i = 0; i < S.length(); i++) {
            if (!visited[i]) {
                buffer.append(S.charAt(i));
                visited[i] = true;
                dfs(S);
                visited[i] = false;
                buffer.deleteCharAt(buffer.length() - 1);
            }
        }
    }

    /**
     * @see 有重复字符串的排序组合
     * @param S
     * @return
     */
    public String[] permutation2(String S) {

        List<String> list = new ArrayList<>();
        char[] arr = S.toCharArray();
        Arrays.sort(arr);
        boolean[] book = new boolean[arr.length];
        dfs(list, new StringBuilder(), book, arr);

        String[] res = new String[list.size()];
        for (int i = 0; i < res.length; i++)
            res[i] = list.get(i);

        return res;
    }
    public void dfs(List<String> res, StringBuilder sb, boolean[] book, char[] arr) {

        if (sb.length() == arr.length) {
            res.add(sb.toString());
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            if (!book[i]) {
                if (i > 0 && arr[i] == arr[i - 1] && !book[i - 1])
                    continue;
                else {
                    sb.append(arr[i]);
                    book[i] = true;
                    dfs(res, sb, book, arr);
                    book[i] = false;
                    sb.deleteCharAt(sb.length() - 1);
                }
            }
        }
    }

    List<String> res;
    /**
     * @see 面试题08.09.括号
     * @param n
     * @return 返回要求n的合法括号
     */
    public List<String> generateParenthesis(int n) {
        res = new ArrayList<>();
        dfs(n, n, "");
        return res;
    }
    private void dfs(int left, int rigth, String str){
        if(left == 0 && rigth == 0){
            res.add(str);
        }
        if(left > 0){
            dfs(left - 1, rigth, str + "(");
        }
        if(left < rigth){
            dfs(left, rigth - 1, str + ")");
        }
    }

    /**
     * @see 面试题08.11.硬币
     * @param n
     * @return 返回由25，10，5，1四类硬币总和为n的解法数量
     */
    public int waysToChange(int n) {
        int[] coins = {25, 10, 5, 1};
        int[] res = new int[n + 1];
        res[0] = 1;
        for (int coin : coins) {
            for (int i = coin; i <=n; i++) {
                res[i] = (res[i] + res[i-coin]) % 1000000007;
            }
        }
        return res[n];
    }
}
