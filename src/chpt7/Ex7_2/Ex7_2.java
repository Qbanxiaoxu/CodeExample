package chpt7.Ex7_2;

import java.util.*;
class Chicken {
  int chickenNum;
  public Chicken(int i) { chickenNum = i; }
  public void show() {
    System.out.println("Chicken id:" + chickenNum);
  }
} 

public class Ex7_2{
  public static void main(String[] args) {
    ArrayList animals = new ArrayList(); //����һ��ArrayList animals
    for(int i = 0; i < 5; i++)
      animals.add(new Chicken(i));  //��5ֻchicken����animals��
    for(int i = 0; i < 5; i++){   //ȡ��5ֻchicken  	
    	((Chicken)animals.get(i)).show();
    }
  }
} 


