
package tfpackage;

enum TrafficLightColor{
    RED, GREEN, YELLOW
}

public class TrafficLightSimulator implements Runnable{
    private Thread thrd;
    //current color
    private TrafficLightColor tlc;
    //true - for stop imitation
    boolean stop = false;
    boolean changed = false;
    
    TrafficLightSimulator(TrafficLightColor init){
        tlc = init;
        thrd = new Thread(this);
        thrd.start();
    }
    
    TrafficLightSimulator(){
        tlc = TrafficLightColor.RED;
        thrd = new Thread(this);
        thrd.start();
    }
}
