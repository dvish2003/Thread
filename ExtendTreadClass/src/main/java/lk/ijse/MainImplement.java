package lk.ijse;


public class MainImplement {
    public static void main(String[] args) {

Thread t1 = new Thread( () -> { for (int i = 0; i < 5; i++) {
    System.out.println("A");
    try {
        Thread.sleep(1000);
    } catch (InterruptedException e) {
        throw new RuntimeException(e);
    }

}});
Thread t2 = new Thread( () -> { for (int i = 0; i < 5; i++) {
    System.out.println("B");
    try {
        Thread.sleep(1000);
    } catch (InterruptedException e) {
        throw new RuntimeException(e);
    }

}});
t1.start();

t2.start();

    }
}
