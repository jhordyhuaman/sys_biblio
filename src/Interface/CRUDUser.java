package Interface;


import Model.Usuario;

import java.util.List;

public interface CRUDUser {
    public List listar(); // Listar
    public Usuario buscar(Usuario user); // Buscar
    public boolean agregar(Usuario user);
    public boolean editar(Usuario user);
    public boolean eliminar(int id);
}
