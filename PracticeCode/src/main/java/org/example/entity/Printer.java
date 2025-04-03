package org.example.entity;

public class Printer  {

    int number=1;
    final int max=10;

    public synchronized void printNumber(boolean evenOdd) throws InterruptedException {
        while (number <= max) {

            if((number%2==0) != evenOdd){
                wait();
            }
            else {
                System.out.println(Thread.currentThread().getName()+":"+number);
                number++;
                notify();
            }

        }
    }
}
