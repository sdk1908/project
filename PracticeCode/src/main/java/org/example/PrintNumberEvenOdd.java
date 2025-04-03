package org.example;

public class PrintNumberEvenOdd {
    private static int max=10;
    private static boolean flagE=true;
    private static final Object lock = new Object();

    public static void main(String[] args) {
        Thread t1 = new Thread(new PrintEven());
        t1.start();
        Thread t2 = new Thread(new PrintOdd());
        t2.start();
    }

  static  class PrintEven implements Runnable {

      @Override
      public void run() {
          synchronized (lock) {
              for (int i = 1; i <= max; i++) {
                  while (!flagE) {
                      try {
                          lock.wait();
                      } catch (InterruptedException e) {
                          e.printStackTrace();
                      }
                  }
                  System.out.println(i);
                  flagE = false;
                  lock.notify();
              }
          }

      }
  }

      static  class PrintOdd implements Runnable{
            char ch='A';
          @Override
          public void run() {
              synchronized (lock){
                  for(int i=1;i<=max;i++){
                      while(flagE){
                          try {
                              lock.wait();
                          } catch (InterruptedException e) {
                              e.printStackTrace();
                          }
                      }
                      System.out.println(ch++);
                      flagE=true;
                      lock.notify();
                  }
              }

          }
  }

}
