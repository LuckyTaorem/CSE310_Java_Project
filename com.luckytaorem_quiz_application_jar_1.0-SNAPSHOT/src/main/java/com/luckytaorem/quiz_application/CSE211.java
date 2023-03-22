/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.luckytaorem.quiz_application;

/**
 *
 * @author lucky
 */
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class CSE211 extends JFrame implements ActionListener{
    static JFrame frame;
    static JLabel label,timeleft;
    static JButton button;
    private JLabel timerLabel;
    private int secondsRemaining;
    JRadioButton radioButtons[] = new JRadioButton[5];
    JButton btnNext,btnResult;
    ButtonGroup bg;
    int count = 0, wcount=0, current = 0, x=1,y=1,now=0;
    int m[]= new int[10];
    Timer timer;
    
    public CSE211(String s){
        super(s);
        label = new JLabel();
        startTimer();
        add(label);
        timeleft = new JLabel("Time Left:");
        timeleft.setForeground(Color.RED);
        timeleft.setFont(new Font("Arial", Font.BOLD, 24));
        timeleft.setBounds(620,30,150,50);
        timerLabel = new JLabel("20:00");
        timerLabel.setForeground(Color.RED);
        timerLabel.setFont(new Font("Arial", Font.BOLD, 24));
        timerLabel.setBounds(750,30,100,50);
        add(timeleft);
        add(timerLabel);
       
        bg = new ButtonGroup();
        for(int i=0;i<5;i++){
            radioButtons[i]= new JRadioButton();
            add(radioButtons[i]);
            bg.add(radioButtons[i]);
                       
        }
        btnNext = new JButton("Next");
        btnResult = new JButton("Result");
        btnResult.setVisible(false);
        btnResult.addActionListener(this);
        btnNext.addActionListener(this);
        add(btnNext);
        add(btnResult);
        setData();
        label.setFont(new Font("Arial",Font.BOLD,24));
        label.setBounds(30,40,450,20);
        radioButtons[0].setBounds(50,80,450,20);
        radioButtons[1].setBounds(50,110,200,20);
        radioButtons[2].setBounds(50,140,200,20);
        radioButtons[3].setBounds(50,170,200,20);
        btnNext.setBounds(100,240,100,30);
        btnResult.setBounds(270,240,100,30);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setVisible(true);
        setSize(1980,1080);
    }
    
    void setData(){
        radioButtons[4].setSelected(true);
        if(current==0){
            label.setText("Question 1: Correct Radio Button is A");
            radioButtons[0].setText("A");
            radioButtons[1].setText("B");
            radioButtons[2].setText("C");
            radioButtons[3].setText("D");
        }
        if(current==1){
            label.setText("Question 2: Correct Radio Button is B");
            radioButtons[0].setText("A");
            radioButtons[1].setText("B");
            radioButtons[2].setText("C");
            radioButtons[3].setText("D");
        }
        label.setBounds(30,40,450,20);
        for(int i=0,j=0;i<=90;i+=30,j++){
            radioButtons[j].setBounds(50,80+i,200,20);
        }
    }
    
        boolean checkAns(){
        if(current==0){
            return(radioButtons[0].isSelected());
        }
        if(current==1){
            return(radioButtons[1].isSelected());
        }
        return false;
    }
    
    public static void quiz(){
        frame = new JFrame("Test for CSE211");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        label = new JLabel("<html>"
                + "There will be 10 Questions"
                + "<br>"
                + "Time Limit: 20 minutes"
                + "<br>"
                + "If you keep on giving the correct answer, you will get the harder question"
                + "<br>"
                + "The harder the questions is the more marks you will be able to attempt."
                + "</html>");
        label.setFont(new Font("Serif",Font.BOLD,30));
        button = new JButton("Next");
        button.addActionListener((ActionEvent e) -> {
            frame.setVisible(false);
//            startTimer();
            new CSE211("Test for CSE211");
        });
        label.setBounds(100,50,1980,200);
        button.setBounds(100,250,100,50);
        button.setBorderPainted(false);
        button.setBackground(Color.WHITE);
        button.setFont(new Font("Serif",Font.BOLD,30));
        frame.setSize(1980,1080);
        frame.add(label);
        frame.add(button);
        frame.setLayout(null);
        frame.setVisible(true);
    }
//    public void run(){
//        frame = new JFrame();
//        label = new JLabel();
//        startTimer();
//        frame.add(label);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setLayout(new FlowLayout());
//        timeleft = new JLabel("Time Left:");
//        timeleft.setForeground(Color.RED);
//        timeleft.setFont(new Font("Arial", Font.BOLD, 24));
//        timerLabel = new JLabel("30:00");
//        timerLabel.setForeground(Color.RED);
//        timerLabel.setFont(new Font("Arial", Font.BOLD, 24));
//        frame.add(timeleft);
//        frame.add(timerLabel);
//        frame.setVisible(true);
//        frame.setSize(1980,1080);
//    }
    
    private void startTimer() {
        secondsRemaining = 1200;
        timer = new Timer(1000, e -> {
            secondsRemaining--;
            if (secondsRemaining >= 0) {
                int minutes = secondsRemaining / 60;
                int seconds = secondsRemaining % 60;
                timerLabel.setText(String.format("%02d:%02d", minutes, seconds));
            } else {
                timer.stop();
                timerLabel.setText("Time Up");
                
            }
        });

        timer.start();
    }
    
    public static void main(String[] cse211){
        quiz();
//        new CSE211("test");
    }
    
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btnNext){
            if(checkAns())
                count = count +1;
            if(!checkAns())
                wcount +=1;
               current++;
               setData();
                if(current==1){
                    btnNext.setEnabled(false);
                    btnResult.setVisible(true);
                    btnResult.setText("Result");
                }
        }
            
            if(e.getActionCommand().equals("Result")){
                if(checkAns())
                    count = count +1;
                   current++;
                   timer.stop();
                   JOptionPane.showMessageDialog(this,"Correct Answer are "+count+"\nWrong Answer are "+wcount);
                   System.exit(0);
        }
    }
}
