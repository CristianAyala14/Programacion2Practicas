
import java.util.Scanner;


class programacionEstructurada {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        
        
        System.out.print("EJERCICIO 1");
        System.out.print("Ingrese un año: ");
        int anio = scanner.nextInt();
        if (esBisiesto(anio)) {
            System.out.println("El año " + anio + " es bisiesto.");
        } else {
            System.out.println("El año " + anio + " no es bisiesto.");
        }
        
        
        System.out.print("EJERCICIO 2");
        System.out.print("Ingrese el primer número: ");
        int num1 = scanner.nextInt();
        System.out.print("Ingrese el segundo número: ");
        int num2 = scanner.nextInt();
        System.out.print("Ingrese el tercer número: ");
        int num3 = scanner.nextInt();
        int mayor = encontrarMayor(num1, num2, num3);
        System.out.println("El mayor es: " + mayor);
        
        
        
        System.out.print("EJERCICIO 3");
        System.out.print("Ingrese su edad: ");
        int edad = scanner.nextInt();
        String etapa = clasificarEdad(edad);
        System.out.println("Eres un " + etapa + ".");
        
        
        
        System.out.print("EJERCICIO 4");
        System.out.print("Ingrese el precio del producto: ");
        double precio = scanner.nextDouble();
        System.out.print("Ingrese la categoría del producto (A, B o C): ");
        char categoria = scanner.next().toUpperCase().charAt(0);
        double precioFinal = calcularDescuento(precio, categoria);
        double descuento = precio - precioFinal;
        System.out.println("Precio original: " + precio);
        System.out.println("Descuento aplicado: " + (int)((descuento / precio) * 100) + "%");
        System.out.println("Precio final: " + precioFinal);

        
        
        System.out.print("EJERCICIO 5");
        int sumaPares = sumarPares(scanner);
        System.out.println("La suma de los números pares es: " + sumaPares);
        
        
        System.out.print("EJERCICIO 6");
        int[] resultados = contarNumeros(scanner);
        System.out.println("Resultados:");
        System.out.println("Positivos: " + resultados[0]);
        System.out.println("Negativos: " + resultados[1]);
        System.out.println("Ceros: " + resultados[2]);
        
        
        
        System.out.print("EJERCICIO 7");
        int nota = validarNota(scanner);
        System.out.println("Nota guardada correctamente: " + nota);
        
        
        
        System.out.print("EJERCICIO 8");
        System.out.print("Ingrese el precio base del producto: ");
        double precioBase = scanner.nextDouble();
        System.out.print("Ingrese el impuesto en porcentaje (Ejemplo: 10 para 10%): ");
        double impuesto = scanner.nextDouble();
        System.out.print("Ingrese el descuento en porcentaje (Ejemplo: 5 para 5%): ");
        double descuento_ej8= scanner.nextDouble();
        double precioFinal_ej8= calcularPrecioFinal(precioBase, impuesto, descuento);
        System.out.println("El precio final del producto es: " + precioFinal);
        
        
        
        System.out.print("EJERCICIO 9");
        System.out.print("Ingrese el precio del producto: ");
        double precioProducto = scanner.nextDouble();
        System.out.print("Ingrese el peso del paquete en kg: ");
        double peso = scanner.nextDouble();
        scanner.nextLine(); 
        System.out.print("Ingrese la zona de envío (Nacional/Internacional): ");
        String zona = scanner.nextLine();

        // Llamada a las funciones
        double costoEnvio = calcularCostoEnvio(peso, zona);
        double total = calcularTotalCompra(precioProducto, costoEnvio);
        System.out.println("El costo de envío es: " + costoEnvio);
        System.out.println("El total a pagar es: " + total);
        
        
        System.out.print("EJERCICIO 10");
        System.out.print("Ingrese el stock actual del producto: ");
        int stockActual = scanner.nextInt();
        System.out.print("Ingrese la cantidad vendida: ");
        int cantidadVendida = scanner.nextInt();
        System.out.print("Ingrese la cantidad recibida: ");
        int cantidadRecibida = scanner.nextInt();
        int nuevoStock = actualizarStock(stockActual, cantidadVendida, cantidadRecibida);
        System.out.println("El nuevo stock del producto es: " + nuevoStock);
        
        
        System.out.print("EJERCICIO 11");
        System.out.print("Ingrese el precio del producto: ");
        double precio2 = scanner.nextDouble();
        calcularDescuentoEspecial(precio2);
        
        
        
        System.out.print("EJERCICIO 12");
        double[] precios = {199.99, 299.50, 149.75, 399.00, 89.99};
        System.out.println("Precios originales:");
        for (double precio3 : precios) {
            System.out.println("Precio: $" + precio3);
        }
        precios[2] = 129.99;
        System.out.println("\nPrecios modificados:");
        for (double precio3 : precios) {
            System.out.println("Precio: $" + precio);
        }
        
        
        
        System.out.print("EJERCICIO 13");
        double[] precios2 = {199.99, 299.50, 149.75, 399.00, 89.99};
        System.out.println("Precios originales:");
        mostrarPrecios(precios, 0);
        precios2[2] = 129.99;
        System.out.println("\nPrecios modificados:");
        mostrarPrecios(precios, 0);
        
        
    }
       
    
    //FUNCIONES
    // Ejercicio 1
        public static boolean esBisiesto(int anio) {
            return (anio % 4 == 0 && anio % 100 != 0) || (anio % 400 == 0);
        }
    
    // Ejercicio 2
        public static int encontrarMayor(int a, int b, int c) {
            int mayor = a;

            if (b > mayor) {
                mayor = b;
            }
            if (c > mayor) {
                mayor = c;
            }
            return mayor;
        }
        
    // Ejercicio 3
        public static String clasificarEdad(int edad) {
            if (edad < 12) {
                return "Niño";
            } else if (edad >= 12 && edad <= 17) {
                return "Adolescente";
            } else if (edad >= 18 && edad <= 59) {
                return "Adulto";
            } else {
                return "Adulto mayor";
            }
       }
        
    // Ejercicio 4
        public static double calcularDescuento(double precio, char categoria) {
            double descuento = 0;

            switch (categoria) {
                case 'A':
                    descuento = 0.10;
                    break;
                case 'B':
                    descuento = 0.15;
                    break;
                case 'C':
                    descuento = 0.20;
                    break;
                default:
                    System.out.println("Categoría no válida. No se aplica descuento.");
                    descuento = 0;
                    break;
            }

            return precio * (1 - descuento);
        }
   
    // Ejercicio 5
        public static int sumarPares(Scanner scanner) {
          int numero;
          int suma = 0;

          do {
              System.out.print("Ingrese un número (0 para terminar): ");
              numero = scanner.nextInt();

              if (numero != 0 && numero % 2 == 0) {
                  suma += numero;
              }
          } while (numero != 0);

          return suma;
    }  
    
    // Ejercicio 6
        public static int[] contarNumeros(Scanner scanner) {
           int positivos = 0;
           int negativos = 0;
           int ceros = 0;

           for (int i = 1; i <= 10; i++) {
               System.out.print("Ingrese el número " + i + ": ");
               int numero = scanner.nextInt();

               if (numero > 0) {
                   positivos++;
               } else if (numero < 0) {
                   negativos++;
               } else {
                   ceros++;
               }
           }

           return new int[]{positivos, negativos, ceros};
       }
        
    // Ejercicio 7
        public static int validarNota(Scanner scanner) {
            int nota;
            do {
                System.out.print("Ingrese una nota (0-10): ");
                nota = scanner.nextInt();

                if (nota < 0 || nota > 10) {
                    System.out.println("Error: Nota inválida. Ingrese una nota entre 0 y 10.");
                }

            } while (nota < 0 || nota > 10);
            return nota;
        }
    
    // Ejercicio 8
        public static double calcularPrecioFinal(double precioBase, double impuesto, double descuento) {
           // Convertimos los porcentajes a fracciones
           double impuestoDecimal = impuesto / 100;
           double descuentoDecimal = descuento / 100;
           return precioBase + (precioBase * impuestoDecimal) - (precioBase * descuentoDecimal);
       }
        
    // Ejercicio 9
      
        public static double calcularCostoEnvio(double peso, String zona) {
            double costoPorKg;
            if (zona.equalsIgnoreCase("Nacional")) {
                costoPorKg = 5.0;
            } else if (zona.equalsIgnoreCase("Internacional")) {
                costoPorKg = 10.0;
            } else {
                System.out.println("Zona no válida. Se asume Nacional por defecto.");
                costoPorKg = 5.0;
            }
            return peso * costoPorKg;
        }
        
        public static double calcularTotalCompra(double precioProducto, double costoEnvio) {
            return precioProducto + costoEnvio;
        }
        
    // Ejercicio 10 
        
        public static int actualizarStock(int stockActual, int cantidadVendida, int cantidadRecibida) {
            int nuevoStock = stockActual - cantidadVendida + cantidadRecibida;
            return nuevoStock;
        }

    // Ejercicio 11
        public static void calcularDescuentoEspecial(double precio) {
            double descuento = 0.10;
            
            double descuentoAplicado = precio * descuento;
            double precioFinal = precio - descuentoAplicado;
            System.out.println("El descuento especial aplicado es: " + descuentoAplicado);
            System.out.println("El precio final con descuento es: " + precioFinal);
        }
        
        
    // Ejercicio 12, dentro del main.
    
    // Ejercicio 13
        public static void mostrarPrecios(double[] precios, int indice) {
            // Caso base: cuando llegamos al final del array, detenemos la recursión
            if (indice == precios.length) {
                return;
            }
            System.out.println("Precio: $" + precios[indice]);
            mostrarPrecios(precios, indice + 1);
        }
        
}


