package com.tao.javacode_part2;

/**
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

 Integers in each row are sorted from left to right.
 The first integer of each row is greater than the last integer of the previous row.
 Example 1:

 Input:
 matrix = [
 [1,   3,  5,  7],
 [10, 11, 16, 20],
 [23, 30, 34, 50]
 ]
 target = 3
 Output: true
 Example 2:

 Input:
 matrix = [
 [1,   3,  5,  7],
 [10, 11, 16, 20],
 [23, 30, 34, 50]
 ]
 target = 13
 Output: false
 */
public class _74_search_2d_matrix {
    public static void main(String[] args){

    }

    /**
     * The basic idea is from right corner, if the current number greater than target col - 1 in same row,
     * else if the current number less than target,
     * row + 1 in same column, finally if they are same, we find it, and return return.
     * 基本思想是：target同矩阵右上角元素比较，若target比右上角元素大，则row+1
     * 否则，col-1
     */
    public static boolean searchMatrix(int[][] matrix, int target) {
        int row = 0, col = matrix[0].length -1;
        while (row < matrix.length && col >= 0){
            if(matrix[row][col] == target){
                return true;
            }else if(matrix[row][col] < target){
                row++;
            }else {
                col--;
            }
        }
        return false;
    }
}
