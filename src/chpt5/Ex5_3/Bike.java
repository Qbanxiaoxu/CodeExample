package chpt5.Ex5_3;

//Bike.java
class Bike 
{   
    int colornum;  
    int brand;
    int speed;
    
    Bike(){ System.out.println("call Bike constructor");}
    public void speedup()
    {
          speed = 0;
          System.out.println("too slow......");
     }
    public void presshorn() {System.out.println("beep......");  }
}  