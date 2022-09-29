//Product.java
package chpt5.Ex5_4;
public class Product {
     protected int ID;
     protected String name;
     protected String categories;
     protected double ProductPrice;

    public Product(){ this(0, "","",0);}
	public Product(int aID, String aname, String acategories, double aPrice) 
	{ 
		ID=aID;
		name=aname; 
		categories=acategories; 
		ProductPrice=aPrice;
	}
	public String toString()
	{
	  return ("Product ID:"+ID +"\n"+"Product name:"+name+"\n"+"Product category:"+categories+"\n"+"Product Price:"+ProductPrice+"\n");
	}
     int getID(){
        return ID;
    }
     String getName(){
        return name;
    }
    String getCategories(){
        return categories;
    }
    double getPrice(){
        return ProductPrice;
    }   
}
