package chpt2;

class Ex2_5 {
    public static void main(String[] args) {
        String[][] names = {
            {"Mr. ", "Mrs. ", "Ms. "},
            {"Smith", "Jones"}
        };
        // Mr. Smith
        System.out.println(names[0][0] + names[1][0]);
        // Ms. Jones
        System.out.println(names[0][2] + names[1][1]);
        //����ĳ���
        System.out.println("���鳤��Ϊ��"+names.length);
        for(int i=0; i<names.length; i++)
        	System.out.println("�������"+i+"��Ԫ�س���Ϊ: "+names[i].length); 
        
    }
}

