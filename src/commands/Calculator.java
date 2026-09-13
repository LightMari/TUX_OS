package commands;
import utils.Os_res;

import javax.swing.*;
import java.awt.*;

import java.util.Scanner;
import java.util.concurrent.CountDownLatch;

public class Calculator extends Thread{
    public static String programName;
    private CountDownLatch windowClosed;
    public Calculator(){
        programName="Calculator";
        windowClosed=new CountDownLatch(1);
    }

    @Override
    public void run() {
        this.display();
    }

    public void display() {

        JFrame frame = new JFrame("Hello World");

        JLabel label = new JLabel("Hello World");

        // Green text
        label.setForeground(Color.GREEN);

        // Center the text
        label.setHorizontalAlignment(SwingConstants.CENTER);

        // Add label to frame
        frame.add(label);

        // Frame settings
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        frame.addWindowListener(new java.awt.event.WindowAdapter(){
            @Override
            public void windowClosed(java.awt.event.WindowEvent e){
                windowClosed.countDown();
            }
        });

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        try {
            windowClosed.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Calculator Terminated....");
    }
}
