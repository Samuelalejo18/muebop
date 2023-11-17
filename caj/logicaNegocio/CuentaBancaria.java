package logicaNegocio;

/**
 * clase Usuario
 */
public class CuentaBancaria {

    private String nombre;
    private double saldo;
    private String contraseña;



    /****************************************************************************************************/
    /******************************************* CONSTRUCTORES ******************************************/
    /****************************************************************************************************/

    /**
     * Método constuctor para inicializar los atributos de la clase usuario
     * @param nombre nombre del usuario
     * @param saldo saldo del usuario
     * @param contraseña contraseña del usuario
     *
     * Complejidad temporal: O(1) Tiempo constante
     */

    public CuentaBancaria(String nombre, double saldo, String contraseña) {
        this.nombre = nombre;
        this.saldo = saldo;
        this.contraseña = contraseña;
    }

    /****************************************************************************************************/
    /*************************************** MÉTODOS MODIFICADORES **************************************/
    /****************************************************************************************************/

    /**
     * Método para obtener el nombre del usuario
     * @return Retorna el nombre del usuario
     *
     * Complejidad temporal: O(1) Tiempo constante
     */

    public String getNombre() {

        return nombre;
    }

    /**
     * Método para obtener el nombre del usuario
     * @return Retorna el nombre del usuario
     *
     * Complejidad temporal: O(1) Tiempo constante
     */

    public double getSaldo() {

        return saldo;
    }

    /**
     * Método para  modificar el saldo del usuario
     * @set establece o modifica el saldo del usuario
     *
     * Complejidad temporal: O(1) Tiempo constante
     */

    public void setSaldo(double saldo) {

        this.saldo = saldo;
    }

    /**
     * Método para obtener la contraseña del usuario
     * @return Retorna la contraseña del usuario
     *
     * Complejidad temporal: O(1) Tiempo constante
     */

    public String getContraseña() {
        return contraseña;
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
            CuentaBancaria destinario = null;
            for (CuentaBancaria Usuario : cuentaBancaria) {
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
}