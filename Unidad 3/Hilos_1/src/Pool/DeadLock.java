/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Pool;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 
 * @author García García José Ángel
 */
public class DeadLock{
    static class Friend {
    private final String name;
    private final Lock lock = new ReentrantLock();
    
    public Friend(String name){
        this.name = name;
    }
    
    public String getName(){
        return this.name;
    }
    
    public synchronized  void bowBack(Friend bower){
        System.out.format("%s: %s " + " has bowed back to me!%n"
                , this.name,bower.getName());
    }
    public synchronized void bow(Friend bower){
        System.out.format("%s: %s" + "hasbowed to me!%n"
                ,this.name,bower.getName());
        bower.bowBack(this);
    }
}

}