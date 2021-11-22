/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructureshw2;

/**
 *
 * @author Veteran
 */
public class Questions {
    
    /**
     * This method will sort your given stack using
     * 2 other stacks.
     * The algorithm is simple, find min value of given
     * stack and push it to third stack then refill the
     * first stack. 
     * @param s
     * @return Sorted Stack
     * 
     */
    public Stack question1(Stack s)
    {
        //declare 3 stacks
        Stack s1 = new Stack(s.size());
        Stack s2 = new Stack(s.size());
        Stack s3 = new Stack(s.size());
        
        //fill the first stack from source stack
        while(!s.isEmpty())
            s1.push(s.pop());
        
        //check if first stack has more than 1 element or not
        if(s1.size() >= 2)
        {
            //Beginning of sorting
            while(!s1.isEmpty()){
                //find min value of first stack
                int min = (int)s1.peek();
                int i =0;
                while(!s1.isEmpty())
                {
                    int temp = (int) s1.pop();
                    if(temp <= min)
                        min = temp;
                    s2.push(temp);
                }
                //push min value to third stack
                s3.push(min);
                //refill the first stack
                while(!s2.isEmpty())
                {
                    int temp = (int) s2.pop();
                    //push all elments of second stack except the first occurnace of min value
                    if(temp!=min || i>0){
                        s1.push(temp);
                    }
                    if(temp==min) i++;
                }
            }
            //end of sorting
            
            //move elements from third stack to first stack
            while(!s3.isEmpty())
                s1.push(s3.pop());
        }
//        else
//            System.out.println("stack has one element or stack is empty.");
//        
        return s1;
    }
    
    /**
     * This method reverse words (substrings split by spaces)
     * using stacks, the algorithm is simple, split the given string by space
     * and push the chars one bye one and then pop all elms and create new string.
     * @param str
     * @return partially reversed string
     */
    public String question3(String str)
    {
        String res = "";
        Stack s1 = new Stack(str.length());
        String[] parts = str.split("\\s");
        int j=0;
        for(String p : parts){
            for (int i = 0; i < p.length(); i++) {
                s1.push(p.charAt(i));
                j++;
            }
            while(!s1.isEmpty())
                res += (char)s1.pop();
            j++;
            if(j<str.length()) res+=str.charAt(j-1);
        }
        
        
        return res;
    }
    
    /**
     * This method sorts given stack s, the algorithm is, get the top elm of source stack
     * and compare it with auxiliary stack if it was less than top elm of second stack
     * it will get pushed to second stack, otherwise you must move elms of second stack to source stack
     * until you get to suitable condition.
     * @param s
     * @return sorted stack
     */
    public Stack question4(Stack s)
    {
        Stack tempStack = new Stack(s.size());
        
        while(!s.isEmpty())
        {
            int temp = (int)s.pop();
            
            while(!tempStack.isEmpty() && (int)tempStack.peek() > temp)
            {
                s.push(tempStack.pop());
            }
            
            tempStack.push(temp);
        }
        
        return tempStack;
    }
    
    /**
     * This method will count valid brackets, the algorithm is simple,
     * if you see '(' push it into the stack otherwise when you see ')'
     * there is 2 state, the top elm of stack is '(' which makes a valid bracket,
     * or the top elm of stack is ')' which you simple push an other ')' to it.
     * @param str
     * @return valid brackets count
     */
    public int question5(String str){
        int validBrackets = 0;
        Stack bStack = new Stack(str.length());
        
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == '(')
                bStack.push('(');
            else if(str.charAt(i) == ')'){
                if(!bStack.isEmpty() && (char)bStack.peek() == '(')
                {
                    validBrackets++;
                    bStack.pop();
                }
                else
                    bStack.push(')');
            }
        }
        
        return validBrackets;
    }

    /**
     * This method will calculate the count of min brackets needed to add to string
     * to make it valid.
     * algorithm is quit simple, if you see '(' push it into the stack otherwise when you see ')'
     * there is 2 state, the top elm of stack is '(' which makes a valid bracket,
     * or the top elm of stack is ')' which you simple push an other ')' to it.
     * at the end return the stack elms count. 
     * @param str
     * @return minimum count of brackets to make string valid
     */
    public int question6(String str)
    {
        Stack bStack = new Stack(str.length());
        
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == '(')
                bStack.push('(');
            else if(str.charAt(i) == ')'){
                if(!bStack.isEmpty() && (char)bStack.peek() == '(')
                {
                    bStack.pop();
                }
                else
                    bStack.push(')');
            }
        }
        
        return bStack.size();
    }
    
    /**
     * This method will find the longest decreasing sub array length.
     * for every elm of array you need to count the next elms until it is not
     * more than your picked elm. 
     * @param array
     * @return length of longest descending subsequence
     */
    public int question7(int[] array){
        int maxLength = 0;
        int count = 1;
        
        for (int i = 0; i < array.length-1; i++) {
            count=1;
            for (int j = i; j < array.length-1; j++) {
                if(array[j] >= array[j+1])
                    count++;
                else
                {
                    i= j+1;
                    break;
                }
            }
            if(maxLength < count)
                maxLength = count;
        }
        
        return maxLength;
    }
    
    /**
     * This method will sort your given queue,
     * this algorithm will find max elm of source queue using auxiliary stack,
     * and enqueues the max to destination queue, until the source queue gets empty.
     * @param q
     * @return sorted queue
     */
    public Queue question8(Queue q){
        Queue queue = new Queue(q.size());
        Stack stack = new Stack(q.size());
        
        while(!q.isEmpty())
        {
            int temp = (int)q.dequeue();
            while(!q.isEmpty())
            {
                if((int)q.peek() > temp)
                {
                    stack.push(temp);
                    temp = (int)q.dequeue();
                }
                else
                    stack.push(q.dequeue());
            }
            while(!stack.isEmpty())
                q.enqueue(stack.pop());
            
            
            queue.enqueue(temp);
        }
        
        return queue;
    }
    
    /**
     * This method will change front and rear elms of a queue
     * @param q
     * @return new queue
     */
    public Queue question9(Queue q){
        if(q.size() < 2)
            return q;
        
        int temp = (int)q.dequeue();
        for (int i = 0; i < q.size()-1; i++) {
            q.enqueue(q.dequeue());
        }
        q.enqueue(temp);
        
        return q;
    }
    
    
    public Queue question10(Queue q){
        if(q.size() % 2 !=0)
            return q;
        
        int s = q.size()/2;
        Queue q1 = new Queue(s);
        Queue q2 = new Queue(s);
        
        for (int i = 0; i < s; i++) {
            q1.enqueue(q.dequeue());
        }
        for (int i = 0; i < s; i++) {
            q2.enqueue(q.dequeue());
        }
        while(!q1.isEmpty())
        {
            q.enqueue(q1.dequeue());
            q.enqueue(q2.dequeue());
        }
        
        return q;
    }
    
    /**
     * This method is an implementation of bubble sort using 2 stacks.
     * @param arr
     * @return sorted array
     */
    public int[] question11(int[] arr){
        int[] res = new int[arr.length];
        Stack s1 = new Stack(arr.length);
        Stack s2 = new Stack(arr.length);
        
        for (int i = 0; i < arr.length; i++) {
            s1.push(arr[i]);
        }
        
        for (int i = 0; i < arr.length; i++) {
            if(i%2==0)
            {
                while(!s1.isEmpty())
                {
                    int temp = (int)s1.pop();
                    if(s2.isEmpty())
                        s2.push(temp);
                    else
                    {
                        if((int)s2.peek() > temp)
                        {
                            int t = (int)s2.pop();
                            s2.push(temp);
                            s2.push(t);
                        }
                        else
                            s2.push(temp);
                    }
                }
                res[arr.length-1-i] = (int) s2.pop();
            }
            else
            {
                while(!s2.isEmpty())
                {
                    int temp = (int)s2.pop();
                    if(s1.isEmpty())
                        s1.push(temp);
                    else
                    {
                        if((int)s1.peek() > temp)
                        {
                            int t = (int)s1.pop();
                            s1.push(temp);
                            s1.push(t);
                        }
                        else
                            s1.push(temp);
                    }
                }
                res[arr.length-1-i] = (int) s1.pop();
            }
        }
        
        return res;
    }
    
    public double question12(String str) throws Exception{
        double res = 0;
        String[] parts = str.split(" ");
        Stack s = new Stack(parts.length);
        
        for (String p : parts) {
            if((s.isEmpty() || s.size()==1) && (p.equals("+") || p.equals("-") || p.equals("*") || p.equals("/") || p.equals("%")))
                throw new Exception("your entery is invalid!");
            
            if(p.matches("-?\\d+(\\.\\d+)?")){
                s.push(Double.parseDouble(p));
            }
            else
            {
                double b = (double) s.pop();
                double a = (double) s.pop();
                //System.out.println("P:"+p+" | a="+a+" | b="+b);
                double r ;
                switch(p){
                    case "+": 
                        r=a + b;
                        s.push(r);
                        break;
                    case "-": 
                        r=a - b;
                        s.push(r);
                        break;
                    case "*": 
                        r=a * b;
                        s.push(r);
                        break;
                    case "/": 
                        if(b == 0)
                            throw new Exception("division by zero!");
                        r=a / b;
                        s.push(r);
                        break;
                    case "%": 
                        if(b == 0)
                            throw new Exception("division by zero!");
                        r=a % b;
                        s.push(r);
                        break;
                    default:
                        throw new Exception("Not standard operator(only +-*/% are valid!)");
                }
            }
            
        }
        if(s.size()!= 1)
            throw new Exception("operators count were not enough!");
        
        res = (double) s.pop();
        return res;
    }
}
