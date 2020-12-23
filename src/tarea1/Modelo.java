/*
 * Esta clase modela la estructura de datos del array
 * y los métodos para entrar introducir y eliminar su contenido
 */
package tarea1;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jorge Sánchez Medina Desarrollar de App Multiplataformas.
 * Especializado en dispositivos móviles. iOS, Flutter, Android
 */
public class Modelo {

    // array que contendra los 6 valores posible del buffer
    private char charBuffer[] = new char[6];

    private boolean statusFull = false;
    private boolean statusEmpty = true;
    private int siguiente = 0;

    public Modelo() {

    }

    public synchronized void meteDatos(String letter) {
        //este metodo ingresa valores en el array
        while (statusFull != false) {
            try {
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Modelo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        for (int i = 0; i <= 5; i++) {
            char c = letter.charAt(siguiente);
            System.out.println("se meten la letra " + c);
            siguiente++;
            charBuffer[i] = c;
            notify();
            if (charBuffer.length == 6) {
                statusFull = true;
            }

        }
    }

    public synchronized void saleDatos() {
        //mientras el buffer este vacio se debe esperar.
        while (statusEmpty != true) {
            try {
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Modelo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        for (int i = 5; i >= 0; i--) {
            char c = charBuffer[i];
            System.out.println("Sacando letra " + c);
            siguiente--;
            //charBuffer[i] = c;

            /*if (charBuffer.length == 0) {
                statusFull = true;
            }*/

            siguiente--;

            //Si buffer esta lleno, puedo coger datos        
            if (siguiente == 0) {
                statusEmpty = false;
            }
            notify();
            //se notifica el consumo de un carácter
        }

    }
}
