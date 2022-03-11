package pe.com.cma.apiaccess.service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ClientDTO {
    private Long clientId;
    private String name;
    private String phone;
    private String email;
}
