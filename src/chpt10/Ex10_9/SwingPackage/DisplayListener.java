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
	JInternalFrame jifShow;//显示结果的面板
	JPanel jplButton;//选择产品类型的面板
	
	public DisplayListener(JPanel jpl)
	{
		this.jplDisplay=jpl;
	}
	public void actionPerformed(ActionEvent e)
	{
		Font fbutton=new Font("宋体", 1, 24);
		
		jplDisplay.removeAll();
		//用于选择产品类型的面板
		jplButton=new JPanel();
		jplButton.setBackground(new Color(250,250,240));
		String[] productName={"Software","Laptop","Desktop","Hometheater","Cartheater"};
		final JComboBox productBox=new JComboBox();		//设置下拉菜单
		productBox.setFont(fbutton);
		productBox.setModel(new DefaultComboBoxModel(productName));
		
		JButton jbSure=new JButton("确定");			//设置按钮
		jbSure.setFont(fbutton);
		
		JButton jbQuit=new JButton("退出");
		jbQuit.setFont(fbutton);
		
		JLabel advise=new JLabel("请选择");
		advise.setFont(new Font("华文行楷", 1, 32));
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
		
		//用于显示结果的面板
		UIManager.put("InternalFrame.titleFont", new java.awt.Font("宋体", 0, 24));
		jifShow=new JInternalFrame("显示面板",true,true,true);	
		
		final JScrollPane jspDisplay=new JScrollPane();	//滚动面板
		jspDisplay.setBackground(Color.WHITE);
		jspDisplay.setVisible(true);
		final DefaultTableModel JTableModel = new DefaultTableModel(15,12);	//定义表格模板
		JTable myFirstTable=new JTable(JTableModel);		//定义表格
		myFirstTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		myFirstTable.setFillsViewportHeight(true);
		myFirstTable.setRowHeight(24);
		jspDisplay.add(myFirstTable);		//添加到显示面板上
		jspDisplay.setViewportView(myFirstTable);
		jifShow.add(jplButton,BorderLayout.EAST);
		jifShow.add(jspDisplay,BorderLayout.CENTER);
		jifShow.setVisible(true);
		jplDisplay.add(jifShow);
		
		//添加监听器
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
					ResultSetMetaData rsmd=operate.rs.getMetaData();	//创建结果集对象
					int colCount=rsmd.getColumnCount();		//得到列数
					String[] name=new String[colCount];
					JTableModel.setRowCount(0);	//表格模板的行数和列数清零
					JTableModel.setColumnCount(0);
					//设置表单头的字体
					UIManager.put("TableHeader.font", new java.awt.Font("宋体", 0,18));
					for(int i=1;i<=colCount;i++)	//得到列名
					{
						name[i-1]=rsmd.getColumnName(i);
						JTableModel.addColumn(name[i-1]);
					}
					operate.rs.beforeFirst();
					while(operate.rs.next())		//得到各行的属性值
					{
						String[] value=new String[colCount];
						for(int i=1;i<=colCount;i++)
							value[i-1]=operate.rs.getString(i);
						JTableModel.addRow(value);
					}
					operate.rs.close();
					JTableModel.setRowCount(JTableModel.getRowCount()+10);
					JTableModel.setColumnCount(JTableModel.getColumnCount()+10);
					myJTable=new JTable(JTableModel);	//用表格模板初始化表格myJTable
					myJTable.setEnabled(true);		//设置表格能被编辑
					myJTable.setRowHeight(24);		//设置行高
					myJTable.setFillsViewportHeight(true);
					myJTable.setFont(new Font("Times New Roman",0,18));
					myJTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);//关闭自动调节列宽
					myJTable.setCellSelectionEnabled(true);			//允许选取单元格
					myJTable.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);	//允许多选
					jspDisplay.add(myJTable);		//添加到显示面板上
					jspDisplay.setViewportView(myJTable);
				} catch (ClassNotFoundException e1) {
					JOptionPane.showMessageDialog(jspDisplay, "数据库连接异常","错误",0);
				}catch(SQLException wrong){
					JOptionPane.showMessageDialog(jspDisplay, "数据库访问异常","错误",0);
				}
			}
		});
	}
}