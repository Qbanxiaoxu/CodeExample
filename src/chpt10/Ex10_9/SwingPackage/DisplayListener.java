package chpt10.Ex10_9.SwingPackage;
import chpt10.Ex10_9.MainPackage.Management;

import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.UIManager;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
class DisplayListener implements ActionListener
{
	JPanel jplDisplay;
	JInternalFrame jifShow;//��ʾ��������
	JPanel jplButton;//ѡ���Ʒ���͵����
	
	public DisplayListener(JPanel jpl)
	{
		this.jplDisplay=jpl;
	}
	public void actionPerformed(ActionEvent e)
	{
		Font fbutton=new Font("����", 1, 24);
		
		jplDisplay.removeAll();
		//����ѡ���Ʒ���͵����
		jplButton=new JPanel();
		jplButton.setBackground(new Color(250,250,240));
		String[] productName={"Software","Laptop","Desktop","Hometheater","Cartheater"};
		final JComboBox productBox=new JComboBox();		//���������˵�
		productBox.setFont(fbutton);
		productBox.setModel(new DefaultComboBoxModel(productName));
		
		JButton jbSure=new JButton("ȷ��");			//���ð�ť
		jbSure.setFont(fbutton);
		
		JButton jbQuit=new JButton("�˳�");
		jbQuit.setFont(fbutton);
		
		JLabel advise=new JLabel("��ѡ��");
		advise.setFont(new Font("�����п�", 1, 32));
		advise.setForeground(Color.BLACK);
		jplButton.setLayout(new GridLayout(12,1));
		for(int i=0;i<12;i++)
		{
			switch(i)
			{
			case 0:jplButton.add(advise,BorderLayout.CENTER);break;
			case 1:jplButton.add(productBox,BorderLayout.CENTER);break;
			case 10:jplButton.add(jbSure,BorderLayout.CENTER);break;
			case 11:jplButton.add(jbQuit,BorderLayout.CENTER);break;
			default:jplButton.add(new JLabel());
			}
		}
		jplButton.setVisible(true);
		
		//������ʾ��������
		UIManager.put("InternalFrame.titleFont", new java.awt.Font("����", 0, 24));
		jifShow=new JInternalFrame("��ʾ���",true,true,true);	
		
		final JScrollPane jspDisplay=new JScrollPane();	//�������
		jspDisplay.setBackground(Color.WHITE);
		jspDisplay.setVisible(true);
		final DefaultTableModel JTableModel = new DefaultTableModel(15,12);	//������ģ��
		JTable myFirstTable=new JTable(JTableModel);		//������
		myFirstTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		myFirstTable.setFillsViewportHeight(true);
		myFirstTable.setRowHeight(24);
		jspDisplay.add(myFirstTable);		//��ӵ���ʾ�����
		jspDisplay.setViewportView(myFirstTable);
		jifShow.add(jplButton,BorderLayout.EAST);
		jifShow.add(jspDisplay,BorderLayout.CENTER);
		jifShow.setVisible(true);
		jplDisplay.add(jifShow);
		
		//��Ӽ�����
		jbQuit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				jifShow.dispose();
			}
		});
		jbSure.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				Management operate = null;
				JTable myJTable;
				String productName=productBox.getSelectedItem().toString();
				try{
					operate = new Management();
					operate.display(productName);
					ResultSetMetaData rsmd=operate.rs.getMetaData();	//�������������
					int colCount=rsmd.getColumnCount();		//�õ�����
					String[] name=new String[colCount];
					JTableModel.setRowCount(0);	//���ģ�����������������
					JTableModel.setColumnCount(0);
					//���ñ�ͷ������
					UIManager.put("TableHeader.font", new java.awt.Font("����", 0,18));
					for(int i=1;i<=colCount;i++)	//�õ�����
					{
						name[i-1]=rsmd.getColumnName(i);
						JTableModel.addColumn(name[i-1]);
					}
					operate.rs.beforeFirst();
					while(operate.rs.next())		//�õ����е�����ֵ
					{
						String[] value=new String[colCount];
						for(int i=1;i<=colCount;i++)
							value[i-1]=operate.rs.getString(i);
						JTableModel.addRow(value);
					}
					operate.rs.close();
					JTableModel.setRowCount(JTableModel.getRowCount()+10);
					JTableModel.setColumnCount(JTableModel.getColumnCount()+10);
					myJTable=new JTable(JTableModel);	//�ñ��ģ���ʼ�����myJTable
					myJTable.setEnabled(true);		//���ñ���ܱ��༭
					myJTable.setRowHeight(24);		//�����и�
					myJTable.setFillsViewportHeight(true);
					myJTable.setFont(new Font("Times New Roman",0,18));
					myJTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);//�ر��Զ������п�
					myJTable.setCellSelectionEnabled(true);			//����ѡȡ��Ԫ��
					myJTable.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);	//�����ѡ
					jspDisplay.add(myJTable);		//��ӵ���ʾ�����
					jspDisplay.setViewportView(myJTable);
				} catch (ClassNotFoundException e1) {
					JOptionPane.showMessageDialog(jspDisplay, "���ݿ������쳣","����",0);
				}catch(SQLException wrong){
					JOptionPane.showMessageDialog(jspDisplay, "���ݿ�����쳣","����",0);
				}
			}
		});
	}
}