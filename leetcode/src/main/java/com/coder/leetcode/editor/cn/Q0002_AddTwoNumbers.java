//You are given two non-empty linked lists representing two non-negative 
//integers. The digits are stored in reverse order, and each of their nodes contains a 
//single digit. Add the two numbers and return the sum as a linked list. 
//
// You may assume the two numbers do not contain any leading zero, except the 
//number 0 itself. 
//
// 
// Example 1: 
//
// 
//Input: l1 = [2,4,3], l2 = [5,6,4]
//Output: [7,0,8]
//Explanation: 342 + 465 = 807.
// 
//
// Example 2: 
//
// 
//Input: l1 = [0], l2 = [0]
//Output: [0]
// 
//
// Example 3: 
//
// 
//Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
//Output: [8,9,9,9,0,0,0,1]
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in each linked list is in the range [1, 100]. 
// 0 <= Node.val <= 9 
// It is guaranteed that the list represents a number that does not have 
//leading zeros. 
// 
// Related Topics 递归 链表 数学 👍 6909 👎 0

package com.coder.leetcode.editor.cn;

import com.coder.leetcode.editor.cn.basic.ListNode;

public class Q0002_AddTwoNumbers {
    public static void main(String[] args) {
        Solution solution = new Q0002_AddTwoNumbers().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode protect = new ListNode(0);
        ListNode cur = protect;
        int more = 0;
        while (l1 != null || l2 != null || more > 0) {
            int val = getVal(l1) + getVal(l2) + more;
            more = val / 10;
            val %= 10;
            cur.next = new ListNode(val);


            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
            cur = cur.next;
        }
        return protect.next;
    }

    private int getVal(ListNode l) {
        if (l == null) {
            return 0;
        }
        return l.val;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}