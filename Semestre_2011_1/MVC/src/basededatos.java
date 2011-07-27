import java.io.*;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import com.db4o.*;
import modelo.Modelo;

public class basededatos {
	static JFrame ventana;
	static Modelo modelo;
	static String nombre;
    final static String DB4OFILENAME = System.getProperty("user.home")
            + "/tombstone.db4o";
    
    public basededatos() {
    }
    
    @SuppressWarnings("finally")
	public static Modelo accessDb4o(Modelo m, int i,String archivo) {
    	modelo=m;
    	nombre=archivo;
        ObjectContainer db = Db4oEmbedded.openFile(DB4OFILENAME); 
        try {
        	if(i==1)
        			guardar(db);
        	else if(i==2)
        			cargar(db);
        	else	
        			borrar(db);
        } finally {
            db.close();
            return modelo;
        }
    }
    
    public static String accessDb4o(Modelo m) {
    	modelo=m;
    	String lista = null;
    	ObjectContainer db = Db4oEmbedded.openFile(DB4OFILENAME);
        try {
        	lista=listar(db);
        } finally {
            db.close();
            return lista;
        }
    }
    
    public static String listar(ObjectContainer db) {
    	String aux = "";
    	ObjectSet result = db.queryByExample(Modelo.class);
    	for(int i=0; i<result.size();i++){
    		 Modelo modelo = (Modelo) result.next();
    		 aux=aux+modelo.nombre+"\n";
             System.out.println(i+1+" "+modelo.nombre);
    	}
    	return aux;
    }
    
    public static Modelo cargar(ObjectContainer db) {
    	 Modelo aux = new Modelo();
    	 aux.nombre=nombre;
    	 ObjectSet result = db
                 .queryByExample(aux);
    	 if(result.size()>0){
         modelo = (Modelo) result.next();
         System.out.println("cargado " + modelo.nombre);
         ventana_emergente("Proyecto: "+modelo.nombre+" Cargado con exito");
    	}
    	else{
    		modelo=new Modelo();
    		System.out.println("no se puede cargar");
    		ventana_emergente("Error el proyecto no existe");
    	}
    	return modelo;
    }
    
    public static void guardar(ObjectContainer db) {
    	modelo.nombre=nombre;
    	Modelo aux = modelo;
   	 	ObjectSet result = db
                .queryByExample(aux);
   	 	if(result.size()>0){
   	 		aux=(Modelo)result.next();
   	 		db.delete(aux);
   	 	}
   	 	db.store(modelo);
 		System.out.println("guardado " + modelo.nombre);  
 		ventana_emergente("Proyecto: "+modelo.nombre+" guardado con exito");
    }
    
    public static void borrar(ObjectContainer db) {
    	Modelo aux = modelo;
    	aux.nombre=nombre;
   	 	ObjectSet result = db
                .queryByExample(aux);
   	 	if(result.size()>0){
   	 		aux=(Modelo)result.next();
	 		db.delete(aux);
   	 		System.out.println("borrado " + modelo.nombre); 
   	 	ventana_emergente("Proyecto: "+modelo.nombre+" eliminado con exito");
   	 	}
   	 	else{
   	 	System.out.println("no se puede borrar ");
   	    ventana_emergente("Error el proyecto no existe");
   	 	}
    }
    
    public static void ventana_emergente(String mensaje){  	
		JOptionPane.showMessageDialog(ventana, mensaje);	
    }
}