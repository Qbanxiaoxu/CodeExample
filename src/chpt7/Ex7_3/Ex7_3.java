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
    ArrayList<Chicken> animals = new ArrayList<Chicken>(); //定义一个ArrayList animals
    for(int i = 0; i < 5; i++)
      animals.add(new Chicken(i));  //把5只chicken放入animals里
    for(int i = 0; i < 5; i++){   //取出5只chicken  	
    	animals.get(i).show();
    }
  }
} 


