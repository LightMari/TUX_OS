package apps;

import utils.Os_res;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Duration;
import java.util.Random;


public class RockPaperScissor extends Thread implements ActionListener {
    public int matchCount=0;
    public int WinCount=0,looseCount=0;
    JFrame frame;
    JPanel playerPanel,enemyPanel,AnnouncerPanel,buttonPanel,stackPanel,wrapperpanel,wrapperpanel2;
    JLabel playerAction,enemyAction,playerlabel,enemylabel,announcerlabel,enemyScoreannouncerlabel,
            playerScoreannouncerlabel,matchCounter;
    JButton rock,paper,scissor;
    Random enemySystem;

    public RockPaperScissor(){
    frame=new JFrame();

    playerPanel=new JPanel();
    enemyPanel =new JPanel();
    AnnouncerPanel =new JPanel();
    buttonPanel = new JPanel();
    stackPanel = new JPanel();

    playerlabel=new JLabel("Player");
    enemylabel=new JLabel("Enemy");

    announcerlabel=new JLabel("!!Get Started !!",SwingConstants.CENTER);
    playerAction=new JLabel("Player Action",SwingConstants.CENTER);
    enemyAction = new JLabel("Enemy Action",SwingConstants.CENTER);
    playerScoreannouncerlabel = new JLabel("0",SwingConstants.CENTER);
    enemyScoreannouncerlabel = new JLabel("0",SwingConstants.CENTER);
    matchCounter=new JLabel("Match Count: 0",SwingConstants.CENTER);
    enemySystem=new Random();
    setImageButtons();
    }

    @Override
    public void run(){
        frame.setSize(500,500);
        frame.setResizable(false);
        frame.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        wrapperpanel=new JPanel(new GridLayout(2,1));
        wrapperpanel2 =new JPanel(new GridLayout(2,1));

        playerPanel.add(playerlabel);
        playerPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        playerScoreannouncerlabel.setBackground(Color.gray);
        playerScoreannouncerlabel.setForeground(Color.white);
        playerScoreannouncerlabel.setOpaque(true);

        enemyScoreannouncerlabel.setBackground(Color.lightGray);
        enemyScoreannouncerlabel.setOpaque(true);
        enemyScoreannouncerlabel.setForeground(Color.darkGray);

        playerAction.setBackground(Color.gray);
        playerAction.setOpaque(true);
        playerAction.setForeground(Color.white);

        enemyAction.setBackground(Color.lightGray);
        enemyAction.setOpaque(true);
        enemyAction.setForeground(Color.darkGray);

        announcerlabel.setBackground(Color.gray);
        announcerlabel.setOpaque(true);

        announcerlabel.setFont(announcerlabel.getFont().deriveFont(24.0f));
        playerAction.setFont(playerAction.getFont().deriveFont(24.0f));
        enemyAction.setFont(enemyAction.getFont().deriveFont(24.0f));

        playerScoreannouncerlabel.setFont(playerScoreannouncerlabel.getFont().deriveFont(22.0f));
        enemyScoreannouncerlabel.setFont(enemyScoreannouncerlabel.getFont().deriveFont(22.0f));

        matchCounter.setFont(matchCounter.getFont().deriveFont(18.0f));


        AnnouncerPanel.setLayout(new GridLayout(3,2));
        AnnouncerPanel.add(playerScoreannouncerlabel);
        AnnouncerPanel.add(enemyScoreannouncerlabel);
        AnnouncerPanel.add(playerAction);
        AnnouncerPanel.add(enemyAction);

        wrapperpanel.add(AnnouncerPanel);
        wrapperpanel2.add(announcerlabel);
        wrapperpanel2.add(matchCounter);
        wrapperpanel.add(wrapperpanel2);

        playerlabel.setFont(playerlabel.getFont().deriveFont(18.0f));
        enemylabel.setFont(enemylabel.getFont().deriveFont(18.0f));
        enemyPanel.add(enemylabel);
        enemyPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        stackPanel.setLayout(new GridLayout(1,2));
        stackPanel.add(playerPanel);
        stackPanel.add(enemyPanel);

        buttonPanel.setLayout(new GridLayout(1,3));
        buttonPanel.add(rock);
        buttonPanel.add(paper);
        buttonPanel.add(scissor);

       wrapperpanel.setBackground(Color.lightGray);
       wrapperpanel.setOpaque(true);

        frame.add(BorderLayout.NORTH,stackPanel);
        frame.add(BorderLayout.CENTER,wrapperpanel);
        frame.add(BorderLayout.WEST,new JPanel());
        frame.add(BorderLayout.EAST,new JPanel());

        frame.add(BorderLayout.SOUTH,buttonPanel);


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

        rock.setBackground(Color.gray);
        rock.setForeground(Color.white);
        rock.setBorderPainted(false);
        rock.setFocusPainted(false);
        rock.setFont(rock.getFont().deriveFont(18.0f));

        paper.setBackground(Color.gray);
        paper.setForeground(Color.white);
        paper.setBorderPainted(false);
        paper.setFocusPainted(false);
        paper.setFont(paper.getFont().deriveFont(18.0f));

        scissor.setBackground(Color.gray);
        scissor.setForeground(Color.white);
        scissor.setBorderPainted(false);
        scissor.setFocusPainted(false);
        scissor.setFont(scissor.getFont().deriveFont(18.0f));

        rock.addActionListener(this);
        paper.addActionListener(this);
        scissor.addActionListener(this);


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

        playerAction.setText(symbols[player_choice]);
        enemyAction.setText(symbols[enemy_choice]);
        announcerlabel.setForeground(Color.green);

        if(player_choice == enemy_choice){
            announcerlabel.setForeground(Color.orange);
            announcerlabel.setText("!! Match Draw !!");
        }
        else if(player_choice == 0 && enemy_choice==2){
            announcerlabel.setText("!! Player WIN !!");
            WinCount++;
        }
        else if(player_choice == 1 && enemy_choice==0){
            announcerlabel.setText("!! Player WIN !!");
            WinCount++;
        }
        else if(player_choice == 2 && enemy_choice==1){
            announcerlabel.setText("!! Player WIN !!");
            WinCount++;
        }
        else {
            announcerlabel.setForeground(Color.red);
            announcerlabel.setText("!! Player LOOSE !!");
            looseCount++;
        }

        matchCount++;
        playerScoreannouncerlabel.setText(WinCount+"");
        enemyScoreannouncerlabel.setText(looseCount+"");
        matchCounter.setText("Match Count: "+matchCount);


    }


}
