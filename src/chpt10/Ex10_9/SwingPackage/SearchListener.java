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
	JInternalFrame jifShow;//显示面板窗口
	JPanel displayUp,displayMid,displayDown;
	Management operate=null;
	public SearchListener(JPanel jpl)
	{
		this.jplDisplay=jpl;
	}
	public void actionPerformed(ActionEvent e)
	{
		jplDisplay.removeAll();
		jifShow=new JInternalFrame("查询产品面板",true,true,true);
		//顶层面板
		displayUp=new JPanel();
		JLabel jTitle=new JLabel("查询产品");
		jTitle.setFont(new Font("华文行楷", 2, 28));
		jTitle.setForeground(Color.BLACK);
		displayUp.add(jTitle);
		displayUp.setBackground(Color.GREEN);
		//中间面板
		displayMid=new JPanel(new BorderLayout());		//中间面板的上部
		JLabel[] jName=new JLabel[2];
		String[] sType={"","Software","Laptop","DeskTop","Hometheater","Cartheater"};
		jName[0]=new JLabel("产品类型");
		jName[1]=new JLabel("产品名称");
		final JComboBox productBox=new JComboBox(sType);
		final JTextField pName=new JTextField(12);
		JPanel panelMidUp=new JPanel(new FlowLayout());
		panelMidUp.add(jName[0]);
		panelMidUp.add(productBox);
		panelMidUp.add(jName[1]);
		panelMidUp.add(pName);
		displayMid.add(panelMidUp, BorderLayout.NORTH);
		
		JTable myJTable;		//定义表格，填充中间面板的下部
		final DefaultTableModel JTableModel = new DefaultTableModel(10,20);	//定义表格模板
		myJTable=new JTable(JTableModel);	//用表格模板初始化表格myJTable
		myJTable.setEnabled(true);
		myJTable.setRowHeight(18);
		myJTable.setFillsViewportHeight(true);
		myJTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
//		myJTable.setCellSelectionEnabled(true);			//允许选取单元格
//		myJTable.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);	//允许多选
		final JScrollPane mySrollPane=new JScrollPane();	//滚动面板
		mySrollPane.add(myJTable);
		mySrollPane.setViewportView(myJTable);
		displayMid.add(mySrollPane, BorderLayout.CENTER);
		
		
		//底层面板
		JButton jbSearch=new JButton("查询");			//设置按钮
		JButton jbQuit=new JButton("退出");
		jbSearch.setFont(new Font("华文行楷",1,20));
		jbQuit.setFont(new Font("华文行楷",1,20));
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
		
		//为jbQuit按钮添加监听器
		jbQuit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				jifShow.dispose();
			}
		});
		//为jbSearch按钮添加监听器
		jbSearch.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String tableName=productBox.getSelectedItem().toString();
				if(tableName.length()==0)//产品类型提示框，1代表消息类型
				{
					JOptionPane.showMessageDialog(jifShow, "请选择产品类型","提示",1);
					return;
				}
				String productName=pName.getText();
				Pattern pattern=Pattern.compile("^[\\040]*");//其中‘\040是空格的八进制转义字符’
				if(pattern.matcher(productName).matches()==true)//产品名称提示框
				{
					JOptionPane.showMessageDialog(jifShow, "请输入产品名字","提示",1);
					return;
				}
				try{
					operate = new Management();
					operate.rs=operate.stmt.executeQuery("select * from "+
												tableName+" where Name='"+productName+"'");
					if(operate.rs.next())
					{
						operate.rs.beforeFirst();
						ResultSetMetaData rsmd=operate.rs.getMetaData();	//创建结果集对象
						JTableModel.setRowCount(0);	//表格模板的行数和列数清零
						JTableModel.setColumnCount(0);
						int colCount=rsmd.getColumnCount();		//得到列数
						String[] name=new String[colCount];
						for(int i=1;i<=colCount;i++)	//得到列名
						{
							name[i-1]=rsmd.getColumnName(i);
							JTableModel.addColumn(name[i-1]);
						}
						while(operate.rs.next())		//得到各行的属性值
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
						resTable.setEnabled(true);		//设置表格能被编辑
						resTable.setRowHeight(18);		//设置行高
						resTable.setFillsViewportHeight(true);
						resTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);//关闭自动调节列宽
						mySrollPane.add(resTable);
						mySrollPane.setViewportView(resTable);
					}
					else
					{
						JTable resTable=new JTable(new DefaultTableModel(10,20));
						resTable.setRowHeight(18);		//设置行高
						resTable.setFillsViewportHeight(true);
						resTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);//关闭自动调节列宽
						mySrollPane.add(resTable);
						mySrollPane.setViewportView(resTable);
						JOptionPane.showMessageDialog(jifShow, "此产品不存在","错误",1);
					}
				}catch (ClassNotFoundException e1) {
					JOptionPane.showMessageDialog(jplDisplay, "数据库连接异常","错误",0);
				}catch(SQLException fault)
				{
					JOptionPane.showMessageDialog(jifShow, "数据库访问异常","错误",0);
				}
			}
		});
	}
}