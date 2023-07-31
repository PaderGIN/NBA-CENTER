package ru.nvacenter.nbacenter.entity;

import java.math.BigDecimal;

public abstract class BankCard {

    private BigDecimal balance;

    public BankCard(BigDecimal balance) {
        this.balance = balance;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    void setNullBalance() {
        balance = new BigDecimal(0);
    }

    public void addMoney(BigDecimal amount) {
        balance = balance.add(amount);
    }

    public Boolean pay(BigDecimal money) {
        if (canAfford(money)) {
            balance = balance.subtract(money);
            return true;
        }
        return false;
    }

    private boolean canAfford(BigDecimal money) {
        return BigDecimal.ZERO.compareTo(balance.subtract(money)) <= 0;
    }

    public abstract String getAllFunds();
}