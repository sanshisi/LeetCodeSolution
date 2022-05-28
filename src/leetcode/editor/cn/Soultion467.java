//把字符串 s 看作是 “abcdefghijklmnopqrstuvwxyz” 的无限环绕字符串，所以 s 看起来是这样的： 
//
// 
// "...zabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcd...." . 
// 
//
// 现在给定另一个字符串 p 。返回 s 中 唯一 的 p 的 非空子串 的数量 。 
//
// 
//
// 示例 1: 
//
// 
//输入: p = "a"
//输出: 1
//解释: 字符串 s 中只有一个"a"子字符。
// 
//
// 示例 2: 
//
// 
//输入: p = "cac"
//输出: 2
//解释: 字符串 s 中的字符串“cac”只有两个子串“a”、“c”。.
// 
//
// 示例 3: 
//
// 
//输入: p = "zab"
//输出: 6
//解释: 在字符串 s 中有六个子串“z”、“a”、“b”、“za”、“ab”、“zab”。
// 
//
// 
//
// 提示: 
//
// 
// 1 <= p.length <= 10⁵ 
// p 由小写英文字母构成 
// 
// Related Topics 字符串 动态规划 👍 248 👎 0

/**
 * @author sanshisi
 */

package leetcode.editor.cn;

public class Soultion467 {
    public static void main(String[] args) {
        Solution solution = new Soultion467().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findSubstringInWraproundString(String p) {
            char[] chs = p.toCharArray();
            int n = chs.length;
            int[] f = new int[26];
            f[chs[0] - 'a'] = 1;
            int len = 1;
            for (int i = 1; i < n; i++) {
                if ((chs[i] - 'a') == (chs[i - 1] - 'a' + 1) % 26) {
                    len++;
                } else {
                    len = 1;
                }
                // 记录相同的字母能组成的最长子串的长度
                f[chs[i] - 'a'] = Math.max(f[chs[i] - 'a'], len);
            }

            int ans = 0;
            for (int i : f) {
                ans += i;
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
