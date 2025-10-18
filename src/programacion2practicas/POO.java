package programacion2practicas;
import java.util.Scanner;


class POO {
    public static void main(String[] args) {
    // empleados con constructor completo
        Empleado emp1 = new Empleado(1, "Ana", "Gerente", 1200000);
        Empleado emp2 = new Empleado(2, "Luis", "Vendedor", 950000);

        // con constructor que asigna id automático y salario por defecto
        Empleado emp3 = new Empleado("Marta", "Asistente");
        Empleado emp4 = new Empleado("Carlos", "Analista");

        // Aplicando métodos actualizarSalario
        emp1.actualizarSalario(10.0);      // +10% de salario
        emp2.actualizarSalario(150000);  // +150000 fijo
        emp3.actualizarSalario(5.0);       // +5%
        emp4.actualizarSalario(200000);  // +200000 fijo

        // Imprimiendo información de cada empleado
        System.out.println(emp1);
        System.out.println(emp2);
        System.out.println(emp3);
        System.out.println(emp4);

        // Mostrando total de empleados creados
        System.out.println("Total de empleados: " + Empleado.mostrarTotalEmpleados());
   
    }   
}


class Empleado{
    private int id;
    private String nombre;
    private String puesto;
    private double salario_actual;
    private static int totalEmpleados;
    
    //Constructores y sobrecarga 
    public Empleado(){
        totalEmpleados++;
    }
    public Empleado(int id, String nombre, String puesto, double salario_actual) {
        this();
        this.id = id;
        this.nombre = nombre;
        this.puesto = puesto;
        this.salario_actual = salario_actual;
    }
    public Empleado(String nombre, String puesto) {
        this();
        this.id = totalEmpleados;
        this.nombre = nombre;
        this.puesto = puesto;
        this.salario_actual = 1300000;
        
    }
    
    //Metodos y sobrecarga 
    public void actualizarSalario(double porcentaje ){
        this.salario_actual += this.salario_actual * (porcentaje /100);
    }
    
    public void actualizarSalario(int cantidadFija ){
        this.salario_actual += cantidadFija;
    }
    
    //tostring
    @Override
    public String toString() {
        return "Empleado {" +
               "id=" + id +
               ", nombre='" + nombre + '\'' +
               ", puesto='" + puesto + '\'' +
               ", salario_actual=" + salario_actual +
               '}';
    }
    
    //Metodos estaticos
    public static int mostrarTotalEmpleados(){
        return totalEmpleados;
    }
    
    //getters y setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public double getSalario_actual() {
        return salario_actual;
    }

    public void setSalario_actual(double salario_actual) {
        this.salario_actual = salario_actual;
    }

   
}



