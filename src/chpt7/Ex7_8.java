package chpt7;

//Ex7_6.java
import java.util.*;

public class Ex7_8 {
    public static void main(String[] args) {    	
    	//�����ظ�Ԫ�أ�������֤Ԫ�صĵ�������
    	String[] strArray = new  String[]{"one", "world ",  "one",  "dream"};     
        Set<String> s = new HashSet<String>();       
        for (int i=0; i<4; i++)
            if (!s.add(strArray[i])) //���strArrayԪ�ص�����s��
                System.out.println("Duplicate detected: " + strArray[i]);
        System.out.println(s.size() + " distinct words: " + s); 
        
       //�Զ��������������� �����˵��ظ�Ԫ�� 
        TreeSet<String> treeset=new TreeSet<String>();
        treeset.add("b");  
        treeset.add("a");  
        treeset.add("c");  
        treeset.add("d"); 
        treeset.add("b");
        System.out.println("TreeSet:");  
        System.out.println(treeset);  
        System.out.println("the first element is: "+treeset.first());//���ص�һ��Ԫ��  
        Iterator<String> iterator=treeset.iterator();  
        while(iterator.hasNext()){  
         System.out.print(iterator.next()+";");  
        } 
         
        //�����ظ�Ԫ�أ���֤Ԫ�صĵ�������
        LinkedHashSet<String> hashset=new LinkedHashSet<String>();    
        hashset.add("b");  
        hashset.add("a");  
        hashset.add("c");  
        hashset.add("d");  
        hashset.add("b");  
        System.out.println("\n"+"LinkedHashSet:");  
        System.out.println(hashset);  
        Iterator<String> iterator1=hashset.iterator();//ȡ��Ԫ��  
        while(iterator1.hasNext()){  
          System.out.print(iterator1.next()+";");  
        }  
    }
}
