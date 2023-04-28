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

public class CSE408 extends JFrame implements ActionListener{
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
        {"Dijkstra’s algorithm is used to solve __________  problems?","Single source shortest path", "Network lock", "Single source shortest path", "All pair shortest path", "Sorting"},
        {"The Bellmann Ford Algorithm returns __________  value?","Boolean", "String", "Boolean", "Double", "Integer"},
        {"Which of the following is used for solving the N Queens Problem?", "Backtracking" ,"Greedy algorithm", "Dynamic programming", "Backtracking", "Sorting"},
        {"Which of the following statements is true about AVL Trees?","All of the above","The difference between the heights of left and right nodes cannot be more than one","The height of an AVL Tree always remains of the order of O(logn)","AVL Trees are a type of self-balancing Binary Search Trees","All of the above"},
        {"Representation of data structure in memory is known as?","Abstract Data Type","Storage structure","File structure","Recursive","Abstract Data Type"},
        {"In what time complexity can we find the diameter of a binary tree optimally?","O(V+E)","O(V+E)","O(V)","O(E)","O(V*logE)"},
        {"To main measures of the efficiency of an algorithm are?","Time and space complexity","Time and space complexity","Data and Space","Processor and memory","Complexity and capacity"},
        {"Which of the following sorting algorithms provide the best time complexity in the worst-case scenario?","Merge sort","Merge sort","Quick Sort","Bubble Sort","Selection Sort"},
        {"Which of the following is a Divide and Conquer algorithm?","Merge Sort","Merge Sort","Bubble Sort","Heap Sort","Merge Sort"},
        {"Which of the following data structure is used to perform recursion?","Queue","Linked List","Array","Queue","Stack"}
    };
    
    String[][] Medium_questions = {
        {"Identify the best case time complexity of selection sort?","O(n^2)","O(nlogn)","O(n^2)","O(n)","O(1)"},
        {"Another name of the fractional knapsack is?","Continuous Knapsack Problem","Non-continous knapsack problem","Divisible knapsack problem","0/1 knapsack problem","Continous Knapsack Problem"},
        {"Identify the approach followed in Floyd Warshall’s algorithm?","Dynamic Programming","Linear programming","Dynamic Programming","Greedy Technique","Backtracking"},
        {"Hamiltonian path problem is _________?","NP-complete  problem","NP problem","P class problem","NP-complete problem","N class problem"},
        {"What is the time complexity of the following code snippet in C++?\nvoid solve() {\n    string s = 'scaler';\n    int n = s.size();\n    for(int i = 0; i < n; i++) {\n        s = s + s[i];\n    }\n    cout << s << endl;\n}","O(n^2)","O(n)","O(n^2)","O(1)","O(log n)"},
        {"When a pop() operation is called on an empty queue, what is the condition called?","Underflow","Overflow","Underflow","Syntax Error","Garbage value"},
        {"What is the time complexity of the binary search algorithm?","O(log2n)","O(n)","O(1)","O(log2n)","O(n^2)"},
        {"What will be the best sorting algorithm, given that the array elements are small (<= 1e6)?","Counting Sort","Bubble Sort","Merge Sort","Counting Sort","Heap Sort"},
        {"What is the time complexity of the Sieve of Eratosthenes to check if a number is prime?","O(nlog(logn))Precomputation,O(1) for check.","O(nlog(logn))Precomputation,O(1) for check.","O(n) Precomputation, O(1) for the check","O(n*logn) Precomputation, O(logn) for check","O(n) Precomputation, O(logn) for check"},
        {"The worst-case time complexity of Quicksort is?","O(n^2)","O(n)","O(1)","O(log2n)","O(n^2)"}
    };
    
    String[][] Hard_questions = {
        {"What is the technique called in which it does not require extra memory for carrying out the sorting procedure?","In-place","Stable","Unstable","In-place","In-partition"},
        {"Identify the slowest sorting technique among the following?","Bubble Sort","Merge Sort","Quick Sort","Bubble Sort","Selection Sort"},
        {"Select the correct recurrence relation for Tower of Hanoi?","T(N)=2T(N-1)+1","T(N)=2T(N-1)+1","T(N)=2T(N/2)+1","T(N)=2T(N-1)+N","T(N)=2T(N-2)+2"},
        {"Identify the sorting technique which compares adjacent elements in a list and switches whenever necessary?","Bubble Sort","Merge Sort","Quick Sort","Bubble Sort","Selection Sort"},
        {"Among the following options which is the best sorting algorithm when the list is already sorted?","Insertion Sort","Merge Sort","Insertion Sort","Bubble Sort","Selection Sort"},
        {"What is the best case time complexity of the binary search algorithm?","O(1)","O(1)","O(n)","O(log2n)","O(n^2)"},
        {"Which of the following algorithms are used to find the shortest path from a source node to all other nodes in a weighted graph?","Dijkstra's Algorithm","BFS","Dijkstra's Algorithm","Prims Algorithm","Kruskal's Algorithm"},
        {"Which of the following are applications of Topological Sort of a graph?","Sentence Ordering","Course Scheduling","Sentence Ordering","OS Deadlock Detection","All of the above"},
        {"What is the time complexity in decreasing the node value in a binomial heap?","O(logN)","O(1)","O(N)","O(logN)","O(NlogN)"},
        {"An algorithm is __________?","A procedure for solving a problem","A problem","A procedure for solving a problem","A real-life mathematical problem","None of the above"}
    };
    
    Timer timer;
    
    public CSE408(){
        setTitle("Test for CSE408");
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
        frame = new JFrame("Test for CSE408");
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
            new CSE408();
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
            
   