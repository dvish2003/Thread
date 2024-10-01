package lk.ijse;

class MyRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println("Thread is running ");
    }
}

//this is interface type thread creat
public class ImplementRunnableInterface {
    public static void main(String[] args) {
        MyRunnable myRunnable = new MyRunnable();
        Thread thread = new Thread(myRunnable);
        thread.start();
    }

}
