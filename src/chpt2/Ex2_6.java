package chpt2;
//arrays��ķ���ʹ��

import java.util.*;
public class Ex2_6 {
     public static void main(String[] args) {

         int[] a=new int[]{1,3,5,7};
         int[] a1=new int[]{1,3,5,7};
         System.out.println(Arrays.equals(a, a1));    //�ж�a��a1�Ƿ����,���true
 
        int[] b=Arrays.copyOf(a, 6);
        System.out.println(Arrays.equals(b, a1));  //���false
        System.out.println(Arrays.toString(b));    //������ת�����ַ������
 
        Arrays.fill(b, 2,5,1);    //�ѵڶ��������ĸ�Ԫ�ظ�Ϊ1
        System.out.println(Arrays.toString(b));
 
        Arrays.sort(b);                //��b��������
        System.out.println(Arrays.toString(b));
 
        System.out.println(Arrays.binarySearch(b, 3)); //ʹ�ö��ֲ��ҷ�����3��λ��
 }
}

