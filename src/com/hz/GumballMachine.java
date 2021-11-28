package com.hz;

import com.hz.state.NoQuarterState;
import com.hz.state.SoldOutState;
import com.hz.state.State;

public class GumballMachine {

    final static String SOLD_OUT = "SoldOutState";
    final static String NO_QUARTER = "NoQuarterState";
    final static String HAS_QUARTER = "HasQuarterState";
    final static String SOLD = "SoldState";

    State state;
    String stateName;
    int count = 0;

    public GumballMachine(int count) {
        this.count = count;
        if (count > 0) {
            state = new NoQuarterState(this);
            stateName = NO_QUARTER;
        }
    }

    public void changeState(State state){
        this.state = state;
        this.stateName = state.getClass().getSimpleName();
    }

    public void insertQuarter() {
        if (stateName.equals(HAS_QUARTER)) {
            System.out.println("You can't insert another quarter");
        } else if (stateName.equals(NO_QUARTER)) {
            state.hasQuarter();
            System.out.println("You inserted a quarter");
        } else if (stateName.equals(SOLD_OUT)) {
            refill((int)(Math.random() * 10));
            System.out.println("You can't insert a quarter, the machine is sold out");
        } else if (stateName.equals(SOLD)) {
            System.out.println("Please wait, we're already giving you a gumball");
        }
    }

    public void ejectQuarter() {
        if (stateName.equals(HAS_QUARTER)) {
            System.out.println("Quarter returned");
            this.state.noQuarter();
        } else if (stateName.equals(NO_QUARTER)) {
            System.out.println("You haven't inserted a quarter");
        } else if (stateName.equals(SOLD)) {
            System.out.println("Sorry, you already turned the crank");
        } else if (stateName.equals(SOLD_OUT)) {
            refill((int)(Math.random() * 10));
            System.out.println("You can't eject, you haven't inserted a quarter yet");
        }
    }

    public void turnCrank() {
        if (stateName.equals(SOLD)) {
            System.out.println("Turning twice doesn't get you another gumball!");
        } else if (stateName.equals(NO_QUARTER)) {
            System.out.println("You turned but there's no quarter");
        } else if (stateName.equals(SOLD_OUT)) {
            refill((int)(Math.random() * 10));
            System.out.println("You turned, but there are no gumballs");
        } else if (stateName.equals(HAS_QUARTER)) {
            System.out.println("You turned...");
            this.state.sold();
            dispense();
        }
    }

    private void dispense() {
        if (stateName.equals(SOLD)) {
            System.out.println("A gumball comes rolling out the slot");
            count = count - 1;
            if (count == 0) {
                System.out.println("Oops, out of gumballs!");
                this.state.soldOut();
            } else {
                this.state.noQuarter();
            }
        } else if (stateName.equals(NO_QUARTER)) {
            System.out.println("You need to pay first");
        } else if (stateName.equals(SOLD_OUT)) {
            refill((int)(Math.random() * 10));
            System.out.println("No gumball dispensed");
        } else if (stateName.equals(HAS_QUARTER)) {
            System.out.println("No gumball dispensed");
        }
    }

    public void refill(int numGumBalls) {
        this.count = numGumBalls;
        state = new NoQuarterState(this);;
    }

    public String toString() {
        StringBuffer result = new StringBuffer();
        result.append("\nMighty Gumball, Inc.");
        result.append("\nJava-enabled Standing Gumball Model #2004\n");
        result.append("Inventory: " + count + " gumball");
        if (count != 1) {
            result.append("s");
        }
        result.append("\nMachine is ");
        if (stateName.equals(SOLD_OUT)) {
            result.append("sold out");
        } else if (stateName.equals(NO_QUARTER)) {
            result.append("waiting for quarter");
        } else if (stateName.equals(HAS_QUARTER)) {
            result.append("waiting for turn of crank");
        } else if (stateName.equals(SOLD)) {
            result.append("delivering a gumball");
        }
        result.append("\n");
        return result.toString();
    }
}
