package org.formation.projet_aida_goumble.domain.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

public abstract class Account {
    private Long id;
    private String accountNumber;
    private BigDecimal balance;
    private LocalDateTime createdAt;
    private Long clientId;

    protected Account(String accountNumber, BigDecimal balance, Long clientId) {
        this.accountNumber = accountNumber;
        this.balance = balance != null ? balance : BigDecimal. ZERO;
        this.createdAt = LocalDateTime.now();
        this.clientId = clientId;
    }

    protected Account(Long id, String accountNumber, BigDecimal balance, LocalDateTime createdAt, Long clientId) {
        this.id = id;
        this.accountNumber = accountNumber;
        this. balance = balance;
        this.createdAt = createdAt;
        this. clientId = clientId;
    }

    public Long getId() {
        return id;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public Long getClientId() {
        return clientId;
    }

    protected void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(id, account.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}