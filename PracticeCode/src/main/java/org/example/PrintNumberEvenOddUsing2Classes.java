package org.example;

public class PrintNumberEvenOddUsing2Classes {

    public static Object lock = new Object();
    private static boolean evenflag=true;
    private static int max=10;

    public static void main(String[] args) {
        Thread t1 = new Thread(new PrintEven());
        t1.start();
        Thread t2 = new Thread(new PrintOdd());
        t2.start();
    }

    static class PrintEven implements Runnable{

        @Override
        public void run() {
            for(int i=1;i<=max;i++){
                synchronized (lock){
                    while(!evenflag){
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    if(i%2==0)
                        System.out.println(i);
                    evenflag=false;
                    lock.notify();
                }
            }
        }
    }

    static class PrintOdd implements  Runnable{
        @Override
        public void run(){
            for(int i=1;i<=max;i++){
                synchronized (lock){
                    while(evenflag){
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    if(i%2==1)
                        System.out.println(i);
                    evenflag=true;
                    lock.notify();
                }
            }
        }
    }
}
