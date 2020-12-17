package Interface;



import Model.Autor;
import java.util.List;

public interface CRUDAutor {
    public List listar(); // Listar
    public Autor buscar(Autor a); // Buscar
    public boolean agregar(Autor a);
    public boolean editar(Autor a);
    public boolean eliminar(int id);
}
