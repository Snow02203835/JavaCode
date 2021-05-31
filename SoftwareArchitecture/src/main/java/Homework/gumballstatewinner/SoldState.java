package Homework.gumballstatewinner;

public class SoldState implements State {
    GumballMachine gumballMachine;
 
    public SoldState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }
       
	public void insertQuarter() {
		this.gumballMachine.getInfo().append("Please wait, we're already giving you a gumball\n");
	}
 
	public void ejectQuarter() {
		this.gumballMachine.getInfo().append("Sorry, you already turned the crank\n");
	}
 
	public void turnCrank() {
		this.gumballMachine.getInfo().append("Turning twice doesn't get you another gumball!\n");
	}
 
	public void dispense() {
		gumballMachine.releaseBall();
		if (gumballMachine.getCount() > 0) {
			gumballMachine.setState(gumballMachine.getNoQuarterState());
		} else {
			this.gumballMachine.getInfo().append("Oops, out of gumballs!\n");
			gumballMachine.setState(gumballMachine.getSoldOutState());
		}
	}
 
	public String toString() {
		return "dispensing a gumball";
	}
}
