//You are given two non-empty linked lists representing two non-negative 
//integers. The most significant digit comes first and each of their nodes contains a 
//single digit. Add the two numbers and return the sum as a linked list. 
//
// You may assume the two numbers do not contain any leading zero, except the 
//number 0 itself. 
//
// 
// Example 1: 
//
// 
//Input: l1 = [7,2,4,3], l2 = [5,6,4]
//Output: [7,8,0,7]
// 
//
// Example 2: 
//
// 
//Input: l1 = [2,4,3], l2 = [5,6,4]
//Output: [8,0,7]
// 
//
// Example 3: 
//
// 
//Input: l1 = [0], l2 = [0]
//Output: [0]
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
//
// 
// Follow up: Could you solve it without reversing the input lists? 
// Related Topics 栈 链表 数学 👍 436 👎 0

package com.coder.leetcode.editor.cn;

import com.coder.leetcode.editor.cn.basic.ListNode;

import java.util.Stack;

public class Q0445_AddTwoNumbersIi {
    public static void main(String[] args) {
        Solution solution = new Q0445_AddTwoNumbersIi().new Solution();
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
        Stack<Integer> stack1 = getStackFromList(l1);
        Stack<Integer> stack2 = getStackFromList(l2);
        ListNode ans = null;
        int more = 0;
        while(!stack1.isEmpty() || !stack2.isEmpty() || more > 0) {
            int val = pop(stack1) + pop(stack2) + more;
            more = val / 10;
            val %= 10;
            ans = new ListNode(val, ans);
        }
        return ans;
    }

    private Stack<Integer> getStackFromList(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        while(head != null) {
            stack.push(head.val);
            head = head.next;
        }
        return stack;
    }

    private int pop(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return 0;
        }
        return stack.pop();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}