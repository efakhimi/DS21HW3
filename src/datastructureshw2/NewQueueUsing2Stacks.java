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
public class NewQueueUsing2Stacks implements QueueInterface{
    private int capacity,size;
    private Stack s1,s2;

    NewQueueUsing2Stacks(int capacity)
    {
        size=0;
        this.capacity = capacity;
        s1 = new Stack(capacity);
        s2 = new Stack(capacity);
    }
    @Override
    public void enqueue(Object o) {
        if(s1.isFull())
            return;
        s1.push(o);
        size++;
    }

    @Override
    public Object dequeue() {
        if(s1.isEmpty())
            return null;
        
        while(!s1.isEmpty())
            s2.push(s1.pop());
        Object o = s2.pop();
        
        s1 = new Stack(capacity);
        while(!s2.isEmpty())
            s1.push(s2.pop());
        s2 = new Stack(capacity);
        
        size--;
        return o;
    }

    @Override
    public Object peek() {
        if(s1.isEmpty())
            return null;
        
        while(!s1.isEmpty())
            s2.push(s1.pop());
        Object o = s2.peek();
        
        s1 = new Stack(capacity);
        while(!s2.isEmpty())
            s1.push(s2.pop());
        s2 = new Stack(capacity);
        
        return o;
    }

    @Override
    public boolean isFull() {
        return s1.isFull();
    }

    @Override
    public boolean isEmpty() {
        return s1.isEmpty();
    }
    
    public int size(){
        return size;
    }
}
