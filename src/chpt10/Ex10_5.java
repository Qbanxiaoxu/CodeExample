package chpt10;
//Ex10_5.java
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Ex10_5 extends JFrame  implements ActionListener
{
	public Ex10_5()
	{
		JButton b=new JButton("��ť");		
		add(b);	//��Ӱ�ť����������
		b.addActionListener(this);  //����¼�������
	}
	public void actionPerformed(ActionEvent arg0) {
		 Toolkit.getDefaultToolkit().beep();
	}
	public static void main(String[] args)
	{
		Ex10_5 frame=new Ex10_5();
		frame.setTitle("��ť��ӵ������");
		frame.setSize(300,200);				
		frame.setVisible(true);				
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE );
	 }
}
