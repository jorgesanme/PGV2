/*
 * Esta clase modela la estructura de datos del array
 * y los métodos para entrar introducir y eliminar su contenido
 */
package tarea1;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jorge Sánchez Medina Desarrollar de App Multiplataformas.
 * Especializado en dispositivos móviles. iOS, Flutter, Android
 */
public class Modelo {

    // array que contendra los 6 valores posible del buffer
    // con lista 
    private final ArrayList<String> charBuffer;
    private boolean statusFull = false;
    private boolean statusEmpty = true;
    private int siguiente = 0;

    public Modelo(int size) {
        this.charBuffer = new ArrayList<>(size);

    }

    public  void meteDatos(String letter) {
        //este metodo ingresa valores en el Buffer
        while (statusFull != false) {
            try {
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Modelo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        synchronized (charBuffer) {
            String d = letter.substring(siguiente, siguiente + 1);
            System.out.println("se meten la letra " + d);
            charBuffer.add(d);

            if (charBuffer.size() == 6) {
                
                charBuffer.notify();
                statusFull = false;
            } 
            charBuffer.notify();
        }

        siguiente++;

    }

    public  void saleDatos() {
        //mientras el buffer este vacio se debe esperar.
        while (!statusEmpty ) {
            try {
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Modelo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        //Si buffer esta lleno, puedo coger datos    
        synchronized (charBuffer) {
            int siguiente2 = charBuffer.size() - 1;
            if (charBuffer.size() > 0) {
                System.out.println("se casa la letra " + charBuffer.get(siguiente2));
                charBuffer.remove(siguiente2);
                charBuffer.notifyAll();
            } else if (charBuffer.isEmpty()) {
                charBuffer.notify();            
            } else {
                statusEmpty = false;
            }
            charBuffer.notify();
            //se notifica el consumo de un carácter
        }            
        siguiente--;
    }
}
