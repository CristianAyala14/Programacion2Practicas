


class IntroduccionAPOO {
    public static void main(String[] args) {
        // Ejercicio 1:
        Estudiante estudiante1 = new Estudiante("Juan", "Pérez",                                     "Programación", 8.5);
        estudiante1.mostrarInfo();
        estudiante1.subirCalificacion(1.0);
        estudiante1.mostrarInfo();
        estudiante1.bajarCalificacion(2.0);
        estudiante1.mostrarInfo();
        
        
        // Ejercicio 2:
        Mascota mascota1 = new Mascota("Firulais", "Perro", 3);
        mascota1.mostrarInfo();
        mascota1.cumplirAnios();
        mascota1.mostrarInfo();
        mascota1.cumplirAnios();
        mascota1.mostrarInfo();
        
        
        // Ejercicio 3:
        Libro libro1 = new Libro("Cien años de soledad", "Gabriel García Márquez", 1967);
        libro1.mostrarInfo();
        // modificando con dato no valido para ejemplificar:
        System.out.println("\nIntentando establecer año de publicación: 1800");
        libro1.setAnioPublicacion(1800); // el año invalido
        libro1.mostrarInfo();
        // ahora modifico con un valor correcto
        System.out.println("\nEstableciendo año de publicación: 1985");
        libro1.setAnioPublicacion(1985); // Año válido
        libro1.mostrarInfo();
        
        //EJERCICIO 4:
        Gallina gallina1 = new Gallina(1, 2, 30);
        Gallina gallina2 = new Gallina(2, 1, 10);
        // Mostrar estado inicial
        System.out.println("Estado Inicial:");
        gallina1.mostrarEstado();
        gallina2.mostrarEstado();
        // Simular acciones
        System.out.println("\nSimulación de acciones:");
        gallina1.envejecer();
        gallina1.ponerHuevo();
        gallina1.ponerHuevo();
        gallina2.envejecer();
        gallina2.ponerHuevo();
        System.out.println("\nEstado Final:");
        gallina1.mostrarEstado();
        gallina2.mostrarEstado();
        
        
        
        //EJERCICIO 5:
         // Crear una nave con 50 unidades de combustible
        NaveEspacial nave1 = new NaveEspacial("Explorer", 50, 100); // nombre, combustible inicial, combustible máximo

       
        System.out.println("Estado Inicial:");
        nave1.mostrarEstado();

        // Intentar avanzar sin recargar suficiente
        System.out.println("\nIntentando avanzar 60 unidades de distancia:");
        nave1.avanzar(60); // no debería poder
        // Recargar combustible
        System.out.println("\nRecargando 40 unidades de combustible:");
        nave1.recargarCombustible(40);
        // Intentar avanzar nuevamente
        System.out.println("\nIntentando avanzar 60 unidades de distancia:");
        nave1.avanzar(60); // ahora debería poder
        // Mostrar estado final
        System.out.println("\n=== Estado Final ===");
        nave1.mostrarEstado();
        
       
    }
}

//EJERCICIO 1
class Estudiante {
    // Atributos
    private String nombre;
    private String apellido;
    private String curso;
    private double calificacion;

    // Constructor
        public Estudiante(String nombre, String apellido, String curso,                       double calificacion) {
            this.nombre = nombre;
            this.apellido = apellido;
            this.curso = curso;
            this.calificacion = calificacion;
        }

    // Mostrar información
    public void mostrarInfo() {
        System.out.println("----- Información del Estudiante -----");
        System.out.println("Nombre: " + nombre);
        System.out.println("Apellido: " + apellido);
        System.out.println("Curso: " + curso);
        System.out.println("Calificación: " + calificacion);
        System.out.println("--------------------------------------");
    }

    // Subir calificacion
    public void subirCalificacion(double puntos) {
        calificacion += puntos;
        System.out.println("Calificación aumentada en " + puntos + " puntos.");
    }

    // Bajar calificacion
    public void bajarCalificacion(double puntos) {
        calificacion -= puntos;
        if (calificacion < 0) {
            calificacion = 0; 
        }
        System.out.println("Calificación reducida en " + puntos + "                                     puntos.");
    }
}


// EJERCICIO 2: 
class Mascota {
    // Atributos
    private String nombre;
    private String especie;
    private int edad;

    // Constructor
    public Mascota(String nombre, String especie, int edad) {
        this.nombre = nombre;
        this.especie = especie;
        this.edad = edad;
    }

    // Mostrar informaciOn
    public void mostrarInfo() {
        System.out.println("----- Información de la Mascota -----");
        System.out.println("Nombre: " + nombre);
        System.out.println("Especie: " + especie);
        System.out.println("Edad: " + edad + " años");
        System.out.println("-------------------------------------");
    }

    // Incrementar la edad
    public void cumplirAnios() {
        edad++;
        System.out.println(nombre + " ha cumplido un año más. ¡Felicidades!");
    }
}

//EJERCICIO 3:
class Libro {
    // Atributos privados para hacer uso de getters y setters
    private String titulo;
    private String autor;
    private int anioPublicacion;

    // Constructor
    public Libro(String titulo, String autor, int anioPublicacion) {
        this.titulo = titulo;
        this.autor = autor;
        this.anioPublicacion = anioPublicacion;
    }

    // Getters
    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public int getAnioPublicacion() {
        return anioPublicacion;
    }

    // Setter con validación
    public void setAnioPublicacion(int anioPublicacion) {
        if (anioPublicacion >= 1900 && anioPublicacion <= 2025) {
            this.anioPublicacion = anioPublicacion;
            System.out.println("Año de publicación actualizado correctamente.");
        } else {
            System.out.println("Error: año de publicación inválido. Debe estar entre 1900 y 2025.");
        }
    }

    // Mostrar info del libro
    public void mostrarInfo() {
        System.out.println("----- Información del Libro -----");
        System.out.println("Título: " + titulo);
        System.out.println("Autor: " + autor);
        System.out.println("Año de publicación: " + anioPublicacion);
        System.out.println("---------------------------------");
    }
}

//EJERCICIO 4:
class Gallina {
    // Atributos
    private int idGallina;
    private int edad; // en años
    private int huevosPuestos;

    // Constructor
    public Gallina(int idGallina, int edad, int huevosPuestos) {
        this.idGallina = idGallina;
        this.edad = edad;
        this.huevosPuestos = huevosPuestos;
    }

    // Método para poner un huevo
    public void ponerHuevo() {
        huevosPuestos++;
        System.out.println("La gallina #" + idGallina + " ha puesto un huevo. Total ahora: " + huevosPuestos);
    }

    // Método para envejecer
    public void envejecer() {
        edad++;
        System.out.println("La gallina #" + idGallina + " ha cumplido un año más. Edad actual: " + edad);
    }

    // Método para mostrar el estado
    public void mostrarEstado() {
        System.out.println("Gallina #" + idGallina + " | Edad: " + edad + " años | Huevos puestos: " + huevosPuestos);
    }
}


//EJERCICIO 5: 
class NaveEspacial {
    private String nombre;
    private double combustible;      // combustible actual
    private double combustibleMax;   // límite máximo de combustible

    // Constructor
    public NaveEspacial(String nombre, double combustible, double combustibleMax) {
        this.nombre = nombre;
        this.combustible = combustible;
        this.combustibleMax = combustibleMax;
    }

    public void despegar() {
        System.out.println(nombre + " ha despegado!");
    }

    public void avanzar(double distancia) {
        double consumo = distancia * 1; // 1 unidad de combustible por unidad de distancia
        if (combustible >= consumo) {
            combustible -= consumo;
            System.out.println(nombre + " avanzó " + distancia + " unidades de distancia. Combustible restante: " + combustible);
        } else {
            System.out.println("No hay suficiente combustible para avanzar " + distancia + " unidades. Combustible actual: " + combustible);
        }
    }

    public void recargarCombustible(double cantidad) {
        if (combustible + cantidad > combustibleMax) {
            combustible = combustibleMax;
            System.out.println(nombre + " recargó hasta el máximo: " + combustibleMax + " unidades de combustible.");
        } else {
            combustible += cantidad;
            System.out.println(nombre + " recargó " + cantidad + " unidades de combustible. Total ahora: " + combustible);
        }
    }

    public void mostrarEstado() {
        System.out.println("----- Estado de la Nave -----");
        System.out.println("Nombre: " + nombre);
        System.out.println("Combustible actual: " + combustible + "/" + combustibleMax);
        System.out.println("-----------------------------");
    }
}