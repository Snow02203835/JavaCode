package Homework.gumballstatewinner;

public class NoQuarterState implements State {
    GumballMachine gumballMachine;
 
    public NoQuarterState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }
 
	public void insertQuarter() {
    	this.gumballMachine.getInfo().append("You inserted a quarter\n");
		gumballMachine.setState(gumballMachine.getHasQuarterState());
	}
 
	public void ejectQuarter() {
		this.gumballMachine.getInfo().append("You haven't inserted a quarter\n");
	}
 
	public void turnCrank() {
		this.gumballMachine.getInfo().append("You turned, but there's no quarter\n");
	 }
 
	public void dispense() {
		this.gumballMachine.getInfo().append("You need to pay first\n");
	} 
 
	public String toString() {
		return "waiting for quarter";
	}
}
