////////给你一个字符串 s，找到 s 中最长的回文子串。 
////////
//////// 
////////
//////// 示例 1： 
////////
//////// 
////////输入：s = "babad"
////////输出："bab"
////////解释："aba" 同样是符合题意的答案。
//////// 
////////
//////// 示例 2： 
////////
//////// 
////////输入：s = "cbbd"
////////输出："bb"
//////// 
////////
//////// 
////////
//////// 提示： 
////////
//////// 
//////// 1 <= s.length <= 1000 
//////// s 仅由数字和英文字母组成 
//////// 
//////// Related Topics 字符串 动态规划 👍 5443 👎 0
//////
////
//

package leetcode.editor.cn;

public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        Solution solution = new LongestPalindromicSubstring().new Solution();
        String abba = solution.longestPalindrome("aacabdkacaa");
        System.out.println(abba + "");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 动态规划的解法
        public String longestPalindrome(String s) {
            if (s == null || "".equals(s)) {
                return "";
            }
            StringBuilder stringBuilder = new StringBuilder(s);
            String reverse = stringBuilder.reverse().toString();
            int length = s.length();
            int[][] arr = new int[length][length];
            int maxLen = 0;
            int endIndex = 0;
            for (int i = 0; i < length; i++) {
                for (int j = 0; j < length; j++) {
                    if (s.charAt(i) == reverse.charAt(j)) {
                        if (i == 0 || j == 0) {
                            arr[i][j] = 1;
                        } else {
                            arr[i][j] = arr[i-1][j-1] + 1;
                        }

                        if (maxLen < arr[i][j]) {
                            // 检测是原数组相对位置上的字符串，才能确认是真的回文字符串
                            int before = length - 1 - j;
                            if (before + arr[i][j] - 1 == i) {
                                maxLen = arr[i][j];
                                endIndex = i;
                            }
                        }
                    }
                }
            }
            // 起始位置到最终位置截取字符串
            return s.substring(endIndex + 1 - maxLen, endIndex + 1);
        }
    }

//leetcode submit region end(Prohibit modification and deletion)
}