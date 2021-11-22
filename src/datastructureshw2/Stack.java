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
public class Stack implements StackInterface{

    private int capacity;
    private Object[] stackContainer;
    private int top;
    
    Stack(int size)
    {
        capacity = size;
        stackContainer = new Object[capacity];
        top=-1;
    }
    
    @Override
    public void push(Object o) {
       stackContainer[++top] = o;
    }

    @Override
    public Object pop() {
       return stackContainer[top--]; 
    }

    @Override
    public Object peek() {
       return stackContainer[top]; 
    }

    @Override
    public boolean isEmpty() {
        return (top == -1);
    }

    @Override
    public boolean isFull() {
        return (top == capacity-1);
    }

    @Override
    public int size() {
        return (top+1);
    }
    
    public void dumpStack()
    {
        System.out.println(Arrays.toString(this.stackContainer) + " | top: "+this.top  );
    }
}
