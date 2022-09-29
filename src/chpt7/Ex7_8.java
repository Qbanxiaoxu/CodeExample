package chpt7;

//Ex7_6.java
import java.util.*;

public class Ex7_8 {
    public static void main(String[] args) {    	
    	//过滤重复元素，但不保证元素的迭代次序
    	String[] strArray = new  String[]{"one", "world ",  "one",  "dream"};     
        Set<String> s = new HashSet<String>();       
        for (int i=0; i<4; i++)
            if (!s.add(strArray[i])) //添加strArray元素到集合s中
                System.out.println("Duplicate detected: " + strArray[i]);
        System.out.println(s.size() + " distinct words: " + s); 
        
       //自动按升序排列内容 并过滤掉重复元素 
        TreeSet<String> treeset=new TreeSet<String>();
        treeset.add("b");  
        treeset.add("a");  
        treeset.add("c");  
        treeset.add("d"); 
        treeset.add("b");
        System.out.println("TreeSet:");  
        System.out.println(treeset);  
        System.out.println("the first element is: "+treeset.first());//返回第一个元素  
        Iterator<String> iterator=treeset.iterator();  
        while(iterator.hasNext()){  
         System.out.print(iterator.next()+";");  
        } 
         
        //过滤重复元素，保证元素的迭代次序
        LinkedHashSet<String> hashset=new LinkedHashSet<String>();    
        hashset.add("b");  
        hashset.add("a");  
        hashset.add("c");  
        hashset.add("d");  
        hashset.add("b");  
        System.out.println("\n"+"LinkedHashSet:");  
        System.out.println(hashset);  
        Iterator<String> iterator1=hashset.iterator();//取出元素  
        while(iterator1.hasNext()){  
          System.out.print(iterator1.next()+";");  
        }  
    }
}
