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
public class Queue implements QueueInterface{
    private int front,rear,capacity,size;
    private Object[] queueContainer;
    
    Queue(int capacity)
    {
        front=0;
        rear = capacity-1;
        size=0;
        this.capacity = capacity;
        queueContainer = new Object[capacity];
    }
    
    @Override
    public void enqueue(Object o) {
        if(isFull()) return;
        
        this.rear = (this.rear+1)%this.capacity;
        queueContainer[this.rear] = o;
        this.size++;
    }

    @Override
    public Object dequeue() {
        if(this.isEmpty())
            return null;
        Object o = this.queueContainer[this.front];
        this.front = (this.front+1) % this.capacity;
        this.size--;
        return o;
    }

    @Override
    public Object peek() {
        if(this.isEmpty())
            return null;
        Object o = this.queueContainer[this.front];
        return o;        
    }

    @Override
    public boolean isFull() {
        return this.size == this.capacity;
    }

    @Override
    public boolean isEmpty() {
        return this.size==0;
    }
    
    public int size(){
        return this.size;
    }
    
    public void dumpQueue()
    {
        System.out.println(Arrays.toString(this.queueContainer) + " | front: "+this.front  + " | rear: "+this.rear  + " | size: "+this.size );
    }
    
}
