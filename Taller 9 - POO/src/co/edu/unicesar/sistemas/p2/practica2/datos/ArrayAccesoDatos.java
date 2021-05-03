package co.edu.unicesar.sistemas.p2.practica2.datos;

import co.edu.unicesar.sistemas.p2.practica2.dominio.Publicacion;
import co.edu.unicesar.sistemas.p2.practica2.excepciones.ExcepcionAccesoDatos;
import java.util.*;

public class ArrayAccesoDatos implements IAccesoDatos{
    
    private final List<Publicacion> listaPublicaciones;

    public ArrayAccesoDatos() {
        this.listaPublicaciones = new ArrayList();
    }
    
    @Override
    public void insertarPublicacion(Publicacion p) throws ExcepcionAccesoDatos {
        if (p == null) {
            throw new ExcepcionAccesoDatos("Publicacion invalida");
        }
        listaPublicaciones.add(p);
    }

    @Override
    public List<Publicacion> leerPublicaciones() throws ExcepcionAccesoDatos {
        List<Publicacion> resultado = ArrayList();
        
        return resultado;
    }

    @Override
    public Publicacion buscarPublicacion(Publicacion p) throws ExcepcionAccesoDatos {
        if (listaPublicaciones.size() == 0) 
            throw new ExcepcionAccesoDatos("Lista vacia");
        if (p == null) 
            throw new ExcepcionAccesoDatos("\nPublicacion no registrada");
        if (p.getIsbn() == null) 
            throw new ExcepcionAccesoDatos("El ISBN es invalido");

        for (Publicacion publicacion: listaPublicaciones) {
            if (p.getIsbn().equals(publicacion.getIsbn())) {
                Publicacion encontrado = publicacion;
                return encontrado;
            }
        }
        return null;
    }

    @Override
    public Publicacion eliminarPublicacion(Publicacion p) throws ExcepcionAccesoDatos {
        Publicacion publicacionABorrar = buscarPublicacion(p);
        listaPublicaciones.remove(publicacionABorrar);
        return publicacionABorrar;
    }

    private List<Publicacion> ArrayList() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
