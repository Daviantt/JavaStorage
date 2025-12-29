package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Execute extends JFrame{
    Container container = getContentPane();
    
    public Execute(String title){
        super(title);
        Label label = new Label("Hi!");
        container.add(label);
    }

    public static void main (String[] args){
        Execute exe = new Execute("Frame");
        exe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        exe.pack();
        exe.setSize(200, 300);
        exe.setResizable(true);
        exe.setVisible(true);
    }
}
