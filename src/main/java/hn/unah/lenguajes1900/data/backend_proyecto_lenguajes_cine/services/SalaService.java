package hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.services;

import hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.entities.Sala;

public interface SalaService {
    
    public Sala crearSala(String nombreTipoSala);

    public String eliminarSalaPorId(long codigoSala);

}
