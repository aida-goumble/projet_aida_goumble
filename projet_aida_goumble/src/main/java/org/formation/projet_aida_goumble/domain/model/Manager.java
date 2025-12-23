package org.formation.projet_aida_goumble.domain.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;
import org.formation.projet_aida_goumble.adapter.out.persistence.entity.Advisor;
import org.springframework.boot.autoconfigure.info.ProjectInfoProperties;

import java.util.*;

public class Manager {

    private Long id;
    private String lastName;
    private String firstName;
    private List<Long> advisorIds = new ArrayList<>();

    public Manager(Builder builder) {
        this.id = builder.id;
        this.lastName = builder.lastName;
        this.firstName = builder.firstName;
        this.advisorIds = builder.advisorIds;
    }

    public Manager(String lastName, String firstName) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.advisorIds = new ArrayList<>();
    }

    public Manager(Long id, String lastName, String firstName, List<Long> advisorIds) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.advisorIds = advisorIds != null ? new ArrayList<>(advisorIds) : new ArrayList<>();
    }

    public void addAdvisor(Long advisorId) {
        if (advisorId == null) {
            throw new IllegalArgumentException("Advisor ID cannot be null");
        }
        if (!this.advisorIds.contains(advisorId)) {
            this.advisorIds. add(advisorId);
        }
    }

    public void removeAdvisor(Long advisorId) {
        this.advisorIds.remove(advisorId);
    }

    public void updatePersonalInfo(String lastName, String firstName) {
        this.lastName = lastName;
        this.firstName = firstName;
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

    public List<Long> getAdvisorIds() {
        return Collections. unmodifiableList(advisorIds);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Manager manager = (Manager) o;
        return Objects.equals(id, manager.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Manager{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", advisorCount=" + advisorIds.size() +
                '}';
    }

    public static Builder builder() {return new Builder();}

    public static class Builder {
        private Long id;
        private String lastName;
        private String firstName;
        private List<Long> advisorIds = new ArrayList<>();

        public Builder id (Long id){
            this.id = id;
            return this;
        }

        public Builder lastName (String lastName){
            this.lastName = lastName;
            return this;
        }

        public Builder firstName (String firstName){
            this.firstName = firstName;
            return this;
        }

        public Builder advisors(List<Long> advisors){
            this.advisorIds = advisors;
            return this;
        }
    }
}
