package lk.ijse;


public class Main {
    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread( () -> { for (int i = 0; i < 5; i++) {
            System.out.println("A");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }});
        t1.start();

        Thread t2 = new Thread( () -> { for (int i = 0; i < 5; i++) {
            System.out.println("B");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }});
        t2.start();
        System.out.println(t1.isAlive());
        t1.join();
        System.out.println(t2.isAlive());
        t2.join();
        System.out.println("bye");

    }
}
