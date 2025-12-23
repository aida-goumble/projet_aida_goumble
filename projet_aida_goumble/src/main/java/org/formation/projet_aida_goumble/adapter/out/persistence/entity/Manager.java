package org.formation.projet_aida_goumble.adapter.out.persistence.entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="manager")
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Manager {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="last_name")
    private String lastName;
    @Column(name="first_name")
    private String firstName;
    @OneToMany(mappedBy = "manager", cascade = CascadeType.ALL)
    private List<Advisor> advisors = new ArrayList<>();

    public Manager(String lastName, String firstName) {
        this.lastName = lastName;
        this.firstName = firstName;
    }
}
