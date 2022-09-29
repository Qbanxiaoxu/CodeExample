package chpt7.Ex7_5;
//Laptop.java
public class Laptop extends Computer
{
	double thickness;
	double weight;
	
	Laptop(int aID, String aname, String acategories, double aPrice,int amemory,String aProcessorName,double athickness,double aweight) { 
	      super(aID,aname,acategories,aPrice,amemory,aProcessorName);
	      thickness = athickness; 
	      weight = aweight;
	   } 
	   public String toString(){
			
			return(super.toString()+"thickness"+thickness+"\n"+"weight"+weight+"\n");
	   }

	
    public double getthickness()
    {
      return thickness;
    }
    double getweight()
    {
      return weight;
    }

}
