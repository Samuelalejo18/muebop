package presentacion.ColsultarUsuarios;

import logicaNegocio.BaseDeDatos;
import logicaNegocio.CuentaBancaria;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 * Clase para la ventana de Consultar Personas
 */
public class ConsultarUsuariosForm
        extends JFrame {
    private JPanel pnlPrincipal;
    private JLabel lblUsuario;

    /**
     * Constructor de la clase ConsultarPersonasForm
     *
     * Complejidad Temporal: O(1) Complejidad Constante.
     */
    public ConsultarUsuariosForm() {
        // Elimina el proceso cuando se cierra la ventana
        // this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        // Se asigna el panel principal al JFrame
        this.setContentPane(pnlPrincipal);
        // Se asigna el tamaño por defecto
        this.setSize(600, 500);
        // Se asigna la posición por defecto
        this.setLocation(100, 100);
        // No se permite redimensionar la ventana
        this.setResizable(true);
        // Se muestra la ventana como visible
        this.setVisible(true);

        if (BaseDeDatos.getListaDeUsuarios().size() == 0) {
            this.lblUsuario.setText("No hay usuarios registrado");
        } else {
            this.lblUsuario.setText("Lista de usuarios registrados:");
            this.mostrarDatosUsuario();
        }
    }

    /**
     * Método para mostrar los datos de las personas en una tabla
     *
     * Complejidad Temporal: O(N) Complejidad Lineal.
     */
    public void mostrarDatosUsuario() {
        String[] nombresDeColumnas = {"Nombre", "Saldo", "Contraseña"};

        // Crear un DefaultTableModel con columnas
        DefaultTableModel modelo = new DefaultTableModel();

        // Agregar columnas
        for(String nombreDeColumna : nombresDeColumnas) {
            modelo.addColumn(nombreDeColumna);
        }
        // Agregar filas
        for(CuentaBancaria usuario : BaseDeDatos.getListaDeUsuarios()) {
            Object[] fila = new Object[]{usuario.getNombre(), usuario.getSaldo(), usuario.getContraseña()};
            modelo.addRow(fila);
        }

        // Crear la JTable con el modelo
        JTable table = new JTable(modelo);

        // Agregar la JTable a un JScrollPane
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setSize(500, 300);

        // Agregar el JScrollPane al JFrame
        this.add(scrollPane);
    }
}
