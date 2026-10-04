package apps;

import utils.Os_res;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Duration;
import java.util.Random;


public class RockPaperScissor extends Thread implements ActionListener {
    public int matchCount=0;
    public int WinCount=0;
    JFrame frame;
    JPanel playerPanel,enemyPanel,AnnouncerPanel,buttonPanel,stackPanel;
    JLabel playerlabel,enemylabel,announcerlabel;
    JButton rock,paper,scissor;
    Random enemySystem;

    public RockPaperScissor(){
    frame=new JFrame();

    playerPanel=new JPanel();
    enemyPanel =new JPanel();
    AnnouncerPanel =new JPanel();
    buttonPanel = new JPanel();
    stackPanel = new JPanel();

    playerlabel=new JLabel("player 0");
    enemylabel=new JLabel("enemy 0");
    announcerlabel=new JLabel("Announcer");
    enemySystem=new Random();
    setImageButtons();
    }

    @Override
    public void run(){
        frame.setSize(500,500);
        frame.setResizable(false);
        frame.setLayout(new GridLayout(3,1));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        playerPanel.add(playerlabel);
        playerPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        AnnouncerPanel.add(announcerlabel);
        AnnouncerPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        AnnouncerPanel.setBackground(Color.ORANGE);

        enemyPanel.add(enemylabel);
        enemyPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        enemyPanel.setBackground(Color.GRAY);

        stackPanel.setLayout(new GridLayout(1,2));
        stackPanel.add(playerPanel);
        stackPanel.add(enemyPanel);

        buttonPanel.setLayout(new GridLayout(1,3));
        buttonPanel.add(rock);
        buttonPanel.add(paper);
        buttonPanel.add(scissor);

        frame.add(stackPanel);
        frame.add(AnnouncerPanel);
        frame.add(buttonPanel);


        frame.setVisible(true);
        while(true){
            try {
                sleep(Duration.ofDays(10));
            }catch (InterruptedException e){
                System.out.println("RPS Terminated....");
//                frame.setVisible(false);
                Os_res.rpsG = null;
                frame.dispose();
                break;
            }
        }


    }

    void setImageButtons(){
        rock=new JButton("Rock");
        paper=new JButton("Paper");
        scissor=new JButton("Scissor");

        rock.addActionListener(this);
        paper.addActionListener(this);
        scissor.addActionListener(this);

//        String imgPath="/home/maries/Development/Java/TUX_OS/src/utils/images/";
//        rock.setIcon(new ImageIcon(imgPath + "stone.jpg"));
//        paper.setIcon(new ImageIcon(imgPath + "paper.jpg"));
//        scissor.setIcon(new ImageIcon(imgPath + "scissors.jpeg"));


    }



@Override
    public void actionPerformed(ActionEvent e){
        int enemy_choice = enemySystem.nextInt(3);
        int player_choice=0;
        String []symbols= {"Rock","Paper","Scissor"};

        switch (e.getActionCommand()){
            case "Paper" -> player_choice=1;
            case "Scissor" -> player_choice=2;
        }



    if(player_choice == enemy_choice){
            announcerlabel.setText("Player :"+symbols[player_choice]+" Enemy :"+symbols[enemy_choice]+" Match Draw!!");
        }
        else if(player_choice == 0 && enemy_choice==2){
            announcerlabel.setText("Player :"+symbols[player_choice]+" Enemy :"+symbols[enemy_choice]+" Player WIN!!");
            WinCount++;
        }
        else if(player_choice == 1 && enemy_choice==0){
            announcerlabel.setText("Player :"+symbols[player_choice]+" Enemy :"+symbols[enemy_choice]+" Player WIN!!");
            WinCount++;
        }
        else if(player_choice == 2 && enemy_choice==1){
            announcerlabel.setText("Player :"+symbols[player_choice]+" Enemy :"+symbols[enemy_choice]+" Player WIN!!");
            WinCount++;
        }
        else {
            announcerlabel.setText("Player :"+symbols[player_choice]+" Enemy :"+symbols[enemy_choice]+" Enemy WIN!!");
        }

        matchCount++;

    }


}
