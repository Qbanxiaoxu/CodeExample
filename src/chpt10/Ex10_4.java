package chpt10;

//Ex10_4.java
import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.*;


public class Ex10_4 extends JFrame {	
	public Ex10_4() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
	
		JButton btnOk = new JButton("OK"); //���һ��Button
		btnOk.setBounds(10, 25, 93, 23);
		add(btnOk);
		
		//���һ��RadioButton
		JRadioButton rdbtnRadioButton = new JRadioButton("radio button");
		rdbtnRadioButton.setBounds(19, 85, 121, 23);
		add(rdbtnRadioButton);
		
		//���һ��Textfield
		JTextField txtTextfield = new JTextField();
		txtTextfield.setText("TextField");
		txtTextfield.setBounds(36, 143, 66, 21);
		add(txtTextfield);
		txtTextfield.setColumns(10);
		
		//���һ��Label
		JLabel lblLabel = new JLabel("label");
		lblLabel.setBounds(150, 44, 54, 15);
		add(lblLabel);
		
		JCheckBox chckbxCheckBox = new JCheckBox("check box");
		chckbxCheckBox.setBounds(144, 85, 103, 23);
		add(chckbxCheckBox);
		
		//���һ��ComboTox
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(150, 143, 32, 21);
		add(comboBox);
		
		//���һ��TextArea
		JTextArea txtrTextarea = new JTextArea();
		txtrTextarea.setText("TextArea");
		txtrTextarea.setBounds(500, 500, 200, 500);
		add(txtrTextarea);
	}
	
	public static void main(String[] args) {
		Ex10_4 frame=new Ex10_4();
		frame.setTitle("�������ӵ������");
		frame.setSize(500,300);				
		frame.setVisible(true);				
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE );
	}
}
