package chpt10;

//Ex10_6.java
import java.awt.event.*; 
import javax.swing.*; 

public class Ex10_6 implements MouseListener{ //实现MouseListener接口
     JFrame f;  //在构造方法和别的方法中都要使用，所以声明为类属性
     public Ex10_6() //构造方法
     {
        f=new JFrame(); 
        f.setSize(600,400);
        f.setVisible(true);
	    f.addMouseListener(this); //为窗口增加鼠标事件监听器
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //设置关闭窗口则退出程序         
    }
    
     public void mouseClicked(MouseEvent e){  //实现接口的mouseClicked方法
         f.setTitle("点击坐标为 ("+e.getX()+", "+e.getY()+")");//设置窗口标题
     }
     
     public void mousePressed(MouseEvent e) {
         System.out.println ("Mouse pressed (# of clicks: "
                 + e.getClickCount() + ")");
     }
     
     public void mouseReleased(MouseEvent e) {
    	 System.out.println("Mouse released (# of clicks: "
                 + e.getClickCount() + ")");
     }
     
     public void mouseEntered(MouseEvent e) {
         System.out.println("Mouse entered");
     }
     
     public void mouseExited(MouseEvent e) {
    	 System.out.println ("Mouse exited");
     }
     
    public static void main(String[] args){ //主方法，创建Ex10_6类的一个对象
        new Ex10_6();
    }
}
