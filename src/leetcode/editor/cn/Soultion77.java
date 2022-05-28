//给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。 
//
// 你可以按 任何顺序 返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 4, k = 2
//输出：
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//] 
//
// 示例 2： 
//
// 
//输入：n = 1, k = 1
//输出：[[1]] 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 20 
// 1 <= k <= n 
// 
// Related Topics 数组 回溯 👍 908 👎 0

/**
 * @author sanshisi
 */

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Soultion77 {
    public static void main(String[] args) {
        Solution solution = new Soultion77().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<List<Integer>> res = new ArrayList<>();

        public List<List<Integer>> combine(int n, int k) {
            LinkedList<Integer> track = new LinkedList<>();
            backtrack(1, n, k, track, res);
            return res;
        }

        void backtrack(int start, int n, int k, LinkedList<Integer> track, List<List<Integer>> res) {
            // 终止条件
            if (track.size() == k) {
                res.add(new ArrayList<>(track));
                return;
            }
            for (int i = start; i <= n; i++) {
                track.add(i);
                backtrack(i + 1,n,k,track,res);
                track.removeLast();
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
