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

public class CSE316 extends JFrame implements ActionListener{
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
        {"Which of the following are CPU scheduling algorithms?","All of the above", "Priority scheduling", "Round Robin", "Shortest Job First", "All od the above"},
        {"Operating Systems","Provides a layer so as to act as a user-friendly interface that enables the programmer to draw a flow chart", "Provides a layer so as to act as a user-friendly interface that enables the programmer to draw a flow chart", "Links the program with subroutines", "Helps to create a flow chart of the programs", "All of these"},
        {"A process which is copied from main memory to secondary memory on the basis of requirement is known as ", "Demand Paging" ,"Demand Paging", "Paging", "Threads", "Segmentation"},
        {"FIFO scheduling is a type of:","Non-Pre-emptive scheduling","Pre-emptive scheduling","Deadline scheduling","Non-Pre-emptive scheduling","None of the above"},
        {"Which of the type of OS reads and reacts in terms of actual time?","Real time OS","Quick sharing OS","Real time OS","Batch OS"},
        {"A systematic procedure for moving the CPU to new process is known as-","Context Switching","Synchronization","Deadlock","Starvation","Context Switching"},
        {"UNIX is written in which language?","C","c++","C","C#",".NET"},
        {"Thread is a","Light weight process","Light weight process","Heavy weight process","Multi process","I/O process"},
        {"OS classifies the threads as-","Kernal and User level","Mainframe and motherboard level","Kernal and User level","Security and Memory level","OS and CPU level"},
        {"Among the following CPU scheduling algorithms, which of these allocated the CPU first to the process that requests the CPU first?","FCFS","FCFS","SJF","Priority scheduling","None"}
    };
    
    String[][] Medium_questions = {
        {"What are the two types of operating modes of AT?","Real mode","Virtual mode, dedicated mode","Private mode, public mode","Real mode, protected mode","Direct mode, indirect mode"},
        {"Which of the following schedules threads?","Operating system","Virtual memory","Operating system","CPU","Input"},
        {"What is meant by ready state of a process?","None of these","When the process is scheduled to run after some execution","When the process currently using the CPU","When the process is dependent of the execution time of some other process","None of these"},
        {"Among the following, which is an example of a spooled device?","A line printer that prints the output of a number of jobs","A line printer that prints the output of a number of jobs","A terminal that inputs user data","A I/O device to display graphics","None"},
        {"Main memory of a computer system is?","Volatile","Non-volatile","Volatile","Restricted","Unrestricted"},
        {"For which of the following purposes in Banker’s algorithm is used?","Preventing deadlock","Preventing deadlock","Solving deadlock","Recover from deadlock","None"},
        {"Device driver required in?","Disk","Register","Main memory","Disk","Cache"},
        {"When are the register context and stack of thread deallocated?","when the thread terminates","when the thread terminates","when the thread blocks","when the thread unblocks","when the thread spawns"},
        {"Threads is not shared among which of the following?","both program counter and stack","stack","program counter","both program counter and stack","none"},
        {"For which of the following is the jacketing technique used?","converting a blocking system call in non blocking system call","to construct a new thread","to communicate between threads","converting a blocking system call in non blocking system call","None"}
    };
    
    String[][] Hard_questions = {
        {"For which of the following is resource sharing used?","All of the mentioned","an application having several threads of activity all within the same address space","share the memory and resources","Compress the address space","All of the mentioned"},
        {"Many to One model is at an advantage in which of the following conditions?","When the program does not need multithreading","When the program needs to be multi-threaded","When there is a single processor present","When the program does not need multithreading","None"},
        {"Identify the system calls that on termination does not return control to the calling point.","exec","exec","fork","longjmp","ioctl"},
        {"Consider the following program:\nmain()\n{\n     if(fork()>0)\nsleep(100);\n}","zombie process","infinite process","orphan process","zombie process","none"},
        {"The output of the following C program is?\nint main(){\n	fork();\n    fork();\n    printf('code');\n}","code code code code","code code code code","code code code","code code","code"},
        {"Identify the call which never returns an error?","getpid","fork","getpid","ioctl","open"},
        {"What of the following defines Thread cancellation?","The process of terminating a thread process before its execution","The process of terminating a thread process before its execution","The process of removing a thread after its work is executed","The process of destroying the thread after its work is executed","none"},
        {"When a thread terminates some target thread immediately, it is known as?","Asynchronous termination","Immediate Termination","Asynchronous termination","Synchronous termination","Deferred cancellation"},
        {"Signals of some given type are","sent together","sent together","queued","stacked","none"},
        {"Which of the following commands in UNIX is used to send a signal?","Kill","send","Kill","sigsend","none"}
};

    
    Timer timer;
    
    public CSE316(){
        setTitle("Test for CSE316");
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
        frame = new JFrame("Test for CSE316");
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
            new CSE316();
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
            
   