/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package observer;

/**
 *
 * @author zigis
 */
public class MyApp {
    
    public static void main(String[] args) {
        ClockTimer timer = new ClockTimer();
       new DigitalClock(timer);
       new ShadyClock(timer);
       new Thread(timer).start();
        
        
        
    
    }
    
}
