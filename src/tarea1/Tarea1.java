/*
 * Este clase lanza todo el proceso del programa
 */
package tarea1;

/**
 *
 * @author Jorge Sánchez Medina Desarrollar de App Multiplataformas.
 * Especializado en dispositivos móviles. iOS, Flutter, Android
 */
public class Tarea1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // se crea un objeto de la clase Modelo
        Modelo modeloDatos = new Modelo();
        
        // se ejecutan los hilos entrando datos en el buffer
        
            Thread meterLetra = new MeterDatos(modeloDatos);     
            Thread sacarLetra = new SacarDatos(modeloDatos);        
            
        
            meterLetra.start();
            sacarLetra.start();
    }
    
}
