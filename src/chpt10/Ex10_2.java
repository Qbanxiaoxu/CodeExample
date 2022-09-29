package chpt10;

//Ex10_2.java
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class JPanelClass extends JPanel{//����һ���̳���JPane�������JPanelClass
	JLabel nameLabel, phoneLabel;  //�������
	JTextField name;
	JTextField phone;
	JButton LoginButton, CancelButton; 
	
	Font ffont=new Font("����", 1, 24);//��������
	
	public JPanelClass(){
		//����Label���
		nameLabel = new JLabel("User");
		nameLabel.setFont(ffont);
		phoneLabel = new JLabel("phone:");
		phoneLabel.setFont(ffont); 
		
		//����TextField���
		name = new JTextField(10);
		name.setFont(ffont);		
		phone = new JTextField(10);
		phone.setFont(ffont);
		
		//����Button���
		LoginButton = new JButton("Summit");
		LoginButton.setFont(ffont);		
		CancelButton = new JButton("Cancel");
		CancelButton.setFont(ffont);
		
		//�������� ���������
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
		//getContentPane().add(panel);//������ӵ����ݴ���JDK1.5��ǰ����
		add(panel);//�����嵽����������
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
	
