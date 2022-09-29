//Laptop.java
package chpt5.Ex5_4;
public class Laptop extends Computer
{
	 double thickness;
	 double weight;
	
	public Laptop(int aID, String aname, String acategories, double aPrice,int amemory,String aProcessorName,double athickness,double aweight) { 
	      super(aID,aname,acategories,aPrice,amemory,aProcessorName);
	      thickness = athickness; 
	      weight = aweight;
	   } 
	public String toString(){
			
			return(super.toString()+"thickness"+thickness+"\n"+"weight"+weight+"\n");
	   }
    double getthickness()
    {
      return thickness;
    }
    double getweight()
    {
      return weight;
    }
}
