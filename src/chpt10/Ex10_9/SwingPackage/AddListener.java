package chpt10.Ex10_9.SwingPackage;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.regex.Pattern;
import javax.swing.*;
import chpt10.Ex10_9.MainPackage.Management;

class AddListener implements ActionListener
{
	JPanel jplDisplay;
	JInternalFrame jifShow;//��Ӳ�Ʒ��崰��
	JPanel displayUp,displayMid,displayDown;
	Management operate=null;
	public AddListener(JPanel jpl)
	{
		this.jplDisplay=jpl;
	}
	public void actionPerformed(ActionEvent e)
	{
		jplDisplay.removeAll();
		jifShow=new JInternalFrame("��Ӳ�Ʒ���",true,true,true);
		jifShow.setDefaultCloseOperation(JInternalFrame.DISPOSE_ON_CLOSE);
		//�������
		displayUp=new JPanel(new GridBagLayout());
		String[] productName={"","Software","Laptop","Desktop","Hometheater","Cartheater"};
		final JComboBox productBox=new JComboBox(productName);		//���������˵�
		productBox.setName("����");
		JLabel jCate=new JLabel("����");
		JLabel jName=new JLabel("��Ʒ��");
		JLabel jPrice=new JLabel("�۸�");
		JLabel jDescription=new JLabel("˵��");
		final JTextField pName=new JTextField(12);
		final JTextField pPrice=new JTextField(12);
		final JTextField pDescription=new JTextField(12);
		//��������Ĳ���
		GridBagConstraints gridBagCon01 = new GridBagConstraints();
		gridBagCon01.gridx = 5;
		gridBagCon01.gridy = 0;
		gridBagCon01.insets = new Insets(5,5,5,5); 
		displayUp.add(jCate, gridBagCon01);
		gridBagCon01.gridx = 6;
		gridBagCon01.fill = GridBagConstraints.BOTH;;
		displayUp.add(productBox, gridBagCon01);
		
		gridBagCon01.gridx = 3;
		gridBagCon01.gridy = 2;
		displayUp.add(jName, gridBagCon01);
		gridBagCon01.gridx = 4;
		displayUp.add(pName, gridBagCon01);
		gridBagCon01.gridx = 5;
		displayUp.add(jPrice, gridBagCon01);
		gridBagCon01.gridx = 6;
		displayUp.add(pPrice, gridBagCon01);
		gridBagCon01.gridx = 7;
		displayUp.add(jDescription, gridBagCon01);
		gridBagCon01.gridx = 8;
		displayUp.add(pDescription, gridBagCon01);
		displayUp.setBackground(Color.GREEN);
		
		//�м����
		displayMid=new JPanel(new GridBagLayout());
		final int colNum=15;
		final String[] name=new String[colNum];	
		final JTextField[] columnValue=new JTextField[colNum];	//��Ŷ�Ӧ��ֵ
		for(int i=0;i<colNum;i++)
		{	name[i]=null;columnValue[i]=null;}
		String[] sTF={"","True","False"};
		final JComboBox removableJCB=new JComboBox(sTF);
		
		/*ΪproductBox��Ӽ�����*/
		productBox.addItemListener(new ItemListener(){
			public void itemStateChanged(ItemEvent e) {
				String productName=productBox.getSelectedItem().toString();//�õ���Ʒ������
				if(e.getStateChange()==ItemEvent.DESELECTED)	//�ж������˵����¼�ItemEvent.DESELECTED
					return;
				displayMid.removeAll();
				if(productName.length()==0)		//�жϲ˵����Ƿ�Ϊ��ֵ
				{
					jplDisplay.add(jifShow);return;
				}
				for(int i=0;i<colNum;i++)
				{
					name[i]=null;
					columnValue[i]=null;
				}
				try{	//�������ݿ������ݣ�Ϊ�м���岼��
					operate = new Management();
					operate.display(productName);	//���ú������������ݿ�
					ResultSetMetaData rsmd=operate.rs.getMetaData();	//�������������
					int colCount=rsmd.getColumnCount();		//�õ�����
					for(int i=1;i<=colCount;i++)	//�õ�����
					{
						name[i-1]=rsmd.getColumnName(i);
					}
					operate.rs.close();
					GridBagConstraints gridBagCon02 = new GridBagConstraints();//���ֹ������
					gridBagCon02.insets = new Insets(10,5,5,5);//���������������ֵ
					gridBagCon02.fill = GridBagConstraints.BOTH;//���ö����Ƿ���������
					for(int i=4;i<colCount;i++)
					{
						gridBagCon02.gridx = 5;
						gridBagCon02.gridy =(i-4);
						displayMid.add(new JLabel(name[i]), gridBagCon02);
						gridBagCon02.gridx = 6;
						if(name[i].equals("Removable"))
						{
							
							displayMid.add(removableJCB, gridBagCon02);
						}
						else
						{
							columnValue[i]=new JTextField(16);
							displayMid.add(columnValue[i], gridBagCon02);
						}
					}
					displayMid.setVisible(true);	//���ÿɼ���
					jifShow.add(displayMid,BorderLayout.CENTER);
					jplDisplay.add(jifShow);		//��Ӷ���
				}catch (ClassNotFoundException e1) {
					JOptionPane.showMessageDialog(jplDisplay, "���ݿ������쳣","����",0);
				}catch(SQLException wrong){
					JOptionPane.showMessageDialog(jifShow, "���ݿ�����쳣","����",0);
				}
			}
		});
		//�ײ����
		JButton jbStore=new JButton("����");			//���ð�ť
		JButton jbReset=new JButton("���");
		JButton jbQuit=new JButton("�˳�");
		displayDown=new JPanel(new FlowLayout());
		displayDown.add(jbStore);
		displayDown.add(jbReset);
		displayDown.add(jbQuit);
		displayDown.setBackground(Color.BLACK);
		
		jifShow.add(displayUp,BorderLayout.NORTH);
		jifShow.add(displayDown,BorderLayout.SOUTH);
		jifShow.setVisible(true);
		jplDisplay.add(jifShow);
		//ΪjbQuit��ť��Ӽ�����
		jbQuit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				jifShow.dispose();
			}
		});
		//ΪjbReset��ť��Ӽ�����
		jbReset.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				productBox.setSelectedIndex(0);
				pName.setText(null);
				pPrice.setText(null);
				pDescription.setText(null);
			}
		});
		//ΪjbStore��ť��Ӽ�����
		jbStore.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String tableName=productBox.getSelectedItem().toString();
				if(tableName.length()==0)//��Ʒ������ʾ��1������Ϣ����
				{
					JOptionPane.showMessageDialog(jifShow, "��ѡ���Ʒ����","��ʾ", 1);
					return;
				}
				String productName=pName.getText();
				Pattern pattern=Pattern.compile("^[\\040]*");//���С�\040�ǿո�İ˽���ת���ַ���
				if(pattern.matcher(productName).matches()==true)//��Ʒ������ʾ��
				{
					JOptionPane.showMessageDialog(jifShow, "�������Ʒ����","��ʾ", 1);
					return;
				}
				String productPrice=pPrice.getText();
				pattern=Pattern.compile("^\\d+(\\.\\d+)*$");	//����������ʽ
				if(pattern.matcher(productPrice).matches()==false)//��Ʒ�۸���ʾ��
				{
					JOptionPane.showMessageDialog(jifShow, "��������ȷ�Ĳ�Ʒ�۸�","����", 2);
					return;
				}
				String productDes=pDescription.getText();
				pattern=Pattern.compile("^[\\040]*");
				if(pattern.matcher(productDes).matches()==true)//��Ʒ������ʾ��
				{
					JOptionPane.showMessageDialog(jifShow, "�������Ʒ������","��ʾ", 1);
					return;
				}
				int max=0;
				for(;name[max]!=null;){max++;}
				String[] tableValue=new String[max-1];
				tableValue[0]=new String(productName);
				tableValue[1]=new String(productPrice);
				tableValue[2]=new String(productDes);
				int i=3;
				for(;columnValue[i+1]!=null;i++)
				{
					tableValue[i]=new String(columnValue[i+1].getText());
				}
				if(name[i+1]!=null && name[i+1].equals("Removable"))
					tableValue[i]=new String(removableJCB.getSelectedItem().toString());
				String dbTableName=new String(productBox.getSelectedItem().toString());
//				for(int j=0;j<tableValue.length;j++)
//					System.out.println(tableValue[j]);
				try {		/*���ú����������ݿ��������*/
					operate = new Management();
					operate.addition(dbTableName, tableValue);
					JOptionPane.showMessageDialog(jifShow, "�����Ϣ�ɹ�","Successful", 1);
				}catch(ClassNotFoundException e2){
					JOptionPane.showMessageDialog(jifShow, "���ݿ������쳣","����", 2);
				}catch (SQLException e1) {
					JOptionPane.showMessageDialog(jifShow, "���ݿ�����쳣","����", 2);
				}catch(Exception e3){
					JOptionPane.showMessageDialog(jifShow, "������Ϸ�������","����", 2);
				}finally{
					Management.maxId--;
				}
			}
		});
	}
	

}