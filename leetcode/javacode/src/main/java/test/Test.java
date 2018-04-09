package test;

/**
 * Created by SDT14324 on 2018/4/9.
 */

public class Test {
    public static void main(String[] args){
        /*Calendar mCalendar = Calendar.getInstance(TimeZone.getDefault());
        mCalendar.setTimeInMillis(System.currentTimeMillis());
        SimpleDateFormat sdf = new SimpleDateFormat("MM.dd.EE");
        String format = sdf.format(mCalendar.getTime());
        System.out.println("format = "+format);

        String[] split = format.split("\\.");
        System.out.println("split = "+split.length);*/

        String temp = "左温区温度调到18度";
        System.out.println(temp.substring(7));
        System.out.println(temp.substring(7,temp.length()-1));

    }}
