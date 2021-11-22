/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructureshw2;

import java.util.Arrays;

/**
 *
 * @author Veteran
 */
public class DataStructuresHW2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int[] arr = {-1, 2,34,5,7,0, -9, -5};
        Stack stack1 = new Stack(arr.length);
        for(int elm : arr)
            stack1.push(elm);
        
        
        
        Questions answers = new Questions();
        //q1
        System.out.println("Question 1:");
        stack1.dumpStack();
        stack1 = answers.question1(stack1);
        stack1.dumpStack();
        
        
        //q2
        System.out.println("Question 2:");
        NewQueueUsing2Stacks queueQuestion2 = new NewQueueUsing2Stacks(arr.length);
        for(int elm : arr)
            queueQuestion2.enqueue(elm);
        System.out.println(queueQuestion2.dequeue());
        System.out.println(queueQuestion2.dequeue());
        System.out.println(queueQuestion2.dequeue());
        
        //q3
        System.out.println("Question 3:");
        String s = "This is a test string .  and my duty calls .";
        //String s = "data structure";
        System.out.println(answers.question3(s));
        
        //q4
        System.out.println("Question 4:");
        Stack stack2 = new Stack(arr.length);
        for(int elm : arr)
            stack2.push(elm);
        stack1.dumpStack();
        stack2 = answers.question4(stack2);
        stack2.dumpStack();
        
        //q5
        System.out.println("Question 5:");
        s = "((ds981((ilam university))))(((((((((data structure)))";
        System.out.println("valid Brackets count:"+answers.question5(s));
        
        //q6
        System.out.println("Question 6:");
        s = "()))(((";
        System.out.println("min needed Brackets count:"+answers.question6(s));
        
        
        //q7
        System.out.println("Question 7:");
        int[] arrQ7 = {15, 27, 14, 38, 63, 55, 46, 45, 85, 63, 55, 46,85};
        System.out.println("result :"+answers.question7(arrQ7));
        
        //q8
        System.out.println("Question 8:");
        int[] arrQ8 = {-1,99,54,2,10,0,-9,-15,43,65};
        Queue q1 = new Queue(arrQ8.length);
        for (int i : arrQ8) {
            q1.enqueue(i);
        }
        q1.dumpQueue();
        Queue q2 = answers.question8(q1);
        q2.dumpQueue();
        
        //q9
        System.out.println("Question 9:");
        int[] arrQ9 = {-1,99,54,2,10,0,-9,-15,43,65};
        q1 = new Queue(arrQ9.length);
        for (int i : arrQ9) {
            q1.enqueue(i);
        }
        q1.dumpQueue();
        q2 = answers.question9(q1);
        q2.dumpQueue();
        
        while(!q2.isEmpty()){
            System.out.print(q2.dequeue() + "\t");
        }
    
        
        //q10
        System.out.println("");
        System.out.println("Question 10:");
        int[] arrQ10 = {-1,99,54,2,10,0,-9,-15,43,65};
        q1 = new Queue(arrQ10.length);
        for (int i : arrQ10) {
            q1.enqueue(i);
        }
        q1.dumpQueue();
        q2 = answers.question10(q1);
        q2.dumpQueue();
    
        //q11
        System.out.println("Question 11:");
        int[] arrQ11 = {1,34,2,90,-5,-3,-19,91,67,0,1,-3};
        System.out.println(Arrays.toString(arrQ11));
        int[] arrResult = answers.question11(arrQ11);
        System.out.println(Arrays.toString(arrResult));
        
        
        //q12
        System.out.println("Question 12:");
        s = "2 4 + 4 6 + *"; // 60
        //s = "25 12 5 - * 3 / 21 0 / +";// exception
        //s = "25 12 5 - * 3 / 21 9 / +";// 60.66
        try {
            System.out.println(answers.question12(s));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
    }
    
}
