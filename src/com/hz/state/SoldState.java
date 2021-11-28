package com.hz.state;

import com.hz.GumballMachine;

public class SoldState extends State {
    public SoldState(GumballMachine machine) {
        super(machine);
    }

    @Override
    public void soldOut() {
        this.machine.changeState(new SoldOutState(this.machine));
    }

    @Override
    public void hasQuarter() {

    }

    @Override
    public void sold() {

    }

    @Override
    public void noQuarter() {
        this.machine.changeState(new NoQuarterState(this.machine));
    }
}
