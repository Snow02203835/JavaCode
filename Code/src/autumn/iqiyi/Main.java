package autumn.iqiyi;


import java.util.Scanner;
import java.util.function.IntConsumer;

public class Main {
    public static void main(String[] args) {
        final Scanner reader = new Scanner(System.in);
        int n = reader.nextInt();
        ZeroEvenOdd zeroEvenOdd = new ZeroEvenOdd(n);
        new Thread(() -> {
            try {
                zeroEvenOdd.printZero(System.out::print);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                zeroEvenOdd.printEven(System.out::print);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                zeroEvenOdd.printOdd(System.out::print);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}

class ZeroEvenOdd {
    private int n;
    private int next;
    private boolean hasZero;
    private boolean odd;

    public ZeroEvenOdd(int n) {
        this.n = n;
        next = 1;
        odd = true;
        hasZero = false;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void printZero(IntConsumer printNumber) throws InterruptedException {
        while (next <= n) {
            if (!hasZero) {
                synchronized (this) {
                    printNumber.accept(0);
                    hasZero = true;
                    notifyAll();
                }
            }
        }
    }

    public void printEven(IntConsumer printNumber) throws InterruptedException {
        while (next <= n) {
            if (hasZero) {
                if (!odd) {
                    synchronized (this) {
                        printNumber.accept(next++);
                        hasZero = false;
                        odd = true;
                    }
                }
            }
        }
    }

    public void printOdd(IntConsumer printNumber) throws InterruptedException {
        while (next <= n) {
            if (hasZero) {
                if (odd) {
                    synchronized (this) {
                        printNumber.accept(next++);
                        hasZero = false;
                        odd = true;
                    }
                }
            }
        }
    }
}
