package chpt5.Ex5_3;
//SpeedBike.java
class SpeedBike extends Bike
{
   
	SpeedBike(){ 
		super();            //调用父类的构造方法
		super.colornum =12; //调用父类的数据成员
		super.presshorn();
		System.out.println("call Speed Bike constructor"); 
		
	}
    public void ride() {System.out.println("I am riding the bike");}
    public void speedup()
    {
    	
    	   super.speedup();
           speed = speed +10;
           System.out.println("So fast!, my speed is:"+speed+"now");
    } 
}