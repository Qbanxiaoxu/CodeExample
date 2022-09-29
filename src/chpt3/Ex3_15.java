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
     ��		* ����һ��Productʵ�����趨Product�����ֺ��Ա�
     	* @param ID int 
     ��		* @param name String ����
     ��		* @param categories String ���
        * @param productPrice ��Ʒ�۸�
     ��		* @throws ProductArgumentException
     ��		* @see javadoc.tool
     ��	*/
     Ex3_15(int id, String nm, String categ,double price)
     {
    	 ID =id;
    	 name=nm;
    	 categories = categ;
    	 productPrice = price;
     }
     /**
     * ��ȡ����
     * @return String
     */
     public String getName()
     {
      return name;
     }
     /**
      * ��ȡ���
      * @return String
      */
      public String getcategories()
      {
       return categories;
      }
      
      /**
       * ��ȡ��Ʒ�۸�
       * @return double
       */
       public double productPrice()
       {
        return productPrice;
       }
     /**
      * toString����
      * @return String
      */
    public String toString(){
    	return ("Product "+ ID+","+ name + ","+categories+","+productPrice);
    } 
}
