//Product.java
package chpt11.Ex11_9;

class Product {   
     int id;// 产品id    
     String name;// 产品名称    
   
    public Product(int id, String name) {   
        this.id = id;   
        this.name = name;   
    }      
    public String toString() {   
        return "(Product ID：" + id + " Product name：" + name + ")";   
    }    
}   
  
