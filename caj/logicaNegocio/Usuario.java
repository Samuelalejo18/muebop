package logicaNegocio;

/**
 * clase Usuario
 */
public class Usuario {

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

    public Usuario(String nombre, double saldo, String contraseña) {
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