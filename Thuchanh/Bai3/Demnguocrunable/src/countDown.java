public class countDown implements Runnable{
    @Override
    public void run() {
        for (int i = 10; i>=0; i--){
            System.out.println(i);
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
