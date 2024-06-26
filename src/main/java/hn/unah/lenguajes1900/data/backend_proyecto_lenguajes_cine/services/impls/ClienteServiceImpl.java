package hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.services.impls;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.Validations.Validation;
import hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.entities.Cliente;

import hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.repositories.ClienteRepository;
import hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.services.ClienteService;


@Service
public class ClienteServiceImpl implements ClienteService{

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public Cliente crearCliente(Cliente cliente) {
        Validation validator = new Validation();

        if(cliente.getNombreCompleto().trim().matches("([A-Za-záéíóúäëïöü]+\\s?)+") && 
        validator.validarTelefono(cliente.getTelefono()) && validator.validarCorreo(cliente.getCorreo())){

            cliente.setClienteFrecuente(0);
            return this.clienteRepository.save(cliente);
        }
        System.out.println(cliente.getNombreCompleto().trim().matches("([A-Za-záéíóúäëïöü]+\\s?)+"));
        System.out.println(validator.validarTelefono(cliente.getTelefono()));
        System.out.println(validator.validarCorreo(cliente.getCorreo()));
        return null;
    }


    @Override
    public List<Cliente> obtenerClientes() {
        return (List<Cliente>)this.clienteRepository.findAll();
    }

    

    @Override
    public Cliente editarCliente(long codigoCliente, Cliente cliente) {

        Cliente clienteActualizar = this.clienteRepository.findById(codigoCliente).get();

        if(null != clienteActualizar){
            
            Validation validator = new Validation();
            if(cliente.getNombreCompleto().trim().matches("([A-Za-záéíóúäëïöü]+\\s?)+") && 
            validator.validarTelefono(cliente.getTelefono()) && validator.validarCorreo(cliente.getCorreo())){

                clienteActualizar.setNombreCompleto(cliente.getNombreCompleto());
                clienteActualizar.setFechaNacimiento(cliente.getFechaNacimiento());
                clienteActualizar.setCorreo(cliente.getCorreo());
                clienteActualizar.setContrasenia(cliente.getContrasenia());
                clienteActualizar.setTelefono(cliente.getTelefono());

                this.clienteRepository.save(clienteActualizar);
            }
            return clienteActualizar;
        }
        return null;
    }


    @Override
    public Cliente obtenerClientePorId(long codigoCliente) {

        if(this.clienteRepository.existsById(codigoCliente)){
            return this.clienteRepository.findById(codigoCliente).get();
        }
        System.out.println("No existe ningún cliente con este ID");
        return null;
    }


    @Override
    public Cliente obtenerClientePorCorreo(String correo, String contrasenia) {

        List<Cliente> clientes = (List<Cliente>) this.clienteRepository.findAll();

        for (Cliente cliente : clientes) {

            if(cliente.getCorreo().equals(correo)){

                if(cliente.getContrasenia().equals(contrasenia)){

                    return cliente;
                }
                System.out.println("La contraseña no es correcta.");
            }
        }
        System.out.println("El correo o la contraseña son incorrectos.");
        return null;
    }
}
    
    

