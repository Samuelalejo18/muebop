package logicaNegocio;

import java.util.LinkedList;

public class BaseDeDatos {
    private static LinkedList<Usuario> listaDeUsuarios = new LinkedList<>();

    /**
     * Retorna la lista de personas
     * @return this.listaDePersonas
     *
     * Complejidad temporal: O(1) Complejidad Constante
     */
    public static LinkedList<Usuario> getListaDeUsuarios() {

        return listaDeUsuarios;
    }

    /**
     * Agrega una persona a la lista de personas
     * @param usuario Persona a agregar
     *
     * Complejidad temporal: O(1) Complejidad Constante
     */
    public static void agregarUsuarios(Usuario usuario) {

        listaDeUsuarios.add(usuario);
    }
}
