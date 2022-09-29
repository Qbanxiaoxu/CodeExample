package chpt7.Ex7_9;
//Product.java
public class Product {
     protected int ID;
     protected String name;
     protected String categories;
     protected double ProductPrice;

     public Product() 
     { 
     } 
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
