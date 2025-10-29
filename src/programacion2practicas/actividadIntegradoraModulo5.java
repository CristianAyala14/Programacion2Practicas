/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package programacion2practicas;

/**
 *
 * @author cristian.ayala
 */
public class actividadIntegradoraModulo5 {
    public static void main(String[] args){
        Posnet posnet = new Posnet();
        Persona p = new Persona("40545665", "Pepe", "Gomez", "1112346678", "pepe@fakemail.com");
        TarjetaDeCredito t = new TarjetaDeCredito("FakeBank", "1234567890123456", 15000, p, EntidadFinanciera.BIRZA);

        System.out.println("Tarjeta antes del pago");
        System.out.println(t);

        System.out.println("Ticket tras pagar...");
        Ticket ticketGenerado = posnet.efectuarPago(t, 10000, 5);
        System.out.println(ticketGenerado);

        System.out.println("Tarjeta despues del pago");
        System.out.println(t);
    }
}







class Posnet{
    public static final double RECARGO_POR_CUOTA = 0.03;
    public static final double MIN_CANT_CUOTAS = 1;
    public static final double MAX_CANT_CUOTAS = 6;

    //METODO QUE DEVUELVE UN OBJETO TIPO TICKET
    public Ticket efectuarPago(TarjetaDeCredito tarjeta, double montoAAbonar, int cantCuotas){
        Ticket elTicket = null;
        if(datosValidos(tarjeta, montoAAbonar, cantCuotas)){
           double montoFinal = montoAAbonar + montoAAbonar * recargoSegunCuotas(cantCuotas); 
           if(tarjeta.tieneSaldoDisponible(montoFinal)){
               tarjeta.descontar(montoFinal);
               String nomApe = tarjeta.nombreCompletoDeTitular();
               double montoPorCuota = montoFinal / cantCuotas;
               elTicket = new Ticket(nomApe, montoFinal, montoPorCuota);
           }
        }
        return elTicket;
    }
    
    private boolean datosValidos(TarjetaDeCredito tarjeta, double monto, int cant){
        boolean esTarjetaValida = tarjeta != null;
        boolean esMontoValido = monto > 0;
        boolean cantCuotasValidas = cant >= MIN_CANT_CUOTAS && cant <= MAX_CANT_CUOTAS;
        return esTarjetaValida && esMontoValido && cantCuotasValidas;
    }
    
    private double recargoSegunCuotas(int cantCuotas){
        return (cantCuotas - 1) * RECARGO_POR_CUOTA; 
    }
    
    
    
           
}

class TarjetaDeCredito {
    private String entidadBancaria;
    private String nroTarjeta;
    private double saldo;
    private EntidadFinanciera entidadFinanciera;
    private Persona titular;
    
    public TarjetaDeCredito(String entidadBancaria, String nroTarjeta, double saldo, Persona titular, EntidadFinanciera      entidadFinanciera){
        this.entidadFinanciera = entidadFinanciera;
        this.nroTarjeta = nroTarjeta;
        this.saldo = saldo;
        this.titular = titular;
        this.entidadFinanciera = entidadFinanciera;
    }
    
    public boolean tieneSaldoDisponible(double monto){
        return saldo >= monto;
    }
    
    public void descontar(double monto){
        saldo = saldo - monto;
    }
    
    public String nombreCompletoDeTitular(){
        return titular.nombreCompleto();
    }

    @Override
    public String toString() {
        return "TarjetaDeCredito{" + "entidadBancaria=" + entidadBancaria + ", nroTarjeta=" + nroTarjeta + ", saldo=" +         saldo + ", entidadFinanciera=" + entidadFinanciera + ", titular=" + titular + '}';
    }
    
    
    
}

enum EntidadFinanciera{
    BIRZA, CASTERMARD;
}

class Persona{
    
    private String DNI;
    private String nombre;
    private String apellido;
    private String telefono;
    private String mail;
    
    
    public Persona(String DNI, String nombre, String apellido, String telefono, String mail){
        this.DNI = DNI;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.mail = mail;
    }
    
    public String nombreCompleto(){
        return nombre + " " + apellido;
    }
    
    
}

class Ticket {
    private String nombreApellido;
    private double montoTotal;
    private double montoPorCuota;
    
    public Ticket(String nombreApellido, double montoTotal, double montoPorCuota){
        this.nombreApellido = nombreApellido;
        this.montoTotal = montoTotal;
        this.montoPorCuota = montoPorCuota;
    }

    @Override
    public String toString() {
        return "Ticket{" + "nombreApellido=" + nombreApellido + ", montoTotal=" + montoTotal + ", montoPorCuota=" +             montoPorCuota + '}';
    }
    
}






