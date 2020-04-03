package Pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 
 * @author García García José Ángel
 */
public class MultipleTasksExecutorExample {
    public static void main(String[] args) {
        ExecutorService pool = Executors.newCachedThreadPool();
        ExecutorService pool2 = Executors.newFixedThreadPool(2);
        CountDownClock reloj1 = new CountDownClock("Reloj1");
        pool.execute(new CountDownClock("A"));
        pool.execute(new CountDownClock("B"));
        pool.execute(reloj1);
        pool.execute(new CountDownClock("C"));
        pool.execute(new CountDownClock("D"));
        pool.execute(reloj1);
        pool2.execute(new CountDownClock("A2"));
        pool2.execute(new CountDownClock("B2"));
        pool2.execute(new CountDownClock("C2"));
        pool2.execute(new CountDownClock("D2"));
        pool.shutdown();
        pool2.shutdown();
    }
}
