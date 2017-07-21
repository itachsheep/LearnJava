package structe_data;

/**
 * Created by taow on 2017/7/20.
 */

public class Recursion_3_combination {
    public static void main(String[] args){
    /**
     1. 所有元素的全排列: ab的全排列是ab, ba(顺序相关);
     2. 所有元素的全组合: ab的全组合是a, b, ab(顺序无关);
     3. 求n个元素中选取m个元素的组合方式有哪些: abc中选2个元素的组合是ab, ac, bc;
     4. 求n个元素中选取m个元素的排列方式有哪些: abc中选2个元素的排列是ab, ba, ac, ca, bc, cb;
     */
        char[] arr = {'1','2','3','4'};
        combination(arr);
    }
    /** 数组元素的全组合 */
    private static void combination(char[] buf){
        char[] subuf = new char[buf.length];//存储子组合数据的数组
        for(int i = 0; i < buf.length; i++){
            int m = i+1;
            combinat_sub_nums(buf,buf.length,m,subuf,m);
        }
    }



    /**
     * n个元素选m个元素的组合问题的实现. 原理如下:
     *  从后往前选取, 选定位置i后, 再在前i-1个里面选取m-1个.
     *  如: 1, 2, 3, 4, 5 中选取3个元素.
     *  1) 选取5后, 再在前4个里面选取2个, 而前4个里面选取2个又是一个子问题, 递归即可;
     *  2) 如果不包含5, 直接选定4, 那么再在前3个里面选取2个, 而前三个里面选取2个又是一个子问题, 递归即可;
     *  3) 如果也不包含4, 直接选取3, 那么再在前2个里面选取2个, 刚好只有两个.
     *  纵向看, 1与2与3刚好是一个for循环, 初值为5, 终值为m.
     *  横向看, 该问题为一个前i-1个中选m-1的递归.
     *
     * @param buf
     *  原始字符串
     * @param length
     * 原始字符串长度
     * @param mElements
     * 组合字符串的个数，可能为 1,2,3....
     * @param subuf
     * 组合字符串的容器，定义长度为原始长度
     * @param lenElements
     * 组合字符串实际长度
     */
    private static void combinat_sub_nums(char[] buf, int length, int mElements, char[] subuf,
                                          int lenElements) {
        if(mElements == 0){//出口，所有元素都选好了
            Utils.printArr(subuf,0,lenElements-1);
        }else {
            for(int i = length; i >= mElements ; --i){//从后往前依次选定一个
                subuf[mElements -1] = buf[i -1];
                combinat_sub_nums(buf,i-1,mElements-1,subuf,lenElements);
            }
        }

    }
}
