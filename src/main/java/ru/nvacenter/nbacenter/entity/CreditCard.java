package ru.nvacenter.nbacenter.entity;

import java.math.BigDecimal;

public class CreditCard extends BankCard {

    private final BigDecimal creditLimit;

    private BigDecimal creditBalance;

    public CreditCard(BigDecimal balance, BigDecimal creditLimit) {
        super(balance);
        this.creditLimit = creditLimit;
        creditBalance = creditLimit;
    }

    @Override
    public void addMoney(BigDecimal amount) {
        BigDecimal difference = creditLimit.subtract(creditBalance);
        if (difference.signum() > 0) {
            if (difference.compareTo(amount) >= 0) {
                creditBalance = creditBalance.add(amount);
            } else {
                super.addMoney(amount.subtract(difference));
                creditBalance = creditLimit;
            }
        } else {
            super.addMoney(amount);
        }
    }

    @Override
    public Boolean pay(BigDecimal amountToDeducted) {
        if (canAfford(amountToDeducted)) {
            BigDecimal balance = getBalance();
            if (balance.compareTo(amountToDeducted) >= 0) {
                super.pay(amountToDeducted);
            } else {
                creditBalance = creditBalance.subtract(amountToDeducted.subtract(balance));
                setNullBalance();
            }
            return true;
        }
        return false;
    }

    private boolean canAfford(BigDecimal amount) {
        BigDecimal allMoney = super.getBalance().add(creditBalance);
        return BigDecimal.ZERO.compareTo(allMoney.subtract(amount)) <= 0;
    }

    @Override
    public String getAllFunds() {
        return String.format("Your current balance: %s, Your credit limit: %s", super.getBalance(), creditBalance);
    }
}