public class GuessNumber extends Thread{
    private int guessNumber = 0;
    private int count = 0;
    public GuessNumber(int guessNumber){
        this.guessNumber = guessNumber;
    }

    @Override
    public void run(){
        int randomNumber;
        do {
            randomNumber = (int) (Math.random() * 100 + 1);
            count++;
            System.out.println(getName() + " đoán số " + randomNumber);

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }while (guessNumber != randomNumber);

        System.out.println(getName() + " đã đoán ra số " + guessNumber + " trong " + count + " lần đếm");
    }
}
