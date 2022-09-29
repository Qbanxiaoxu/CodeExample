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

        addAButton("Button 1", pane);  //添加Button组件1
        addAButton("Button 2", pane);  //添加Button组件2
        addAButton("Button 3", pane);  //添加Button组件3
        addAButton("Long-Named Button 4", pane); //添加Button组件4
        addAButton("5", pane);   //添加Button组件5
    }

    private static void addAButton(String text, Container container) {
        JButton button = new JButton(text);
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        container.add(button);
    }

    public static void main(String[] args) {
    	//创建一个顶层容器
        JFrame frame = new JFrame("BoxLayoutDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //设置内容窗格
        addComponentsToPane(frame.getContentPane());

        //显示窗口
        frame.pack();
        frame.setVisible(true);	
    }
}
