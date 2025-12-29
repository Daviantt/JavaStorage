package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args){
        JFrame frame = new JFrame("Main Frame");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1366, 768);
        
        JMenuBar menubar = new JMenuBar();
        JMenu filemenu = new JMenu("File");
        JMenuItem openItem = new JMenuItem("Open");
        JMenuItem exitItem = new JMenuItem("Exit");
        filemenu.add(openItem);
        filemenu.addSeparator();
        filemenu.add(exitItem);
        menubar.add(filemenu);

        JPanel panel = new JPanel();
        JButton button = new JButton("Click me");
        panel.add(button);

        button.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                JOptionPane.showMessageDialog(frame, "button clicked");
            }
        });
        
        JPanel newpanel = new JPanel();
        JLabel newlabel = new JLabel("New text");
        newpanel.add(newlabel);

        frame.setLayout(new BorderLayout());
        frame.setJMenuBar(menubar);
        frame.add(panel,BorderLayout.CENTER);
        frame.add(newpanel,BorderLayout.SOUTH);

        frame.setVisible(true);
    }
}
