/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package programacion2practicas;

import java.util.*;

/**
 *
 * @author cristian.ayala
 */
public class herenciaypoliformismo {

    // MÉTODO PRINCIPAL
    public static void main(String[] args) {

        System.out.println("===============================================");
        System.out.println("1. VEHÍCULOS Y HERENCIA BÁSICA");
        System.out.println("===============================================");
        Auto auto = new Auto("Toyota", "Corolla", 4);
        auto.mostrarInfo();

        System.out.println("\n===============================================");
        System.out.println("2. FIGURAS GEOMÉTRICAS Y POLIMORFISMO");
        System.out.println("===============================================");
        Figura[] figuras = {
            new Circulo(5),
            new Rectangulo(4, 6)
        };

        for (Figura f : figuras) {
            System.out.println(f.getNombre() + " -> Área: " + f.calcularArea());
        }

        System.out.println("\n===============================================");
        System.out.println("3. EMPLEADOS Y POLIMORFISMO");
        System.out.println("===============================================");
        List<Empleado> empleados = new ArrayList<>();
        empleados.add(new EmpleadoPlanta("Juan", 150000));
        empleados.add(new EmpleadoTemporal("Ana", 80, 1500));

        for (Empleado e : empleados) {
            System.out.println("Empleado: " + e.getNombre() + ", Sueldo: $" + e.calcularSueldo());

            // Clasificación usando instanceof
            if (e instanceof EmpleadoPlanta) {
                System.out.println(" -> Es un empleado de planta.");
            } else if (e instanceof EmpleadoTemporal) {
                System.out.println(" -> Es un empleado temporal.");
            }
        }

        System.out.println("\n===============================================");
        System.out.println("4. ANIMALES Y COMPORTAMIENTO SOBRESCRITO");
        System.out.println("===============================================");
        Animal[] animales = {
            new Perro(),
            new Gato(),
            new Vaca()
        };

        for (Animal a : animales) {
            a.describirAnimal();
            a.hacerSonido();
        }

        System.out.println("\n===============================================");
        System.out.println("FIN DE LAS KATAS - HERENCIA Y POLIMORFISMO");
        System.out.println("===============================================");
    }
}

// ======================================================
// 1.
// ======================================================

class Vehiculo {
    protected String marca;
    protected String modelo;

    public Vehiculo(String marca, String modelo) {
        this.marca = marca;
        this.modelo = modelo;
    }

    public void mostrarInfo() {
        System.out.println("Marca: " + marca + ", Modelo: " + modelo);
    }
}

class Auto extends Vehiculo {
    private int cantidadPuertas;

    public Auto(String marca, String modelo, int cantidadPuertas) {
        super(marca, modelo);
        this.cantidadPuertas = cantidadPuertas;
    }

    @Override
    public void mostrarInfo() {
        System.out.println("Auto -> Marca: " + marca + ", Modelo: " + modelo + ", Puertas: " + cantidadPuertas);
    }
}

// ======================================================
// 2. 
// ======================================================

abstract class Figura {
    protected String nombre;

    public Figura(String nombre) {
        this.nombre = nombre;
    }

    public abstract double calcularArea();

    public String getNombre() {
        return nombre;
    }
}

class Circulo extends Figura {
    private double radio;

    public Circulo(double radio) {
        super("Círculo");
        this.radio = radio;
    }

    @Override
    public double calcularArea() {
        return Math.PI * Math.pow(radio, 2);
    }
}

class Rectangulo extends Figura {
    private double base;
    private double altura;

    public Rectangulo(double base, double altura) {
        super("Rectángulo");
        this.base = base;
        this.altura = altura;
    }

    @Override
    public double calcularArea() {
        return base * altura;
    }
}

// ======================================================
// 3. 
// ======================================================

abstract class Empleado {
    protected String nombre;

    public Empleado(String nombre) {
        this.nombre = nombre;
    }

    public abstract double calcularSueldo();

    public String getNombre() {
        return nombre;
    }
}

class EmpleadoPlanta extends Empleado {
    private double sueldoBase;

    public EmpleadoPlanta(String nombre, double sueldoBase) {
        super(nombre);
        this.sueldoBase = sueldoBase;
    }

    @Override
    public double calcularSueldo() {
        return sueldoBase;
    }
}

class EmpleadoTemporal extends Empleado {
    private int horasTrabajadas;
    private double valorHora;

    public EmpleadoTemporal(String nombre, int horasTrabajadas, double valorHora) {
        super(nombre);
        this.horasTrabajadas = horasTrabajadas;
        this.valorHora = valorHora;
    }

    @Override
    public double calcularSueldo() {
        return horasTrabajadas * valorHora;
    }
}

// ======================================================
// 4.
// ======================================================

class Animal {
    public void hacerSonido() {
        System.out.println("El animal hace un sonido genérico.");
    }

    public void describirAnimal() {
        System.out.println("Soy un animal del reino animalia.");
    }
}

class Perro extends Animal {
    @Override
    public void hacerSonido() {
        System.out.println("El perro dice: ¡Guau guau!");
    }
}

class Gato extends Animal {
    @Override
    public void hacerSonido() {
        System.out.println("El gato dice: ¡Miau!");
    }
}

class Vaca extends Animal {
    @Override
    public void hacerSonido() {
        System.out.println("La vaca dice: ¡Muuu!");
    }
}
