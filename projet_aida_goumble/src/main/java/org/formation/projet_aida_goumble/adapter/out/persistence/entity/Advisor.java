package org.formation.projet_aida_goumble.adapter.out.persistence.entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name="advisor")
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Advisor {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;
    @Column(name="last_name")
    private String lastName;
    @Column(name="first_name")
    private String firstName;
    @OneToMany(mappedBy = "advisor", cascade = CascadeType.ALL)
    private List<Client> clients;
    @ManyToOne
    @JoinColumn(name = "manager_id")
    private Manager manager;

    public Advisor(String lastName, String firstName) {
        this.lastName = lastName;
        this.firstName = firstName;
    }
}
