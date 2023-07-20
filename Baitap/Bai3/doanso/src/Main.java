import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập một số nguyên để các thread đoán: ");
        int guessNumber = scanner.nextInt();

        GuessNumber guessNumber1 = new GuessNumber(guessNumber);
        GuessNumber guessNumber2 = new GuessNumber(guessNumber);

        guessNumber1.setName("Thread1");
        guessNumber2.setName("Thread2");

        guessNumber1.start();
        guessNumber2.start();
    }
}