/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package observer;

import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author zigis
 */
public class DigitalClock implements Observer {
    ClockTimer timer;
    
    public DigitalClock(ClockTimer ct) {
        timer = ct;
        timer.addObserver(this);
        //timer.run();
        
    }

    @Override
    public void update(Observable o, Object arg) {
        System.out.println("Kellonaika: " + arg);
    }
    
}
