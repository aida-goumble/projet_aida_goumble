package org.formation.projet_aida_goumble.adapter.out.persistence.entity;

import jakarta.persistence. Column;
import jakarta.persistence. Entity;
import jakarta.persistence. Table;
import lombok.AllArgsConstructor;
import lombok. Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "account_current")
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class AccountCurrent extends Account {

    @Column(name = "overdraft_limit", nullable = false)
    private BigDecimal overdraftLimit;
}