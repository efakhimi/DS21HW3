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
public interface StackInterface {
    public void push(Object o);
    public Object pop();
    public Object peek();
    public boolean isEmpty();
    public boolean isFull();
    public int size();
}
