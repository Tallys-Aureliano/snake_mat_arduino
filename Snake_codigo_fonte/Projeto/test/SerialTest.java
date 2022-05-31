
import arduino.LerArduino;

public class SerialTest {

    public static void main(String[] args) {
        
        LerArduino lerArduino = new LerArduino("COM4");
        lerArduino.openPort();
        
        Thread threadArduino = new Thread(lerArduino);
        threadArduino.start();
    }
    
}
