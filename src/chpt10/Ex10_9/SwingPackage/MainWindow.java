
package chpt10.Ex10_9.SwingPackage;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.*;

public class MainWindow extends JFrame
{
	
	final int MIN_WIDTH=1200;
	final int MIN_HIGHT=800;
	Point point=new Point(0,0);		//���ڵĵ�ǰ����
	JMenuBar myMenubar;
	JMenu menuFile,menuEdit;
	JMenuItem menuitemExit, menuitemAbout;
	
	Icon iconTitle;
	JButton jbnButtons[];
	JPanel jplTitle,jplDisplay,jplButton;
	
	
	Font f12 = new Font("Times New Roman", 0, 24);
	Font f121 = new Font("Times New Roma28n", 1,24);
	Font fbutton=new Font("�����п�", 1, 24);
	String[] name={"��ʾ��Ʒ","��Ӳ�Ʒ","�����۸�","��ѯ��Ʒ","ɾ����Ϣ"};
	
	/** ����������*/
	public MainWindow()
	{
		this.initComponents();
	}
	private void initComponents()
	{
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//��Ӳ˵���
		menuFile=new JMenu("File");
		menuFile.setFont(f121);
	
		menuitemExit=new JMenuItem("Exit");
		menuitemExit.setFont(f12);
		menuFile.add(menuitemExit);
		
		menuEdit=new JMenu("Help");
		menuEdit.setFont(f121);
	 
		menuitemAbout=new JMenuItem("About...");
		menuitemAbout.setFont(f12);
		menuEdit.add(menuitemAbout);
		
		myMenubar=new JMenuBar();
		myMenubar.add(menuFile);
		myMenubar.add(menuEdit);
		this.setJMenuBar(myMenubar);
		
		//���������ڵ�λ��
		
		this.setMinimumSize(new Dimension(MIN_WIDTH,MIN_HIGHT));
		this.setSize(1200,900);
		this.setTitle("�����̵����ϵͳ");
		this.setLocationRelativeTo(null);//����Ļ���м���ʾ

		final JFrame jfmain=this;
		this.addMouseListener(new MouseListener(){
			public void mouseClicked(MouseEvent e){}	//�����
			public void mouseEntered(MouseEvent e){}	//������
			public void mouseExited(MouseEvent e){}		//����˳�
			public void mouseReleased(MouseEvent e){}	//����ɿ�
			public void mousePressed(MouseEvent e){		//��갴��
				point=e.getPoint();//��ȡ��ǰ�������
			}
		});
		
		//��Ӱ�ť���
		jbnButtons=new JButton[5];		
		for(int i=0;i<jbnButtons.length;i++)
		{
			// set the style of each Jbutton label
			jbnButtons[i]=new JButton(name[i]);
			jbnButtons[i].setFont(fbutton);
			jbnButtons[i].setForeground(Color.BLACK);
		}
		jplButton=new JPanel();		//create the panel to store Button
		jplButton.setBackground(new Color(250,250,240));
		jplButton.setLayout(new GridLayout(9,1));
		for(int i=0;i<9;i++)
		{
			if((i%2)==0)
				jplButton.add(jbnButtons[i/2],BorderLayout.CENTER);
			else
				jplButton.add(new JLabel());
		}
		this.add(jplButton,BorderLayout.WEST);
		
		//�����ʾ���
		
		jplDisplay=new JPanel();
		jplDisplay.setLayout(new BorderLayout());
		jplDisplay.setBackground(new Color(230,230,230));
		this.add(jplDisplay,BorderLayout.CENTER);
		this.pack();
		
		//Ϊ�����Ӽ�����
		jbnButtons[0].addActionListener(new DisplayListener(jplDisplay));
		jbnButtons[1].addActionListener(new AddListener(jplDisplay));
		jbnButtons[2].addActionListener(new AdjustListener(jplDisplay));
		jbnButtons[3].addActionListener(new SearchListener(jplDisplay));	
		jbnButtons[4].addActionListener(new DeleteListener(jplDisplay));
		menuitemExit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				System.exit(0);
			}
		});
	}
}