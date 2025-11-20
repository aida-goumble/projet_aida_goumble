package org.formation.projet_aida_goumble.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Client {
    @Id
    @GeneratedValue
    private Long id;
    private String lastName;
    private String firstName;
    private String address;
    private String phone;
    private String postalCode;
    private String city;

}
