package lk.ijse;

 class Calculation{

     int num = 0;

    public synchronized void increment(){
         num++;
    }
}

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Calculation calculation = new Calculation();

        Thread t1 = new Thread(() ->{  for (int i = 0; i < 1000; i++) {
            calculation.increment();
        }});
        t1.start();
       /* try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);*/
        //}
        Thread t2 = new Thread(() ->{  for (int i = 0; i < 1000; i++) {
            calculation.increment();
        }});
        t2.start();
        t1.join();
        t2.join();
       /* try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }*/
        System.out.println(calculation.num);

    }
}