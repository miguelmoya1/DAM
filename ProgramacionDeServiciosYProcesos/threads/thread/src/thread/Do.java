package thread;

/**
 * @author Miguel Moya Ortega
 */
public class Do extends Thread {

    @Override
    public void run(){
        for (int i = 0; i < 10000; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
            }
            System.out.println(i);
        }
    }
}
