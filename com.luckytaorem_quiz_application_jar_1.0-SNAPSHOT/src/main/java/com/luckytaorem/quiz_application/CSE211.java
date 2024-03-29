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
        {"Register A:1100 Register B:1010 After applying Selective-Set on the given data, value of register A is:","1110", "1001", "1110", "1011", "1111"},
        {"A digital system has a common bus system for 16 registers of 32 bits each. If the bus constructed using multiplexers, then how many multiplexers are there in the bus?","32", "8", "16", "32", "64"},
        {"Mask logic micro-operation implements which of the following logic gate?", "AND" ,"OR", "AND", "XOR", "NAND"},
        {"Binary adder is constructed using?","Full adder","4 bit Adder","Half adder","Full adder","Sequential circuit"},
        {"The number of bits in the opcode are dependent on:","Total number of operations","Total number of words","Number of bits in a word","Total number of addresses","Total number of operations"},
        {"A group of bits that instructs the computer to perform a specific operation is known as:","Operation Code","Instruction Code","Operation Code","Addressing Mode","None"},
        {"Which type of instruction is represented by the op-code 0111?","Register Reference Instruction","Memory Reference Instruction","Register Reference Instruction","Input-Output Instruction","None of These"},
        {"Which register is used to store the results of any operation?","AC","AR","AC","TR","DR"},
        {"By what timing signal the Memory-Reference Instructions are executed?","T4","T3","T4","T2","T5"},
        {"A computer with large number of instructions is classified as:","CISC","RISC","CISC","Pipeline","None"}
    };
    
    String[][] Medium_questions = {
        {"What is the purpose of the instruction register (IR)?","B. To store the current instruction being executed","A. To store the memory address of the current instruction","B. To store the current instruction being executed","C. To store the data value of the current instruction","D. To store the memory address of the next instruction"},
        {"Which of the following is NOT a characteristic of a RISC processor?","B. Fixed-length instructions","A. Simple instructions","B. Fixed-length instructions","B. Fixed-length instructions","D. Hardwired control"},
        {"Which type of memory is the fastest?","Cache memory","Cache memory","Virtual memory","Secondary memory","ROM"},
        {"What is the purpose of a memory controller?","To manage the flow of data between the CPU and the memory","To manage the flow of data between the CPU and the memory","To manage the flow of data between the input/output devices and the memory","To manage the flow of data between the CPU and the input/output devices","To manage the flow of data between the input/output devices and the CPU"},
        {"Which of the following is NOT a component of the CPU?","Input/output unit (IOU)","Arithmetic logic unit (ALU)","Control unit (CU)","Input/output unit (IOU)","Registers"},
        {"Which of the following is an example of a pipelined processor?","Pentium III","Pentium III","Motorola 68000","ARM Cortex-A9","ARM Cortex-A9"},
        {"Which of the following is NOT a characteristic of a superscalar processor?","Single-issue instructions","Out-of-order execution","Out-of-order execution","Dynamic instruction scheduling","Single-issue instructions"},
        {"What is the purpose of the memory hierarchy?","To provide a balance between fast and slow storage","To provide a small amount of slow storage","To provide a small amount of slow storage","To provide a balance between fast and slow storage","To provide a large amount of slow storage"},
        {"Which of the following is a characteristic of a Harvard architecture?","The CPU and memory have separate buses","The CPU and memory share the same bus","The CPU and memory have separate buses","The CPU has multiple cores","The CPU has a large cache"},
        {"Which of the following is a type of interrupt that occurs when a program executes an illegal instruction or attempts to access an invalid memory address?","Exceptions","Hardware interrupt","Software interrupt","Traps","Exceptions"}
    };
    
    String[][] Hard_questions = {
        {"Which of the following is NOT a common technique for reducing instruction execution time?","D) Interrupts","A) Pipelining","B) Instruction-level parallelism","C) Speculative execution","D) Interrupts"},
        {"Which of the following is NOT a characteristic of a RISC processor?","B) Complex addressing modes","A) Fixed-length instruction format","B) Complex addressing modes","C) Simple instructions","D) Large register file"},
        {"In a two-level cache hierarchy, which cache is typically smaller and faster?","B) L2 cache","A) L1 cache","B) L2 cache","C) Main memory","D) Virtual memory"},
        {"Which of the following is NOT a common addressing mode in a processor's instruction set?","C) Indirect with displacement","A) Immediate","B) Direct","C) Indirect with displacement","D) Indirect with index"},
        {"Which of the following is a potential hazard in pipelined processors?","D) All of the above","A) Resource hazards","B) Structural hazards","C) Data hazards","D) All of the above"},
        {"What is the purpose of the branch target buffer (BTB) in a processor?","A) To predict the target address of a conditional branch instruction","A) To predict the target address of a conditional branch instruction","B) To store the address of the next instruction to be fetched","C) To buffer the result of an ALU operation","D) To store recently used instructions"},
        {"Which of the following is NOT a component of a typical instruction execution cycle?","C) Writeback","A) Fetch","B) Decode","C) Writeback","D) Execute"},
        {"Which of the following cache replacement policies is least likely to cause thrashing?","B) Random","A) Least Recently Used (LRU)","B) Random","C) First-In First-Out (FIFO)","D) Most Recently Used (MRU)"},
        {"What is the purpose of the translation lookaside buffer (TLB) in a computer system?","C) To map virtual addresses to physical addresses","A) To store recently used data","B) To store recently used instructions","C) To map virtual addresses to physical addresses","D) To buffer data in between the processor and memory"},
        {"Which of the following is a potential advantage of using SIMD instructions?","D) All of the above","A) Increased parallelism","B) Reduced instruction count","C) Improved cache utilization","D) All of the above"}
    };
    
    Timer timer;
    
    public CSE211(){
        setTitle("Test for CSE211");
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
        add(questionLabel);
        questionLabel.setFont(new Font("Arial",Font.BOLD,24));
        questionLabel.setEditable(false);
        questionLabel.setLineWrap(true);
        questionLabel.setWrapStyleWord(true);
        questionLabel.setBackground(null);
        questionLabel.setBounds(50,80,1200,50);
        
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
        
        option1.setBounds(50,200,1000,30);
        option2.setBounds(50,270,1000,30);
        option3.setBounds(50,340,1000,30);
        option4.setBounds(50,410,1000,30);
        
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
        nextButton.setBounds(50,480,100,60);
        resultButton.setBounds(50,480,300,60);
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
            
   