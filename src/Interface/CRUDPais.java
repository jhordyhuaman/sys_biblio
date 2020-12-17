package Interface;



import Model.Pais;
import java.util.List;

public interface CRUDPais {
    public List listar(); // Listar
    public Pais buscar(Pais p); // Buscar
    public boolean agregar(Pais p);
    public boolean editar(Pais p);
    public boolean eliminar(int id);
}
