//Product.java
package chpt11.Ex11_11;

class Product {   
     int id;// ��Ʒid    
     String name;// ��Ʒ����    
   
    public Product(int id, String name) {   
        this.id = id;   
        this.name = name;   
    }   
   
    @Override   
    public String toString() {   
        return "(Product ID��" + id + " Product name��" + name + ")";   
    }   
   
  
   
}   
   