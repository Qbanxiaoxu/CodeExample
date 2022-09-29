package chpt10;

//Ex10_6.java
import java.awt.event.*; 
import javax.swing.*; 

public class Ex10_6 implements MouseListener{ //ʵ��MouseListener�ӿ�
     JFrame f;  //�ڹ��췽���ͱ�ķ����ж�Ҫʹ�ã���������Ϊ������
     public Ex10_6() //���췽��
     {
        f=new JFrame(); 
        f.setSize(600,400);
        f.setVisible(true);
	    f.addMouseListener(this); //Ϊ������������¼�������
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //���ùرմ������˳�����         
    }
    
     public void mouseClicked(MouseEvent e){  //ʵ�ֽӿڵ�mouseClicked����
         f.setTitle("�������Ϊ ("+e.getX()+", "+e.getY()+")");//���ô��ڱ���
     }
     
     public void mousePressed(MouseEvent e) {
         System.out.println ("Mouse pressed (# of clicks: "
                 + e.getClickCount() + ")");
     }
     
     public void mouseReleased(MouseEvent e) {
    	 System.out.println("Mouse released (# of clicks: "
                 + e.getClickCount() + ")");
     }
     
     public void mouseEntered(MouseEvent e) {
         System.out.println("Mouse entered");
     }
     
     public void mouseExited(MouseEvent e) {
    	 System.out.println ("Mouse exited");
     }
     
    public static void main(String[] args){ //������������Ex10_6���һ������
        new Ex10_6();
    }
}
