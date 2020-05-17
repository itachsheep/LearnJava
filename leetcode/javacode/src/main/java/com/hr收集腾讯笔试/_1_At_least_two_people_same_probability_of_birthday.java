package com.hr收集腾讯笔试;

public class _1_At_least_two_people_same_probability_of_birthday {
    /**
     * https://blog.csdn.net/u010278318/article/details/8850480
     * 把问题转换成“计算完全没有相同生日的概率A(n)”，
     * 再用1减去这个概率即可求出至少两个人生日相同的概率P(n)。
     *
     * 第1个人的生日是随意的，有365种可能，概率是365/365＝1；
     * 第2个人的生日不能与第1个人相同，只有365－1＝364种可能，概率是364/365；
     * 第3个人的生日不能与前面2人相同，只有365－2＝363种可能，概率是363/365；……；
     *
     * 第n个人的生日不能与前面n-1人相同，只有365－(n-1)＝365-n+1种可能，概率是(365-n+1)/365
     * A(n) = A(n-1) *  (365 -n + 1) / 365;
     * P(n) = 1 - A(n);
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(probabilityOfSameBirthday(5));
        System.out.println(probabilityOfSameBirthday(10));
        System.out.println(probabilityOfSameBirthday(15));
        System.out.println(probabilityOfSameBirthday(20));
        System.out.println(probabilityOfSameBirthday(25));
        System.out.println(probabilityOfSameBirthday(30));
        System.out.println(probabilityOfSameBirthday(35));
        System.out.println(probabilityOfSameBirthday(55));
    }

    public static float probabilityOfSameBirthday(int n) {
        return 1 - allDifferentBirthday(n);
    }

    public static float allDifferentBirthday(int n) {
        if(n < 0) {
            throw new IllegalArgumentException("n must be a Valid positive integer");
        }
        if(n == 1) {
            return 1;
        }
        return allDifferentBirthday(n -1) * (365 -n + 1) / 365;
    }
}
