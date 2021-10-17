//An integer array is called arithmetic if it consists of at least three 
//elements and if the difference between any two consecutive elements is the same. 
//
// 
// For example, [1,3,5,7,9], [7,7,7,7], and [3,-1,-5,-9] are arithmetic 
//sequences. 
// 
//
// Given an integer array nums, return the number of arithmetic subarrays of 
//nums. 
//
// A subarray is a contiguous subsequence of the array. 
//
// 
// Example 1: 
//
// 
//Input: nums = [1,2,3,4]
//Output: 3
//Explanation: We have 3 arithmetic slices in nums: [1, 2, 3], [2, 3, 4] and [1,
//2,3,4] itself.
// 
//
// Example 2: 
//
// 
//Input: nums = [1]
//Output: 0
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 5000 
// -1000 <= nums[i] <= 1000 
// 
// Related Topics 数组 动态规划 👍 362 👎 0

package com.coder.leetcode.editor.cn;

import com.coder.leetcode.editor.cn.basic.ListNode;

import java.util.*;
import java.util.stream.Collectors;

public class ArithmeticSlices {
    public static void main(String[] args) {
        Solution solution = new ArithmeticSlices().new Solution();


        solution.numberOfArithmeticSlices(new int[]{1,2,3,4,5,6});


        int first = solution.first(2);

        solution.next(12);

        solution.combine(4, 2);

    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        Map<Long, Integer>[] maps = new HashMap[nums.length];
        for (int i = 0; i < maps.length; i++) {
            maps[i] = new HashMap<>();
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                long diff = (long) nums[j] - nums[i];
                maps[j].merge(diff, maps[i].getOrDefault(diff, 0) + 1, Integer::sum);
            }
        }

        int ans = 0;
        for (Map<Long, Integer> map : maps) {
            ans += map.values().stream().mapToInt(x -> x).sum();
        }

        Random random = new Random();



        return ans - nums.length * (nums.length-1) /2;
    }


    public int minEatingSpeed(int[] piles, int h) {
        int lo = 1, hi = Arrays.stream(piles).max().getAsInt();
        while (lo < hi) {
            int mid = lo + hi >> 1;
            if (check(piles, h, mid)) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }

        int[][] intervals;



        List<int[]> rst = new ArrayList<>();
        int[][] ans = new int[rst.size()][];
        rst.toArray(ans);




        return lo;
    }

        public int[] relativeSortArray(int[] arr1, int[] arr2) {
            int[] flag = new int[1000 + 1];

            for (int i = 0; i < flag.length; i++) {
                flag[i] = 1001 + i;
            }
            for (int i = 0; i < arr2.length; i++) {
                flag[arr2[i]] = i;
            }

            List<Integer> collect = Arrays.stream(arr1).mapToObj(x -> (Integer) x).sorted(Comparator.comparingInt(x -> flag[x])).collect(Collectors.toList());

            for (int i = 0; i < collect.size(); i++) {
                arr1[i] = collect.get(i);
            }
            return arr1;
        }

    private boolean check(int[] piles, int h, int k) {
        return Arrays.stream(piles).map(pile -> pile / k + ((pile % k) > 0 ? 1 : 0)).sum() <= h;
    }

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(k);
        for (int num : nums) {
            if (pq.size() == k) {
                if (num > pq.peek()) {
                    pq.poll();
                    pq.offer(num);
                }
            } else {
                pq.offer(num);
            }
        }
        return pq.peek();
    }


    public ListNode sortList(ListNode head) {
        List<Integer> list = new ArrayList<>();
        ListNode h = head;
        while (h != null) {
            list.add(h.val);
            h = h.next;
        }
        list.sort(Comparator.comparingInt(x -> x));
        h = head;
        for (int l : list) {
            h.val = l;
            h = h.next;
        }
        return head;
    }


    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>(Comparator.comparingInt(list -> list.val));
        for (ListNode list : lists) {

            pq.offer(list);
        }
        ListNode pretect = new ListNode(0);
        ListNode cur = pretect;
        while (!pq.isEmpty()) {
            ListNode poll = pq.poll();
            cur.next = poll;

            cur = cur.next;
            poll = poll.next;
            if (poll != null) {
                pq.offer(poll);
            }
        }
        return pretect.next;
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> rst = new ArrayList<>();
        for (int i = 0; i < (1 << nums.length); i++) {
            rst.add(getSubset(nums, i));
        }
        return rst;
    }

    private List<Integer> getSubset(int[] nums, int n) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 0, mark = 1; i < nums.length; i++, mark <<= 1) {
            if ((n & mark) > 0) {
                ans.add(nums[i]);
            }
        }
        return ans;
    }


    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = first(k); i < (1 << n); i = next(i)) {
            ans.add(getSubset(n, i));
        }
        return ans;
    }

    private List<Integer> getSubset(int n, int k) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 1, mark = 1; i <= n; i++, mark <<= 1) {
            if ((k & mark) > 0) {
                ans.add(i);
            }
        }
        return ans;
    }

    private int first(int k) {
        int ans = 0;
        for (int i = 0, mark = 1; i < k; i++, mark <<= 1) {
            ans += mark;
        }
        return ans;
    }


    private int next(int n) {
        int k = 0;
        for (int mark = 1; mark <= n; mark <<= 1) {
            if ((n & mark) > 0 ) {
                if ((n & (mark << 1)) == 0) {
                    n += mark + first(k);
                    return n;
                }
                k++;
                n -= mark;
            }
        }
        // 不会执行到这
        return n;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}