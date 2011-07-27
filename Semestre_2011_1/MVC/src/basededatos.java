import java.io.*;
import com.db4o.*;
import modelo.Modelo;

public class basededatos {
	
	static Modelo modelo;
    final static String DB4OFILENAME = System.getProperty("user.home")
            + "/tombstone.db4o";
    
    public basededatos() {
    //	modelo=m;
      //  accessDb4o();
    }
    
    public static void/*debe ser RETURN MODELO*/ accessDb4o(Modelo m) {
    	modelo=m;
        ObjectContainer db = Db4oEmbedded.openFile(DB4OFILENAME); 
        try {
        	//aqui serian CASE
        	guardar(db);
        	borrar(db);
        	guardar(db);
        	listar(db);
        	cargar(db);
            // do something with db4o
        } finally {
            db.close();
            //seria el return modelo;
        }
    }
    
    public static void listar(ObjectContainer db) {
    	ObjectSet result = db.queryByExample(Modelo.class);
    	for(int i=0; i<result.size();i++){
    		 Modelo modelo = (Modelo) result.next();
             System.out.println(i+1+" "+modelo.nombre);
    	}
    }
    
    public static void cargar(ObjectContainer db) {
    	 Modelo aux = new Modelo();
    	 aux.nombre="alejandro";
    	 ObjectSet result = db
                 .queryByExample(aux);
    	 if(result.size()>0){
         modelo = (Modelo) result.next();
         System.out.println("cargado " + modelo.nombre);
    	}
    	else
    		System.out.println("no se puede cargar");
    }
    
    public static void guardar(ObjectContainer db) {
    	Modelo aux = new Modelo();
    	aux.nombre="alejandro";
   	 	ObjectSet result = db
                .queryByExample(aux);
   	 	if(result.size()>0){
   	 		aux=(Modelo)result.next();
   	 		db.delete(aux);
   	 	}
   	 	modelo.nombre="alejandro";
   	 	db.store(modelo);
 		System.out.println("guardado " + modelo.nombre);  	
    }
    
    public static void borrar(ObjectContainer db) {
    	Modelo aux = new Modelo();
    	aux.nombre="alejandro";
   	 	ObjectSet result = db
                .queryByExample(aux);
   	 	if(result.size()>0){
   	 		aux=(Modelo)result.next();
	 		db.delete(aux);
   	 		System.out.println("borrado " + modelo.nombre); 
   	 	}
   	 	else{
   	 	System.out.println("no se puede borrar "); 
   	 	}
    	
    }
}