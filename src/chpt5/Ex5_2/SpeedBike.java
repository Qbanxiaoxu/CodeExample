//SpeedBike.java
package chpt5.Ex5_2;

class SpeedBike extends Bike
{
   
    public void ride() {System.out.println("I am riding the bike");    }
    public void speedup()
    {
    	   super.speedup();
           speed = speed +10;
           System.out.println("So fast!, my speed is:"+speed+"now");
     }
}
