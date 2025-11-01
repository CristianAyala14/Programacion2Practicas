/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package programacion2practicas;

import java.io.*;
import java.util.*;

/**
 *
 * @author cristian pablo ayala
 */
public class InterfacesYExcepciones {

    /* ===========================================================
       PARTE 1: Interfaces en un sistema de E-commerce
    ============================================================ */

    // 1. Interfaz Pagable con método calcularTotal()
    interface Pagable {
        double calcularTotal();
    }

    // 4. Interfaces Pago y PagoConDescuento
    interface Pago {
        void procesarPago(double monto);
    }

    interface PagoConDescuento extends Pago {
        double aplicarDescuento(double monto);
    }

    // 5. Interfaz Notificable
    interface Notificable {
        void notificarCambio(String mensaje);
    }

    // 2. Clase Producto implementa Pagable
    static class Producto implements Pagable {
        private String nombre;
        private double precio;

        public Producto(String nombre, double precio) {
            this.nombre = nombre;
            this.precio = precio;
        }

        public String getNombre() {
            return nombre;
        }

        public double getPrecio() {
            return precio;
        }

        @Override
        public double calcularTotal() {
            return precio;
        }

        @Override
        public String toString() {
            return nombre + " ($" + precio + ")";
        }
    }

    // Clase Cliente implementa Notificable
    static class Cliente implements Notificable {
        private String nombre;

        public Cliente(String nombre) {
            this.nombre = nombre;
        }

        @Override
        public void notificarCambio(String mensaje) {
            System.out.println("Notificación para " + nombre + ": " + mensaje);
        }
    }

    // 3. Clase Pedido implementa Pagable
    static class Pedido implements Pagable {
        private List<Producto> productos;
        private Cliente cliente;
        private String estado;

        public Pedido(Cliente cliente) {
            this.cliente = cliente;
            this.productos = new ArrayList<>();
            this.estado = "Creado";
        }

        public void agregarProducto(Producto p) {
            productos.add(p);
        }

        public void cambiarEstado(String nuevoEstado) {
            this.estado = nuevoEstado;
            cliente.notificarCambio("El estado del pedido cambió a: " + nuevoEstado);
        }

        @Override
        public double calcularTotal() {
            double total = 0;
            for (Producto p : productos) {
                total += p.calcularTotal();
            }
            return total;
        }

        public List<Producto> getProductos() {
            return productos;
        }
    }

    // Clases concretas de pago
    static class PagoTarjetaCredito implements PagoConDescuento {
        @Override
        public double aplicarDescuento(double monto) {
            return monto * 0.95; // 5% de descuento
        }

        @Override
        public void procesarPago(double monto) {
            System.out.println("Pago con Tarjeta de Crédito procesado: $" + monto);
        }
    }

    static class PagoPayPal implements PagoConDescuento {
        @Override
        public double aplicarDescuento(double monto) {
            return monto * 0.97; // 3% de descuento
        }

        @Override
        public void procesarPago(double monto) {
            System.out.println("Pago con PayPal procesado: $" + monto);
        }
    }

    /* ===========================================================
       PARTE 2: Ejercicios sobre Excepciones
    ============================================================ */

    // 4. Excepción personalizada
    static class EdadInvalidaException extends Exception {
        public EdadInvalidaException(String mensaje) {
            super(mensaje);
        }
    }

    public static void verificarEdad(int edad) throws EdadInvalidaException {
        if (edad < 0 || edad > 120) {
            throw new EdadInvalidaException("Edad inválida: " + edad);
        }
        System.out.println("Edad válida: " + edad);
    }

    /* ===========================================================
       MÉTODO PRINCIPAL
    ============================================================ */
    public static void main(String[] args) {

        System.out.println("========== PARTE 1: E-COMMERCE ==========");

        Cliente cliente = new Cliente("Cristian Ayala");
        Pedido pedido = new Pedido(cliente);

        pedido.agregarProducto(new Producto("Mouse", 5000));
        pedido.agregarProducto(new Producto("Teclado", 12000));
        pedido.agregarProducto(new Producto("Monitor", 85000));

        System.out.println("Productos en el pedido:");
        for (Producto p : pedido.getProductos()) {
            System.out.println(" - " + p);
        }

        double total = pedido.calcularTotal();
        System.out.println("Total del pedido: $" + total);

        pedido.cambiarEstado("En preparación");

        // Pago con tarjeta
        PagoConDescuento pago = new PagoTarjetaCredito();
        double totalConDescuento = pago.aplicarDescuento(total);
        pago.procesarPago(totalConDescuento);

        pedido.cambiarEstado("Enviado");

        /* ===========================================================
           PARTE 2: EXCEPCIONES
        ============================================================ */
        System.out.println("\n========== PARTE 2: EXCEPCIONES ==========");

        // 1. División segura
        try {
            int a = 10, b = 0;
            int resultado = a / b;
            System.out.println("Resultado: " + resultado);
        } catch (ArithmeticException e) {
            System.out.println("Error: No se puede dividir por cero.");
        }

        // 2. Conversión de cadena a número
        try {
            String texto = "Hola";
            int numero = Integer.parseInt(texto);
            System.out.println("Número: " + numero);
        } catch (NumberFormatException e) {
            System.out.println("Error: No es un número válido.");
        }

        // 3. Lectura de archivo
        try {
            FileReader fr = new FileReader("archivo_inexistente.txt");
            BufferedReader br = new BufferedReader(fr);
            System.out.println(br.readLine());
            br.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error: El archivo no existe.");
        } catch (IOException e) {
            System.out.println("Error al leer el archivo.");
        }

        // 4. Excepción personalizada
        try {
            verificarEdad(150);
        } catch (EdadInvalidaException e) {
            System.out.println("Excepción personalizada capturada: " + e.getMessage());
        }

        // 5. Try-with-resources
        System.out.println("\nLeyendo archivo con try-with-resources:");
        try (BufferedReader br = new BufferedReader(new FileReader("archivo.txt"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo con try-with-resources.");
        }

        System.out.println("\nPrograma finalizado correctamente ✅");
    }
}
