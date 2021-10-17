//According to Wikipedia's article: "The Game of Life, also known simply as 
//Life, is a cellular automaton devised by the British mathematician John Horton 
//Conway in 1970." 
//
// The board is made up of an m x n grid of cells, where each cell has an 
//initial state: live (represented by a 1) or dead (represented by a 0). Each cell 
//interacts with its eight neighbors (horizontal, vertical, diagonal) using the 
//following four rules (taken from the above Wikipedia article): 
//
// 
// Any live cell with fewer than two live neighbors dies as if caused by under-
//population. 
// Any live cell with two or three live neighbors lives on to the next 
//generation. 
// Any live cell with more than three live neighbors dies, as if by over-
//population. 
// Any dead cell with exactly three live neighbors becomes a live cell, as if 
//by reproduction. 
// 
//
// The next state is created by applying the above rules simultaneously to 
//every cell in the current state, where births and deaths occur simultaneously. Given 
//the current state of the m x n grid board, return the next state. 
//
// 
// Example 1: 
//
// 
//Input: board = [[0,1,0],[0,0,1],[1,1,1],[0,0,0]]
//Output: [[0,0,0],[1,0,1],[0,1,1],[0,1,0]]
// 
//
// Example 2: 
//
// 
//Input: board = [[1,1],[1,0]]
//Output: [[1,1],[1,1]]
// 
//
// 
// Constraints: 
//
// 
// m == board.length 
// n == board[i].length 
// 1 <= m, n <= 25 
// board[i][j] is 0 or 1. 
// 
//
// 
// Follow up: 
//
// 
// Could you solve it in-place? Remember that the board needs to be updated 
//simultaneously: You cannot update some cells first and then use their updated 
//values to update other cells. 
// In this question, we represent the board using a 2D array. In principle, the 
//board is infinite, which would cause problems when the active area encroaches 
//upon the border of the array (i.e., live cells reach the border). How would you 
//address these problems? 
// 
// Related Topics 数组 矩阵 模拟 👍 375 👎 0

package com.coder.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class Q0289_GameOfLife {
    public static void main(String[] args) {
        Solution solution = new Q0289_GameOfLife().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        public void gameOfLife(int[][] board) {
            List<int[]> changePoints = new ArrayList<>();
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    int num = lifeNum(board, i, j);

                    if (board[i][j] == 0) {
                        if (num == 3) {
                            changePoints.add(new int[]{i, j});
                        }

                    } else {
                        num--;
                        if (num < 2 || num >3) {
                            changePoints.add(new int[]{i, j});
                        }
                    }
                }
            }


            for (int[] p : changePoints) {
                board[p[0]][p[1]] ^= 1;
            }
        }

        private int lifeNum(int[][] board, int i, int j) {

            int ans = lifeNum(board[i], j);
            if (i > 0) {
                ans += lifeNum(board[i-1], j);
            }

            if (i < board.length -1) {
                ans += lifeNum(board[i+1], j);
            }
            return ans;
        }

        private int lifeNum(int[] boardi, int j) {
            int ans = boardi[j];
            if (j > 0) {
                ans += boardi[j-1];
            }

            if (j < boardi.length - 1) {
                ans += boardi[j+1];
            }
            return ans;
        }
}
//leetcode submit region end(Prohibit modification and deletion)

}