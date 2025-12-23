package org.formation.projet_aida_goumble.domain.model;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import org.formation.projet_aida_goumble.adapter.out.persistence.entity.Advisor;

import java.util.Objects;

public class Client {

    private Long id;
    private String lastName;
    private String firstName;
    private String address;
    private String phone;
    private String postalCode;
    private String city;
    private Long advisorId;

    public Client(Builder builder) {
        this.id = builder.id;
        this.lastName = builder.lastName;
        this.firstName = builder.firstName;
        this.address = builder.address;
        this.phone = builder.phone;
        this.postalCode = builder.postalCode;
        this.city = builder.city;
        this.advisorId = builder.advisorId;
    }
    public Client(String lastName, String firstName, String address, String phone, String postalCode, String city) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.address = address;
        this.phone = phone;
        this.postalCode = postalCode;
        this.city = city;
    }

    public Client(Long id, String lastName, String firstName, String address, String phone, String postalCode, String city, Long advisorId) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.address = address;
        this.phone = phone;
        this.postalCode = postalCode;
        this.city = city;
        this.advisorId = advisorId;
    }

    public void assignToAdvisor(Long advisorId) {
        if (advisorId == null) {
            throw new IllegalArgumentException("Advisor ID cannot be null");
        }
        this.advisorId = advisorId;
    }

    public void updatePersonalInfo(String lastName, String firstName, String address, String phone, String postalCode, String city) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.address = address;
        this.phone = phone;
        this.postalCode = postalCode;
        this.city = city;
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

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getCity() {
        return city;
    }

    public Long getAdvisorId() {
        return advisorId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(id, client.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", city='" + city + '\'' +
                ", advisorId=" + advisorId +
                '}';
    }

    public static class Builder {
        private Long id;
        private String lastName;
        private String firstName;
        private String address;
        private String phone;
        private String postalCode;
        private String city;
        private Long advisorId;
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

        public Builder address(String address) {
            this.address = address;
            return this;
        }
        public Builder phone(String phone) {
            this.phone = phone;
            return this;
        }

        public Builder postalCode(String postalCode) {
            this.postalCode = postalCode;
            return this;
        }

        public Builder city(String city) {
            this.city = city;
            return this;
        }

        public Builder advisor(Long advisorId) {
            this.advisorId = advisorId;
            return this;
        }
        public Client build() {
            return new Client(this);
        }
    }
}
