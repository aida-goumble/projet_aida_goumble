package org.formation.projet_aida_goumble.entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Manager {
    @Id
    @GeneratedValue()
    private Long id;
    private String lastName;
    private String firstName;
    @OneToMany(mappedBy = "manager", cascade = CascadeType.PERSIST)
    private Set<Advisor> advisors = new HashSet<>();
}
