package hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.services;

import hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.entities.Boleto;

public interface BoletoService {
    
    public Boleto crearBoleto(Boleto boleto);

    public String eliminarBoleto(long codigoEvento);
}