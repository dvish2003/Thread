package lk.ijse;

public class MainImplement {
    public static void main(String[] args) {

        RunnableTread RunnableTread = () -> {
    for (int i = 0; i < 10; i++) {
        System.out.println("a");
    }
};
 RunnableTread.run();
    }
}
