package chpt10.Ex10_9.SwingPackage;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.regex.Pattern;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import chpt10.Ex10_9.MainPackage.Management;

class SearchListener implements ActionListener
{
	JPanel jplDisplay;
	JInternalFrame jifShow;//��ʾ��崰��
	JPanel displayUp,displayMid,displayDown;
	Management operate=null;
	public SearchListener(JPanel jpl)
	{
		this.jplDisplay=jpl;
	}
	public void actionPerformed(ActionEvent e)
	{
		jplDisplay.removeAll();
		jifShow=new JInternalFrame("��ѯ��Ʒ���",true,true,true);
		//�������
		displayUp=new JPanel();
		JLabel jTitle=new JLabel("��ѯ��Ʒ");
		jTitle.setFont(new Font("�����п�", 2, 28));
		jTitle.setForeground(Color.BLACK);
		displayUp.add(jTitle);
		displayUp.setBackground(Color.GREEN);
		//�м����
		displayMid=new JPanel(new BorderLayout());		//�м������ϲ�
		JLabel[] jName=new JLabel[2];
		String[] sType={"","Software","Laptop","DeskTop","Hometheater","Cartheater"};
		jName[0]=new JLabel("��Ʒ����");
		jName[1]=new JLabel("��Ʒ����");
		final JComboBox productBox=new JComboBox(sType);
		final JTextField pName=new JTextField(12);
		JPanel panelMidUp=new JPanel(new FlowLayout());
		panelMidUp.add(jName[0]);
		panelMidUp.add(productBox);
		panelMidUp.add(jName[1]);
		panelMidUp.add(pName);
		displayMid.add(panelMidUp, BorderLayout.NORTH);
		
		JTable myJTable;		//����������м������²�
		final DefaultTableModel JTableModel = new DefaultTableModel(10,20);	//������ģ��
		myJTable=new JTable(JTableModel);	//�ñ��ģ���ʼ�����myJTable
		myJTable.setEnabled(true);
		myJTable.setRowHeight(18);
		myJTable.setFillsViewportHeight(true);
		myJTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
//		myJTable.setCellSelectionEnabled(true);			//����ѡȡ��Ԫ��
//		myJTable.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);	//�����ѡ
		final JScrollPane mySrollPane=new JScrollPane();	//�������
		mySrollPane.add(myJTable);
		mySrollPane.setViewportView(myJTable);
		displayMid.add(mySrollPane, BorderLayout.CENTER);
		
		
		//�ײ����
		JButton jbSearch=new JButton("��ѯ");			//���ð�ť
		JButton jbQuit=new JButton("�˳�");
		jbSearch.setFont(new Font("�����п�",1,20));
		jbQuit.setFont(new Font("�����п�",1,20));
		displayDown=new JPanel(new GridLayout(1,9));
		for(int i=0;i<9;i++)
		{
			if(i==3) displayDown.add(jbSearch);
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
		//ΪjbSearch��ť��Ӽ�����
		jbSearch.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String tableName=productBox.getSelectedItem().toString();
				if(tableName.length()==0)//��Ʒ������ʾ��1������Ϣ����
				{
					JOptionPane.showMessageDialog(jifShow, "��ѡ���Ʒ����","��ʾ",1);
					return;
				}
				String productName=pName.getText();
				Pattern pattern=Pattern.compile("^[\\040]*");//���С�\040�ǿո�İ˽���ת���ַ���
				if(pattern.matcher(productName).matches()==true)//��Ʒ������ʾ��
				{
					JOptionPane.showMessageDialog(jifShow, "�������Ʒ����","��ʾ",1);
					return;
				}
				try{
					operate = new Management();
					operate.rs=operate.stmt.executeQuery("select * from "+
												tableName+" where Name='"+productName+"'");
					if(operate.rs.next())
					{
						operate.rs.beforeFirst();
						ResultSetMetaData rsmd=operate.rs.getMetaData();	//�������������
						JTableModel.setRowCount(0);	//���ģ�����������������
						JTableModel.setColumnCount(0);
						int colCount=rsmd.getColumnCount();		//�õ�����
						String[] name=new String[colCount];
						for(int i=1;i<=colCount;i++)	//�õ�����
						{
							name[i-1]=rsmd.getColumnName(i);
							JTableModel.addColumn(name[i-1]);
						}
						while(operate.rs.next())		//�õ����е�����ֵ
						{
							String[] value=new String[colCount];
							for(int i=1;i<=colCount;i++)
								value[i-1]=operate.rs.getString(i);
							JTableModel.addRow(value);
						}
						operate.rs.close();
						JTableModel.setRowCount(JTableModel.getRowCount()+15);
						JTableModel.setColumnCount(JTableModel.getColumnCount()+10);
						JTable resTable=new JTable(JTableModel);
						resTable.setEnabled(true);		//���ñ���ܱ��༭
						resTable.setRowHeight(18);		//�����и�
						resTable.setFillsViewportHeight(true);
						resTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);//�ر��Զ������п�
						mySrollPane.add(resTable);
						mySrollPane.setViewportView(resTable);
					}
					else
					{
						JTable resTable=new JTable(new DefaultTableModel(10,20));
						resTable.setRowHeight(18);		//�����и�
						resTable.setFillsViewportHeight(true);
						resTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);//�ر��Զ������п�
						mySrollPane.add(resTable);
						mySrollPane.setViewportView(resTable);
						JOptionPane.showMessageDialog(jifShow, "�˲�Ʒ������","����",1);
					}
				}catch (ClassNotFoundException e1) {
					JOptionPane.showMessageDialog(jplDisplay, "���ݿ������쳣","����",0);
				}catch(SQLException fault)
				{
					JOptionPane.showMessageDialog(jifShow, "���ݿ�����쳣","����",0);
				}
			}
		});
	}
}