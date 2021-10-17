//The DNA sequence is composed of a series of nucleotides abbreviated as 'A', 
//'C', 'G', and 'T'. 
//
// 
// For example, "ACGAATTCCG" is a DNA sequence. 
// 
//
// When studying DNA, it is useful to identify repeated sequences within the 
//DNA. 
//
// Given a string s that represents a DNA sequence, return all the 10-letter-
//long sequences (substrings) that occur more than once in a DNA molecule. You may 
//return the answer in any order. 
//
// 
// Example 1: 
// Input: s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
//Output: ["AAAAACCCCC","CCCCCAAAAA"]
// Example 2: 
// Input: s = "AAAAAAAAAAAAA"
//Output: ["AAAAAAAAAA"]
// 
// 
// Constraints: 
//
// 
// 1 <= s.length <= 10⁵ 
// s[i] is either 'A', 'C', 'G', or 'T'. 
// 
// Related Topics 位运算 哈希表 字符串 滑动窗口 哈希函数 滚动哈希 👍 283 👎 0

package com.coder.leetcode.editor.cn;

import java.util.*;
import java.util.stream.Collectors;

public class RepeatedDnaSequences {
    public static void main(String[] args) {
        Solution solution = new RepeatedDnaSequences().new Solution();

        solution.findRepeatedDnaSequences("AAAAAAAAAAA");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        class SubStr{
            char[] chs;
            int idx;
            int len;

            private int hash; // Default to 0

            public SubStr(char[] chs, int idx, int len) {
                this.chs = chs;
                this.idx = idx;
                this.len = len;
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                SubStr subStr = (SubStr) o;
                if (len != subStr.len) return false;
                for (int i = 0; i < len; i++) {
                    if (subStr.chs[i+ subStr.idx] != chs[i+idx]) {
                        return false;
                    }
                }
                return true;
            }

            @Override
            public int hashCode() {

                int h = hash;
                if (h == 0 && len > 0) {
                    char val[] = chs;

                    for (int i = 0; i < len; i++) {
                        h = 31 * h + val[i+idx];
                    }
                    hash = h;
                }
                return h;
            }
        }
    public List<String> findRepeatedDnaSequences(String s) {
        char[] chs = s.toCharArray();
        Map<SubStr, Integer> map = new HashMap<>();
        for (int i = 0; i + 10 < s.length(); i++) {
            map.merge(new SubStr(chs, i, 10),1, Integer::sum);
        }
        List<String> ans = new ArrayList<>();
        map.forEach((k, v)-> {
            if (v > 1) {
                ans.add(s.substring(k.idx, k.idx+k.len));
            }
        });
        return ans;
    }

        public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
            Set<Integer> set1 = initSet(nums1);
            Set<Integer> set2 = initSet(nums2);
            Set<Integer> set3 = initSet(nums3);
            Set<Integer> ans = new HashSet<>();

            ans.addAll(comSet(set1, set2));
            ans.addAll(comSet(set2, set3));
            ans.addAll(comSet(set3, set1));

            return new ArrayList<>(ans);
        }

        private List<Integer> comSet(Set<Integer> set1, Set<Integer> set2) {
            List<Integer> ans = new ArrayList<>();
            for (Integer s : set1) {
                if (set2.contains(s)) {
                    ans.add(s);
                }
            }
            return ans;
        }

        private Set<Integer> initSet(int[] nums) {
            Set<Integer> set = new HashSet<>();
            for (int num : nums) {
                set.add(num);
            }
            return set;
        }


        public int minOperations(int[][] grid, int x) {
            int m = grid.length;
            int n = grid[0].length;
            int[] arr = new int[m * n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    arr[i*n +j] = grid[i][j];
                }
            }
            Arrays.sort(arr);
            for (int i = 1; i < arr.length; i++) {
                arr[i] -= arr[0];
                if (arr[i] % x != 0) {
                    return -1;
                }
                arr[i] /= x;
            }
            arr[0] = 0;
            int[] sum = new int[arr.length];
            for (int i = 1; i < arr.length; i++) {
                sum[i] = sum[i-1] + arr[i];
            }
            int ans = Math.max(sum[0], sum[arr.length-1] - sum[0]);
            for (int i = 1; i < arr.length; i++) {
                int max = Math.max(arr[i] * (i) -(sum[i-1]-sum[0]), (sum[arr.length - 1] -sum[i])-(n-i-1));
                ans = Math.min(ans, max);
            }
            return ans;
        }
}
//leetcode submit region end(Prohibit modification and deletion)

}