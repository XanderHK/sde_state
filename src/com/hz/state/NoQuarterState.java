package com.hz.state;

import com.hz.GumballMachine;

public class NoQuarterState extends State {

    public NoQuarterState(GumballMachine machine) {
        super(machine);
    }

    @Override
    public void soldOut() {

    }

    @Override
    public void hasQuarter() {
        this.machine.changeState(new HasQuarterState(this.machine));
    }

    @Override
    public void sold() {

    }

    @Override
    public void noQuarter() {

    }
}
