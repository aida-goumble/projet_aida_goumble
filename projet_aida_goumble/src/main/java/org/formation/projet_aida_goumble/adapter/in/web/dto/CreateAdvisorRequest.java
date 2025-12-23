package org.formation.projet_aida_goumble.adapter.in.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateAdvisorRequest {
    private String lastName;
    private String firstName;
}