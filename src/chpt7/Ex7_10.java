package chpt7;

//Ex7_10.java
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
 
public class Ex7_10 {    
    public static void main(String args[]) {
        //排序
        List<Double> list = new ArrayList<Double>();
        double array[] = { 245,656,12,67,56,890 };
   
        for (int i = 0; i < array.length; i++) {
            list.add(new Double(array[i]));
        }
        Collections.sort(list);
        System.out.println("sorted number:");
        for (int i = 0; i < array.length; i++) {
            System.out.println(list.get(i));
        }
        //逆转
        Collections. reverse (list);
        System.out.println("reversed number:");
        for (int i = 0; i < array.length; i++) {
            System.out.println(list.get(i));
        }
        //查找最小值
        System.out.println("min number is: "+Collections.min(list));
        //查找最大值
        System.out.println("min number is: "+Collections.max(list));
    }
}