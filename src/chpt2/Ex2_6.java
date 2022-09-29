package chpt2;
//arrays里的方法使用

import java.util.*;
public class Ex2_6 {
     public static void main(String[] args) {

         int[] a=new int[]{1,3,5,7};
         int[] a1=new int[]{1,3,5,7};
         System.out.println(Arrays.equals(a, a1));    //判断a和a1是否相等,输出true
 
        int[] b=Arrays.copyOf(a, 6);
        System.out.println(Arrays.equals(b, a1));  //输出false
        System.out.println(Arrays.toString(b));    //把数组转换成字符串输出
 
        Arrays.fill(b, 2,5,1);    //把第二个到第四个元素赋为1
        System.out.println(Arrays.toString(b));
 
        Arrays.sort(b);                //对b进行排序
        System.out.println(Arrays.toString(b));
 
        System.out.println(Arrays.binarySearch(b, 3)); //使用二分查找法查找3的位置
 }
}

