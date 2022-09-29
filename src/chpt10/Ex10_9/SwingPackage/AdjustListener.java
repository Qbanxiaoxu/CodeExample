package chpt10.Ex10_9.SwingPackage;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;

import javax.swing.*;

import chpt10.Ex10_9.MainPackage.Management;
class AdjustListener implements ActionListener
{
	JPanel jplDisplay;
	JInternalFrame jifShow;//��ʾ��崰��
	JPanel displayUp,displayMid,displayDown;
	Management operate=null;
	public AdjustListener(JPanel jpl)
	{
		this.jplDisplay=jpl;
	}
	public void actionPerformed(ActionEvent e)
	{
		jplDisplay.removeAll();
		jifShow=new JInternalFrame("������Ϣ���",true,true,true);
		//�������
		displayUp=new JPanel();
		JLabel jTitle=new JLabel("������Ʒ�۸�");
		jTitle.setFont(new Font("�����п�", 2, 28));
		jTitle.setForeground(Color.BLACK);
		displayUp.add(jTitle);
		displayUp.setBackground(Color.GREEN);
		//�м����
		displayMid=new JPanel(new GridBagLayout());
		GridBagConstraints myGridBag = new GridBagConstraints();//���ֹ������
		myGridBag.insets = new Insets(10,5,5,5);//���������������ֵ
		myGridBag.fill=GridBagConstraints.BOTH;
		myGridBag.gridwidth=2;
		JLabel[] jName=new JLabel[3];
		jName[0]=new JLabel("��Ʒ����");
		jName[1]=new JLabel("����");
		jName[2]=new JLabel("����");
		String[] item1={"","Software","Laptop","DeskTop","Hometheater","Cartheater"};
		String[] item2={"","����","�½�"};
		String[] item3={"","5%","10%","20%","30%","40%","50%","100%"};
		final JComboBox[] jBox=new JComboBox[3];		//���������˵�
		jBox[0]=new JComboBox(item1);
		jBox[1]=new JComboBox(item2);
		jBox[2]=new JComboBox(item3);
		for(int i=0;i<3;i++)
		{
			jName[i].setFont(new Font("����",1,20));
			jName[i].setHorizontalAlignment(SwingConstants.RIGHT);
			myGridBag.gridx=2;
			myGridBag.gridy=(2*i-1);
			displayMid.add(jName[i], myGridBag);
			myGridBag.gridx=6;
			displayMid.add(jBox[i], myGridBag);
		}
		displayMid.setBackground(new Color(150,200,150));
		
		//�ײ����
		JButton jbStore=new JButton("ȷ��");			//���ð�ť
		JButton jbQuit=new JButton("�˳�");
		jbStore.setFont(new Font("�����п�",1,20));
		jbQuit.setFont(new Font("�����п�",1,20));
		displayDown=new JPanel(new GridLayout(1,9));
		for(int i=0;i<9;i++)
		{
			if(i==3) displayDown.add(jbStore);
			else if(i==5) displayDown.add(jbQuit);
			else displayDown.add(new JLabel());
		}
		displayDown.setBackground(Color.BLACK);
		
		jifShow.add(displayUp,BorderLayout.NORTH);
		jifShow.add(displayMid,BorderLayout.CENTER);
		jifShow.add(displayDown,BorderLayout.SOUTH);
		jifShow.setVisible(true);
		jplDisplay.add(jifShow);
		
		//ΪjbQuit��ť��Ӽ�����
		jbQuit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				jifShow.dispose();
			}
		});
		//ΪjbQuit��ť��Ӽ�����
		jbStore.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String tableName=jBox[0].getSelectedItem().toString();
				if(tableName.length()==0)//��Ʒ������ʾ��1������Ϣ����
				{
					JOptionPane.showMessageDialog(jifShow, "��ѡ���Ʒ����","��ʾ",1);
					return;
				}
				String adjustType=jBox[1].getSelectedItem().toString();
				if(adjustType.length()==0)//��Ʒ������ʾ��1������Ϣ����
				{
					JOptionPane.showMessageDialog(jifShow,"��ѡ�����(����/�½�)","��ʾ",1);
					return;
				}
				String adjustValue=jBox[2].getSelectedItem().toString();
				if(adjustValue.length()==0)//��Ʒ������ʾ��1������Ϣ����
				{
					JOptionPane.showMessageDialog(jifShow,"��ѡ���������(�ٷֱ�)","��ʾ",1);
					return;
				}
				try {
					operate = new Management();
					operate.adjustInf(tableName, adjustType, adjustValue);
					jBox[2].setSelectedIndex(0);
					JOptionPane.showMessageDialog(jifShow,"�����ɹ�","Success",1);
				}catch (ClassNotFoundException e1) {
					JOptionPane.showMessageDialog(jplDisplay, "���ݿ������쳣","����",0);
				}catch(SQLException fault) {
					JOptionPane.showMessageDialog(jifShow,"���ݿ�����쳣","����",2);
				}catch(Exception fault) {
					JOptionPane.showMessageDialog(jifShow,"δ֪���󣡣�","�쳣",3);
				}
			}
		});
	}
}