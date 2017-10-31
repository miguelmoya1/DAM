package thread;

/**
 *
 * @author Miguel Moya Ortega
 */
public class Threads extends Thread{

    public static void main(String[] args) {
        Do d = new Do();
        System.out.println("Start");
        d.start();
    }
    
}
