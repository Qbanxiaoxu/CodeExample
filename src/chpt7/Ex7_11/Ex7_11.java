package chpt7.Ex7_11;
//Ex7_11.java
import java.util.*;
import java.lang.Comparable;

//Product实现Comparable比较器，本身支持排序
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
    //重写compareTo<T t>函数,对name进行比较
    public int compareTo(Product ipad) {
    	 return name.compareTo(ipad.name);
    }
}
//为Product创建一个升序比较器，根据ID升序排序
class AscComparator implements Comparator<Product> {
    public int compare(Product p1, Product p2) {
        return p1.getID() - p2.getID();
    }
}
//为Product创建一个降序比较器,根据ID降序排序
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
        
        // 对list进行排序,按照Product实现的CompareTo()进行排序
        Collections.sort(list);
        System.out.printf("Product ID sorted list:%s\n", list);
        
        // 通过比较器(Ascomparator)，对list进行排序
        Collections.sort(list, new AscComparator());
        System.out.printf("Asc ID sorted, list:%s\n", list);
        
        // 通过比较器DescComparator，对list进行排序
        Collections.sort(list, new DescComparator());
        System.out.printf("Desc ID sorted, list:%s\n", list);
    }
}
    