package lk.ijse;

class Calculation{

    int num = 0;

    public synchronized void increment(){
        num++;
    }
}

public class Main {

    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(() ->{  for (int i = 0; i < 5; i++) {
            System.out.println("A");
        }});
        t1.start();

        Thread t2 = new Thread(() ->{  for (int i = 0; i < 5; i++) {
            System.out.println("B");
        }});
        t1.setPriority(Thread.MAX_PRIORITY);
        t2.setPriority(Thread.MIN_PRIORITY);
       // t2.start();

       try {
           Thread.sleep(1000);
       } catch (InterruptedException e) {
           throw new RuntimeException(e);
       }

       t2.start();

        System.out.println(t1.getPriority());
        System.out.println(t2.getPriority());


       /* t1.join();
        t2.join();*/

       // System.out.println(calculation.num);

    }
}