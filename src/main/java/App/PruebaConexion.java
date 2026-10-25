package App;
import Datos.ConexionMongo;
import com.mongodb.MongoException;
import org.bson.Document;

public class PruebaConexion {
    public static void main(String[] args) {
        try {
            // Usamos el constructor vacío y agregamos la propiedad mediante .append()
            Document respuesta = ConexionMongo.getBaseDeDatos()
                    .runCommand(new Document().append("ping", 1));

            System.out.println("Conexion exitosa a MongoDB Atlas. ok = " + respuesta.get("ok"));
        } catch (MongoException e) {
            System.err.println("No se pudo conectar: " + e.getMessage());
        } finally {
            ConexionMongo.cerrar();
        }
    }
}
