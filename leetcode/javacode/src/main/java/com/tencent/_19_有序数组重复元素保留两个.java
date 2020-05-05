package com.tencent;

public class _19_有序数组重复元素保留两个 {
    /**
     * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素最多出现两次，
     * 返回移除后数组的新长度。
     * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
     *
     * 给定 nums = [0,0,1,1,1,1,2,3,3],
     * 函数应返回新长度 length = 7, 并且原数组的前五个元素为 0, 0, 1, 1, 2, 3, 3 。
     * 你不需要考虑数组中超出新长度后面的元素。
     *
     * 给定 nums = [1,1,1,2,2,3],
     * 函数应返回新长度 length = 5, 并且原数组的前五个元素被修改为 1, 1, 2, 2, 3 。
     * 你不需要考虑数组中超出新长度后面的元素。
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] arr1 = {0,0,1,1,1,1,2,3,3};
        int[] arr2 = {1,1,1,2,2,3};

        //printNewArray(arr1);
        //printNewArray(arr2);
        System.out.println(removeDuplicateOption(arr1));
        System.out.println(removeDuplicateOption(arr2));

    }

    public static int removeDuplicateOption(int[] arr) {
        int i = 0;
        for (int num:arr) {
            if(i < 2 || num > arr[i - 2]) {
                arr[i++] = num;
            }
        }
        return i;
    }

    public static int removeDuplicate(int[] arr) {
        int flag = 1;
        int last = arr[0];
        int pos = 1;
        for (int i = 1; i < arr.length; i++) {
            flag = (arr[i] == last) ? flag +1 : 1;

            if(flag <= 2) {
                arr[pos++] = arr[i];
            }

            last = arr[i];
        }
        return pos;
    }

    public static void printNewArray(int[] arr) {
        int newLength = removeDuplicate(arr);
        System.out.println("newLength: " + newLength);
        for (int i = 0 ; i < newLength; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
