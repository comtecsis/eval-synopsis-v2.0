package pe.com.cma.apiaccess.dao.model;

import lombok.Data;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "access.client")
@Data
@ToString
public class Client {
    private Long clientId;
    private String name;
    private String phone;
    private String mail;
}
