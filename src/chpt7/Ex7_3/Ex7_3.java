package chpt7.Ex7_3;
//Ex7_3.java
import java.util.*;
class Chicken {
  int chickenNum;
  public Chicken(int i) { chickenNum = i; }
  public void show() {
    System.out.println("Chicken id:" + chickenNum);
  }
} 

public class Ex7_3{
  public static void main(String[] args) {
    ArrayList<Chicken> animals = new ArrayList<Chicken>(); //����һ��ArrayList animals
    for(int i = 0; i < 5; i++)
      animals.add(new Chicken(i));  //��5ֻchicken����animals��
    for(int i = 0; i < 5; i++){   //ȡ��5ֻchicken  	
    	animals.get(i).show();
    }
  }
} 


