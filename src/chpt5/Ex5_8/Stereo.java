//Stereo.java
package chpt5.Ex5_8;
public class Stereo extends Product
{	
	int speaker;		//扬声器个数
	int watts;			//功率
	
	Stereo(int c){System.out.println("Stereo Constructor...");}
	Stereo(){}  //默认构造方法，生成new Stereo()必需
	public int getNumSpk()
	{
		return speaker;
	}
	public int getWatts()
	{
		return watts;
	}
	void ads(){System.out.println("This is awful!");}	
}