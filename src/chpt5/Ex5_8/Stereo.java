//Stereo.java
package chpt5.Ex5_8;
public class Stereo extends Product
{	
	int speaker;		//����������
	int watts;			//����
	
	Stereo(int c){System.out.println("Stereo Constructor...");}
	Stereo(){}  //Ĭ�Ϲ��췽��������new Stereo()����
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