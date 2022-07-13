package string;

public class LongestPalindrome {

    /**
     * 输入：s = "babad"
     * 输出："bab"
     * 解释："aba" 同样是符合题意的答案。
     */
    public static void main(String[] args) {
        String abba = longestPalindrome("aacabdkacaa");
        System.out.println(abba + "");
    }

    public static String longestPalindrome(String s) {
        if (null == s || "".equals(s)) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder(s);
        String reverse = stringBuilder.reverse().toString();
        int length = s.length();
        int[][] arr = new int[length][length];
        int maxLen = 0, endIndex = 0;
        for (int i = 0; i <length; i++) {
            for (int j = 0; j < length; j++) {
                if (s.charAt(i) == reverse.charAt(j)) {
                    if (i == 0 || j == 0) {
                        arr[i][j] = 1;
                    } else {
                        arr[i][j] = arr[i-1][j-1] + 1;
                    }
                }

                if (arr[i][j] > maxLen) {
                    // 计算原始位置，是根据j计算，maxLen没办法计算的
                    int before = length - 1 - j;
                    if (before + arr[i][j] - 1 == i) {
                        maxLen = arr[i][j];
                        endIndex = i;
                    }
                }
            }
        }
        // 这里起始位置是要+1的，因为maxLen是长度，不是角标，而endIndex是角标，差了1
        return s.substring(endIndex - maxLen + 1, endIndex + 1);
    }
}
