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
		JButton b=new JButton("按钮");		
		add(b);	//添加按钮到顶层容器
		b.addActionListener(this);  //添加事件监听器
	}
	public void actionPerformed(ActionEvent arg0) {
		 Toolkit.getDefaultToolkit().beep();
	}
	public static void main(String[] args)
	{
		Ex10_5 frame=new Ex10_5();
		frame.setTitle("按钮添加到框架中");
		frame.setSize(300,200);				
		frame.setVisible(true);				
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE );
	 }
}
