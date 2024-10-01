package lk.ijse;


    class A{
        int num;
        boolean value= false;
        public void put(int num) throws InterruptedException {
            while (value){
                try {
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println("PUT :" + num);
            this.num = num;
           // wait();
            notify();
        }
        public void getNum(){
            while (!value){
                try {
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println("GET :" + num);
            value = false;
            notify();
        }
    }
    class Producer implements Runnable{
    A a;

    public Producer(A a){
        this.a = a;
        Thread t = new Thread(this,"Producer");
        t.start();
    }
        @Override
        public void run() {
        int i = 0;
        while (true){
            try {
                a.put(i++);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        }
    }

    class Consumer implements Runnable{
    A a;
    public Consumer(A a){
        this.a = a;
        Thread t = new Thread(this,"Consumer");
        t.start();
    }
        @Override
        public void run() {
        while (true){
            a.getNum();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        }
    }

    public class Main {
        public static void main(String[] args) {
         A a = new A();
            new Consumer(a);
            new Producer(a);
        }
    }