public class Main {
    public static void main(String[] args) {
        NumberGenerator numberGenerator1 = new NumberGenerator();
        NumberGenerator numberGenerator2 = new NumberGenerator();

        Thread thread1 = new Thread(numberGenerator1);
        Thread thread2 = new Thread(numberGenerator2);


        thread1.start();
        thread2.start();
    }
}