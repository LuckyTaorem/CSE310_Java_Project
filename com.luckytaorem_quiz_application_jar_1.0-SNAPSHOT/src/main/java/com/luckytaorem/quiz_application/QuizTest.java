/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 package com.luckytaorem.quiz_application;
//import java.awt.event.*;
import javax.swing.*;
/**
 *
 * @author Taorem
 */
public class QuizTest{
    JFrame frame;
    JLabel label;
    QuizTest(){
//        String[] optionsToChoose = {"CSE211", "CSE310", "CSE316", "CSE408", "INT404","MTH302","PEA305"};
        String[] optionsToChoose = {"CSE211","CSE316", "CSE310", "CSE408"};
        frame = new JFrame("Selection of Subject");
        String getSubject = (String) JOptionPane.showInputDialog(
                null,
                "Select the subject from the dropdown: ",
                "Choose Subject",
                JOptionPane.QUESTION_MESSAGE,
                null,
                optionsToChoose,
                optionsToChoose[0]);

//        System.out.println(getSubject);
        if(getSubject == "CSE211")
            CSE211.quiz();
        else if(getSubject == "CSE310")
            CSE310.quiz();
        else if(getSubject == "CSE408")
            CSE408.quiz();
        else if(getSubject == "CSE316")
            CSE316.quiz();
        
    }
    public static void main(String[] args){
        new QuizTest();
    }
}
