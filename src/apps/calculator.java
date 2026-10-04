package apps;
import utils.Os_res;

import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.time.Duration;
import java.util.concurrent.CountDownLatch;
import javax.swing.*;

public class calculator extends Thread implements ActionListener{

    JFrame APP_frame;
    boolean isOprator=false;
    double input1,input2;
    char oprator_symbol = ' ';
    StringBuilder command = new StringBuilder();
    JButton Calculate_button;
    JButton [] number_buttons;
    JLabel display;
    JPanel Display_panel;
    JPanel buttonPlaceholder;
    JPanel placeholderCanvas;
    JButton clear_button;
    private CountDownLatch windowClosed;

    public calculator(){
        APP_frame = new JFrame("Calculator");
        windowClosed=new CountDownLatch(1);
        Display_panel = new JPanel();
        buttonPlaceholder=new JPanel();
        placeholderCanvas=new JPanel();
        display=new JLabel();
        Calculate_button = new JButton("=");
        number_buttons = new JButton[14];
        clear_button = new JButton("Clear");
        set_buttons();
    }

    @Override
    public void run(){
        APP_frame.setSize(450,550);
        APP_frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        placeholderCanvas.setLayout(null);
        Display_panel.setBackground(Color.black);
        Display_panel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        placeholderCanvas.setBackground(Color.GRAY);


        buttonPlaceholder.setLayout(new GridLayout(4,4));
        for(JButton button : number_buttons){
        buttonPlaceholder.add(button);
        }


        Calculate_button.addActionListener(this);
        clear_button.addActionListener(this);
        Calculate_button.setBackground(Color.ORANGE);
        Calculate_button.setForeground(Color.black);
        clear_button.setBackground(Color.darkGray);
        clear_button.setForeground(Color.white);
        buttonPlaceholder.setSize(200,200);
        display.setForeground(Color.WHITE);
        display.setFont(new Font("Arial",Font.BOLD,25));
        Display_panel.add(display);

        Display_panel.setBounds(20,20,400,100);
        buttonPlaceholder.setBounds(20,140,400,300);
        Calculate_button.setBounds(230,450,200,60);
        clear_button.setBounds(20,450,200,60);
        placeholderCanvas.add(Display_panel);
        placeholderCanvas.add(buttonPlaceholder);
        placeholderCanvas.add(Calculate_button);
        placeholderCanvas.add(clear_button);

        APP_frame.add(placeholderCanvas);
        APP_frame.setResizable(false);

        APP_frame.setVisible(true);

        while(true){
            try {
                sleep(Duration.ofDays(10));
            }catch (InterruptedException e){
                System.out.println("Calculator Terminated....");
//                APP_frame.setVisible(false);
                Os_res.cal = null;
                APP_frame.dispose();
                break;
            }
        }


    }

    private void set_buttons(){
        char [] oprator_symbol = {'+','-','*','/'};
        for(int i=0;i<14;i++){
            if(i<=9){
                number_buttons[i] = new JButton(String.valueOf(i + 1));
            }
            else {
                number_buttons[i] = new JButton(String.valueOf(oprator_symbol[i%10]));
            }
                number_buttons[i].addActionListener(this);
                number_buttons[i].setBorderPainted(false);
                number_buttons[i].setBackground(Color.white);
        }

                number_buttons[9].setText("0");

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        if (command.matches("[0-9]")) {
            display.setText(display.getText() + command);

        }
        else if (e.getSource() == Calculate_button) {
            if (isOprator && !display.getText().isEmpty()) {
                input2 = Double.parseDouble(display.getText());
                isOprator=false;
            switch (oprator_symbol) {
                case '+'->input1 = input1 + input2;
                case '-'->input1 = input1 - input2;
                case '*'->input1 = input1 * input2;
                case '/'->input1 = input1 / input2;
            }
            }
            display.setText(String.valueOf(input1));
        }
        else if (e.getSource() == clear_button) {
            display.setText("");
        }
        else{
                if (!isOprator){
                    oprator_symbol = command.charAt(0);
                    input1 = Double.parseDouble(display.getText());
                    display.setText("");
                    isOprator=true;
                }

        }


    }

}
