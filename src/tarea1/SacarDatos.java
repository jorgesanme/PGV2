/*
 * Esta clase extiende de Thread
 * para definir un hilo ejecutor del método
 * que eliminar letras a la variable datos
 */
package tarea1;

/**
 *
 * @author Jorge Sánchez Medina Desarrollar de App Multiplataformas.
 * Especializado en dispositivos móviles. iOS, Flutter, Android
 */
public class SacarDatos extends Thread {

    private Modelo datos;

    public SacarDatos(Modelo datos) {
        this.datos = datos;
    }

     @Override
    public synchronized void run(){
       
      
        for (int i=0 ; i < 5; i++){
            //System.out.println("Se extrae la letra  "+ i );
            datos.saleDatos();
        }
       
        
    }
     
    
}
