
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
    //run the imitation
    public void run(){
        while(!stop){
            try{
                switch(tlc){
                    case GREEN:
                        Thread.sleep(10000);
                        break;
                    case YELLOW:
                        Thread.sleep(2000);
                        break;
                    case RED:
                        Thread.sleep(12000);
                        break;
                }
            } catch (InterruptedException exc){
                System.out.println(exc);
            }
            changeColor();
        }
    }
    synchronized void changeColor(){
        switch(tlc){
            case RED:
                tlc = TrafficLightColor.GREEN;
                break;
            case YELLOW:
                tlc = TrafficLightColor.RED;
                break;
            case GREEN:
                tlc = TrafficLightColor.YELLOW;
        }
        changed = true;
        notify();
    }
}
