package presentacion.RegistroUsuario;

import logicaNegocio.CuentaBancaria;
import logicaNegocio.Usuario;
import presentacion.VentanaPrincipal.VentanaPrincipalForms;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Clase IngresarPersonaForm.
 * Hereda de JFrame y utiliza el layout GridLayout (Por defecto en IntelliJ).
 */
public class RegistroUsuarioForm extends JFrame {
    private JPanel pnlPrincipal;
    private JTextField txtNombre;
    private JTextField txtSaldo;
    private JTextField txtContraseña;
    private JButton btnGuardar;
    private JLabel lblNombre;
    private JLabel lblSaldo;
    private JLabel lblContraseña;


    /**
     * Constructor de la clase EjemploGridLayout
     *
     * Complejidad Temporal: O(1) Tiempo Constante.
     */
    public RegistroUsuarioForm() {

        // Elimina el proceso cuando se cierra la ventana
        // this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        // Se asigna el panel principal al JFrame
        this.setContentPane(pnlPrincipal);
        // Se asigna el tamaño por defecto
        this.setSize(500, 300);
        // Se asigna la posición por defecto
        this.setLocation(100, 100);
        // No se permite redimensionar la ventana
        this.setResizable(false);
        // Se muestra la ventana como visible
        this.setVisible(true);

        btnGuardar.addActionListener(new ActionListener() {
            @Override
            /**
             * Evento click del botón btnGuardar
             *
             * Complejidad Temporal: O(1) Tiempo Constante.
             */
            public void actionPerformed(ActionEvent e) {
                String nombre = txtNombre.getText();
                String dinero = txtSaldo.getText();
                String contraseña = txtContraseña.getText();
                double saldo = Double.parseDouble(dinero);

                Usuario usuario = new Usuario(nombre, saldo, contraseña);

                CuentaBancaria.agregarUsuarios(usuario);

                String mensaje = "Tus datos son: \n" +
                                 "Nombre De La Cuenta: " + nombre + "\n" +
                                 "Saldo: " + saldo + "\n" +
                                 "Contraseña: " + contraseña;

                JOptionPane.showMessageDialog(btnGuardar, mensaje);
                dispose();
                // TODO: Llamar a la ventana de Login
                VentanaPrincipalForms v = new VentanaPrincipalForms();
            }
        });
    }
}
