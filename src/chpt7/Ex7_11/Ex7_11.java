package chpt7.Ex7_11;
//Ex7_11.java
import java.util.*;
import java.lang.Comparable;

//Productʵ��Comparable�Ƚ���������֧������
class Product implements Comparable<Product>{
    int ID;
    String name;
    public Product(String name, int id) {
        this.name = name;
        this.ID = id;
    }
    public String getName() {
        return name;
    }
    public int getID() {
        return ID;
    }
    public String toString() {
        return name + " - " +ID;
    }  
    //��дcompareTo<T t>����,��name���бȽ�
    public int compareTo(Product ipad) {
    	 return name.compareTo(ipad.name);
    }
}
//ΪProduct����һ������Ƚ���������ID��������
class AscComparator implements Comparator<Product> {
    public int compare(Product p1, Product p2) {
        return p1.getID() - p2.getID();
    }
}
//ΪProduct����һ������Ƚ���,����ID��������
class DescComparator implements Comparator<Product> {
    public int compare(Product p1, Product p2) {
        return p2.getID() - p1.getID();
    }
}

public class Ex7_11{
    public static void main(String[] args) {
        ArrayList<Product> list = new ArrayList<Product>();
        list.add(new Product("dphone", 12));
        list.add(new Product("cphone", 587));
        list.add(new Product("Bphone",34));
        list.add(new Product("Aphone", 108));
        System.out.printf("Original  sort, list:%s\n", list);
        
        // ��list��������,����Productʵ�ֵ�CompareTo()��������
        Collections.sort(list);
        System.out.printf("Product ID sorted list:%s\n", list);
        
        // ͨ���Ƚ���(Ascomparator)����list��������
        Collections.sort(list, new AscComparator());
        System.out.printf("Asc ID sorted, list:%s\n", list);
        
        // ͨ���Ƚ���DescComparator����list��������
        Collections.sort(list, new DescComparator());
        System.out.printf("Desc ID sorted, list:%s\n", list);
    }
}
    