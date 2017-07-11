package com.example;

public class Huiwen {
    public static void main(String[] args){
    String s1 = "A man, a plan, a canal: Panama";
    String s2 = "Race a car";
    System.out.println("s1 ----- "+isHuiWen(s1));
    System.out.println("s2 ----- "+isHuiWen(s2));
    }

    public static boolean isHuiWen(String s){
        s = saveCharacterAndDigital(s);
        for(int i = 0; i < s.length()/2; i++){
            char c_start = s.charAt(i);
            char c_end = s.charAt(s.length()-1-i);
            if(c_start != c_end){
                System.out.println(" ------- "+c_start+", ------------"+c_end);
                return false;
            }
        }
        return true;
    }

    private static String saveCharacterAndDigital(String s) {
        StringBuffer sb = new StringBuffer();
        for(int i = 0 ; i < s.length(); i++){
            char c = s.charAt(i);
            if((c >= 'a' && c <= 'z')){
                sb.append(c);
            }else if(c >= 'A' && c <= 'Z'){

                c = (char) (c + 'a' - 'A');
                sb.append(c);
            }
        }
        System.out.println("sb ------- "+sb);
        return sb.toString();
    }

}
