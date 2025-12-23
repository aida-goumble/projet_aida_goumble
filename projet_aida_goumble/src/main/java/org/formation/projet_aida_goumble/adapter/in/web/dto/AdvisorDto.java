package org.formation.projet_aida_goumble.adapter.in.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdvisorDto {
    private Long id;
    private String lastName;
    private String firstName;
    private Long managerId;
    private List<Long> clientIds;
}
