public class guessNummber implements Runnable{
    private int guessNumber;
    private int count;
    public guessNummber(int guessNumber){
        this.guessNumber=guessNumber;
    }
    @Override
    public void run() {
        int randomNumber;
        do {
            randomNumber = (int) (Math.random() * 100 + 1);
            count++;
            System.out.println(Thread.currentThread().getName() + " đoán số " + randomNumber);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }while (randomNumber != guessNumber);

        System.out.println(Thread.currentThread().getName() + " đã đoán ra số " + guessNumber + " trong " + count + " lần đếm");
    }
}
