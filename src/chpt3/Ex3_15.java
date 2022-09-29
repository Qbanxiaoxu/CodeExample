package chpt3;

//Ex3_15.java
/** @see javadoc.tool.
* @version 1.0, 2008-09-12
* @author RedWolf
* @since JDK1.3**/

public class Ex3_15 {
     int ID;
     String name;
     String categories; 
     double productPrice;

     /**
     　		* 构造一个Product实例。设定Product的名字和性别。
     	* @param ID int 
     　		* @param name String 名字
     　		* @param categories String 类别
        * @param productPrice 产品价格
     　		* @throws ProductArgumentException
     　		* @see javadoc.tool
     　	*/
     Ex3_15(int id, String nm, String categ,double price)
     {
    	 ID =id;
    	 name=nm;
    	 categories = categ;
    	 productPrice = price;
     }
     /**
     * 获取姓名
     * @return String
     */
     public String getName()
     {
      return name;
     }
     /**
      * 获取类别
      * @return String
      */
      public String getcategories()
      {
       return categories;
      }
      
      /**
       * 获取产品价格
       * @return double
       */
       public double productPrice()
       {
        return productPrice;
       }
     /**
      * toString方法
      * @return String
      */
    public String toString(){
    	return ("Product "+ ID+","+ name + ","+categories+","+productPrice);
    } 
}
