package org.formation.projet_aida_goumble.domain.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class AccountCurrent extends Account {
    private BigDecimal overdraftLimit;

    public AccountCurrent(String accountNumber, BigDecimal balance, Long clientId, BigDecimal overdraftLimit) {
        super(accountNumber, balance, clientId);
        this.overdraftLimit = overdraftLimit != null ? overdraftLimit : BigDecimal.ZERO;
    }

    public AccountCurrent(Long id, String accountNumber, BigDecimal balance, LocalDateTime createdAt, Long clientId, BigDecimal overdraftLimit) {
        super(id, accountNumber, balance, createdAt, clientId);
        this.overdraftLimit = overdraftLimit;
    }

    public BigDecimal getOverdraftLimit() {
        return overdraftLimit;
    }

    public void setOverdraftLimit(BigDecimal overdraftLimit) {
        if (overdraftLimit.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Overdraft limit cannot be negative");
        }
        this.overdraftLimit = overdraftLimit;
    }

    public BigDecimal getAvailableBalance() {
        return getBalance().add(overdraftLimit);
    }

    @Override
    public String toString() {
        return "AccountCurrent{" +
                "id=" + getId() +
                ", accountNumber='" + getAccountNumber() + '\'' +
                ", balance=" + getBalance() +
                ", overdraftLimit=" + overdraftLimit +
                ", clientId=" + getClientId() +
                '}';
    }
}