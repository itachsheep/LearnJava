package structe_data.forth_stack_and_queue;

/**
 * Created by taowei on 2017/7/18.
 * 2017-07-18 16:45
 * Algorithm
 * structe_data
 */

public class Stack_1_CharReverse {
    public static void main(String[] args){
        String s1 = "22222_1_3333";
        int n = s1.length();
        StackX stackX = new StackX(100);
        for(int i = 0; i < n; i++){
            stackX.push(s1.charAt(i));
        }

        while(!stackX.isEmpty()){
            System.out.print(stackX.pop());
        }
        System.out.println();

    }
}
