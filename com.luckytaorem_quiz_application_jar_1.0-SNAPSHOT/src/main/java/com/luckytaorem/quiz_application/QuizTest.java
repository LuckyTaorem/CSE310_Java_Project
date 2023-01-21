/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.luckytaorem.quiz_application;
import javax.swing.JFrame;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
/**
 *
 * @author Taorem
 */
public class QuizTest extends JFrame implements ActionListener{
    
    JLabel label;
    JRadioButton radioButtons[] = new JRadioButton[5];
    JButton btnNext,btnResult;
    ButtonGroup bg;
    int count = 0, current = 0, x=1,y=1,now=0;
    int m[]= new int[10];
    
    
    QuizTest(String s){
        super(s);
        label = new JLabel();
        add(label);
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
        label.setBounds(30,40,450,20);
        radioButtons[0].setBounds(50,80,450,20);
        radioButtons[1].setBounds(50,110,200,20);
        radioButtons[2].setBounds(50,140,200,20);
        radioButtons[3].setBounds(50,170,200,20);
        btnNext.setBounds(100,240,100,30);
        btnResult.setBounds(270,240,100,30);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocation(250,100);
        setVisible(true);
        setSize(600,350);
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
    
    public static void main(String[] args){
        new QuizTest("Testing for Quiz Application");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btnNext){
            if(checkAns())
                count = count +1;
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
                   JOptionPane.showMessageDialog(this,"Correct Answer are "+count);
                   System.exit(0);
        }
    }
}
