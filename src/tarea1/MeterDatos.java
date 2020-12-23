/*
 * Esta clase extiende de Thread
 * para definir un hilo ejecutor del método
 * que añade letras a la variable datos
 */
package tarea1;

/**
 *
 * @author Jorge Sánchez Medina Desarrollar de App Multiplataformas.
 * Especializado en dispositivos móviles. iOS, Flutter, Android
 */
public class MeterDatos extends Thread{
    
    private Modelo datos;
    private String letter = "ABCDEFGHIJKLMNÑOPQRSTUVXYZ";

    public MeterDatos(Modelo datos) {
        this.datos = datos;
    }
   

    @Override
    public synchronized void run() { 
        //... aqui hay que poner        
        
        
        for (int i=0 ; i < 5; i++){
            
            this.datos.meteDatos(letter);
            //System.out.println("se meten datos "+i);
            
        }
         
    }
    
}
