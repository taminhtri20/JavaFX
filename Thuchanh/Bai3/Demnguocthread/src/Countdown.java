public class Countdown extends Thread{
    @Override
    public void run(){
        for (int i = 10; i >= 1 ;i--){
            System.out.println(i);
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
