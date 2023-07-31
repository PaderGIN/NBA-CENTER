package ru.nvacenter.nbacenter.entity;

import ru.nvacenter.nbacenter.promotion.Bonusable;
import ru.nvacenter.nbacenter.promotion.Depositable;

import java.math.BigDecimal;

public class RedBankCard extends DebitCard implements Bonusable, Depositable {

    private BigDecimal bonus;

    public RedBankCard(BigDecimal balance) {
        super(balance);
        bonus = new BigDecimal(0);
    }

    @Override
    public void addMoney(BigDecimal amount) {
        BigDecimal accumulation = amount.multiply(new BigDecimal("0.005"));
        super.addMoney(amount);
        System.out.println(String.format("You've got some accumulation! It's %s", accumulation));
        super.addMoney(accumulation);
    }

    @Override
    public Boolean pay(BigDecimal money) {
        Boolean transactionResult = super.pay(money);

        if (transactionResult) {
            BigDecimal newBonus = money.multiply(new BigDecimal("0.01"));
            bonus = bonus.add(newBonus);
            System.out.println(String.format("You've earned bonus! It's %s", newBonus));
            return true;
        } else return false;
    }

    @Override
    public String getAllFunds() {
        return super.getAllFunds() + ", Your bonus balance: " + bonus;
    }
}
