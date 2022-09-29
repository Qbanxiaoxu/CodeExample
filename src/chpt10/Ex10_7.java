package chpt10;

//Ex10_7.java
import java.awt.event.*; //载入MouseAdapter所在的包
import javax.swing.*;   

public class Ex10_7 extends MouseAdapter{ //Ex10_7类继承MouseAdapter适配器类
    JFrame f;
    public Ex10_7(){    
        f=new JFrame();
        f.setSize(600,400);    
        f.setVisible(true);
        f.addMouseListener(this);
        f.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    }
     public void mouseClicked(MouseEvent e){ //可见只要重写mouseClicked方法
         f.setTitle("点击坐标为 ("+e.getX()+", "+e.getY()+")");
     }
    public static void main(String[] args){
        new Ex10_7();
    }
}
