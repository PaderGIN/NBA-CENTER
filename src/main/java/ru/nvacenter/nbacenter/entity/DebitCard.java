package ru.nvacenter.nbacenter.entity;

import java.math.BigDecimal;

public class DebitCard extends BankCard {

    public DebitCard(BigDecimal balance) {
        super(balance);
    }

    @Override
    public void addMoney(BigDecimal amount) {
        super.addMoney(amount);
    }

    @Override
    public Boolean pay(BigDecimal money) {
        return super.pay(money);
    }

    @Override
    public BigDecimal getBalance() {
        return super.getBalance();
    }

    @Override
    public String getAllFunds() {
        return String.format("Your current balance: %s", getBalance());
    }
}