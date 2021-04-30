package Homework.InversionOfControl;

public class Main {
    public static void main(String[] args) {
        Store bookStore = new Bookstore();
        Store restaurant = new Restaurant();
        Customer customer = new Customer();
        System.out.println(customer.buySomething(bookStore, "Full Band Interception"));
        System.out.println(customer.buySomething(restaurant, "coffee"));
    }
}
