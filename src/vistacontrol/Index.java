/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistacontrol;

import Dao.AutorDao;
import Dao.EditorialDao;
import Dao.LibroDAO;
import Dao.PaisDao;
import Dao.PrestamoDAO;
import Dao.UsuarioDao;
import Model.Autor;
import Model.Editorial;
import Model.Libro;
import Model.Pais;
import Model.Prestamo;
import Model.Usuario;
import java.text.SimpleDateFormat;
import utils.Leer;
import utils.TableGenerator;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Index {
     public static LibroDAO dao = new LibroDAO();
     public static PaisDao Pdao = new PaisDao();     
     public static AutorDao Adao = new AutorDao();
     public static EditorialDao Edao = new EditorialDao();
     public static PrestamoDAO Prdao = new PrestamoDAO();
     public static UsuarioDao Udao = new  UsuarioDao();
       // listar methods 
    public static void listLibro() {
        List<Libro> libros = dao.listar();
        System.out.println("Listado de Libros");
        TableGenerator tableGenerator = new TableGenerator();
        List<String> headersList = new ArrayList<>();
      
        headersList.add("Id");
        headersList.add("Nombre");
        headersList.add("Nombre Autor");
        headersList.add("Editorial");
        headersList.add("País");
        headersList.add("stock");
        headersList.add("stock disponible");
        headersList.add("paginas");

        List<List<String>> rowsList = new ArrayList<>();

        for (Libro biblioteca : libros) {
            List<String> row = new ArrayList<>();
            
            row.add(String.valueOf(biblioteca.getIdlibro()));
            row.add(format(biblioteca.getNombre().toUpperCase()));
            row.add(format(biblioteca.getAutor().toUpperCase()));
            row.add(biblioteca.getEditorial().toUpperCase());
            row.add(biblioteca.getPais().toUpperCase());
            row.add(String.valueOf(biblioteca.getStock()));
            row.add(String.valueOf(biblioteca.getCodigo()));
            row.add(String.valueOf(biblioteca.getEstado()));

            rowsList.add(row);
        }

        System.out.println(tableGenerator.generateTable(headersList, rowsList));
    } 
    public static void listPais() {
        List<Pais> paises = Pdao.listar();
        System.out.println("Listado de Paises");
        TableGenerator tableGenerator = new TableGenerator();
        List<String> headersList = new ArrayList<>();
      
        headersList.add("Id");
        headersList.add("Nombre");
        headersList.add("Estado");

        List<List<String>> rowsList = new ArrayList<>();

        for (Pais p : paises) {
            List<String> row = new ArrayList<>();
            
            row.add(String.valueOf(p.getIdpais()));
            row.add(p.getNombre().toUpperCase());
            row.add(p.getEstado().toUpperCase());

            rowsList.add(row);
        }

        System.out.println(tableGenerator.generateTable(headersList, rowsList));
    }
    public static void listPrestamosType(String type){
    List<Prestamo> prestamos = Prdao.listar(type);
        System.out.println("Listado de los Prestamos");
        TableGenerator tableGenerator = new TableGenerator();
        List<String> headersList = new ArrayList<>();
       
        headersList.add("Id");
        headersList.add("Fecha prestamo");
        headersList.add("Fecha devolucion");        
        headersList.add("Usuario");
        headersList.add("Libro");
        headersList.add("Estado");

        List<List<String>> rowsList = new ArrayList<>();

        for (Prestamo p : prestamos) {
            List<String> row = new ArrayList<>();
            row.add(String.valueOf(p.getIdprestamo()));
            row.add(p.getFecha_prestamo());
            row.add(p.getFecha_devolucion());
            row.add(p.getUser_name());
            row.add(p.getLibro_titulo());
            row.add(p.getEstado());
            rowsList.add(row);
        }

        System.out.println(tableGenerator.generateTable(headersList, rowsList));
    }
    
    public static void listAutor() {
        List<Autor> autors = Adao.listar();
        System.out.println("Listado de Autores");
        TableGenerator tableGenerator = new TableGenerator();
        List<String> headersList = new ArrayList<>();
      
        headersList.add("Id");
        headersList.add("Nombre");
        headersList.add("Apellido");

        List<List<String>> rowsList = new ArrayList<>();

        for (Autor p : autors) {
            List<String> row = new ArrayList<>();
            
            row.add(String.valueOf(p.getIdautor()));
            row.add(p.getNombre().toUpperCase());
            row.add(p.getApellido().toUpperCase());

            rowsList.add(row);
        }

        System.out.println(tableGenerator.generateTable(headersList, rowsList));
    }
    public static void listEditorial() {
        List<Editorial> editorials = Edao.listar();
        System.out.println("Listado de Editoriales");
        TableGenerator tableGenerator = new TableGenerator();
        List<String> headersList = new ArrayList<>();
      
        headersList.add("Id");
        headersList.add("Nombre");
        headersList.add("Estado");

        List<List<String>> rowsList = new ArrayList<>();

        for (Editorial p : editorials) {
            List<String> row = new ArrayList<>();
            
            row.add(String.valueOf(p.getIdeditorial()));
            row.add(format(p.getNombre().toUpperCase()));
            row.add(p.getEstado().toUpperCase());

            rowsList.add(row);
        }

        System.out.println(tableGenerator.generateTable(headersList, rowsList));
    }
       // eliminar methods
    public static void deleteLibro(){
        System.out.println("Ingrese el ID del libro a Eliminar");
        int id = Leer.entero();
        dao.eliminar(id);
    }
    public static void deletePais(){
        System.out.println("Ingrese el ID del Pais a Eliminar");
        int id = Leer.entero();
        Pdao.eliminar(id);
    }
    public static void deleteAutor(){
        System.out.println("Ingrese el ID del Autor a Eliminar");
        int id = Leer.entero();
        Adao.eliminar(id);
    }
    public static void deletEditorial(){
        System.out.println("Ingrese el ID del la editorial a Eliminar");
        int id = Leer.entero();
        Edao.eliminar(id);
    }
       // editar methods
    public static void editLibro(){
        listLibro();
        System.out.println("Ingrese el ID del Libro a editar: ");
        int id = Leer.entero();
        String nombre,  codigo,  ISBN,  fecha_publicacion,  stock,  precio_compra,  idautor,  ideditorial,  estado,  autor, pais;
        
        System.out.println("Editar Libro");
        
        System.out.print("Nombre: ");
        nombre = Leer.cadena();
        System.out.print("codigo: ");
        codigo = Leer.cadena();
        System.out.print("ISBN: ");
        ISBN = Leer.cadena();
        System.out.print("fecha_publicacion: ");
        fecha_publicacion = Leer.cadena();
        System.out.print("stock: ");
        stock = Leer.cadena();
        System.out.print("precio_compra: ");
        precio_compra = Leer.cadena();
        System.out.print("id autor: ");
        idautor = Leer.cadena();
        System.out.print("id editorial: ");
        ideditorial = Leer.cadena();
        System.out.print("estado: ");
        estado = Leer.cadena();

      
        System.out.print("ID Pais: ");
        pais = Leer.cadena();
       
       
        Libro libro = new Libro(id,nombre,  codigo,  ISBN,  fecha_publicacion,  stock,  precio_compra,  idautor,  ideditorial,  estado, pais);
        dao.editar(libro);
    }
    public static void editEditorial(){
    listEditorial();
        System.out.println("Ingrese el ID de la Editorial a editar: ");
        int id = Leer.entero();
        String nombre;
        String estado;
        System.out.println("Editar Editorial");
        System.out.print("Nombre: ");
        nombre = Leer.cadena();    
        System.out.print("Estado: ");
        estado = Leer.cadena();
        Editorial editorial = new Editorial(id,nombre, estado);
        Edao.editar(editorial);
    }
    public static void editAutor(){
    listAutor();
        System.out.println("Ingrese el ID del Autor a editar: ");
        int id = Leer.entero();
        String nombre,estado,nacionalida,apellido;
        System.out.println("Editar Autor");
        System.out.print("Nombre: ");
        nombre = Leer.cadena();
        System.out.print("Apellido: ");
        apellido = Leer.cadena();
        System.out.print("Nacionalida: ");
        nacionalida = Leer.cadena();
        System.out.print("Estado: ");
        estado = Leer.cadena();
        Autor editorial = new Autor(id,nombre, apellido,nacionalida,estado);
        Adao.editar(editorial);
    }
    public static void editPais(){
        listPais();
        System.out.println("Ingrese el ID del Pais a editar: ");
        int id = Leer.entero();
        String nombre;
        String estado;
        System.out.println("Editar Pais");
        System.out.print("Nombre: ");
        nombre = Leer.cadena();    
        System.out.print("Estado: ");
        estado = Leer.cadena();
        Pais editorial = new Pais(id,nombre, estado);
        Pdao.editar(editorial);
    }
    public static void listUsuarios(){
        List<Usuario> models = Udao.listar();
        System.out.println("Listado de Usuarios");
        TableGenerator tableGenerator = new TableGenerator();
        List<String> headersList = new ArrayList<>();
      
        headersList.add("Id");
        headersList.add("Nombre");
        headersList.add("Apellido");
        headersList.add("DNI");
        headersList.add("Estado");


        List<List<String>> rowsList = new ArrayList<>();

        for (Usuario p : models) {
            List<String> row = new ArrayList<>();
            
            row.add(String.valueOf(p.getIdusuario()));
            row.add(format(p.getNombre().toUpperCase()));
            row.add(format(p.getApellidos().toUpperCase()));
            row.add(p.getDni().toUpperCase());
            row.add(p.getEstado().toUpperCase());


            rowsList.add(row);
        }

        System.out.println(tableGenerator.generateTable(headersList, rowsList));
    }
    public static void addDevolucion(){
        System.out.println("Agregar Devolucion");
        listUsuarios();
        System.out.print("Selecciona el ID o ingrese DNI  ");
        String input = Leer.cadena();
        Usuario user = new Usuario();
        if(input.length() == 8){
            user.setDni(input);
        }else{
            user.setIdusuario(Integer.parseInt(input));
        }
        Usuario us = Udao.buscar(user);
        if(us.getApellidos() != null){
             List<Prestamo> prestamos = Prdao.ListByUser(us.getIdusuario());
                    System.out.println("Prestamos de "+us.getNombre()+" "+us.getApellidos());
                    TableGenerator tableGenerator = new TableGenerator();
                    List<String> headersList = new ArrayList<>();

                    headersList.add("Id");
                    headersList.add("Fecha prestamo");
                    headersList.add("Fecha devolucion");        
                    headersList.add("Usuario");
                    headersList.add("Libro");
                    headersList.add("Estado");

                    List<List<String>> rowsList = new ArrayList<>();

                    for (Prestamo p : prestamos) {
                        List<String> row = new ArrayList<>();
                        row.add(String.valueOf(p.getIdprestamo()));
                        row.add(p.getFecha_prestamo());
                        row.add(p.getFecha_devolucion());
                        row.add(p.getUser_name());
                        row.add(p.getLibro_titulo());
                        row.add(p.getEstado());
                        rowsList.add(row);
                    }

                    System.out.println(tableGenerator.generateTable(headersList, rowsList));
                 
                 
                     System.out.println("Seleccion el ID :");
                      String ID_PRESTAMO = Leer.cadena();
                      SimpleDateFormat format = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
                      Prestamo prestamo = new  Prestamo();
                      prestamo.setIdprestamo(Integer.parseInt(ID_PRESTAMO));
                      prestamo.setIdusuario(us.getIdusuario());
                      prestamo.setFecha_devolucion(format.format(new Date()));
                      prestamo.setEstado("D");
                      
                      if(Prdao.editar(prestamo)){
                        System.out.println("Devolucion registrado correctamente !! ");
                        Prestamo pr = Prdao.buscar(prestamo);
                        Libro lib = dao.buscar(new Libro(pr.getIdlibro()));
                        lib.setCodigo(String.valueOf(Integer.parseInt(lib.getCodigo()) + 1)); // codigo == stockdiponibles 
                        if(dao.updateStock(lib)){
                            System.out.println("Actualizando stock OK !! ");
                        }
                      }else{
                      }

        }else{
            System.out.println("Sin resultados ");
        }
    }
    public static void addPrestamo(){
        System.out.println("Agregar Prestamo");
        listUsuarios();
        System.out.print("Selecciona el ID o ingrese DNI  ");
        String input = Leer.cadena();
        Usuario user = new Usuario();
        if(input.length() == 8){
            user.setDni(input);
        }else{
            user.setIdusuario(Integer.parseInt(input));
        }
        Usuario us = Udao.buscar(user);
        if(us.getApellidos() != null){
            System.out.println("Usuario => "+us.getNombre()+" "+us.getApellidos());
            System.out.print("Buscar libro : [ Nombre del Libro ]  ");
            String libro_name = Leer.cadena();
           
            Libro libro = dao.buscar(new Libro(libro_name));
            if(libro.getNombre() != null){
                 System.out.println("[Usuario] => ["+us.getNombre()+" "+us.getApellidos()+"] Libro => "+libro.getNombre());
                 
                 System.out.println("===============================================");
                 System.out.println("  Guardar prestamo !  1) => SI       2) => NO  ");
                 System.out.println("===============================================");
                 String value = Leer.cadena();
                  if(value.equals("1")){
                      System.out.println("¿Cuantos dias ? :");
                      String dias_prestamo = Leer.cadena();
                      Calendar cal = Calendar.getInstance();
                      cal.setTime(new Date());
                      cal.set(Calendar.DAY_OF_WEEK_IN_MONTH, Integer.parseInt(dias_prestamo));
                      SimpleDateFormat format = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
                      System.out.println(" Fecha de devolución : "+format.format(cal.getTimeInMillis()));                       
                      Prestamo prestamo = new  Prestamo();
                      prestamo.setIdlibro(libro.getIdlibro());
                      prestamo.setIdusuario(us.getIdusuario());
                      prestamo.setFecha_prestamo(format.format(new Date()));
                      prestamo.setFecha_devolucion(format.format(cal.getTimeInMillis()));
                      prestamo.setEstado("P");
                      if(Prdao.agregar(prestamo)){
                        System.out.println("Prestamo registrado correctamente !! ");
                        // update stock
                        Libro lib = dao.buscar(libro);
                        lib.setCodigo(String.valueOf(Integer.parseInt(lib.getCodigo()) - 1)); // codigo == stockdiponibles 
                        if(dao.updateStock(lib)){
                            System.out.println("Actualizando stock OK !! ");
                        }
                      }
                  }  
       
            }else{
             System.out.println("Sin resultados de Libro ");
            }
        }else{
            System.out.println("Sin resultados ");
        }
        
    }

    public static void addLibro(){
         String nombre,  codigo,  ISBN,  fecha_publicacion,  stock,  precio_compra,  idautor,  ideditorial,  estado,  autor, pais;
        System.out.println("Agregar Biblioteca");
     
        System.out.print("Nombre: ");
        nombre = Leer.cadena();
        System.out.print("codigo: ");
        codigo = Leer.cadena();
        System.out.print("ISBN: ");
        ISBN = Leer.cadena();
        System.out.print("fecha_publicacion: ");
        fecha_publicacion = Leer.cadena();
        System.out.print("stock: ");
        stock = Leer.cadena();
        System.out.print("precio_compra: ");
        precio_compra = Leer.cadena();
        System.out.print("id autor: ");
        idautor = Leer.cadena();
        System.out.print("id editorial: ");
        ideditorial = Leer.cadena();
        System.out.print("estado: ");
        estado = Leer.cadena();
 
      
        System.out.print("ID Pais: ");
        pais = Leer.cadena();
       
       
        Libro libro = new Libro(nombre,  codigo,  ISBN,  fecha_publicacion,  stock,  precio_compra,  idautor,  ideditorial,  estado, pais);
        dao.agregar(libro);

    }
    public static void addEditorial(){
        String nombre;
        String estado;
        System.out.println("Nuevo Editorial");
        System.out.print("Nombre: ");
        nombre = Leer.cadena();    
        System.out.print("Estado: ");
        estado = Leer.cadena();
        Editorial editorial = new Editorial(nombre, estado);
        Edao.agregar(editorial);
    }
    public static void addAutor(){
        String nombre,estado,nacionalida,apellido;
        System.out.println("Nuevo Autor");
        System.out.print("Nombre: ");
        nombre = Leer.cadena();
        System.out.print("Apellido: ");
        apellido = Leer.cadena();
        System.out.print("Nacionalida: ");
        nacionalida = Leer.cadena();
        System.out.print("Estado: ");
        estado = Leer.cadena();
        Autor autor = new Autor(nombre, apellido,nacionalida,estado);
        Adao.agregar(autor);
    }
    public static void addPais(){
        String nombre;
        String estado;
        System.out.println("Nuevo Pais");
        System.out.print("Nombre: ");
        nombre = Leer.cadena();    
        System.out.print("Estado: ");
        estado = Leer.cadena();
        Pais editorial = new Pais(nombre, estado);
        Pdao.agregar(editorial);
    }
    
    
    public static void salir(){
        System.out.println("Gracias por su visita....");
    }
    public static void error(int tipo){
        switch(tipo){
            case 1:
                System.out.println("- Opcion Fuera de Rango");
                break;
            case 2:
                System.out.println("- DNI debe tener 10 Dígitos");
                break;
            case 3:
                System.out.println("- DNI debe ser compuesto por dígitos");
                break;
            case 4:
                System.out.println("- DNI repetido (Pertenece a otra persona)");
            default:
                System.out.println("Error");
        }

    }

    public static void menu(){
        System.out.println("===============================================");
        System.out.println("              Menu Principal                  ");
        System.out.println("===============================================");
        System.out.print("1. Datos Autor");
        System.out.println("     - 2. Datos Pais");
        System.out.print("3. Datos Editorial");
        System.out.println(" - 4. Datos Usuario");
        System.out.print("5. Datos Libro");
        System.out.println("     - 6. Prestamos"); 
        System.out.print("7. Devoluciones");
        System.out.println("    - 8. Salir");         
        System.out.println("===============================================");
        
    }
    public static void PrintSubMenu(String Item){
        SimpleDateFormat time = new SimpleDateFormat("hh:mm:ss");
        System.out.println("===============================================");
        System.out.println("           "+Item+"  HORA: "+time.format(new Date()));
        System.out.println("===============================================");
        if(Item.equals("Prestamo") || Item.equals("Devoluciones") ){
                System.out.print("1. Listar");
                System.out.println("  - 2. Agregar");
                System.out.print("5. Atras");
                System.out.println("  "); 
        }else{
        System.out.print("1. Listar");
        System.out.println("  - 2. Agregar");
        System.out.print("3. Eliminar");
        System.out.println(" - 4. Editar");  
        System.out.print("5. Atras");
        System.out.println(""); 
        System.out.println("===============================================");
        }

    }
    
    public static void inicio(){
       
        int opcion;
        do {
             menu();
            opcion = Leer.entero();
            switch(opcion){
                case 1:
                    subMenu("Autor");
                    break;
                case 2:
                    subMenu("Pais");
                    break;
                case 3:
                    subMenu("Editorial");
                    break;
                case 4:
                    subMenu("Usuario");
                    break;
                case 5:
                    subMenu("Libro");
                    break;
                case 6:
                    subMenu("Prestamo");
                    break;
                case 7:
                    subMenu("Devoluciones");
                    break;
           
                default:
                    error(1);
                    break;
            }
        } while (opcion!=8);
    }

    public static void startMenu(String item,int option){
        switch(item){
                case "Autor":
                    switch(option){
                        case 1:
                            listAutor();
                        break;
                        case 2:
                            addAutor();
                        break;
                        case 3:
                            editAutor();
                        break;
                        case 4:
                            deleteAutor();
                        break;
                    }
                break;
                case "Pais":
                    switch(option){
                        case 1:
                            listPais();
                        break;
                        case 2:
                            addPais();
                        break;
                        case 3:
                            editPais();
                        break;
                        case 4:
                            editPais();
                        break;
                    }
                break;
                case "Editorial":
                    switch(option){
                        case 1:
                            listEditorial();
                        break;
                        case 2:
                            addEditorial();
                        break;
                        case 3:
                            editEditorial();
                        break;
                        case 4:
                            deletEditorial();
                        break;
                    }
                break;
                case "Usuario":
                    switch(option){
                        case 1:
                            listUsuarios();
                        break;
                        case 2:
                        break;
                        case 3:
                        break;
                        case 4:
                        break;
                    }
                break;
                case "Libro":
                    switch(option){
                        case 1:
                            listLibro();
                        break;
                        case 2:
                            addLibro();
                        break;
                        case 3:
                            editLibro();
                        break;
                        case 4:
                            deleteLibro();
                        break;
                    }
                break;
                case "Prestamo":
                    switch(option){
                        case 1:
                            listPrestamosType("P");
                        break;
                        case 2:
                            addPrestamo();
                        break;
                    }
                break;
                case "Devoluciones":
                    switch(option){
                        case 1:
                            listPrestamosType("D");
                        break;
                        case 2:
                            addDevolucion();
                        break;
                    }
                break;
                
        }
    }
    public static void subMenu(String item){
        int opcion;
        do {
            PrintSubMenu(item);
            opcion = Leer.entero();
            startMenu(item, opcion);
        } while (opcion!=5);
    }

    
    
    public static void main(String[] args) {
        inicio();
    }

    public static String format(String cadena){
        cadena.replace(" ","\u200F\u200F");
        if (cadena.length()>=28) {
            cadena = cadena.substring(0,28) + "...";

        }else if (cadena.length()>=10){
            cadena = cadena + "..";
        }
        return cadena;
    }

    public static String validate(String value,int max_length){
        String input = "";
        do {
            input = Leer.cadena();
            if (input.length()>max_length){
                System.out.println("Introducir Nuevamente "+value);
            }else{
                break;
            }
        } while (true);
        return input;
    }
}
