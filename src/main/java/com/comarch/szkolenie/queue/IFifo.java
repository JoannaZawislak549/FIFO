package com.comarch.szkolenie.queue;

public interface IFifo {

    public void push(String argument);
    public void pushFew(int quantity);
    public String pop();
}
