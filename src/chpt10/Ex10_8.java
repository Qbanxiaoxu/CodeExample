package chpt10;

//Ex10_8.java
import java.awt.event.*; 
import javax.swing.*;

public class Ex10_8 extends JFrame {
	JFrame f;
    
    public Ex10_8()
    {
    		
    	f=new JFrame();
        f.setSize(300,150);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    	
    	f.addMouseListener(new MouseAdapter(){
			public void mouseClicked(java.awt.event.MouseEvent e) {
			
				 f.setTitle("�������Ϊ ("+e.getX()+", "+e.getY()+")");
			}
		});//�������ڲ������
    }
  
    public static void main(String[] args){
    	Ex10_8 frame=new Ex10_8();
		
    }
}
