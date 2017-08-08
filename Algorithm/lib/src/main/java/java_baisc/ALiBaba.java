package java_baisc;

/**
 * Created by taow on 2017/8/8.
 */

public class ALiBaba {
    public static void main(String[] args){
        int i=0;
        Integer j = new Integer(0);
        System.out.println(i==j);
        String a = "11";
        String b = new String("11");
        System.out.println(a.equals(b));
        System.out.println(j.equals(i));

        /*String str=new String("hello");
        char[]ch={'a','b'};

        change(str,ch);
        System.out.print(str+" and ");
        System.out.print(ch);*/

        /*((ALiBaba)null).testMethod();*/
    }

    public static void change(String str,char ch[]){
        str="test ok";
        ch[0]='c';
    }

    private static void testMethod(){
        System.out.println("testMethod");
    }
}
