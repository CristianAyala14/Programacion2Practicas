package programacion2practicas;

import java.util.ArrayList;
import java.util.UUID;
import java.util.List;

/**
 * @author cristian pablo ayala
 * TRABAJO PRACTICA COLECCIONES - 
 */


class Colecciones {
    public static void main(String[] args) {
        // EJERCICIO 1
        Inventario inventario = new Inventario();
        Producto p1 = new Producto("Laptop", 2500.0, 5, CategoriaProducto.ELECTRONICA);
        Producto p2 = new Producto("Remera", 1500.0, 10, CategoriaProducto.ROPA);
        Producto p3 = new Producto("Arroz", 500.0, 20, CategoriaProducto.ALIMENTOS);
        System.out.println(inventario.agregarProducto(p1));
        System.out.println(inventario.agregarProducto(p2));
        System.out.println(inventario.agregarProducto(p3));
        System.out.println("\n--- Listar productos ---");
        inventario.listarProductos();
        System.out.println("\n--- Categorías disponibles ---");
        inventario.mostrarCategoriasDisponibles();
        
        
        // EJERCICIO 2
        //Creo bibilioteca
        Biblioteca biblioteca = new Biblioteca();
        //Creo autores
        Autor autor1 = new Autor("George Orwell", "Británico");
        Autor autor2 = new Autor("Gabriel García Márquez", "Colombiano");
        Autor autor3 = new Autor("J.K. Rowling", "Británica");
        //Agrego 5 libros asociados a los autores
        biblioteca.agregarLibro("1984", 1949, autor1);
        biblioteca.agregarLibro("Cien Años de Soledad", 1967, autor2);
        biblioteca.agregarLibro("Harry Potter y la Piedra Filosofal", 1997, autor3);
        biblioteca.agregarLibro("Harry Potter y la Cámara Secreta", 1998, autor3);
        biblioteca.agregarLibro("El Coronel no Tiene Quien le Escriba", 1961, autor2);
        // Listo todos los libros con info
        System.out.println("\n--- Listado de todos los libros ---");
        biblioteca.listarLibros();
        //Busco un libro por ISBN
        Libro libroEncontrado = biblioteca.buscarLibroPorIsbn("asdasda");
        //Filtro por año
        biblioteca.filtrarLibrosPorAnio(1997);
        //Elimino un libro por ISBN
        biblioteca.eliminarLibroPorIsbn("asdadsa");
        // Muestro cantidad total de libros
        int cant = biblioteca.obtenerCantidadLibros();
        
    }
}

//EJERCICIO 1---------------------------------------------------------------------------------------------------------------------------------

class Producto {
    private String id;
    private String nombre;
    private double precio;
    private int cantStock;
    private CategoriaProducto catProd;


    public Producto(String nombre, double precio, int cantStock, CategoriaProducto catProd) {
        this.id = UUID.randomUUID().toString(); 
        this.nombre = nombre;
        this.precio = precio;
        this.cantStock = cantStock;
        this.catProd = catProd;
    }

    // Getters y Setters 
    public String getId() { return id; }
    public String getNombre() { return nombre; }
    public double getPrecio() { return precio; }
    public int getCantStock() { return cantStock; }
    public void setCantStock(int cantStock) { this.cantStock = cantStock; }
    public CategoriaProducto getCatProd() { return catProd; }

    // Mostrar info
    public void mostrarInfo() {
        System.out.println("ID: " + id);
        System.out.println("Nombre: " + nombre);
        System.out.println("Precio: $" + precio);
        System.out.println("Cantidad en stock: " + cantStock);
        System.out.println("Categoría: " + catProd + " - " + catProd.getDescripcion());
    }

    
    @Override
    public String toString() {
        return nombre + " ($" + precio + ")";
    }
}

// Enum CategoriaProducto 
enum CategoriaProducto {
    ALIMENTOS("Productos comestibles"),
    ELECTRONICA("Dispositivos electrónicos"),
    ROPA("Prendas de vestir"),
    HOGAR("Artículos de hogar");

    private final String descripcion;

    private CategoriaProducto(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }
}

// Clase Inventario
class Inventario {
    private ArrayList<Producto> productos = new ArrayList<>();

    public Inventario() {}

    public String agregarProducto(Producto p) {
        if (p != null && !productos.contains(p)) {
            productos.add(p);
            return "El producto " + p.getNombre() + " ha sido agregado correctamente.";
        } else {
            return "El producto no existe o ya está agregado.";
        }
    }

    public void listarProductos() {
        if (productos.isEmpty()) {
            System.out.println("No hay productos en el inventario.");
        } else {
            for (Producto p : productos) {
                p.mostrarInfo();
                System.out.println("---------------------------");
            }
        }
    }

    public Producto buscarProductoPorId(String id) {
        for (Producto p : productos) {
            if (p.getId().equals(id)) {
                return p;
            }
        }
        return null;
    }

    public boolean eliminarProducto(String id) {
        Producto p = buscarProductoPorId(id);
        if (p != null) {
            productos.remove(p);
            return true;
        }
        return false;
    }

    public boolean actualizarStock(String id, int nuevaCantidad) {
        Producto p = buscarProductoPorId(id);
        if (p != null) {
            p.setCantStock(nuevaCantidad);
            return true;
        }
        return false;
    }

    public ArrayList<Producto> filtrarPorCategoria(CategoriaProducto categoria) {
        ArrayList<Producto> resultado = new ArrayList<>();
        for (Producto p : productos) {
            if (p.getCatProd() == categoria) {
                resultado.add(p);
            }
        }
        return resultado;
    }

    public int obtenerTotalStock() {
        int total = 0;
        for (Producto p : productos) {
            total += p.getCantStock();
        }
        return total;
    }

    public Producto obtenerProductoConMayorStock() {
        if (productos.isEmpty()) return null;

        Producto max = productos.get(0);
        for (Producto p : productos) {
            if (p.getCantStock() > max.getCantStock()) {
                max = p;
            }
        }
        return max;
    }

    public ArrayList<Producto> filtrarProductosPorPrecio(double min, double max) {
        ArrayList<Producto> resultado = new ArrayList<>();
        for (Producto p : productos) {
            if (p.getPrecio() >= min && p.getPrecio() <= max) {
                resultado.add(p);
            }
        }
        return resultado;
    }

    public void mostrarCategoriasDisponibles() {
        System.out.println("Categorías disponibles:");
        for (CategoriaProducto c : CategoriaProducto.values()) {
            System.out.println("- " + c + " (" + c.getDescripcion() + ")");
        }
    }
}


//EJERCICIO 2---------------------------------------------------------------------------------------------------------------------------------
//Clase autor
class Autor {
    private String id;
    private String nombre;
    private String nacionalidad;

    public Autor(String nombre, String nacionalidad) {
        this.id = UUID.randomUUID().toString(); 
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
    }

    // Getters
    public String getId() { return id; }
    public String getNombre() { return nombre; }
    public String getNacionalidad() { return nacionalidad; }

    public void mostrarInfo() {
        System.out.println("Autor: " + nombre);
        System.out.println("Nacionalidad: " + nacionalidad);
    }

    @Override
    public String toString() {
        return nombre + " (" + nacionalidad + ")";
    }
}

// Clase libro
class Libro {
    private String isbn;
    private String titulo;
    private int anioPublicacion;
    private Autor autor;
    

    public Libro(String titulo, int anioPublicacion, Autor autor) {
        this.isbn = UUID.randomUUID().toString(); 
        this.titulo = titulo;
        this.autor = autor;
        this.anioPublicacion = anioPublicacion;
        
    }

    // Getters}
    public String getIsbn() { return isbn; }
    public String getTitulo() { return titulo; }
    public Autor getAutor() { return autor; }
    public int getAnioPublicacion() { return anioPublicacion; }
    

    public void mostrarInfo() {
        System.out.println("Isbn: " + isbn);
        System.out.println("Título: " + titulo);
        System.out.println("Autor: " + autor.getNombre());
        System.out.println("Año: " + anioPublicacion);
    }

    @Override
    public String toString() {
        return titulo + " de " + autor;
    }
}


//Clase InventarioLibros
class Biblioteca {
    private String nombre;
    
    private List<Libro> libros = new ArrayList<>();

    public String agregarLibro(String titulo, int anioPublicacion, Autor autor) {
        Libro libro = new Libro(titulo, anioPublicacion, autor);
        libros.add(libro);
        return "El libro \"" + libro.getTitulo() + "\" ha sido agregado correctamente.";
    }

    public void listarLibros() {
        if (libros.isEmpty()) {
            System.out.println("No hay libros en el inventario.");
        } else {
            for (Libro libro : libros) {
                libro.mostrarInfo();
                System.out.println("---------------------------");
            }
        }
    }
    
     public Libro buscarLibroPorIsbn(String isbn) {
        for (Libro libro : libros) {
            if (libro.getIsbn().equalsIgnoreCase(isbn)) {
                return libro;
            }
        }
        return null;
    }
     
    public void eliminarLibroPorIsbn(String isbn){
        Libro libroEncontrado = buscarLibroPorIsbn(isbn);
        if(libroEncontrado != null){
            libros.remove(libroEncontrado);
            System.out.println("❌ Libro eliminado: " + libroEncontrado.getTitulo());
        }else{
            System.out.println("⚠️ No se encontró un libro con ISBN " + isbn);
        }
    }
    
   
    public Libro buscarLibroPorTitulo(String titulo) {
        for (Libro libro : libros) {
            if (libro.getTitulo().equalsIgnoreCase(titulo)) {
                return libro;
            }
        }
        return null;
    }
    
    public int obtenerCantidadLibros() {
        return libros.size();
    }

    public void filtrarLibrosPorAnio(int anio) {
        System.out.println("📖 Libros del año " + anio + ":");
        for (Libro libro : libros) {
            if (libro.getAnioPublicacion() == anio) {
                System.out.println(libro);
            }
        }
    }

}


//EJERCICIO 3-----------------------------------------------------------------------------------------------------------------------
// Clase Profesor
class Profesor {
    private String id;
    private String nombre;
    private String especialidad;
    private List<Curso> cursos = new ArrayList<>();

    public Profesor(String nombre, String especialidad) {
        this.id = UUID.randomUUID().toString();
        this.nombre = nombre;
        this.especialidad = especialidad;
    }

    public String getId() { return id; }
    public String getNombre() { return nombre; }
    public String getEspecialidad() { return especialidad; }
    public List<Curso> getCursos() { return cursos; }

    // Sincronizando el lado del curso
    public void agregarCurso(Curso c) {
        if (c != null && !cursos.contains(c)) {
            cursos.add(c);
            if (c.getProfesor() != this) {
                c.setProfesor(this); 
            }
        }
    }

    public void eliminarCurso(Curso c) {
        if (cursos.remove(c)) {
            if (c.getProfesor() == this) {
                c.setProfesor(null); // rompe el vínculo
            }
        }
    }

    public void listarCursos() {
        if (cursos.isEmpty()) {
            System.out.println(nombre + " no dicta cursos actualmente.");
        } else {
            System.out.println("Cursos dictados por " + nombre + ":");
            for (Curso c : cursos) {
                System.out.println(" - [" + c.getCodigo() + "] " + c.getNombre());
            }
        }
    }

    public void mostrarInfo() {
        System.out.println("Profesor: " + nombre);
        System.out.println("Especialidad: " + especialidad);
        System.out.println("Cantidad de cursos: " + cursos.size());
    }

    @Override
    public String toString() {
        return nombre + " (" + especialidad + ")";
    }
}


// Clase Curso
class Curso {
    private String codigo;
    private String nombre;
    private Profesor profesor;

    public Curso(String codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }

    public String getCodigo() { return codigo; }
    public String getNombre() { return nombre; }
    public Profesor getProfesor() { return profesor; }

    public void setProfesor(Profesor p) {
        if (this.profesor == p) return; // No hacer nada si es el mismo

        // Si tenía profesor anterior, se quita de su lista
        if (this.profesor != null) {
            this.profesor.getCursos().remove(this);
        }

        this.profesor = p;

        // Si el nuevo profesor no es null, agregar este curso a su lista
        if (p != null && !p.getCursos().contains(this)) {
            p.getCursos().add(this);
        }
    }

    public void mostrarInfo() {
        System.out.println("Código: " + codigo);
        System.out.println("Nombre: " + nombre);
        System.out.println("Profesor: " + (profesor != null ? profesor.getNombre() : "Sin asignar"));
    }

    @Override
    public String toString() {
        return "[" + codigo + "] " + nombre + " - Profesor: " +
                (profesor != null ? profesor.getNombre() : "Sin asignar");
    }
}


// Clase Universidad
class Universidad {
    private String nombre;
    private List<Profesor> profesores = new ArrayList<>();
    private List<Curso> cursos = new ArrayList<>();

    public Universidad(String nombre) {
        this.nombre = nombre;
    }

    public void agregarProfesor(Profesor p) {
        if (p != null && !profesores.contains(p)) {
            profesores.add(p);
        }
    }

    public void agregarCurso(Curso c) {
        if (c != null && !cursos.contains(c)) {
            cursos.add(c);
        }
    }

    public Profesor buscarProfesorPorId(String id) {
        for (Profesor p : profesores) {
            if (p.getId().equals(id)) return p;
        }
        return null;
    }

    public Curso buscarCursoPorCodigo(String codigo) {
        for (Curso c : cursos) {
            if (c.getCodigo().equalsIgnoreCase(codigo)) return c;
        }
        return null;
    }

    public void asignarProfesorACurso(String codigoCurso, String idProfesor) {
        Curso curso = buscarCursoPorCodigo(codigoCurso);
        Profesor profesor = buscarProfesorPorId(idProfesor);
        if (curso != null && profesor != null) {
            curso.setProfesor(profesor);
            System.out.println("✅ Profesor " + profesor.getNombre() +
                    " asignado al curso " + curso.getNombre());
        } else {
            System.out.println("⚠️ No se pudo asignar. Verifique códigos e IDs.");
        }
    }

    public void eliminarCurso(String codigo) {
        Curso curso = buscarCursoPorCodigo(codigo);
        if (curso != null) {
            if (curso.getProfesor() != null) {
                curso.setProfesor(null); // romper relación
            }
            cursos.remove(curso);
            System.out.println("❌ Curso eliminado: " + codigo);
        }
    }

    public void eliminarProfesor(String id) {
        Profesor profesor = buscarProfesorPorId(id);
        if (profesor != null) {
            // Romper relaciones con sus cursos
            for (Curso c : new ArrayList<>(profesor.getCursos())) {
                c.setProfesor(null);
            }
            profesores.remove(profesor);
            System.out.println("❌ Profesor eliminado: " + profesor.getNombre());
        }
    }

    public void listarProfesores() {
        System.out.println("\n👩‍🏫 Profesores de " + nombre + ":");
        for (Profesor p : profesores) {
            p.mostrarInfo();
            p.listarCursos();
            System.out.println("----------------------");
        }
    }

    public void listarCursos() {
        System.out.println("\n📚 Cursos de " + nombre + ":");
        for (Curso c : cursos) {
            c.mostrarInfo();
            System.out.println("----------------------");
        }
    }

    public void reporteCantidadCursosPorProfesor() {
        System.out.println("\n📊 Reporte de cursos por profesor:");
        for (Profesor p : profesores) {
            System.out.println(p.getNombre() + " → " + p.getCursos().size() + " cursos");
        }
    }
}