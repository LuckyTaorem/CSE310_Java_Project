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

public class CSE211 extends JFrame implements ActionListener{
    static JFrame frame;
    static JLabel label,timeleft;
    static JButton button;
    JLabel timerLabel, resultLabel;
    JTextArea questionLabel;
    int secondsRemaining;
    JRadioButton option1, option2, option3, option4;
    JButton nextButton, resultButton;
    int score = 0;
    int questionIndex = 0;
    ArrayList<Integer> questionOrder = new ArrayList<Integer>();
    String[][] questions = {
        {"Register A:1100 Register B:1010 After applying Selective-Set on the given data, value of register A is:", "1001", "1110", "1011", "1111"},
        {"A digital system has a common bus system for 16 registers of 32 bits each. If the bus constructed using multiplexers, then how many multiplexers are there in the bus?", "8", "16", "32", "64"},
        {"Mask logic micro-operation implements which of the following logic gate?", "OR", "AND", "XOR", "NAND"},
        {"Binary adder is constructed using?","4 bit Adder","Half adder","Full adder","Sequential circuit"},
        {"The number of bits in the opcode are dependent on:","Total number of words","Number of bits in a word","Total number of addresses","Total number of operations"},
        {"A group of bits that instructs the computer to perform a specific operation is known as:","Instruction Code","Operation Code","Addressing Mode","None"},
        {"Which type of instruction is represented by the op-code 0111?","Memory Reference Instruction","Register Reference Instruction","Input-Output Instruction","None of These"},
        {"Which register is used to store the results of any operation?","AR","AC","TR","DR"},
        {"By what timing signal the Memory-Reference Instructions are executed?","T3","T4","T2","T5"},
        {"A computer with large number of instructions is classified as:","RISC","CISC","Pipeline","None"}
    };
    Timer timer;
    
    public CSE211(){
        setTitle("Test for CSE211");
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
        
        // Add the question label
        questionLabel = new JTextArea(questions[questionOrder.get(questionIndex)][0]);
//        questionLabel = new JTextArea(questions[questionIndex][0]);
        add(questionLabel);
        questionLabel.setFont(new Font("Arial",Font.BOLD,24));
        questionLabel.setEditable(false);
        questionLabel.setLineWrap(true);
        questionLabel.setWrapStyleWord(true);
        questionLabel.setBackground(null);
        questionLabel.setBounds(50,80,1200,50);
        
        // Add the answer options
        option1 = new JRadioButton(questions[questionOrder.get(questionIndex)][1]);
        option2 = new JRadioButton(questions[questionOrder.get(questionIndex)][2]);
        option3 = new JRadioButton(questions[questionOrder.get(questionIndex)][3]);
        option4 = new JRadioButton(questions[questionOrder.get(questionIndex)][4]);

        ButtonGroup group = new ButtonGroup();
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
        
        option1.setBounds(50,200,1000,20);
        option2.setBounds(50,250,1000,20);
        option3.setBounds(50,300,1000,20);
        option4.setBounds(50,350,1000,20);
        
        // Add the submit and reset buttons
        nextButton = new JButton("Next");
        resultButton = new JButton("See Result");
        nextButton.addActionListener(this);
        resultButton.addActionListener(this);
        add(nextButton);
        add(resultButton);
        resultButton.setVisible(false);
        nextButton.setFont(new Font("Arial",Font.BOLD,24));
        resultButton.setFont(new Font("Arial",Font.BOLD,24));
        nextButton.setBounds(50,400,100,60);
        resultButton.setBounds(50,400,300,60);
        setVisible(true);
        setSize(1980,1080);
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
            new CSE211();
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
            // Check the answer
            if(option1.isSelected() && option1.getText().equals("")){
                score++;
            }
            if(option2.isSelected() && option2.getText().equals("1110")||
                    option2.getText().equals("AND")||
                    option2.getText().equals("Operation Code")||
                    option2.getText().equals("Register Reference Instruction")||
                    option2.getText().equals("AC")||
                    option2.getText().equals("T4")||
                    option2.getText().equals("CISC")){
                score++;
            }
            if(option3.isSelected() && option3.getText().equals("32")||
                    option3.getText().equals("Full adder")){
                score++;
            }
            if(option4.isSelected() && option4.getText().equals("Total number of operations")){
                score++;
            }
            
            // Move to the next question
            questionIndex++;
            if(questionIndex >= questions.length-1){
                questionLabel.setText(questions[questionOrder.get(questionIndex)][0]);
                option1.setText(questions[questionOrder.get(questionIndex)][1]);
                option2.setText(questions[questionOrder.get(questionIndex)][2]);
                option3.setText(questions[questionOrder.get(questionIndex)][3]);
                option4.setText(questions[questionOrder.get(questionIndex)][4]);
                nextButton.setVisible(false);
                resultButton.setVisible(true);
            }else {
                // Set up the next question
                questionLabel.setText(questions[questionOrder.get(questionIndex)][0]);
                option1.setText(questions[questionOrder.get(questionIndex)][1]);
                option2.setText(questions[questionOrder.get(questionIndex)][2]);
                option3.setText(questions[questionOrder.get(questionIndex)][3]);
                option4.setText(questions[questionOrder.get(questionIndex)][4]);
            }
        }else if(e.getSource() == resultButton){
            if (option1.isSelected() && option1.getText().equals(questions[questionIndex][1])) {
                score++;
            }
            if (option2.isSelected() && option2.getText().equals(questions[questionIndex][1])) {
                score++;
            }
            if (option3.isSelected() && option3.getText().equals(questions[questionIndex][1])) {
                score++;
            }
            if (option4.isSelected() && option4.getText().equals(questions[questionIndex][1])) {
                score++;
            }
                // Quiz is over
                timer.stop();
                option1.setEnabled(false);
                option2.setEnabled(false);
                option3.setEnabled(false);
                option4.setEnabled(false);
                nextButton.setEnabled(false);
                resultButton.setEnabled(false);
                JOptionPane.showMessageDialog(this,"Correct Answer are "+score);
                System.exit(0);
            
        }
    }
}
            
   