package com.tao.javacode;

/**
 * Created by SDT14324 on 2018/2/13.
 */

/**
 * Determine whether an integer is a palindrome. Do this without extra space.

 click to show spoilers.

 Some hints:
 Could negative integers be palindromes? (ie, -1)

 If you are thinking of converting the integer to string, note the restriction of using extra space.

 You could also try reversing an integer. However, if you have solved the problem "Reverse Integer",
 you know that the reversed integer might overflow. How would you handle such case?

 There is a more generic way of solving this problem.
 */
public class _9_plaindrome_number {
    public static void main(String[] args){
        System.out.println(isPalindrome(12321));
        System.out.println(isPalindrome(1441));
        System.out.println(isPalindrome(1243545343));
    }
    public static boolean isPalindrome(int x) {
        if(x < 0){
            return false;
        }
        if(x % 10 == 0 && x != 0){
            return false;
        }

        int half = 0;
        while (x > half){
            int mod = x % 10;
            half = half * 10 + mod;
            x = x / 10;
        }

        return x == half || x == half / 10;
    }
}
