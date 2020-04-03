package hilos_1;

/**
 * 
 * @author Garcia Garcia Jose Angel
 */
public class HelloThreads extends Thread{
    public void run(){
        System.out.println("Hello from a thread");
    }
    
    public static void main(String[] args) {
        new HelloThreads().run();
    }
    
}
