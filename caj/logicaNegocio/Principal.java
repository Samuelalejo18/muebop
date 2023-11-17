package logicaNegocio;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        try (Scanner lector = new Scanner(System.in)) {
            Banco WolfBank = new Banco();

            // Crear objetos de la clase usuario
            CuentaBancaria Usuario1 = new CuentaBancaria("Samuel", 100000, "Lukas2012");

            // Registrar los libros en la biblioteca
            WolfBank.registrar(Usuario1);

            int opcion = -1; // Operación de tiempo constante, O(1)

            while (opcion != 0) {
                // Impresión de mensaje de tiempo constante, O(1)
                System.out.println("Bienvenidos a WolfBanck");
                System.out.println("Por favor, elija una opción:");
                System.out.println("1. Crear una cuenta");
                System.out.println("2. Ingresa a tu cuenta");
                System.out.println("0. Salir");
                System.out.println("\n");
                opcion = Integer.parseInt(lector.nextLine());


                switch (opcion) {
                    case 1 -> {

                        System.out.println("Registrar un nuevo usuario");
                        System.out.println("Ingrese el nombre del usuario: ");
                        String nuevoNombre = lector.nextLine();
                        System.out.println("Ingrese la contraseña: ");
                        String nuevoContraseña = lector.nextLine();
                        System.out.println("Ingrese el saldo: ");
                        double nuevoSaldo = Double.parseDouble(lector.nextLine());

                        // Crear un nuevo libro con los datos proporcionados
                        CuentaBancaria nuevoUsuario = new CuentaBancaria(nuevoNombre, nuevoSaldo, nuevoContraseña);
                        // Registrar el nuevo libro en la biblioteca
                        WolfBank.registrar(nuevoUsuario);
                    }
                    case 2 -> {

                        System.out.println("\n");
                        System.out.println("Ingrese usuario: ");
                        String user = lector.nextLine();
                        System.out.println("Ingrese la contraseña: ");
                        String password = lector.nextLine();
                        WolfBank.autentificar(user, password);
                        System.out.println("\n");
                    }
                    case 0 -> {

                        System.out.println("\n");
                        System.out.println("Saliendo de WolfBank. Hasta la proxima");
                    }
                    default -> {

                        System.out.println("\n");
                        System.out.println("Opción no válida. Por favor, elija una opción válida.");
                    }
                }
            }
        }
    }
}

