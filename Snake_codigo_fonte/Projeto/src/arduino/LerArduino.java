package arduino;

import java.util.logging.Level;
import java.util.logging.Logger;
import jssc.SerialPort;
import jssc.SerialPortException;
import static projeto.Grade.Tese;
import static projeto.Grade.right;
import static projeto.Grade.down;
import static projeto.Grade.up;
import static projeto.Grade.left;
import projeto.Grade;

public class LerArduino implements Runnable {
    
    private final String BAIXO = "BAIXO";
    private final String CIMA = "CIMA";
    private final String ESQUERDA = "ESQUERDA";
    private final String DIREITA = "DIREITA";
    
    public static boolean temarduino;
    public static String Posicaov;
    public static String informacao;
    int mover = 0;
    
    private SerialPort serialPort;

    public LerArduino(String port) {
        serialPort = new SerialPort(port);
        openPort();
    }
    
    public void openPort() {
        try {
            serialPort.openPort();
            temarduino = true;
        } catch (SerialPortException ex) {
            System.out.println("Sem Arduino");
            //System.out.println(ex.getMessage());
        }
    }
    
    @Override
    public void run() {
        while(true) {
            ler();
        }
    }
    
    public void ler() {
        try {
            
            if(temarduino == true)
            informacao = serialPort.readString();
            if (informacao != null) {
                System.out.println("o arduino ta mandanddo" + informacao);
                verificarInformacao();
            }
            
        } catch (SerialPortException ex) {
            Logger.getLogger(LerArduino.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void verificarInformacao() {
        if (informacao.equals(BAIXO)) {
                Posicaov = BAIXO;
                System.out.println(Posicaov);
                if (down == false) {
                    Tese++;
                }
                down = true;
                left = false;
                right = false;
                up = false;

            } else if (informacao.equals(CIMA)) {
                Posicaov = CIMA;
                                System.out.println(Posicaov);

                if (up == false) {
                    Tese++;
                }
                up = true;
                down = false;
                left = false;
                right = false;

            } else if (informacao.equals(ESQUERDA)) {
                Posicaov = ESQUERDA;
                                System.out.println(Posicaov);

                if (left == false) {
                    Tese++;
                }
                right = false;
                left = true;
                up = false;
                down = false;
            } else if (informacao.equals(DIREITA)) {
                Posicaov = DIREITA;
                                System.out.println(Posicaov);

                if (right == false) {
                    Tese++;
                }
                left = false;
                right = true;
                up = false;
                down = false;
            }
    }
    
    public static int byteArrayToInt(byte[] b) {
        return   b[3] & 0xFF |
                (b[2] & 0xFF) << 8 |
                (b[1] & 0xFF) << 16 |
                (b[0] & 0xFF) << 24;
    }
}
