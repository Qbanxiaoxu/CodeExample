package chpt10.Ex10_9.SwingPackage;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;

import javax.swing.*;

import chpt10.Ex10_9.MainPackage.Management;
class AdjustListener implements ActionListener
{
	JPanel jplDisplay;
	JInternalFrame jifShow;//显示面板窗口
	JPanel displayUp,displayMid,displayDown;
	Management operate=null;
	public AdjustListener(JPanel jpl)
	{
		this.jplDisplay=jpl;
	}
	public void actionPerformed(ActionEvent e)
	{
		jplDisplay.removeAll();
		jifShow=new JInternalFrame("调整信息面板",true,true,true);
		//顶层面板
		displayUp=new JPanel();
		JLabel jTitle=new JLabel("调整产品价格");
		jTitle.setFont(new Font("华文行楷", 2, 28));
		jTitle.setForeground(Color.BLACK);
		displayUp.add(jTitle);
		displayUp.setBackground(Color.GREEN);
		//中间面板
		displayMid=new JPanel(new GridBagLayout());
		GridBagConstraints myGridBag = new GridBagConstraints();//布局管理对象
		myGridBag.insets = new Insets(10,5,5,5);//设置上下左右填充值
		myGridBag.fill=GridBagConstraints.BOTH;
		myGridBag.gridwidth=2;
		JLabel[] jName=new JLabel[3];
		jName[0]=new JLabel("产品类型");
		jName[1]=new JLabel("调整");
		jName[2]=new JLabel("幅度");
		String[] item1={"","Software","Laptop","DeskTop","Hometheater","Cartheater"};
		String[] item2={"","上升","下降"};
		String[] item3={"","5%","10%","20%","30%","40%","50%","100%"};
		final JComboBox[] jBox=new JComboBox[3];		//设置下拉菜单
		jBox[0]=new JComboBox(item1);
		jBox[1]=new JComboBox(item2);
		jBox[2]=new JComboBox(item3);
		for(int i=0;i<3;i++)
		{
			jName[i].setFont(new Font("宋体",1,20));
			jName[i].setHorizontalAlignment(SwingConstants.RIGHT);
			myGridBag.gridx=2;
			myGridBag.gridy=(2*i-1);
			displayMid.add(jName[i], myGridBag);
			myGridBag.gridx=6;
			displayMid.add(jBox[i], myGridBag);
		}
		displayMid.setBackground(new Color(150,200,150));
		
		//底层面板
		JButton jbStore=new JButton("确定");			//设置按钮
		JButton jbQuit=new JButton("退出");
		jbStore.setFont(new Font("华文行楷",1,20));
		jbQuit.setFont(new Font("华文行楷",1,20));
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
		
		//为jbQuit按钮添加监听器
		jbQuit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				jifShow.dispose();
			}
		});
		//为jbQuit按钮添加监听器
		jbStore.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String tableName=jBox[0].getSelectedItem().toString();
				if(tableName.length()==0)//产品类型提示框，1代表消息类型
				{
					JOptionPane.showMessageDialog(jifShow, "请选择产品类型","提示",1);
					return;
				}
				String adjustType=jBox[1].getSelectedItem().toString();
				if(adjustType.length()==0)//产品类型提示框，1代表消息类型
				{
					JOptionPane.showMessageDialog(jifShow,"请选择调整(上升/下降)","提示",1);
					return;
				}
				String adjustValue=jBox[2].getSelectedItem().toString();
				if(adjustValue.length()==0)//产品类型提示框，1代表消息类型
				{
					JOptionPane.showMessageDialog(jifShow,"请选择调整幅度(百分比)","提示",1);
					return;
				}
				try {
					operate = new Management();
					operate.adjustInf(tableName, adjustType, adjustValue);
					jBox[2].setSelectedIndex(0);
					JOptionPane.showMessageDialog(jifShow,"操作成功","Success",1);
				}catch (ClassNotFoundException e1) {
					JOptionPane.showMessageDialog(jplDisplay, "数据库连接异常","错误",0);
				}catch(SQLException fault) {
					JOptionPane.showMessageDialog(jifShow,"数据库访问异常","错误",2);
				}catch(Exception fault) {
					JOptionPane.showMessageDialog(jifShow,"未知错误！！","异常",3);
				}
			}
		});
	}
}