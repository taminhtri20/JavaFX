public class EvenThread extends Thread{
    @Override
    public void run(){
        for (int i=1; i<11; i+=2){
            System.out.println(i);
            try {
                Thread.sleep(11000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
