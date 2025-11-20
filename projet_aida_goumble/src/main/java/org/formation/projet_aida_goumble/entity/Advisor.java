package org.formation.projet_aida_goumble.entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Advisor {
    @Id
    @GeneratedValue()
    private Long id;
    private String lastName;
    private String firstName;
    @OneToMany(mappedBy = "advisor", cascade = CascadeType.PERSIST)
    private List<Client> clients;
    @ManyToOne
    @JoinColumn(name = "manager_id")
    private Manager manager;

    public Advisor(String lastName, String firstName) {
        this.lastName = lastName;
        this.firstName = firstName;
    }
}
