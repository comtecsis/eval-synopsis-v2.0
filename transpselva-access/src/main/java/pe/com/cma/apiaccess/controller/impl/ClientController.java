package pe.com.cma.apiaccess.controller.impl;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.com.cma.apiaccess.controller.response.Response;
import pe.com.cma.apiaccess.controller.response.Status;
import pe.com.cma.apiaccess.enumeration.AccessCodeEnum;
import pe.com.cma.apiaccess.service.ClientService;
import pe.com.cma.apiaccess.service.dto.ClientDTO;
import pe.com.cma.apiaccess.service.dto.LoginDTO;

import java.util.List;

@RestController
@RequestMapping("/v1/client")
public class ClientController {

    private final ClientService service;

    public ResponseEntity<Response<ClientDTO>> findById(Long id) {
        return ResponseEntity.ok(new Response<>(AccessCodeEnum.OK.status(), service.findById(id)));
    }

    public ResponseEntity<Response<List<ClientDTO>>> loadAll() {
        return ResponseEntity.ok(new Response<>(AccessCodeEnum.OK.status(), service.findAll()));
    }


}
