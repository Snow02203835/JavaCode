package Homework.gumballstatewinner;

import java.util.Random;

public class HasQuarterState implements State {
	Random randomWinner = new Random(System.currentTimeMillis());
	GumballMachine gumballMachine;
 
	public HasQuarterState(GumballMachine gumballMachine) {
		this.gumballMachine = gumballMachine;
	}
  
	public void insertQuarter() {
		this.gumballMachine.getInfo().append("You can't insert another quarter\n");
	}
 
	public void ejectQuarter() {
		this.gumballMachine.getInfo().append("Quarter returned\n");
		gumballMachine.setState(gumballMachine.getNoQuarterState());
	}
 
	public void turnCrank() {
		this.gumballMachine.getInfo().append("You turned...\n");
		int winner = randomWinner.nextInt(10);
		if ((winner == 0) && (gumballMachine.getCount() > 1)) {
			gumballMachine.setState(gumballMachine.getWinnerState());
		} else {
			gumballMachine.setState(gumballMachine.getSoldState());
		}
	}

    public void dispense() {
		this.gumballMachine.getInfo().append("No gumball dispensed\n");
    }
 
	public String toString() {
		return "waiting for turn of crank";
	}
}
