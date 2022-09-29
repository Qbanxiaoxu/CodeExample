package chpt8;

//Ex8_12.java
import java.io.*;
//Product类，必须实现Serializable接口
class Product implements Serializable
{
	int ID;
    String name;
    String categories; 
    double productPrice;

    Product(int id, String nm, String categ,double price)
    {
   	 ID =id;
   	 name=nm;
   	 categories = categ;
   	 productPrice = price;
    }
}
public class Ex8_12
{
   public static void main(String args[]) 
   {
        Ex8_12 os = new Ex8_12();

        os.saveObj();
        os.readObj();
   }
   //储存数据到文件里
   public void saveObj() 
   {
       Product pro = new Product(1234, "apple", "computer", 9999);
       try
       {
           FileOutputStream fo = new FileOutputStream("c:\\myjava\\code\\o.dat");
           ObjectOutputStream so = new ObjectOutputStream(fo);
           so.writeObject(pro);
           so.close();
       }
       catch(Exception e)
       {
          System.err.println(e) ;
       }
   }
  //从文件里读出数据
   public void readObj() 
   {
     Product prod;
      try
      {
           FileInputStream fi = new FileInputStream("c:\\myjava\\code\\o.dat");
           ObjectInputStream si = new ObjectInputStream(fi);

           prod = (Product)si.readObject();
           si.close();

           System.out.println("ID: " + prod.ID);
           System.out.println("name: " + prod.name);
           System.out.println("age: " + prod.categories);
           System.out.println("dept.: " + prod.productPrice);
      }
      catch(Exception e)
      {
         System.err.println(e);
      }
   }

}

