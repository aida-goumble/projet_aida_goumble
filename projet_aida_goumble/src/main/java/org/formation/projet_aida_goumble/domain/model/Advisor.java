package org.formation.projet_aida_goumble.domain.model;

import jakarta.persistence.*;
import org.formation.projet_aida_goumble.adapter.out.persistence.entity.Client;
import org.formation.projet_aida_goumble.adapter.out.persistence.entity.Manager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Advisor {
    private Long id;
    private String lastName;
    private String firstName;
    private List<Long> clientsIds;
    private Long managerId;

    private  Advisor(Builder builder) {
        id = builder.id;
        lastName = builder.lastName;
        firstName = builder.firstName;
        clientsIds = builder.clientsIds;
        managerId = builder.managerId;
    }
    public static Builder builder() {return new Builder();}

    public Advisor(String lastName, String firstName) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.clientsIds = new ArrayList<>();
    }

    public Advisor(Long id, String lastName, String firstName, Long managerId, List<Long> clientIds) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.managerId = managerId;
        this.clientsIds = clientIds != null ? new ArrayList<>(clientIds) : new ArrayList<>();
    }

    public void assignToManager(Long managerId) {
        if (managerId == null) {
            throw new IllegalArgumentException("Manager ID cannot be null");
        }
        this.managerId = managerId;
    }

    public void addClient(Long clientId) {
        if (clientId == null) {
            throw new IllegalArgumentException("Client ID cannot be null");
        }
        if (!this.clientsIds.contains(clientId)) {
            this.clientsIds.add(clientId);
        }
    }

    public void removeClient(Long clientId) {
        this.clientsIds.remove(clientId);
    }

    public void updatePersonalInfo(String lastName, String firstName) {
        this.lastName = lastName;
        this. firstName = firstName;
    }

    public Long getId() {
        return id;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public Long getManagerId() {
        return managerId;
    }

    public List<Long> getClientIds() {
        return Collections.unmodifiableList(clientsIds);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Advisor advisor = (Advisor) o;
        return Objects.equals(id, advisor.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Advisor{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", managerId=" + managerId +
                ", clientCount=" + clientsIds.size() +
                '}';
    }


    public static class Builder {
        private Long id;
        private String lastName;
        private String firstName;
        private List<Long> clientsIds;
        private Long managerId;

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder clients(List<Long> clients) {
            this.clientsIds = clients;
            return this;
        }

        public Builder manager(Long manager) {
            this.managerId = manager;
            return this;
        }

        public Advisor build() {
            return new Advisor(this);
        }
    }
}
