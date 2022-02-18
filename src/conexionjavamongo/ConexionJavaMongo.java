package conexionjavamongo;

/**
 *
 * @author js984
 */
public class ConexionJavaMongo {

   
    public static void main(String[] args) {
        Conexion conec = new Conexion();
        System.out.println("Lista actual:");
        conec.mostrar();
        conec.insertar("Spiderman");
        System.out.println("Lista con las inserciones:");
        conec.mostrar();
        conec.actualizar("Spiderman","El hombre araña");
        System.out.println("Lista con la actualizacion de una pelicula:");
        conec.mostrar();
        conec.eliminar("El hombre araña");
        System.out.println("Lista actual con la eliminacion de una pelicula:");
        conec.mostrar();
    
    }
    
}
