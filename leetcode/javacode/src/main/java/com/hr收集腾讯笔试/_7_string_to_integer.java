package com.hr收集腾讯笔试;

public class _7_string_to_integer {
    public static void main(String[] args) {
        String test1 = "283947";
        String test2 = "   93240098";
        String test3 = "-2398401";
        String test4 = "233423490439480";
        String test5 = "-3424234234234";

        System.out.println(myAtoI(test1));
        System.out.println(myAtoI(test2));
        System.out.println(myAtoI(test3));
        //System.out.println(myAtoI(test4));
        System.out.println(myAtoI(test5));
    }

    public static int myAtoI(String number) {
        int multi = 1;
        int sum = 0;
        int temp = 0;

        if(number == null) {
            return 0;
        }

        for (int i = 0; i < number.length(); i++) {
            char c = number.charAt(i);
            if(c == '-') {
                multi = -1;
            }

            if(c >= '0' && c <= '9') {
                if(multi > 0) {
                    sum = sum * 10 + c - '0';
                    if(sum < 0) {
                        throw new IllegalArgumentException("the number is too large");
                    }

                } else {
                    sum = sum * 10 - (c - '0');
                    if(sum > 0) {
                        throw new IllegalArgumentException("the number is too small");
                    }
                }
            }

        }
        return sum;
    }
}
