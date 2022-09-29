package chpt2;

public class Ex2_8 {
    public static void main(String[] args) {
        int i = 9;
        Integer iObj = new Integer(i); //封装为一个Integer对象
    
        String s = iObj.toString();
       
        //读一个字符串，转化为整型
        i = iObj.parseInt( "1897" );
    
        //读一个字符串，转换回封装类对象iObj
        iObj = iObj.valueOf( "1897" );

        int j = 15;
        Integer iObj2 = j; //自动封装
        int d = iObj2;     //解封装

        Float fObj1 = 20.0F;  //自动封装
        Float fObj2 = 10.0F;  //自动封装
        float result = fObj1 * fObj2;  // 解封装
    }
}
