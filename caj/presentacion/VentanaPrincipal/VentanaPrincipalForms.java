package presentacion.VentanaPrincipal;

import presentacion.ColsultarUsuarios.ConsultarUsuariosForm;
import presentacion.RegistroUsuario.RegistroUsuarioForm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Clase para la Venta Principal de la aplicación.
 */
public class VentanaPrincipalForms extends JFrame {
    private JPanel pnlPrincipal;

    /**
     * Método que inicializa el menú con las opciones para el usuario.
     *
     * Complejidad temporal: O(1) Complejidad Constante.
     */
    private void inicializarMenu() {
        JMenuBar menuBar = new JMenuBar();
        this.setJMenuBar(menuBar);

        JMenu usuarioMenu = new JMenu("Inicio");
        menuBar.add(usuarioMenu);

        JMenuItem RegistroDePersonaFormItem = new JMenuItem("RegistroDecuenta");
        usuarioMenu.add(RegistroDePersonaFormItem);

        JMenuItem ConsultarUsuariosItemItem = new JMenuItem("Login");
        usuarioMenu.add(ConsultarUsuariosItemItem);

        RegistroDePersonaFormItem.addActionListener(new ActionListener() {
            @Override
            /**
             * Evento click en el menú "Ingresar Persona".
             *
             * Complejidad temporal: O(1) Complejidad Constante.
             */
            public void actionPerformed(ActionEvent e) {
                RegistroUsuarioForm registroDeUsuarioForm = new RegistroUsuarioForm();
            }
        });

        ConsultarUsuariosItemItem.addActionListener(new ActionListener() {
            @Override
            /**
             * Evento click en el menú "Consultar Personas".
             *
             * Complejidad temporal: O(1) Complejidad Constante.
             */
            public void actionPerformed(ActionEvent e) {
                //JOptionPane.showMessageDialog(consultarPersonasItem, "Opción seleccionada: Consultar Personas");
                ConsultarUsuariosForm consultarusuariosForm = new ConsultarUsuariosForm();
            }
        });
    }

    /**
     * Constructor de la clase EjemploGridLayout
     *
     * Complejidad Temporal: O(1) Tiempo Constante.
     */
    public VentanaPrincipalForms() {
        this.inicializarMenu();

        // Obtener el tamaño de la pantalla
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        // Asignar el tamaño de la ventana (JFrame actual) con tamaño de la pantalla
        this.setSize(screenSize);

        // Elimina el proceso cuando se cierra la ventana
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        // Se asigna el panel principal al JFrame
        this.setContentPane(pnlPrincipal);


        // No se permite redimensionar la ventana
        this.setResizable(false);
        // Se muestra la ventana como visible
        this.setVisible(true);
    }
}
