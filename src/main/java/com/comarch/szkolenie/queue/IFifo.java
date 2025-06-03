package com.comarch.szkolenie.queue;

public interface IFifo {

    public void push(String name, int priority);
    public void pushFew(int quantity);
    public Tuple<String, Integer> popFirst();
    public Tuple<String, Integer> popHighThree();
    public Tuple<String, Integer> popHighest();
}
