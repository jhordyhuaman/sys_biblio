package Interface;


import Model.Libro;

import java.util.List;

public interface CRUDLibro {
    public List listar(); // Listar
    public Libro buscar(Libro libro); // Buscar
    public boolean agregar(Libro libro);
    public boolean editar(Libro libro);
    public boolean eliminar(int id);
}
