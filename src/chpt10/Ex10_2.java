package chpt10;

//Ex10_2.java
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class JPanelClass extends JPanel{//创建一个继承于JPane类的子类JPanelClass
	JLabel nameLabel, phoneLabel;  //组件声明
	JTextField name;
	JTextField phone;
	JButton LoginButton, CancelButton; 
	
	Font ffont=new Font("宋体", 1, 24);//设置字体
	
	public JPanelClass(){
		//创建Label组件
		nameLabel = new JLabel("User");
		nameLabel.setFont(ffont);
		phoneLabel = new JLabel("phone:");
		phoneLabel.setFont(ffont); 
		
		//创建TextField组件
		name = new JTextField(10);
		name.setFont(ffont);		
		phone = new JTextField(10);
		phone.setFont(ffont);
		
		//创建Button组件
		LoginButton = new JButton("Summit");
		LoginButton.setFont(ffont);		
		CancelButton = new JButton("Cancel");
		CancelButton.setFont(ffont);
		
		//添加组件到 面板容器中
		add(nameLabel);
		add(name);
		add(phoneLabel);
		add(phone);
		add(LoginButton);
		add(CancelButton);		
	}
}

//SimpleJFrameClass
 class SimpleJFrameClass extends JFrame{	 
	JPanelClass panel;
	
	public SimpleJFrameClass(){
		setSize(520,320);
		setTitle("Login GUI");
		panel=new JPanelClass();
		//getContentPane().add(panel);//或者添加到内容窗格，JDK1.5以前适用
		add(panel);//添加面板到顶层容器里
		setVisible(true);
		setResizable(false);
	}
}
public class Ex10_2{
	public static void main(String[] args){
		SimpleJFrameClass frame = new SimpleJFrameClass();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
	
