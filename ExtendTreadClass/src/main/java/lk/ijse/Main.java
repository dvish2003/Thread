package lk.ijse;


class a extends Thread {
    public void run() {
        for (int i = 0; i <5; i++) {
            System.out.println("A");
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}

class b extends Thread {
    public void run() {
        for (int i = 0; i <5; i++) {
            System.out.println("B");
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

    }
}
public class Main {
    public static void main(String[] args) {
        a a = new a();
        b b = new b();
        a.start();
        b.start();

        }
    }

