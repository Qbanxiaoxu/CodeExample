package chpt5.Ex5_3;
//SpeedBike.java
class SpeedBike extends Bike
{
   
	SpeedBike(){ 
		super();            //���ø���Ĺ��췽��
		super.colornum =12; //���ø�������ݳ�Ա
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