package Interface;



import Model.Editorial;
import java.util.List;

public interface CRUDEditorial {
    public List listar(); // Listar
    public Editorial buscar(Editorial e); // Buscar
    public boolean agregar(Editorial e);
    public boolean editar(Editorial e);
    public boolean eliminar(int id);
}
