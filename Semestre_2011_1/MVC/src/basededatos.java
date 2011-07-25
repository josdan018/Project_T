
import java.io.*;
import com.db4o.*;

public class basededatos {
    final static String DB4OFILENAME = System.getProperty("user.home")
            + "/tombstone.db4o";
    public basededatos() {
        new File(DB4OFILENAME).delete();
        accessDb4o();
        new File(DB4OFILENAME).delete();
        ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded
                .newConfiguration(), DB4OFILENAME);
        db.close();
    }
    
    public static void accessDb4o() {
        ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded
                .newConfiguration(), DB4OFILENAME);
        try {
            // do something with db4o
        } finally {
            db.close();
        }
    }
    public static void recuperar(ObjectContainer db) {
        //ObjectSet result = db.queryByExample(Pilot.class);
        //listResult(result);
    }
    public static void cargar(ObjectContainer db) {
        //Pilot proto = new Pilot("Michael Schumacher", 0);
        //ObjectSet result = db.queryByExample(proto);
        //listResult(result);
    }
    public static void guardar(ObjectContainer db) {
    //    ObjectSet result = db
     //           .queryByExample(new Pilot("Michael Schumacher", 0));
      //  Pilot found = (Pilot) result.next();
        //found.addPoints(11);
        //db.store(found);
        //System.out.println("Added 11 points for " + found);
    //    retrieveAllPilots(db);
    }
    public static void borrar(ObjectContainer db) {
      //  ObjectSet result = db
        //        .queryByExample(new Pilot("Michael Schumacher", 0));
        //Pilot found = (Pilot) result.next();
        //db.delete(found);
        //System.out.println("Deleted " + found);
        //retrieveAllPilots(db);
    }
}