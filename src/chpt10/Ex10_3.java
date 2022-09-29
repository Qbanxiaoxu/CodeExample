package chpt10;

//Ex10_3.java
import java.awt.Component;
import java.awt.Container;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Ex10_3 {
    public static void addComponentsToPane(Container pane) {
        pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));

        addAButton("Button 1", pane);  //���Button���1
        addAButton("Button 2", pane);  //���Button���2
        addAButton("Button 3", pane);  //���Button���3
        addAButton("Long-Named Button 4", pane); //���Button���4
        addAButton("5", pane);   //���Button���5
    }

    private static void addAButton(String text, Container container) {
        JButton button = new JButton(text);
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        container.add(button);
    }

    public static void main(String[] args) {
    	//����һ����������
        JFrame frame = new JFrame("BoxLayoutDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //�������ݴ���
        addComponentsToPane(frame.getContentPane());

        //��ʾ����
        frame.pack();
        frame.setVisible(true);	
    }
}
