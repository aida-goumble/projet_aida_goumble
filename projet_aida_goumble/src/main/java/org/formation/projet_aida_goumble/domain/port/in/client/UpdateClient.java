package org.formation.projet_aida_goumble.domain.port.in.client;

import org.formation.projet_aida_goumble.domain.model.Client;

public interface UpdateClient {
    Client updateClient(Long id, String lastName, String firstName, String address, String phone, String postalCode, String city);

}
