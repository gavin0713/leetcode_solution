//You are given a string s, and an array of pairs of indices in the string 
//pairs where pairs[i] = [a, b] indicates 2 indices(0-indexed) of the string. 
//
// You can swap the characters at any pair of indices in the given pairs any 
//number of times. 
//
// Return the lexicographically smallest string that s can be changed to after 
//using the swaps. 
//
// 
// Example 1: 
//
// 
//Input: s = "dcab", pairs = [[0,3],[1,2]]
//Output: "bacd"
//Explaination: 
//Swap s[0] and s[3], s = "bcad"
//Swap s[1] and s[2], s = "bacd"
// 
//
// Example 2: 
//
// 
//Input: s = "dcab", pairs = [[0,3],[1,2],[0,2]]
//Output: "abcd"
//Explaination: 
//Swap s[0] and s[3], s = "bcad"
//Swap s[0] and s[2], s = "acbd"
//Swap s[1] and s[2], s = "abcd" 
//
// Example 3: 
//
// 
//Input: s = "cba", pairs = [[0,1],[1,2]]
//Output: "abc"
//Explaination: 
//Swap s[0] and s[1], s = "bca"
//Swap s[1] and s[2], s = "bac"
//Swap s[0] and s[1], s = "abc"
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 10^5 
// 0 <= pairs.length <= 10^5 
// 0 <= pairs[i][0], pairs[i][1] < s.length 
// s only contains lower case English letters. 
// 
// Related Topics 深度优先搜索 广度优先搜索 并查集 哈希表 字符串 👍 239 👎 0

package com.coder.leetcode.editor.cn;

import java.util.Arrays;
import java.util.List;

public class Q1202_SmallestStringWithSwaps {
    public static void main(String[] args) {
        Solution solution = new Q1202_SmallestStringWithSwaps().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
            char[] cs = s.toCharArray();
            int n = cs.length;
            int[] parents = new int[n], rank = new int[n];
            for (int i = 0; i < n; i++) {
                parents[i] = i;
                rank[i] = 1;
            }
            for (List<Integer> pair : pairs) union(parents, rank, pair.get(0), pair.get(1));
            char[][] gs = new char[n][];
            int[] cnt = new int[n];
            int[] gIdx = new int[n];
            int gCnt = 0;
            for (int i = 0; i < n; i++) {
                int r = root(parents, i);
                if (gs[r] == null) {
                    gs[r] = new char[rank[r]];
                    gIdx[gCnt++] = r;
                }
                gs[r][cnt[r]++] = cs[i];
            }
            for (int i = 0; i < gCnt; i++) {
                Arrays.sort(gs[gIdx[i]]);
                cnt[gIdx[i]] = 0;
            }
            for (int i = 0; i < n; i++) {
                int r = parents[i];
                cs[i] = gs[r][cnt[r]++];
            }
            return new String(cs);
        }

        void union(int[] parents, int[] rank, int i, int j) {
            int x = root(parents, i), y = root(parents, j);
            if (x != y) {
                if (rank[x] < rank[y]) {
                    parents[x] = y;
                    rank[y] += rank[x];
                } else {
                    parents[y] = x;
                    rank[x] += rank[y];
                }
            }
        }

        int root(int[] parents, int i) {
            return parents[i] == i ? i : (parents[i] = root(parents, parents[i]));
        }
}
//leetcode submit region end(Prohibit modification and deletion)

}