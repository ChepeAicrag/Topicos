/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Usamos un unico hilo para ejecutar 3 tareas
 * @author García García José Ángel
 */
public class SimpleExecutorExample {
    public static void main(String[] args) {
        ExecutorService pool = Executors.newSingleThreadExecutor();
        
        Runnable task = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        };
        pool.execute(task);
        pool.execute(new CountDownClock("A"));
        pool.execute(new CountDownClock("B"));
        pool.execute(new CountDownClock("C"));
        pool.shutdown();
    }
}
