package Interface;



import Model.Prestamo;
import java.util.List;

public interface CRUDPrestamo {
    public List listar(String type); // Listar
    public Prestamo buscar(Prestamo p); // Buscar
    public boolean agregar(Prestamo p);
    public List ListByUser(int id);
    public boolean editar(Prestamo p);
}
