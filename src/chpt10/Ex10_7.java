package chpt10;

//Ex10_7.java
import java.awt.event.*; //����MouseAdapter���ڵİ�
import javax.swing.*;   

public class Ex10_7 extends MouseAdapter{ //Ex10_7��̳�MouseAdapter��������
    JFrame f;
    public Ex10_7(){    
        f=new JFrame();
        f.setSize(600,400);    
        f.setVisible(true);
        f.addMouseListener(this);
        f.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    }
     public void mouseClicked(MouseEvent e){ //�ɼ�ֻҪ��дmouseClicked����
         f.setTitle("�������Ϊ ("+e.getX()+", "+e.getY()+")");
     }
    public static void main(String[] args){
        new Ex10_7();
    }
}
