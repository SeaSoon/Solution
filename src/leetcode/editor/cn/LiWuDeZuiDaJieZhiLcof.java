//在一个 m*n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）。你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格、直
//到到达棋盘的右下角。给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物？ 
//
// 
//
// 示例 1: 
//
// 输入: 
//[
//  [1,3,1],
//  [1,5,1],
//  [4,2,1]
//]
//输出: 12
//解释: 路径 1→3→5→2→1 可以拿到最多价值的礼物 
//
// 
//
// 提示： 
//
// 
// 0 < grid.length <= 200 
// 0 < grid[0].length <= 200 
// 
// Related Topics 数组 动态规划 矩阵 👍 306 👎 0

package leetcode.editor.cn;

public class LiWuDeZuiDaJieZhiLcof {
    public static void main(String[] args) {
        Solution solution = new LiWuDeZuiDaJieZhiLcof().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxValue(int[][] grid) {
            int len1 = grid.length;
            int len2 = grid[0].length;
            for (int i = 1; i < len1; i++) {
                grid[i][0] = grid[i - 1][0] + grid[i][0];
            }
            for (int i = 1; i < len2; i++) {
                grid[0][i] = grid[0][i - 1] + grid[0][i];
            }
            for (int i = 1; i < len1; i++) {
                for (int j = 1; j < len2; j++) {
                    grid[i][j] = Math.max(grid[i - 1][j], grid[i][j - 1]) + grid[i][j];
                }
            }
            return grid[len1 - 1][len2 - 1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}