package java_baisc;

/**
 * Created by taow on 2017/8/8.
 */

public class ALiBaba {
    public static void main(String[] args){
        /*int i=0;
        Integer j = new Integer(0);

        String a = "11";
        String b = new String("11");

        People p = new People("1",1);
        People q = new People("2",2);

        System.out.println(i==j);
        System.out.println(j.equals(i));
        System.out.println(a.equals(b));
        System.out.println(p == q);
        System.out.print(p.equals(q));*/

        /**
         * java传递参数都是值，如果是对象的话，就是将引用的值复制一份给方法当参数。如果是根据引用把堆里的对象修改了，
         * 那么对象真被修改了，不过不是被创建赋值给的那个引用修改的，是方法里的一个复制的引用副本给修改的。
         */
        /*String str=new String("hello");
        char[]ch={'a','b'};
        People p = new People("taowei",25);

        change(str,ch,p);
        System.out.print(str+" and ");
        System.out.print(ch);
        System.out.println(", "+p.a);*/

        /*((ALiBaba)null).testMethod();*/


    }

    public static void change(String str,char ch[],People p){
        str="test ok";
        p.a = "android";
        ch[0]='c';
    }

    private static void testMethod(){
        System.out.println("testMethod");
    }

}
