package modelo;

import java.util.ArrayList;

public class GestorEstudiantes {
    private ArrayList<Estudiante> lista = new ArrayList<>();

    public void agregar(Estudiante e) {
        lista.add(e);
    }

    public ArrayList<Estudiante> getLista() {
        return lista;
    }
}