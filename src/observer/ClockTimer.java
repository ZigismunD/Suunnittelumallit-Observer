/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package observer;

import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.GregorianCalendar;

/**
 *
 * @author zigis
 */
public class ClockTimer  extends Observable implements Runnable {
    private int hour;
    private int minute;
    private int second;
    private GregorianCalendar kale;
    
    
    public ClockTimer() {
        kale = new GregorianCalendar();
        this.hour = kale.get(GregorianCalendar.HOUR_OF_DAY);
        this.minute = kale.get(GregorianCalendar.MINUTE);
        this.second = kale.get(GregorianCalendar.SECOND);
    }
    
    public void run() {
        while (true) {
            setChanged();
            notifyObservers(this.getTime());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(ClockTimer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public String getTime() {
        if (second == 59 && minute == 59 && hour == 23) {
            second = 0;
            minute = 0;
            hour = 0;
        } else if (second == 59 && minute == 59) {
            hour++;
            minute = 0;
            second = 0; 
        } else if (second == 59) {
            minute++;
            second = 0;
        } else {
            second++;
        }
        
        return hour + ":" + minute + ":" + second;
    }

    
    
}
