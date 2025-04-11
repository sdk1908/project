package org.example;

public class PrintEvenOddSum3Thread {
    public static void main(String[] args) {
        PrintEvenOddSum pr = new PrintEvenOddSum();
        Thread t1 = new Thread(pr::printEven);

        Thread t2 = new Thread(pr::printOdd);
        t1.start();
        t2.start();

        Thread t3 = new Thread(pr::printSum);
        t3.start();

    }

}
class PrintEvenOddSum{
    public int max=10,even=0,odd=0;
    public boolean evenFlag=false,sumFlag=false;

    public synchronized void printEven(){
        for(int i=1;i<=max;i++){
            while(!evenFlag){
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            if(i%2==0) {
                even=i;
                System.out.println(i);
                evenFlag=false;
                sumFlag=true;
                notifyAll();
            }

        }
    }

    public synchronized  void printOdd(){
        for(int i=1;i<=max;i++){
            while(evenFlag || sumFlag){
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            if(i%2==1){
                odd=i;
                System.out.println(i);
                evenFlag=true;
                // sumFlag=false;
                notifyAll();
            }

        }
    }

    public synchronized  void printSum(){
        for(int i=1;i<=5;i++){
            while(!sumFlag){
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            //if(i%2==1){
                System.out.println("sum:"+(even+odd));
            //}
            sumFlag=false;

            notifyAll();
        }
    }
}