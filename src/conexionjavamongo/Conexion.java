
package conexionjavamongo;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.Mongo;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author js984
 */
public class Conexion {
   
    DB BaseDatos;
    DBCollection coleccion;
    BasicDBObject document = new BasicDBObject();
    
    public Conexion(){
    try{
    Mongo mongo = new Mongo("localhost",27017);
    BaseDatos = mongo.getDB("peliculas");
    coleccion = BaseDatos.getCollection("pelicula");
    System.out.println("conexion exitosa");
        
    }catch(UnknownHostException ex){
    Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE,null,ex);
    }
        
    }
    
    
    //CRUD
    
    public boolean insertar(String titulo){
    document.put("Titulo",titulo);
    coleccion.insert(document);
    return true;
    }
    
    public void  mostrar(){
    DBCursor cursor = coleccion.find();
    while(cursor.hasNext()){
        System.out.println(cursor.next());
    }
    }
    
    public boolean actualizar(String tituloAnterior,String tituloNueva){
    document.put("Titulo", tituloAnterior);
    BasicDBObject documentoNuevo = new BasicDBObject();
    documentoNuevo.put("Titulo", tituloNueva);
    coleccion.findAndModify(document, documentoNuevo);
        
    return true;
    }
    
    public boolean eliminar(String titulo){
    document.put("Titulo", titulo);
    coleccion.remove(document);
    return true;
    }
    
    
}
