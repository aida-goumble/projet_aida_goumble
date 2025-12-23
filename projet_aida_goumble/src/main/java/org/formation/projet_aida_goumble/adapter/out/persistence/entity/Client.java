package org.formation.projet_aida_goumble.adapter.out.persistence.entity;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="client")
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="last_name")
    private String lastName;
    @Column(name="first_name")
    private String firstName;
    private String address;
    private String phone;
    @Column(name="postal_code")
    private String postalCode;
    private String city;
    @ManyToOne
    @JoinColumn(name = "advisor_id")
    private Advisor advisor;

    public Client(String lastName, String firstName, String address, String phone, String postalCode, String city) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.address = address;
        this.phone = phone;
        this.postalCode = postalCode;
        this.city = city;
    }


}
