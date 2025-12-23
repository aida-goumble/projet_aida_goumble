package org. formation.projet_aida_goumble.domain.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class AccountSaving extends Account {
    private BigDecimal interestRate;

    public AccountSaving(String accountNumber, BigDecimal balance, Long clientId, BigDecimal interestRate) {
        super(accountNumber, balance, clientId);
        this.interestRate = interestRate != null ? interestRate : BigDecimal.ZERO;
    }

    public AccountSaving(Long id, String accountNumber, BigDecimal balance, LocalDateTime createdAt, Long clientId, BigDecimal interestRate) {
        super(id, accountNumber, balance, createdAt, clientId);
        this.interestRate = interestRate;
    }

    public void applyInterest() {
        BigDecimal interest = getBalance().multiply(interestRate);
        setBalance(getBalance().add(interest));
    }

    public BigDecimal getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(BigDecimal interestRate) {
        if (interestRate. compareTo(BigDecimal. ZERO) < 0) {
            throw new IllegalArgumentException("Interest rate cannot be negative");
        }
        this.interestRate = interestRate;
    }

    @Override
    public String toString() {
        return "AccountSaving{" +
                "id=" + getId() +
                ", accountNumber='" + getAccountNumber() + '\'' +
                ", balance=" + getBalance() +
                ", interestRate=" + interestRate +
                ", clientId=" + getClientId() +
                '}';
    }
}