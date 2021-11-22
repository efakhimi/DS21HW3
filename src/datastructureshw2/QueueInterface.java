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
public interface QueueInterface {
    public void enqueue(Object o);
    public Object dequeue();
    public Object peek();
    public boolean isFull();
    public boolean isEmpty();
}
