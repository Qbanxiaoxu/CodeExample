package chpt2;

public class Ex2_8 {
    public static void main(String[] args) {
        int i = 9;
        Integer iObj = new Integer(i); //��װΪһ��Integer����
    
        String s = iObj.toString();
       
        //��һ���ַ�����ת��Ϊ����
        i = iObj.parseInt( "1897" );
    
        //��һ���ַ�����ת���ط�װ�����iObj
        iObj = iObj.valueOf( "1897" );

        int j = 15;
        Integer iObj2 = j; //�Զ���װ
        int d = iObj2;     //���װ

        Float fObj1 = 20.0F;  //�Զ���װ
        Float fObj2 = 10.0F;  //�Զ���װ
        float result = fObj1 * fObj2;  // ���װ
    }
}
