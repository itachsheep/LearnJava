package com.tao.javacode;

/**
 *
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.

 If the last word does not exist, return 0.

 Note: A word is defined as a character sequence consists of non-space characters only.

 Example:

 Input: "Hello World"
 Output: 5

 * Created by taowei on 2018/5/24.
 * 2018-05-24 20:31
 * leetcode
 * com.tao.javacode
 */

public class _58_length_of_last_word {
    public static void main(String[] args){
        System.out.println(lengthOfLastWord("Hello World"));
        System.out.println(lengthOfLastWord("Hello"));
    }

    public static int lengthOfLastWord(String s) {
        System.out.println("last index of  = "+s.trim().lastIndexOf(" "));
        return s.trim().length() - s.trim().lastIndexOf(" ");
    }
}
