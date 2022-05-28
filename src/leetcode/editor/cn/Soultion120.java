//给定一个三角形 triangle ，找出自顶向下的最小路径和。 
//
// 每一步只能移动到下一行中相邻的结点上。相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。也就是说，如果
//正位于当前行的下标 i ，那么下一步可以移动到下一行的下标 i 或 i + 1 。 
//
// 
//
// 示例 1： 
//
// 
//输入：triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
//输出：11
//解释：如下面简图所示：
//   2
//  3 4
// 6 5 7
//4 1 8 3
//自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
// 
//
// 示例 2： 
//
// 
//输入：triangle = [[-10]]
//输出：-10
// 
//
// 
//
// 提示： 
//
// 
// 1 <= triangle.length <= 200 
// triangle[0].length == 1 
// triangle[i].length == triangle[i - 1].length + 1 
// -10⁴ <= triangle[i][j] <= 10⁴ 
// 
//
// 
//
// 进阶： 
//
// 
// 你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题吗？ 
// 
// Related Topics 数组 动态规划 👍 1005 👎 0

/**
 * @author sanshisi
 */

package leetcode.editor.cn;

import java.util.List;

public class Soultion120 {
    public static void main(String[] args) {
        Solution solution = new Soultion120().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minimumTotal(List<List<Integer>> triangle) {
            int n = triangle.size();
            int ans = Integer.MAX_VALUE;
            int[][] f = new int[2][n];
            f[0][0] = triangle.get(0).get(0);
            for (int i = 1; i < n; i++) {
                for (int j = 0; j < i + 1; j++) {
                    int val = triangle.get(i).get(j);
                    f[i & 1][j] = Integer.MAX_VALUE;
                    if (j != 0) f[i & 1][j] = Math.min(f[i & 1][j], f[(i - 1) & 1][j - 1] + val);
                    if (j != i) f[i & 1][j] = Math.min(f[i & 1][j], f[(i - 1) & 1][j] + val);
                }
            }
            /*查找最后一行最小值*/
            for (int i = 0; i < n; i++) {
                ans = Math.min(ans, f[(n + 1 )& 1][i]);
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
