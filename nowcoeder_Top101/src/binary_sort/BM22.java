package binary_sort;

/**
 * @author Iris 2022/3/22
 */
public class BM22 {
    public static void main(String[] args) {

    }

    /**
     * @see 比较版本号，v1大于v2返回-1，小于返回-1，不然返回0
     * @param version1
     * @param version2
     * @return
     */
    public int compare (String version1, String version2) {
        String[] codes1 = version1.split("\\.");
        String[] codes2 = version2.split("\\.");
        int c1Len = codes1.length;
        int c2Len = codes2.length;

        if (c1Len == 0 || c2Len == 0) {
            return (c1Len == 0) ? -1 : 1;
        }

        for (int i = 0; i < Math.max(c1Len, c2Len); i++) {
            int n1 = (i < c1Len) ? Integer.parseInt(codes1[i]) : 0;
            int n2 = (i < c2Len) ? Integer.parseInt(codes2[i]) : 0;
            if (n1 > n2) return 1;
            else if (n1 < n2) return -1;
        }
        return 0;
    }
}
