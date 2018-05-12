package com.tao.javacode;

/**
 *
 * You are given an n x n 2D matrix representing an image.

 Rotate the image by 90 degrees (clockwise).

 Note:

 You have to rotate the image in-place, which means you have to modify the input 2D matrix directly.
 DO NOT allocate another 2D matrix and do the rotation.

 Example 1:

 Given input matrix =
 [
 [1,2,3],
 [4,5,6],
 [7,8,9]
 ],

 rotate the input matrix in-place such that it becomes:
 [
 [7,4,1],
 [8,5,2],
 [9,6,3]
 ]
 Example 2:

 Given input matrix =
 [
 [ 5, 1, 9,11],
 [ 2, 4, 8,10],
 [13, 3, 6, 7],
 [15,14,12,16]
 ],

 rotate the input matrix in-place such that it becomes:
 [
 [15,13, 2, 5],
 [14, 3, 4, 1],
 [12, 6, 8, 9],
 [16, 7,10,11]
 ]
 * Created by SDT14324 on 2018/5/10.
 */

public class _48_rotate_image {
    public static void main(String[] args){
        int[][] org = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        print(org);
        rotate(org);
        System.out.println("----------------after rotate--------------------");
        print(org);
    }

    /**
     * The idea was firstly transpose the matrix and then flip it symmetrically. For instance,

     1  2  3
     4  5  6
     7  8  9
     after transpose, it will be swap(matrix[i][j], matrix[j][i])

     1  4  7
     2  5  8
     3  6  9
     Then flip the matrix horizontally. (swap(matrix[i][j], matrix[i][matrix.length-1-j])

     7  4  1
     8  5  2
     9  6  3
     *
     */

    public static void print(int[][] matrix){
        for (int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix.length; j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void rotate(int[][] matrix) {
        //沿着斜对角线置换
        for(int i = 0; i < matrix.length; i++){
            for (int j = i ; j < matrix[0].length; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        //置换后，沿着中轴线翻转，也就是交换
        for (int i = 0; i < matrix.length; i++){
            for (int j = 0 ; j < matrix.length / 2; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix.length - 1 -j];
                matrix[i][matrix.length - 1 -j] = temp;
            }
        }
    }

}
