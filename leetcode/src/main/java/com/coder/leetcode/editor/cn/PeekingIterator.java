package com.coder.leetcode.editor.cn;

import com.coder.leetcode.editor.cn.basic.ListNode;
import com.coder.leetcode.editor.cn.basic.TreeNode;

import java.util.*;

/**
 * Created by kougavin on 11/10/2021.
 */
public class PeekingIterator implements Iterator<Integer>  {
    private Iterator<Integer> iterator;
    private Integer cur;
    private boolean hasPeek;
    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        this.iterator = iterator;
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        if (hasPeek) {
            return cur;
        }
        cur = this.iterator.next();
        hasPeek = true;
        return cur;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        if (hasPeek) {
            hasPeek = false;
            return cur;
        }
        return this.iterator.next();
    }

    @Override
    public boolean hasNext() {
        return hasPeek || this.iterator.hasNext();
    }

    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        if (s == null || s.length() == 0 || words == null || words.length == 0) return res;
        HashMap<String, Integer> map = new HashMap<>();
        int one_word = words[0].length();
        int word_num = words.length;
        for (String word : words) {
            map.merge(word, 1, Integer::sum);
        }
        for (int i = 0; i < one_word; i++) {
            int left = i, right = i, count = 0;
            HashMap<String, Integer> tmp_map = new HashMap<>();
            while (right + one_word <= s.length()) {
                String w = s.substring(right, right + one_word);
                right += one_word;
                if (!map.containsKey(w)) {
                    count = 0;
                    left = right;
                    tmp_map.clear();
                } else {
                    tmp_map.put(w, tmp_map.getOrDefault(w, 0) + 1);
                    count++;
                    while (tmp_map.getOrDefault(w, 0) > map.getOrDefault(w, 0)) {
                        String t_w = s.substring(left, left + one_word);
                        count--;
                        tmp_map.put(t_w, tmp_map.getOrDefault(t_w, 0) - 1);
                        left += one_word;
                    }
                    if (count == word_num) res.add(left);
                }
            }
        }
        return res;
    }


    public void nextPermutation(int[] nums) {
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i+1]) {
                for (int j = i+1; j < nums.length; j++) {
                    if (j == nums.length-1 || nums[j+1] < nums[i]) {
                        swap(nums, i, j);
                        reverse(nums, i+1);
                        return;
                    }
                }
            }
        }
        reverse(nums, 0);
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    private void reverse(int[] nums, int start) {
        for (int i = start; i < (nums.length + start) / 2; i++) {
            swap(nums, i, nums.length -1 - i + start);
        }
    }


    public ListNode removeNthFromEnd(ListNode head, int n) {
        int i = 1;
        ListNode pretect = new ListNode(0, head);
        ListNode mark = null;
        while(head != null) {
            head = head.next;
            if (mark != null) mark = mark.next;
            if (i++ == n) mark = pretect;
        }
        mark.next = mark.next.next;
        return pretect.next;
    }


    public String countAndSay(int n) {
        return countAndSay("1", n - 1);
    }

    public String countAndSay(String n, int level) {
        if (level == 0) return n;
        int num = 1;
        StringBuilder ans = new StringBuilder();
        for (int i = 1; i <= n.length(); i++) {
            if (i == n.length() || n.charAt(i-1) != n.charAt(i)) {
                ans.append(num).append(n.charAt(i - 1));
                num = 1;
            } else {
                num++;
            }
        }
        return countAndSay(ans.toString(), level - 1);
    }


    public String multiply(String num1, String num2) {
        int[] nums1 = getNums(num1);
        int[] nums2 = getNums(num2);
        int[] ans = new int[nums1.length + nums2.length];
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                int mul = nums1[nums1.length - 1 - i] * nums2[nums2.length - 1 - j];
                for (int k = i + j; mul > 0;k++) {
                    int v = mul % 10 + ans[ans.length - 1 - k];
                    mul = mul / 10 + v / 10;
                    ans[ans.length - 1 - k] = v % 10;
                }
            }
        }
        return toString(ans);
    }

    private String toString(int[] nums) {
        StringBuilder sb = new StringBuilder();
        boolean start = false;
        for (int num : nums) {
            if (start || num > 0) {
                start = true;
                sb.append(num);
            }
        }


        return sb.toString();
    }


    private int[] getNums (String num) {
        int[] nums = new int[num.length()];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = num.charAt(i) - '0';
        }
        return nums;
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        return (p == q)
                || (p.val == q.val
                && isSameTree(p.left, q.left) && isSameTree(p.right, q.right));
    }

    public static void main(String[] args) {
        PeekingIterator peekingIterator = new PeekingIterator(null);

        peekingIterator.nextPermutation(new int[]{1,5,1});
        ListNode head = new ListNode(1);
//        head.next = new ListNode(2);
//        head.next.next = new ListNode(3);
        peekingIterator.removeNthFromEnd(head, 1);


        peekingIterator.countAndSay(4);

        peekingIterator.multiply("0","0");

        peekingIterator.isSameTree(null, null);
    }
}
