package pe.com.cma.apiaccess.service;

import pe.com.cma.apiaccess.service.dto.ClientDTO;

import java.util.List;

public interface ClientService {
    ClientDTO findById(Integer id);
    List<ClientDTO> findAll();
}
