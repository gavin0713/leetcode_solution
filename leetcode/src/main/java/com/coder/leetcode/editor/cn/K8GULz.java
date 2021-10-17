//👍 0 👎 0

package com.coder.leetcode.editor.cn;

import com.coder.leetcode.editor.cn.basic.ListNode;

import java.util.*;

public class K8GULz {
    public static void main(String[] args) {
        Solution solution = new K8GULz().new Solution();

        System.out.println(Integer.MAX_VALUE);
        String test = "";
        solution.ringGame(new long[]{1,19,19,2,19,2,2,17,19,1});

//        solution.removeDuplicates("pbbcggttciiippooaais", 2);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        PriorityQueue<Integer> pq;
        boolean[] visited;

        public long ringGame(long[] challenge) {
            if (challenge.length == 1) return challenge[0];

            pq = new PriorityQueue<>(challenge.length, Comparator.comparingLong(i -> challenge[i]));
            visited = new boolean[challenge.length];
            long ans = Long.MAX_VALUE;
            for (int i = 0; i < challenge.length; i++) {
                Arrays.fill(visited, false);
                long min = getMinByStart(challenge, i);
                ans = Math.min(ans, min);
            }
            return ans;
        }

        private long getMinByStart(long[] challenge, int i) {
            pq.clear();
            long min = challenge[i];
            long cur = min;
            visited[i] = true;
            pq.offer(i);
            while (!pq.isEmpty()) {
                Integer idx = pq.poll();
                if (cur < challenge[idx]) {
                    min = getMin(min, cur, challenge[idx]);
                    //min = Math.max(min, min | ());
                    cur = min | cur | challenge[idx];
                }
                if (idx == 0) {
                    update(challenge.length - 1);
                    update(idx + 1);
                } else if (idx == challenge.length - 1) {
                    update(idx - 1);
                    update(0);
                } else {
                    update(idx - 1);
                    update(idx + 1);
                }
                cur |= challenge[idx];
            }

            return min;
        }

        private long getMin(long min, long cur, long target) {
            // 2 2 17  -> 16
            long remain = target - cur;
            for (long i = Math.max(min, remain); i <= target; i++) {
                if ((i | cur) >= target) {
                    return i;
                }
            }
            return min;
        }

        private void update(int idx) {
            if (!visited[idx]) {
                visited[idx] = true;
                pq.offer(idx);
            }
        }


//        public String removeDuplicates(String s, int k) {
//            // key num
//            ListNode<int[]> list = new LinkedList<>();
//            int len = 1;
//            for (int i = 1; i <= s.length(); i++) {
//                if (i == s.length() || s.charAt(i) != s.charAt(i - 1)) {
//                    list.add(new int[]{s.charAt(i - 1), len});
//                } else {
//                    len++;
//                }
//            }
//            ListIterator<int[]> listIterator = list.listIterator(0);
//
//            listIterator.previous()
//        }
}
//leetcode submit region end(Prohibit modification and deletion)

}