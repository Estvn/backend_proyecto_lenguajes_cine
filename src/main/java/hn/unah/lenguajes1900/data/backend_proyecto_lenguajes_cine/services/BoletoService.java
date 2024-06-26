package hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.services;

import java.util.List;

import hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.entities.Boleto;


public interface BoletoService {

    public Boleto crearBoleto(long idEvento, long idAsiento , long codigoDetalleFactura);

    //public List<Boleto> obtenerPorFactura(long idFactura);

    public List<Boleto> obtenerPorIdEvento(long codigoEvento);


}
