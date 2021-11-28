package com.hz.state;

import com.hz.GumballMachine;

public abstract class State {

    protected GumballMachine machine;

    public State(GumballMachine machine) {
        this.machine = machine;
    }

    public abstract void soldOut();
    public abstract void noQuarter();
    public abstract void hasQuarter();
    public abstract void sold();

}
