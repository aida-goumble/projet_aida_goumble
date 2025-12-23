package org.formation.projet_aida_goumble.adapter.in.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClientDto {
    private Long id;
    private String lastName;
    private String firstName;
    private String address;
    private String phone;
    private String postalCode;
    private String city;
    private Long advisorId;
}
