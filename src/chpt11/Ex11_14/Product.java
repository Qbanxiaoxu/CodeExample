//Product.java
package chpt11.Ex11_14;

class Product {   
     String id;// ��Ʒid    
     String name;// ��Ʒ����    
   
    public Product(String id, String name) {   
        this.id = id;   
        this.name = name;   
    }   
    public String toString() {   
        return "(Product ID��" + id + "Product name��" + name + ")";   
    }   
}   
   
