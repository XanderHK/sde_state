package com.hz.state;

import com.hz.GumballMachine;

public class SoldOutState extends State{

    public SoldOutState(GumballMachine machine) {
        super(machine);
    }

    @Override
    public void soldOut() {

    }

    @Override
    public void hasQuarter() {

    }

    @Override
    public void sold() {

    }

    @Override
    public void noQuarter() {

    }
}
