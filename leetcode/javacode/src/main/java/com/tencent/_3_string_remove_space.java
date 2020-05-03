package com.tencent;

public class _3_string_remove_space {
    public static void main(String[] args) {
        String test1 = "ss ddd sss aa";
        System.out.println(removeSpaceOfString(test1));
    }

    /**
     * 字符串去空格
     * @param source
     * @return
     */
    public static String removeSpaceOfString(String source) {
        if(source == null) {
            return "";
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < source.length(); i++) {
            char c = source.charAt(i);
            if(c != ' ') {
                builder.append(c);
            }
        }
        return builder.toString();
    }
}
