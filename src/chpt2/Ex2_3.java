package chpt2;

public class Ex2_3 {
    public static void main(String[] args){
        int myData[]=new int[10];            //��������
         for(int i=0; i<myData.length;i++)
            System.out.println(i+"\t\t"+myData[i]);
          myData[10]=100;              //����������Խ���쳣
    }
}
