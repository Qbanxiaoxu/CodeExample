package chpt2;

//Ex2_4.java
public class Ex2_4 {
	public static void main(String[] args) {
		String name[]={"����","����","����","��ΰ","ë��","����","����","��ϣ",
				       "��һ","����","����","����","�³�","����","�ż�","Ǯ��"};
		int[] grade=new int[]{341,273,278,329,445,402,388,275,
				              243,334,412,393,299,343,317,265};
		
		for(int i=0;i<grade.length;i++)
		{
			for(int j=i;j<grade.length;j++){
				int temp;
				String Stemp;
				if (grade[i] < grade[j]) {
					temp = grade[i];
					grade[i] =grade[j];
					grade[j] = temp;
					Stemp = name[i];
					name[i] = name[j];
					name[j] = Stemp;
				}
			}
		}
		System.out.println("����	"+"����	"+"�ɼ�");
		System.out.println("��һ��	"+name[0]+"	"+grade[0]);
		System.out.println("�ڶ���	"+name[1]+"	"+grade[1]);
		System.out.println("������	"+name[2]+"	"+grade[2]);
	}
}
