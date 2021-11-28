package com.hz.state;

import com.hz.GumballMachine;

public class HasQuarterState extends State {
    public HasQuarterState(GumballMachine machine) {
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
        this.machine.changeState(new SoldState(this.machine));
    }

    @Override
    public void noQuarter() {
        this.machine.changeState(new NoQuarterState(this.machine));
    }
}
