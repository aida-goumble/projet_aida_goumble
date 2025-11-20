package org.formation.projet_aida_goumble.entity;


import jakarta.persistence.*;
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

    public Client(String lastName, String firstName, String address, String phone, String postalCode, String city) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.address = address;
        this.phone = phone;
        this.postalCode = postalCode;
        this.city = city;
    }

    @ManyToOne
    @JoinColumn(name = "advisor_id")
    private Advisor advisor;
}
