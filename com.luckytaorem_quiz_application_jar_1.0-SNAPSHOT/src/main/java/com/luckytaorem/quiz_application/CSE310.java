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
import java.util.ArrayList;
import java.util.Collections;

public class CSE310 extends JFrame implements ActionListener{
    static JFrame frame;
    static JLabel label,timeleft;
    static JButton button;
    static ButtonGroup group;
    JLabel timerLabel, resultLabel,dlabel;
    JTextArea questionLabel;
    int secondsRemaining;
    JRadioButton option1, option2, option3, option4;
    JButton nextButton, resultButton;
    float score = 0;
    int questionIndex = 0;
    ArrayList<Integer> questionOrder = new ArrayList<Integer>();
    ArrayList<Integer> questionOrder2 = new ArrayList<Integer>();
    ArrayList<Integer> questionOrder3 = new ArrayList<Integer>();
    String[][] questions = {
        {"Number of primitive data types in Java are?:","8", "7", "8", "9", "10"},
        {"What is the size of float and double in java?","32 and 64", "32 and 32", "64 and 64", "32 and 64", "64 and 128"},
        {"Automatic type conversion is possible in which of the possible cases?", "Int to long" ,"Int to long", "Long to int", "Short to int", "Int to short"},
        {"Find the output of the following code.\nint Integer = 24;\nchar String  = ‘I’;\nSystem.out.print(Integer);\nSystem.out.print(String);","24 I","Throws exception","24","24 I"},
        {"Find the output of the following program.\npublic class Solution{\n       public static void main(String[] args){\n                     short x = 10;\n                     x =  x * 5;\n                     System.out.print(x);\n       }\n}","Compile error","10","Compile error","Exception","50"},
        {"Find the output of the following program.\npublic class Solution{\n       public static void main(String[] args){\n                     byte x = 127;\n                     x++;\n                     x++;\n                     System.out.print(x);\n       }\n}","-127","127","129","2","-127"},
        {"Select the valid statement.","char[] ch = new char[5]","char[] ch = new char[5]","char[] ch = new char()","char[] ch = new char[] ","None of These"},
        {"Find the output of the following program.\npublic class Solution{\n       public static void main(String[] args){\n               int[]  x = {120, 200, 016};\n               for(int i = 0; i < x.length; i++){\n                        System.out.print(x[i] + “ “);\n               }                   \n       }\n}","120 200 14","120 200 14","120 200 16","None","120 16 200"},
        {"When an array is passed to a method, what does the method receive?","The reference of the array","A copy of the array","Length of the array","Copy of first element","The reference of the array"},
        {"Select the valid statement to declare and initialize an array.:","int[] A={1,2,3}","int[] A={1,2,3}","int[] A=(1,2,3)","int[][] A={1,2,3}","None"}
    };
    
    String[][] Medium_questions = {
        {"Find the value of A[1] after execution of the following program.\nint[] A = {0,2,4,1,3};\nfor(int i = 0; i < a.length; i++){\n    a[i] = a[(a[i] + 3) % a.length];\n}","1","0","1","2","3"},
        {"Arrays in java are-","Objects","Object references","Objects","Primitive data type","None"},
        {"When is the object created with new keyword?","At run time","At run time","At compile time","Depends on the code","None"},
        {"Identify the corrected definition of a package.","A package is a collection of classes and interfaces","A package is a collection of editing tools","A package is a collection of classes","A package is a collection of classes and interfaces","A package is a collection of interfaces"},
        {"Identify the correct restriction on static methods.\n1.They must access only static data\n2.They can only call other static methods.\n3.They cannot refer to this or super.","I,II,III","I and II","II and III","Only III","I,II,III"},
        {"Identify the keyword among the following that makes a variable belong to a class,rather than being defined for each instance of the class.","static","final","static","volatile","abstract"},
        {"Identify what can directly access and change the value of the variable res.\nPackage com.mypackage;\nPublic class Solution{\n       Private int res = 100;\n}","Only Solution class","Any class","Only Solution class","Any class that extends Solution","None"},
        {"In which of the following is toString() method defined?","java.lang.Object","java.lang.Object","java.lang.String","java.lang.util","None"},
        {"compareTo() returns","An int value","True","False","An int value","None"},
        {"Identify the output of the following program.\nString str = “abcde”;\nSystem.out.println(str.substring(1, 3));","bc","abc","bc","bcd","cd"}
    };
    
    String[][] Hard_questions = {
        {"Identify the output of the following program.\nString str = “Hellow”;\nSystem.out.println(str.indexOf(‘t));","-1","0","1","true","-1"},
        {"Identify the output of the following program.\nPublic class Test{\n          Public static void main(String argos[]){\n                   String str1 = “one”;\n                   String str2 = “two”;\n                   System.out.println(str1.concat(str2));\n          }\n}","onetwo","one","two","onetwo","twoone"},
        {"What does the following string do to given string str1.\nString str1 = “Interviewbit”.replace(‘e’,’s’);","Replaces all occurences of 'e' to 's'","Replaces single occurences of 'e' to 's'","Replaces all occurences of 'e' to 's'","Replaces single occurences of 's' to 'e'","None"},
        {"To which of the following does the class string belong to.","java.lang","java.awt","java.lang","java.applet","java,string"},
        {"How many objects will be created in the following?\nString a = new String(“Interviewbit”);\nString b = new String(“Interviewbit”);\nStrinc c = “Interviewbit”;\nString d = “Interviewbit”;","3","2","3","4","None"},
        {"Total constructor string class have?","13","3","7","13","20"},
        {"Find the output of the following code.\nint ++a = 100;\nSystem.out.println(++a);","Compile error as ++a is not valid identifier","101","Compile error as ++a is not valid identifier","100","None"},
        {"Find the output of the following code.\nif(1 + 1 + 1 + 1 + 1 == 5){\n  System.out.print(“TRUE”);\n}\nelse{\n  System.out.print(“FALSE”);\n}","True","True","False","Compile error","None"},
        {"Find the output of the following code.\nPublic class Solution{\n      Public static void main(String… argos){\n             Int x = 5;\n             x * = (3 + 7);\n             System.out.println(x);","50","50","22","10","None"},
        {"Identify the return type of a method that does not return any value.","void","int","void","double","None"}
    };
    
    Timer timer;
    
    public CSE310(){
        setTitle("Test for CSE310");
        dlabel = new JLabel("Easy");
        dlabel.setForeground(Color.green);
        dlabel.setFont(new Font("Arial", Font.BOLD, 24));
        dlabel.setBounds(830,30,100,50);
        add(dlabel);
        startTimer();
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
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        
        for (int i = 0; i < questions.length; i++) {
            questionOrder.add(i);
        }
        Collections.shuffle(questionOrder);
        
        for (int i = 0; i < Medium_questions.length; i++) {
            questionOrder2.add(i);
        }
        Collections.shuffle(questionOrder2);
        
        for (int i = 0; i < Hard_questions.length; i++) {
            questionOrder3.add(i);
        }
        Collections.shuffle(questionOrder3);
        
        // Add the question label
        questionLabel = new JTextArea(questions[questionOrder.get(questionIndex)][0]);
//        add(questionLabel);
        JScrollPane jsp = new JScrollPane(questionLabel);
        add(jsp);
        
        questionLabel.setFont(new Font("Arial",Font.BOLD,24));
        questionLabel.setEditable(false);
        questionLabel.setLineWrap(true);
        questionLabel.setWrapStyleWord(true);
        questionLabel.setBackground(null);
        jsp.setBounds(50,80,1400,200);
        
        // Add the answer options
        option1 = new JRadioButton(questions[questionOrder.get(questionIndex)][2]);
        option2 = new JRadioButton(questions[questionOrder.get(questionIndex)][3]);
        option3 = new JRadioButton(questions[questionOrder.get(questionIndex)][4]);
        option4 = new JRadioButton(questions[questionOrder.get(questionIndex)][5]);

        group = new ButtonGroup();
        group.add(option1);
        group.add(option2);
        group.add(option3);
        group.add(option4);
        add(option1);
        add(option2);
        add(option3);
        add(option4);
        
        option1.setFont(new Font("Arial",Font.BOLD,24));
        option2.setFont(new Font("Arial",Font.BOLD,24));
        option3.setFont(new Font("Arial",Font.BOLD,24));
        option4.setFont(new Font("Arial",Font.BOLD,24));
        
        option1.setBounds(50,350,1000,30);
        option2.setBounds(50,420,1000,30);
        option3.setBounds(50,490,1000,30);
        option4.setBounds(50,560,1000,30);
        
        // Add the submit and reset buttons
        nextButton = new JButton("Next");
        resultButton = new JButton("See Result");
        nextButton.addActionListener(this);
        resultButton.addActionListener(this);
        
        dlabel = new JLabel("Easy");
//        dlabel.setBackground(Color.green);
//        dlabel.setBounds(500,60,150,50);
        add(dlabel);
        
        add(nextButton);
        add(resultButton);
        resultButton.setVisible(false);
        nextButton.setFont(new Font("Arial",Font.BOLD,24));
        resultButton.setFont(new Font("Arial",Font.BOLD,24));
        nextButton.setBounds(50,630,100,60);
        resultButton.setBounds(50,630,300,60);
        setVisible(true);
        setSize(1980,1080);
    }
    
    public static void quiz(){
        frame = new JFrame("Test for CSE310");
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
            new CSE310();
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
                JOptionPane.showMessageDialog(this,"Correct Answer are "+score);
                System.exit(0);
            }
        });

        timer.start();
    }
    
    public static void main(String[] cse211){
        quiz();
    }
    
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == nextButton) {
            if(score<=2){
                if(option1.isSelected() && option1.getText().equals(questions[questionOrder.get(questionIndex)][1])){
                    score++;
                }else if(option1.isSelected() && option1.getText()!=(questions[questionOrder.get(questionIndex)][1])){
                    score-=0.25;
                }
                if(option2.isSelected() && option2.getText().equals(questions[questionOrder.get(questionIndex)][1])){
                    score++;
                }else if(option2.isSelected() && option2.getText()!=(questions[questionOrder.get(questionIndex)][1])){
                    score-=0.25;
                }
                if(option3.isSelected() && option3.getText().equals(questions[questionOrder.get(questionIndex)][1])){
                    score++;
                }else if(option3.isSelected() && option3.getText()!=(questions[questionOrder.get(questionIndex)][1])){
                    score-=0.25;
                }
                if(option4.isSelected() && option4.getText().equals(questions[questionOrder.get(questionIndex)][1])){
                    score++;
                }else if(option4.isSelected() && option4.getText()!=(questions[questionOrder.get(questionIndex)][1])){
                    score-=0.25;
                }
            }else if(score>2 && score<=9){
                if(option1.isSelected() && option1.getText().equals(Medium_questions[questionOrder2.get(questionIndex)][1])){
                    score+=2;
                }else if(option1.isSelected() && option1.getText()!=(Medium_questions[questionOrder2.get(questionIndex)][1])){
                    score-=0.75;
                }
                if(option2.isSelected() && option2.getText().equals(Medium_questions[questionOrder2.get(questionIndex)][1])){
                    score+=2;
                }else if(option2.isSelected() && option2.getText()!=(Medium_questions[questionOrder2.get(questionIndex)][1])){
                    score-=0.75;
                }
                if(option3.isSelected() && option3.getText().equals(Medium_questions[questionOrder2.get(questionIndex)][1])){
                    score+=2;
                }else if(option3.isSelected() && option3.getText()!=(Medium_questions[questionOrder2.get(questionIndex)][1])){
                    score-=0.75;
                }
                if(option4.isSelected() && option4.getText().equals(Medium_questions[questionOrder2.get(questionIndex)][1])){
                    score+=2;
                }else if(option4.isSelected() && option4.getText()!=(Medium_questions[questionOrder2.get(questionIndex)][1])){
                    score-=0.75;
                }
            }else if(score>10){
                if(option1.isSelected() && option1.getText().equals(Hard_questions[questionOrder3.get(questionIndex)][1])){
                    score+=5;
                }else if(option1.isSelected() && option1.getText()!=(Hard_questions[questionOrder3.get(questionIndex)][1])){
                    score--;
                }
                if(option2.isSelected() && option2.getText().equals(Hard_questions[questionOrder3.get(questionIndex)][1])){
                    score+=5;
                }else if(option2.isSelected() && option2.getText()!=(Hard_questions[questionOrder3.get(questionIndex)][1])){
                    score--;
                }
                if(option3.isSelected() && option3.getText().equals(Hard_questions[questionOrder3.get(questionIndex)][1])){
                    score+=5;
                }else if(option2.isSelected() && option2.getText()!=(Hard_questions[questionOrder3.get(questionIndex)][1])){
                    score--;
                }
                if(option4.isSelected() && option4.getText().equals(Hard_questions[questionOrder3.get(questionIndex)][1])){
                    score+=5;
                }else if(option2.isSelected() && option2.getText()!=(Hard_questions[questionOrder3.get(questionIndex)][1])){
                    score--;
                }
            }
            if(score<=2){
                questionIndex++;
                if(questionIndex >= questions.length-1){
                    group.clearSelection();
                    dlabel.setText("Easy");
                    dlabel.setForeground(Color.green);
                    questionLabel.setText(questions[questionOrder.get(questionIndex)][0]);
                    option1.setText(questions[questionOrder.get(questionIndex)][2]);
                    option2.setText(questions[questionOrder.get(questionIndex)][3]);
                    option3.setText(questions[questionOrder.get(questionIndex)][4]);
                    option4.setText(questions[questionOrder.get(questionIndex)][5]);
                    nextButton.setVisible(false);
                    resultButton.setVisible(true);
                }else {
                    group.clearSelection();
                    dlabel.setText("Easy");
                    dlabel.setForeground(Color.green);
                    questionLabel.setText(questions[questionOrder.get(questionIndex)][0]);
                    option1.setText(questions[questionOrder.get(questionIndex)][2]);
                    option2.setText(questions[questionOrder.get(questionIndex)][3]);
                    option3.setText(questions[questionOrder.get(questionIndex)][4]);
                    option4.setText(questions[questionOrder.get(questionIndex)][5]);
                }
            }else if(score>2 && score<=9){
                questionIndex++;
                if(questionIndex >= questions.length-1){
                    group.clearSelection();
                    dlabel.setText("Medium");
                    dlabel.setForeground(Color.orange);
                    questionLabel.setText(Medium_questions[questionOrder2.get(questionIndex)][0]);
                    option1.setText(Medium_questions[questionOrder2.get(questionIndex)][2]);
                    option2.setText(Medium_questions[questionOrder2.get(questionIndex)][3]);
                    option3.setText(Medium_questions[questionOrder2.get(questionIndex)][4]);
                    option4.setText(Medium_questions[questionOrder2.get(questionIndex)][5]);
                    nextButton.setVisible(false);
                    resultButton.setVisible(true);
                }else {
                    group.clearSelection();
                    dlabel.setText("Medium");
                    dlabel.setForeground(Color.orange);
                    questionLabel.setText(Medium_questions[questionOrder2.get(questionIndex)][0]);
                    option1.setText(Medium_questions[questionOrder2.get(questionIndex)][2]);
                    option2.setText(Medium_questions[questionOrder2.get(questionIndex)][3]);
                    option3.setText(Medium_questions[questionOrder2.get(questionIndex)][4]);
                    option4.setText(Medium_questions[questionOrder2.get(questionIndex)][5]);
                }
            }else if(score>10){
                questionIndex++;
                if(questionIndex >= questions.length-1){
                    group.clearSelection();
                    dlabel.setText("Hard");
                    dlabel.setForeground(Color.red);
                    questionLabel.setText(Hard_questions[questionOrder3.get(questionIndex)][0]);
                    option1.setText(Hard_questions[questionOrder3.get(questionIndex)][2]);
                    option2.setText(Hard_questions[questionOrder3.get(questionIndex)][3]);
                    option3.setText(Hard_questions[questionOrder3.get(questionIndex)][4]);
                    option4.setText(Hard_questions[questionOrder3.get(questionIndex)][5]);
                    nextButton.setVisible(false);
                    resultButton.setVisible(true);
                }else {
                    group.clearSelection();
                    dlabel.setText("Hard");
                    dlabel.setForeground(Color.red);
                    questionLabel.setText(Hard_questions[questionOrder3.get(questionIndex)][0]);
                    option1.setText(Hard_questions[questionOrder3.get(questionIndex)][2]);
                    option2.setText(Hard_questions[questionOrder3.get(questionIndex)][3]);
                    option3.setText(Hard_questions[questionOrder3.get(questionIndex)][4]);
                    option4.setText(Hard_questions[questionOrder3.get(questionIndex)][5]);
                }
            }
            System.out.println(score);
        }else if(e.getSource() == resultButton){
            if(score<=2){
                if(option1.isSelected() && option1.getText().equals(questions[questionOrder.get(questionIndex)][1])){
                    score++;
                }else if(option1.isSelected() && option1.getText()!=(questions[questionOrder.get(questionIndex)][1])){
                    score-=0.25;
                }
                if(option2.isSelected() && option2.getText().equals(questions[questionOrder.get(questionIndex)][1])){
                    score++;
                }else if(option2.isSelected() && option2.getText()!=(questions[questionOrder.get(questionIndex)][1])){
                    score-=0.25;
                }
                if(option3.isSelected() && option3.getText().equals(questions[questionOrder.get(questionIndex)][1])){
                    score++;
                }else if(option3.isSelected() && option3.getText()!=(questions[questionOrder.get(questionIndex)][1])){
                    score-=0.25;
                }
                if(option4.isSelected() && option4.getText().equals(questions[questionOrder.get(questionIndex)][1])){
                    score++;
                }else if(option4.isSelected() && option4.getText()!=(questions[questionOrder.get(questionIndex)][1])){
                    score-=0.25;
                }
            }else if(score>2 && score<=9){
                if(option1.isSelected() && option1.getText().equals(Medium_questions[questionOrder2.get(questionIndex)][1])){
                    score+=2;
                }else if(option1.isSelected() && option1.getText()!=(Medium_questions[questionOrder2.get(questionIndex)][1])){
                    score-=0.75;
                }
                if(option2.isSelected() && option2.getText().equals(Medium_questions[questionOrder2.get(questionIndex)][1])){
                    score+=2;
                }else if(option2.isSelected() && option2.getText()!=(Medium_questions[questionOrder2.get(questionIndex)][1])){
                    score-=0.75;
                }
                if(option3.isSelected() && option3.getText().equals(Medium_questions[questionOrder2.get(questionIndex)][1])){
                    score+=2;
                }else if(option3.isSelected() && option3.getText()!=(Medium_questions[questionOrder2.get(questionIndex)][1])){
                    score-=0.75;
                }
                if(option4.isSelected() && option4.getText().equals(Medium_questions[questionOrder2.get(questionIndex)][1])){
                    score+=2;
                }else if(option4.isSelected() && option4.getText()!=(Medium_questions[questionOrder2.get(questionIndex)][1])){
                    score-=0.75;
                }
            }else if(score>10){
                if(option1.isSelected() && option1.getText().equals(Hard_questions[questionOrder3.get(questionIndex)][1])){
                    score+=5;
                }else if(option1.isSelected() && option1.getText()!=(Hard_questions[questionOrder3.get(questionIndex)][1])){
                    score--;
                }
                if(option2.isSelected() && option2.getText().equals(Hard_questions[questionOrder3.get(questionIndex)][1])){
                    score+=5;
                }else if(option2.isSelected() && option2.getText()!=(Hard_questions[questionOrder3.get(questionIndex)][1])){
                    score--;
                }
                if(option3.isSelected() && option3.getText().equals(Hard_questions[questionOrder3.get(questionIndex)][1])){
                    score+=5;
                }else if(option2.isSelected() && option2.getText()!=(Hard_questions[questionOrder3.get(questionIndex)][1])){
                    score--;
                }
                if(option4.isSelected() && option4.getText().equals(Hard_questions[questionOrder3.get(questionIndex)][1])){
                    score+=5;
                }else if(option2.isSelected() && option2.getText()!=(Hard_questions[questionOrder3.get(questionIndex)][1])){
                    score--;
                }
            }
            System.out.println(score);
                timer.stop();
                option1.setEnabled(false);
                option2.setEnabled(false);
                option3.setEnabled(false);
                option4.setEnabled(false);
                nextButton.setEnabled(false);
                resultButton.setEnabled(false);
                JOptionPane.showMessageDialog(this,"Correct Answer are "+score);
                System.exit(0);
//                this.setVisible(false);
//                Result();
        }
    }
//    void Result(){
//        JFrame rf = new JFrame("Result");
//        rf.setSize(1980,1080);
//        rf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        rf.setLayout(null);
//        rf.setVisible(true);
//        
//    }
}
            
   