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
	JInternalFrame jifShow;//添加产品面板窗口
	JPanel displayUp,displayMid,displayDown;
	Management operate=null;
	public AddListener(JPanel jpl)
	{
		this.jplDisplay=jpl;
	}
	public void actionPerformed(ActionEvent e)
	{
		jplDisplay.removeAll();
		jifShow=new JInternalFrame("添加产品面板",true,true,true);
		jifShow.setDefaultCloseOperation(JInternalFrame.DISPOSE_ON_CLOSE);
		//顶层面板
		displayUp=new JPanel(new GridBagLayout());
		String[] productName={"","Software","Laptop","Desktop","Hometheater","Cartheater"};
		final JComboBox productBox=new JComboBox(productName);		//设置下拉菜单
		productBox.setName("类型");
		JLabel jCate=new JLabel("类型");
		JLabel jName=new JLabel("产品名");
		JLabel jPrice=new JLabel("价格");
		JLabel jDescription=new JLabel("说明");
		final JTextField pName=new JTextField(12);
		final JTextField pPrice=new JTextField(12);
		final JTextField pDescription=new JTextField(12);
		//设置组件的布局
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
		
		//中间面板
		displayMid=new JPanel(new GridBagLayout());
		final int colNum=15;
		final String[] name=new String[colNum];	
		final JTextField[] columnValue=new JTextField[colNum];	//存放对应的值
		for(int i=0;i<colNum;i++)
		{	name[i]=null;columnValue[i]=null;}
		String[] sTF={"","True","False"};
		final JComboBox removableJCB=new JComboBox(sTF);
		
		/*为productBox添加监听器*/
		productBox.addItemListener(new ItemListener(){
			public void itemStateChanged(ItemEvent e) {
				String productName=productBox.getSelectedItem().toString();//得到产品类型名
				if(e.getStateChange()==ItemEvent.DESELECTED)	//判断下拉菜单的事件ItemEvent.DESELECTED
					return;
				displayMid.removeAll();
				if(productName.length()==0)		//判断菜单项是否为空值
				{
					jplDisplay.add(jifShow);return;
				}
				for(int i=0;i<colNum;i++)
				{
					name[i]=null;
					columnValue[i]=null;
				}
				try{	//更具数据库中内容，为中间面板布局
					operate = new Management();
					operate.display(productName);	//调用函数并连接数据库
					ResultSetMetaData rsmd=operate.rs.getMetaData();	//创建结果集对象
					int colCount=rsmd.getColumnCount();		//得到列数
					for(int i=1;i<=colCount;i++)	//得到列名
					{
						name[i-1]=rsmd.getColumnName(i);
					}
					operate.rs.close();
					GridBagConstraints gridBagCon02 = new GridBagConstraints();//布局管理对象
					gridBagCon02.insets = new Insets(10,5,5,5);//设置上下左右填充值
					gridBagCon02.fill = GridBagConstraints.BOTH;//设置对象是否填满区域
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
					displayMid.setVisible(true);	//设置可见性
					jifShow.add(displayMid,BorderLayout.CENTER);
					jplDisplay.add(jifShow);		//添加对象
				}catch (ClassNotFoundException e1) {
					JOptionPane.showMessageDialog(jplDisplay, "数据库连接异常","错误",0);
				}catch(SQLException wrong){
					JOptionPane.showMessageDialog(jifShow, "数据库访问异常","错误",0);
				}
			}
		});
		//底层面板
		JButton jbStore=new JButton("保存");			//设置按钮
		JButton jbReset=new JButton("清除");
		JButton jbQuit=new JButton("退出");
		displayDown=new JPanel(new FlowLayout());
		displayDown.add(jbStore);
		displayDown.add(jbReset);
		displayDown.add(jbQuit);
		displayDown.setBackground(Color.BLACK);
		
		jifShow.add(displayUp,BorderLayout.NORTH);
		jifShow.add(displayDown,BorderLayout.SOUTH);
		jifShow.setVisible(true);
		jplDisplay.add(jifShow);
		//为jbQuit按钮添加监听器
		jbQuit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				jifShow.dispose();
			}
		});
		//为jbReset按钮添加监听器
		jbReset.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				productBox.setSelectedIndex(0);
				pName.setText(null);
				pPrice.setText(null);
				pDescription.setText(null);
			}
		});
		//为jbStore按钮添加监听器
		jbStore.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String tableName=productBox.getSelectedItem().toString();
				if(tableName.length()==0)//产品类型提示框，1代表消息类型
				{
					JOptionPane.showMessageDialog(jifShow, "请选择产品类型","提示", 1);
					return;
				}
				String productName=pName.getText();
				Pattern pattern=Pattern.compile("^[\\040]*");//其中‘\040是空格的八进制转义字符’
				if(pattern.matcher(productName).matches()==true)//产品名称提示框
				{
					JOptionPane.showMessageDialog(jifShow, "请输入产品名字","提示", 1);
					return;
				}
				String productPrice=pPrice.getText();
				pattern=Pattern.compile("^\\d+(\\.\\d+)*$");	//利用正则表达式
				if(pattern.matcher(productPrice).matches()==false)//产品价格提示框
				{
					JOptionPane.showMessageDialog(jifShow, "请输入正确的产品价格","警告", 2);
					return;
				}
				String productDes=pDescription.getText();
				pattern=Pattern.compile("^[\\040]*");
				if(pattern.matcher(productDes).matches()==true)//产品描述提示框
				{
					JOptionPane.showMessageDialog(jifShow, "请输入产品的描述","提示", 1);
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
				try {		/*调用函数，向数据库添加数据*/
					operate = new Management();
					operate.addition(dbTableName, tableValue);
					JOptionPane.showMessageDialog(jifShow, "添加信息成功","Successful", 1);
				}catch(ClassNotFoundException e2){
					JOptionPane.showMessageDialog(jifShow, "数据库连接异常","警告", 2);
				}catch (SQLException e1) {
					JOptionPane.showMessageDialog(jifShow, "数据库插入异常","警告", 2);
				}catch(Exception e3){
					JOptionPane.showMessageDialog(jifShow, "请输入合法的数据","警告", 2);
				}finally{
					Management.maxId--;
				}
			}
		});
	}
	

}