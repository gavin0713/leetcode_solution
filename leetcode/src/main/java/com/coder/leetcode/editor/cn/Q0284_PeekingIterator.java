//Design an iterator that supports the peek operation on a list in addition to 
//the hasNext and the next operations. 
//
// Implement the PeekingIterator class: 
//
// 
// PeekingIterator(int[] nums) Initializes the object with the given integer 
//array nums. 
// int next() Returns the next element in the array and moves the pointer to 
//the next element. 
// bool hasNext() Returns true if there are still elements in the array. 
// int peek() Returns the next element in the array without moving the pointer. 
//
// 
//
// 
// Example 1: 
//
// 
//Input
//["PeekingIterator", "next", "peek", "next", "next", "hasNext"]
//[[[1, 2, 3]], [], [], [], [], []]
//Output
//[null, 1, 2, 2, 3, false]
//
//Explanation
//PeekingIterator peekingIterator = new PeekingIterator([1, 2, 3]); // [1,2,3]
//peekingIterator.next();    // return 1, the pointer moves to the next element 
//[1,2,3].
//peekingIterator.peek();    // return 2, the pointer does not move [1,2,3].
//peekingIterator.next();    // return 2, the pointer moves to the next element 
//[1,2,3]
//peekingIterator.next();    // return 3, the pointer moves to the next element 
//[1,2,3]
//peekingIterator.hasNext(); // return False
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 1000 
// 1 <= nums[i] <= 1000 
// All the calls to next and peek are valid. 
// At most 1000 calls will be made to next, hasNext, and peek. 
// 
//
// 
//Follow up: How would you extend your design to be generic and work with all 
//types, not just integer? Related Topics 设计 数组 迭代器 👍 140 👎 0

package com.coder.leetcode.editor.cn;

import java.util.Iterator;

public class Q0284_PeekingIterator {
    public static void main(String[] args) {
        //Solution solution = new Q0284_PeekingIterator().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html

class PeekingIterator implements Iterator<Integer> {
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
}
//leetcode submit region end(Prohibit modification and deletion)

}