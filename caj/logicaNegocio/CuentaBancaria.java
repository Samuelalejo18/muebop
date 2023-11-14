package logicaNegocio;

import java.util.LinkedList;
import java.util.Scanner;


public class CuentaBancaria {
    private static LinkedList<Usuario> cuentaBancaria = new LinkedList<>();
    private Usuario usuarioAutenticado;
    Scanner lector = new Scanner(System.in);


    public void Registrar(Usuario Usuario) {

        if (!cuentaBancaria.contains(Usuario)) {
            cuentaBancaria.add(Usuario);
            System.out.println("El Usuario " + Usuario.getNombre() + "  ha sido registrado  exitosomante.");
        } else {
            System.out.println("El Usuario " + Usuario.getNombre()
                    + " ya existe esta usuario. No se puede registrar nuevamente.");
        }
    }


    public void Depositar(double cantidad) {
        if (usuarioAutenticado != null) {
            double saldoActual = usuarioAutenticado.getSaldo();
            double nuevoSaldo = saldoActual + cantidad;
            usuarioAutenticado.setSaldo(nuevoSaldo);
            System.out.println("Deposito de " + cantidad + " realizado exitosamente");
        } else {
            System.out.println("No es psobile realizar el deposito");
        }

    }


    public void Retirar(double cantidad2) {
        if (usuarioAutenticado != null) {
            double saldoActual2 = usuarioAutenticado.getSaldo();

            if (saldoActual2 >= cantidad2) {
                double nuevoSaldo2 = saldoActual2 - cantidad2;
                usuarioAutenticado.setSaldo(nuevoSaldo2);
                System.out.println("Retiro de " + cantidad2 + " realizado exitosamente");
            } else {
                System.out.println("Saldo insuficiente");
            }
        } else {
            System.out.println("No es psobile realizar el retiro");
        }

    }


    public void Transferir(String nombreDestinario, double cantidad) {
        if (usuarioAutenticado != null) {
            Usuario destinario = null;
            for (Usuario Usuario : cuentaBancaria) {
                if (Usuario.getNombre().equals(nombreDestinario)) {
                    destinario = Usuario;
                    break;
                }
            }
            if (destinario != null) {
                if (usuarioAutenticado.getSaldo() >= cantidad) {
                    double saldoOrigen = usuarioAutenticado.getSaldo();
                    double saldoDestinario = destinario.getSaldo();

                    usuarioAutenticado.setSaldo(saldoOrigen - cantidad);
                    destinario.setSaldo(saldoDestinario + cantidad);
                    System.out.println(" Tranferencia de " + cantidad + " realizada exitosamente");
                } else {
                    System.out.println("Saldo insuficiente");
                }
            }
        } else {
            System.out.println("EL Destinario " + nombreDestinario + "no existe");
        }

    }

    public void Autentificar(String nombreUsuario, String contraseña) {
        Usuario usuarioEncontrado = null;

        for (Usuario Usuario : cuentaBancaria) {
            if (Usuario.getNombre().equals(nombreUsuario)) {
                usuarioEncontrado = Usuario;
                break;
            }
        }
        if (usuarioEncontrado != null) {
            if (usuarioEncontrado.getContraseña().equals(contraseña)) {
                usuarioAutenticado = usuarioEncontrado;
                System.out.println("Autentificacion exitosa para el usuario " + nombreUsuario);

                int opcion = -1; // Operación de tiempo constante, O(1)

                while (opcion != 0) {
                    // Impresión de mensaje de tiempo constante, O(1)
                    System.out.println("\n");
                    System.out.println("Por favor, elija una opción:");
                    System.out.println("1. Consultar saldo");
                    System.out.println("2. Ingresar dinero");
                    System.out.println("3. Retirar dinero");
                    System.out.println("4. Realizar una transacción");
                    System.out.println("0. Salir");
                    System.out.println("\n");
                    opcion = Integer.parseInt(lector.nextLine());


                    switch (opcion) {
                        case 1 ->/* Caso para obtener el saldo del usuario, complejidad de tiempo constante */
                            // tiempo constante, O(1)
                            // System.out.println("\n");
                                System.out.println("Tu saldo es de " + usuarioAutenticado.getSaldo());

                        case 2 -> {

                            System.out.println("Digite la cantidad a ingresar");
                            double cantidadIngresada = Double.parseDouble(lector.nextLine());
                            Depositar(cantidadIngresada);
                        }
                        case 3 -> {

                            System.out.println("Digite la cantidad a retirar");
                            double cantidadRetirada = Double.parseDouble(lector.nextLine());
                            Retirar(cantidadRetirada);
                        }
                        case 4 -> {

                            System.out.println("Ingrese el usuario al que desea enviar");
                            String usarioDestinario = lector.nextLine();
                            System.out.println("Ingrese la cantidad a enviar");
                            double cantidadEnviar = Double.parseDouble(lector.nextLine());
                            Transferir(usarioDestinario, cantidadEnviar);
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
            } else {
                System.out.println("contraseña incorrecta ");
            }
        } else {
            System.out.println("El usuario no existe");
        }

    }

}
